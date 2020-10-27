package de.lukasschachner;

import de.lukasschachner.data.MasteryData;
import de.lukasschachner.data.SummonerData;
import de.lukasschachner.discordBot.Bot;
import de.lukasschachner.wrapper.Interface;
import net.dv8tion.jda.api.JDA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.io.IOException;

/**
 * @author Lukas Schachner
 * @version 1.0.0
 */
public class App
{

	static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws IOException, LoginException
	{
		String TOKEN = null;
		if (args.length > 0)
		{
			TOKEN = args[0];
		}
		else if (System.getenv("BOT_TOKEN") != null)
		{
			TOKEN = System.getenv("BOT_TOKEN");
		}
		Bot bot = new Bot();
		JDA jda;
		if (TOKEN != null)
		{
			jda = bot.makeAndStartBot(TOKEN);
		} else
		{
			log.error("No TOKEN supplied. Exiting...");
			return;
		}
		Interface api = new Interface();
		SummonerData test = api.requestSummoner("TSO Aiden", "euw");
		System.out.println(test.getName());
		MasteryData toastmaster = api.requestMastery("TSO Aiden", "euw");
		System.out.println(toastmaster.getTotal_champions());
	}
}
