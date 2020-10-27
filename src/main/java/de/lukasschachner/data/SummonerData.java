package de.lukasschachner.data;

/**
 * @author Lukas Schachner
 * Created on 27.10.2020
 */
public class SummonerData
{
	String server;
	String tier;
	String name;
	int icon;
	String id;
	String shortName;
	String last_info_update;

	public SummonerData()
	{
	}


	public String getServer()
	{
		return server;
	}

	public void setServer(String server)
	{
		this.server = server;
	}

	public String getTier()
	{
		return tier;
	}

	public void setTier(String tier)
	{
		this.tier = tier;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getIcon()
	{
		return icon;
	}

	public void setIcon(int icon)
	{
		this.icon = icon;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getShortName()
	{
		return shortName;
	}

	public void setShortName(String shortName)
	{
		this.shortName = shortName;
	}

	public String getLast_info_update()
	{
		return last_info_update;
	}

	public void setLast_info_update(String last_info_update)
	{
		this.last_info_update = last_info_update;
	}

	@Override
	public String toString()
	{
		return "Summoner{" +
				"server='" + server + '\'' +
				", tier='" + tier + '\'' +
				", name='" + name + '\'' +
				", icon=" + icon +
				", id='" + id + '\'' +
				", shortName='" + shortName + '\'' +
				", last_info_update='" + last_info_update + '\'' +
				'}';
	}


}
