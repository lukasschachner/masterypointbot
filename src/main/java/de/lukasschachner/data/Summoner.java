package de.lukasschachner.data;

/**
 * @author Lukas Schachner
 * Created on 27.10.2020
 */
public class Summoner
{
	private SummonerData summonerData;
	private MasteryData masteryData;

	public Summoner(SummonerData summonerData, MasteryData masteryData)
	{
		this.summonerData = summonerData;
		this.masteryData = masteryData;
	}

	public SummonerData getSummonerData()
	{
		return summonerData;
	}

	public void setSummonerData(SummonerData summonerData)
	{
		this.summonerData = summonerData;
	}

	public MasteryData getMasteryData()
	{
		return masteryData;
	}

	public void setMasteryData(MasteryData masteryData)
	{
		this.masteryData = masteryData;
	}

	@Override
	public String toString()
	{
		return "Summoner{" +
				"summonerData=" + summonerData.toString() +
				", masteryData=" + masteryData.toString() +
				'}';
	}
}
