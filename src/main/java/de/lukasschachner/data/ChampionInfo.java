package de.lukasschachner.data;

/**
 * @author Lukas Schachner
 * Created on 28.10.2020
 */
public class ChampionInfo
{
	String last_play_time;
	int mastery_level_estimate;
	int tokens;
	int mastery_level;
	int champion;
	int points;

	public ChampionInfo()
	{
	}

	public String getLast_play_time()
	{
		return last_play_time;
	}

	public void setLast_play_time(String last_play_time)
	{
		this.last_play_time = last_play_time;
	}

	public int getMastery_level_estimate()
	{
		return mastery_level_estimate;
	}

	public void setMastery_level_estimate(int mastery_level_estimate)
	{
		this.mastery_level_estimate = mastery_level_estimate;
	}

	public int getTokens()
	{
		return tokens;
	}

	public void setTokens(int tokens)
	{
		this.tokens = tokens;
	}

	public int getMastery_level()
	{
		return mastery_level;
	}

	public void setMastery_level(int mastery_level)
	{
		this.mastery_level = mastery_level;
	}

	public int getChampion()
	{
		return champion;
	}

	public void setChampion(int champion)
	{
		this.champion = champion;
	}

	public int getPoints()
	{
		return points;
	}

	public void setPoints(int points)
	{
		this.points = points;
	}

	@Override
	public String toString()
	{
		return "ChampionInfo{" +
				"last_play_time='" + last_play_time + '\'' +
				", mastery_level_estimate=" + mastery_level_estimate +
				", tokens=" + tokens +
				", mastery_level=" + mastery_level +
				", champion=" + champion +
				", points=" + points +
				'}';
	}
}
