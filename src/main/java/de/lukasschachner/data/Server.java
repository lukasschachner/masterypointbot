package de.lukasschachner.data;

/**
 * @author Lukas Schachner
 * Created on 27.10.2020
 */
public enum Server
{
	EUWEST
			{
				@Override
				public String toString()
				{
					return "euw";
				}
			},
	EUEAST
			{
				@Override
				public String toString()
				{
					return "eune";
				}
			},
	NORTHAMERICA
			{
				@Override
				public String toString()
				{
					return "na";
				}
			};

	Server()
	{

	}
}
