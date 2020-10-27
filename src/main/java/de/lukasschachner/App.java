package de.lukasschachner;

import de.lukasschachner.data.MasteryData;
import de.lukasschachner.data.SummonerData;
import de.lukasschachner.wrapper.Interface;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{

    public static void main( String[] args ) throws IOException
    {
        Interface api = new Interface();
        SummonerData test = api.requestSummoner("TSO Aiden", "euw");
        System.out.println(test.getName());
        MasteryData toastmaster = api.requestMastery("TSO Aiden", "euw");
        System.out.println(toastmaster.getTotal_champions());
    }
}
