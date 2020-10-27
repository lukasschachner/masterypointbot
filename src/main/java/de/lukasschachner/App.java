package de.lukasschachner;

import de.lukasschachner.data.MasteryData;
import de.lukasschachner.data.SummonerData;
import de.lukasschachner.discordBot.Bot;
import de.lukasschachner.wrapper.Interface;
import net.dv8tion.jda.api.JDA;

import javax.security.auth.login.LoginException;
import java.io.IOException;

/**
 * @author Lukas Schachner
 * @version 1.0.0
 */
public class App
{

    public static void main( String[] args ) throws IOException, LoginException
    {
        Bot bot = new Bot();
        JDA jda = bot.makeAndStartBot("NzAwMDY0MzAyMTk0ODg0NjM4.XpdfsA.JOtPUXsgPVnEGjF6Mc9EXd0S4-A");

        Interface api = new Interface();
        SummonerData test = api.requestSummoner("TSO Aiden", "euw");
        System.out.println(test.getName());
        MasteryData toastmaster = api.requestMastery("TSO Aiden", "euw");
        System.out.println(toastmaster.getTotal_champions());
    }
}
