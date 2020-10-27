package de.lukasschachner.data;

/**
 * @author Lukas Schachner
 * Created on 27.10.2020
 */
public class MasteryData
{
	String last_mastery_update;
	int total_champions;
	int total_mastered;
	int total_mastered6;
	int total_mastered5;
	int total_mastery_level;
	int total_points;
	int total_points_rank;

	public MasteryData()
	{
	}

	public String getLast_mastery_update()
	{
		return last_mastery_update;
	}

	public void setLast_mastery_update(String last_mastery_update)
	{
		this.last_mastery_update = last_mastery_update;
	}

	public int getTotal_champions()
	{
		return total_champions;
	}

	public void setTotal_champions(int total_champions)
	{
		this.total_champions = total_champions;
	}

	public int getTotal_mastered()
	{
		return total_mastered;
	}

	public void setTotal_mastered(int total_mastered)
	{
		this.total_mastered = total_mastered;
	}

	public int getTotal_mastered6()
	{
		return total_mastered6;
	}

	public void setTotal_mastered6(int total_mastered6)
	{
		this.total_mastered6 = total_mastered6;
	}

	public int getTotal_mastered5()
	{
		return total_mastered5;
	}

	public void setTotal_mastered5(int total_mastered5)
	{
		this.total_mastered5 = total_mastered5;
	}

	public int getTotal_mastery_level()
	{
		return total_mastery_level;
	}

	public void setTotal_mastery_level(int total_mastery_level)
	{
		this.total_mastery_level = total_mastery_level;
	}

	public int getTotal_points()
	{
		return total_points;
	}

	public void setTotal_points(int total_points)
	{
		this.total_points = total_points;
	}

	public int getTotal_points_rank()
	{
		return total_points_rank;
	}

	public void setTotal_points_rank(int total_points_rank)
	{
		this.total_points_rank = total_points_rank;
	}

	@Override
	public String toString()
	{
		return "Mastery{" +
				"last_mastery_update='" + last_mastery_update + '\'' +
				", total_champions=" + total_champions +
				", total_mastered=" + total_mastered +
				", total_mastered6=" + total_mastered6 +
				", total_mastered5=" + total_mastered5 +
				", total_mastery_level=" + total_mastery_level +
				", total_points=" + total_points +
				", total_points_rank=" + total_points_rank +
				'}';
	}
}
