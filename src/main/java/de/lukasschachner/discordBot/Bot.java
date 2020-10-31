package de.lukasschachner.discordBot;

import de.lukasschachner.data.ChampionInfo;
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
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lukas Schachner
 * Created on 27.10.2020
 */
public class Bot implements EventListener
{
	private final Logger log = LoggerFactory.getLogger(Bot.class);
	private final Interface api = new Interface();
	private static Map<Integer, String> championNames = new HashMap<>();

	public JDA makeAndStartBot(String token) throws LoginException
	{
		championNames = api.parseChampions();
		return JDABuilder.createDefault(token).addEventListeners(new Bot()).build();
	}

	private EmbedBuilder buildPointFields(EmbedBuilder embedBuilder, List<ChampionInfo> data)
	{
		while (embedBuilder.getFields().size() % 3 != 0) // make sure the next three fields are in a new row
			embedBuilder.addBlankField(true);

		String text = championNames.get(data.get(0).getChampion()) + '\n' +
				"Level: `" + data.get(0).getMastery_level() + "`\n" +
				"Points: `" + data.get(0).getPoints() + "`\n";
		embedBuilder.addField("Highest Rated Champion", text, true);

		text = championNames.get(data.get(1).getChampion()) + '\n' +
				"Level: `" + data.get(1).getMastery_level() + "`\n" +
				"Points: `" + data.get(1).getPoints() + "`\n";
		embedBuilder.addField("Second Rated Champion", text, true);

		text = championNames.get(data.get(2).getChampion()) + '\n' +
				"Level: `" + data.get(2).getMastery_level() + "`\n" +
				"Points: `" + data.get(2).getPoints() + "`\n";
		embedBuilder.addField("Third Rated Champion", text, true);
		return embedBuilder;
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
		embedBuilder.addField("Champions at Level 7 / 6 / 5", String.format("%d / %d / %d", data.getMasteryInfo().getTotal_mastered(), data.getMasteryInfo().getTotal_mastered6(), data.getMasteryInfo().getTotal_mastered5()), true);
		embedBuilder = buildPointFields(embedBuilder, data.getChampionInfos());
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
	public void onEvent(@NotNull GenericEvent event)
	{
		if (event instanceof ReadyEvent)
		{
			log.info("Bot is ready!");
		} else if (event instanceof GuildMessageReceivedEvent)
		{
			if (((GuildMessageReceivedEvent) event).getAuthor().isBot()) return;
			handleMessage(((GuildMessageReceivedEvent) event).getMessage());
		}
	}
}
