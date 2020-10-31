package de.lukasschachner.data;

import java.util.List;

/**
 * @author Lukas Schachner
 * Created on 27.10.2020
 */
public class Summoner
{
	private SummonerData summonerData;
	private MasteryInfo masteryInfo;
	private List<ChampionInfo> championInfos;

	public Summoner(SummonerData summonerData, MasteryInfo masteryInfo, List<ChampionInfo> championInfos)
	{
		this.summonerData = summonerData;
		this.masteryInfo = masteryInfo;
		this.championInfos = championInfos;
	}

	public SummonerData getSummonerData()
	{
		return summonerData;
	}

	public void setSummonerData(SummonerData summonerData)
	{
		this.summonerData = summonerData;
	}

	public MasteryInfo getMasteryData()
	{
		return masteryInfo;
	}

	public void setMasteryData(MasteryInfo masteryInfo)
	{
		this.masteryInfo = masteryInfo;
	}

	public MasteryInfo getMasteryInfo()
	{
		return masteryInfo;
	}

	public void setMasteryInfo(MasteryInfo masteryInfo)
	{
		this.masteryInfo = masteryInfo;
	}

	public List<ChampionInfo> getChampionInfos()
	{
		return championInfos;
	}

	public void setChampionInfos(List<ChampionInfo> championInfos)
	{
		this.championInfos = championInfos;
	}

	@Override
	public String toString()
	{
		return "Summoner{" +
				"summonerData=" + summonerData.toString() +
				", masteryData=" + masteryInfo.toString() +
				'}';
	}
}
