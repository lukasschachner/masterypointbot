package de.lukasschachner;

import de.lukasschachner.discordBot.Bot;
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

	public static void main(String[] args) throws LoginException, IOException
	{
		String TOKEN = null;
		if (args.length > 0)
		{
			TOKEN = args[0];
			log.info("read TOKEN from command line arguments");
		}
		else if (System.getenv("BOT_TOKEN") != null)
		{
			TOKEN = System.getenv("BOT_TOKEN");
			log.info("got TOKEN from system environment variables, probably running in docker");
		}
		Bot bot = new Bot();
		JDA jda;
		if (TOKEN != null)
		{
			jda = bot.makeAndStartBot(TOKEN);
		} else
		{
			log.error("No TOKEN supplied. Exiting...");
		}
	}
}
