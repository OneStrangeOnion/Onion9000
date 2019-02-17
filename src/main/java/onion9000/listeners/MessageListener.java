package onion9000.listeners;

import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class MessageListener implements EventListener{

	public void onEvent(Event event) {
		if (event instanceof GuildMessageReceivedEvent) {
			if (!((GuildMessageReceivedEvent) event).getAuthor().isBot()) {
				((GuildMessageReceivedEvent)event).getChannel().sendMessage("Fuck").queue();	
			}
		}
		/*
		   switch(command)
		   case !addme : ArrayList<String> user = new ArrayList<String>(); 
		   		user.add(param); 
		   		addTeam(user); 
		   		break;
		   case !addteam : ArrayList<String> party = new ArrayList<String>(); 
		   		party.add(param) * 2 | 3; 
		   		addTeam(party); 
		   		break;
		   case !pick : pick() or pick(param); 
		  		break;
		   case !removeme : ArrayList<String> user = new ArrayList<String>(); 
		   		user.add(param); 
		   		removeUser(user); 
		   		break;
		   case !removeteam : ArrayList<String> party = new ArrayList<String>(); 
		   		party.add(param) * 2 | 3; 
		   		removeTeam(party); 
		   		break;
		   case !open : ????
		   case !close : ????
		   		    
		 */
	}
/*
 * TO DO
 * 
 * !addme - send single user arraylist to addTeam()
 * 		Delete user's message upon successful signup
 * !addteam - send arraylist of all users to addTeam()
 * 		Delete user's message upon successful signup
 * !pick - call pick() and print
 * !pick (param) - call pick(param) and print
 * !removeme - call removeUser() 
 * 		Delete user's message upon successful removal
 * !removeteam - call removeTeam()
 * 		Delete user's message upon successful removal
 * !open - TeamList() and allow user commands
 * 		Response
 * !close - Disallow user commands
 * 		Response
 * !help - DM
 */
}
