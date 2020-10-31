package de.lukasschachner.data;

/**
* Contains all the fields of data returned by the api that are reasonable to display
 * @author Lukas Schachner
 * Created on 27.10.2020 </br>
 */
public class SummonerData
{
	// TODO: 27.10.2020 make this a proper type like an enum
	/**
	 * the server the account is on
	 */
	String server;
	/**
	 * the tier of the account not properly fetched by the api
	 */
	String tier;
	/**
	 * the summoner name of the account
	 */
	String name;
	/**
	 * the id of the icon the accoutn is currently using
	 */
	int icon;
	/**
	 * the AccountID used primarily by the Riot APIs maybe useful in the future
	 */
	String id;
	/**
	 * the shirt version of the summoner name (lowercase and without spaces)
	 */
	String shortName;
	/**
	 * the timestamp the api last updated this users data
	 */
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
