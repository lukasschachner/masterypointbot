package de.lukasschachner.discordBot;

import de.lukasschachner.data.Summoner;
import de.lukasschachner.wrapper.Interface;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.IOException;

/**
 * @author Lukas Schachner
 * Created on 27.10.2020
 */
public class Bot implements EventListener
{
	private final Logger log = LoggerFactory.getLogger(Bot.class);
	private final Interface api = new Interface();

	public JDA makeAndStartBot(String token) throws LoginException
	{
		try
		{
			api.updateVersionsFile();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return JDABuilder.createDefault(token).addEventListeners(new Bot()).build();
	}

	private MessageEmbed buildInfoMessage(Summoner data)
	{
		EmbedBuilder embedBuilder = new EmbedBuilder();
		embedBuilder.setColor(Color.ORANGE);
		embedBuilder.setTitle("Mastery Info");
		embedBuilder.setDescription("Mastery data for: `" + data.getSummonerData().getName() + "` on the `" + data.getSummonerData().getServer() + "` Server");
		embedBuilder.addField("Server Rank", "`" + data.getMasteryData().getTotal_points_rank() + "`", true);
		embedBuilder.addField("Total Points", "`" + data.getMasteryData().getTotal_points() + "`", true);
		embedBuilder.addBlankField(true);
		embedBuilder.addField("Champions at Level 7", String.valueOf(data.getMasteryData().getTotal_mastered()), true);
		embedBuilder.addField("Champions at level 6", String.valueOf(data.getMasteryData().getTotal_mastered6()), true);
		embedBuilder.addField("Champions at level 5", String.valueOf(data.getMasteryData().getTotal_mastered5()), true);
		embedBuilder.setFooter("Masterypoint Infobot");
		return embedBuilder.build();
	}

		private void handleMessage(Message message)
		{

			String content = message.getContentRaw();
			String[] args;
			if (content.startsWith(">get"))
			{
				args = content.split(" ");
				if (args[1].equals("info"))
				{
					try
					{

						message.getChannel().sendMessage(buildInfoMessage(api.buildSummoner(args[2], args[3]))).queue();
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}

		}


	@Override
		public void onEvent(GenericEvent event)
		{
			if(event instanceof ReadyEvent)
				System.out.println("API is ready!");
			else if (event instanceof GuildMessageReceivedEvent)
			{
				if (((GuildMessageReceivedEvent) event).getAuthor().isBot()) return;
				handleMessage(((GuildMessageReceivedEvent) event).getMessage());
			}
		}
}
