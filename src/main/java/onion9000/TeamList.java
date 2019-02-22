package onion9000;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class TeamList {
	private ArrayList<ArrayList<String>> teams; //populated as addTeam() is called
	private ArrayList<String> played; //populated as pick() is called
	private ArrayList<String> banned; //populated at initialisation
	public TeamList() throws IOException
	{
		teams = new ArrayList<ArrayList<String>>();
		played = new ArrayList<String>();
		banned = new ArrayList<String>();
		Scanner banFile = new Scanner(new File("ban.txt")); //local host ban list
		while (banFile.hasNext())
		{
			banned.add(banFile.next()); //populate list of banned users
		}
		banFile.close();
	}
	public void addTeam(ArrayList<String> party)
	{
		for (String user : party)
		{
			if (checkUser(user)) 
			{
				/* THROW ERROR - User already in other team!*/
				return;
			}
			if (played(user))
			{
				/* THROW ERROR - User already played!*/
				return;
			}
			if (banned(user))
			{
				/* THROW ERROR - User banned!*/
				return;
			}
		}
		teams.add(party);
		/* SUCCESS - Party added!*/
	}
	public void removeUser(String user)
	{
		for (ArrayList<String> team : teams)
		{
			for (int i = 0; i < team.size(); i++)
			{
				if (team.get(i).equals(user)) //remove the user found at position
				{
					team.remove(user);
					if (team.size() == 0)
					{
						teams.remove(team); //if the user was solo, remove their team
					}
					return;
				}
			}
		}
		/* THROW ERROR - User does not exist!*/
	}
	public void removeTeam(String user)
	{
		for (int i = 0; i < teams.size(); i++)
		{
			ArrayList<String> team = teams.get(i);
			for (String player : team)
			{
				if (player.equals(user))
				{
					teams.remove(i); //remove the team
					return;
				}
			}
		}
		/* THROW ERROR - User/Team does not exist!*/
	}
	public ArrayList<String> pick()
	{
		int count = 3; //default size of # players we want
		ArrayList<String> users = new ArrayList<String>(); //players to be returned
		while (users.size() < count) //while we have < count players chosen
		{
			int index = (int)(Math.random() * teams.size()); //random index in teams
			ArrayList<String> party = teams.get(index);
			if (party.size() <= count - users.size()) //if adding the party does not push our #players over count
			{
				for (String player : party) //add each player
				{
					users.add(player);
					played.add(player);
				}
				teams.remove(index);
			}
		}
		return users; //return (count) players
	}
	public ArrayList<String> pick(int count)
	{
		//overloaded method version
		ArrayList<String> users = new ArrayList<String>(); //players to be returned
		while (users.size() < count) //while we have < count players chosen
		{
			int index = (int)(Math.random() * teams.size()); //random index in teams
			ArrayList<String> party = teams.get(index);
			if (party.size() <= count - users.size()) //if adding the party does not push our #players over count
			{
				for (String player : party) //add each player
				{
					users.add(player);
				}
				teams.remove(index);
			}
		}
		return users; //return (count) players
	}
	private boolean checkUser(String user)
	{
		for (ArrayList<String> team : teams)
		{
			for (String player : team)
			{
				if (player.equals(user)) return true; //user is already signed up
			}
		}
		return false; //user is not already signed up and can join roster
	}
	private boolean played(String user)
	{
		for (String player : played)
		{
			if (player.equals(user)) return true; //player is contained within played list
		}
		return false;
	}
	private boolean banned(String user)
	{
		for (String player : banned)
		{
			if (player.equals(user)) return true; //player is contained within played list
		}
		return false;	
	}
	public void addBan(String user)
	{
		@SuppressWarnings("unused")
		File banFile = new File("ban.txt");
		//append user to "bans.txt"
	}
	/*
	 * TO ADD
	 * 
	 * PICKING
	 * Check if user has perms to call pick()
	 * If users don't play, add them back to teams??? (or just keep them on played list)
	 * 
	 * SIGNUP
	 * Open roster
	 * Close roster
	 * Check if user has perms to call open and close
	 * Add some way to check if user actually wants to be on team???
	 * 
	 * 
	 * BANS
	 * Add way to append users to ban instead of manual (addBan())
	 * 
	 * ERROR
	 * Error messages
	 * 		Party too Big
	 * 		User already signed up
	 * 		User banned (private message?)
	 * 		User already played
	 * 		Team/User can't be removed
	 */
}
