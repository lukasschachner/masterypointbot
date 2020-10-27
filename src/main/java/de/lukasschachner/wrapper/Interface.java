package de.lukasschachner.wrapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.lukasschachner.data.MasteryData;
import de.lukasschachner.data.SummonerData;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Lukas Schachner
 * Created on 27.10.2020
 */
public class Interface
{
	private final Logger log = LoggerFactory.getLogger(Interface.class);

	private final HttpClient client;

	public Interface()
	{
		this.client = HttpClients.createDefault();
	}

	/**
	 * Builds the request Url for the <a href="https://masterypoints.com/api">Masterypoints API</a>
	 *
	 * @param username
	 * @param server
	 * @return
	 */
	private String buildSummonerRequest(String username, String server)
	{
		String baseUrl = "https://www.masterypoints.com/api/";
		String version = "v1.1";
		return String.format("%s/summoner/%s/%s", baseUrl + version, username.replaceAll(" ", "%20"), server);
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
		return new JSONObject(EntityUtils.toString(getResponse.getEntity()));
	}

	public SummonerData requestSummoner(String name, String server) throws IOException
	{
		JSONObject data = requestData(name, server);
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(data.get("summoner_info").toString(), SummonerData.class);
	}

	public MasteryData requestMastery(String name, String server) throws IOException
	{
		JSONObject data = requestData(name, server);
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(data.get("summoner_mastery").toString(), MasteryData.class);
	}
}
