package de.lukasschachner.wrapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.lukasschachner.data.ChampionInfo;
import de.lukasschachner.data.MasteryInfo;
import de.lukasschachner.data.Summoner;
import de.lukasschachner.data.SummonerData;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author Lukas Schachner
 * Created on 27.10.2020
 */
public class Interface
{
	private final Logger log = LoggerFactory.getLogger(Interface.class);

	private final HttpClient client;

	private String version;

	public Interface()
	{
		this.client = HttpClients.createDefault();
	}


	private String buildSummonerRequest(String name, String server)
	{
		String baseUrl = "https://www.masterypoints.com/api/";
		String version = "v1.1";
		String requesturl = String.format("%s/summoner/%s/%s", baseUrl + version, name.replaceAll(" ", "%20"), server);
		log.info("build request string for " + name + " as " + requesturl);
		return requesturl;
	}

	public String getVersion()
	{
		File versions = new File("requests/versions.json");
		String version = new JSONArray(versions.toString()).get(0).toString();
		log.info("updated version as: " + version);
		return version;
	}

	public void updateVersionsFile() throws IOException
	{
		HttpGet getMethod = new HttpGet("https://ddragon.leagueoflegends.com/api/versions.json");
		HttpResponse getResponse = client.execute(getMethod);
		if (getResponse.getStatusLine().getStatusCode() < 200 || getResponse.getStatusLine().getStatusCode() >= 300)
		{
			log.error("False Request");
		}
		File versions = new File("responses/versions.json");
		FileOutputStream fos = new FileOutputStream(versions);
		getResponse.getEntity().writeTo(fos);
		fos.close();
	}

	private JSONObject requestData(String name, String server) throws IOException
	{
		HttpGet getMethod = new HttpGet(buildSummonerRequest(name, server));
		HttpResponse getResponse = client.execute(getMethod);
		if (getResponse.getStatusLine().getStatusCode() < 200 || getResponse.getStatusLine().getStatusCode() >= 300)
		{
			log.error("False Request");
			return new JSONObject();
		}
		log.info("sucessfully requested data for " + name);
		return new JSONObject(EntityUtils.toString(getResponse.getEntity()));
	}


	/**
	 * make a request to the <a href="https://www.masterypoints.com/api/">Masterypoints API</a>
	 *
	 * @param name   the SummonerName of the user to get
	 * @param server the server the Account is on
	 * @return the parsed json data in a Summoner Object {@link de.lukasschachner.data.Summoner}
	 * @throws IOException
	 * @see de.lukasschachner.data.Summoner
	 * @since 1.0.0
	 */
	public Summoner buildSummoner(String name, String server) throws IOException
	{
		JSONObject data = requestData(name, server);
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return new Summoner(mapper.readValue(data.getJSONObject("summoner_info").toString(), SummonerData.class),
				mapper.readValue(data.getJSONObject("summoner_mastery").toString(), MasteryInfo.class),
				mapper.readValue(data.getJSONObject("summoner_mastery").getJSONArray("mastery_data").toString(), new TypeReference<List<ChampionInfo>>(){}));
	}
}
