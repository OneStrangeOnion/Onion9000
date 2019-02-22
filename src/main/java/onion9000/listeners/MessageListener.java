package onion9000.listeners;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import onion9000.Logger;

public class MessageListener implements EventListener{

	public void onEvent(Event event) {
		if (event instanceof ReadyEvent) {
			Logger.logInfo("Ready to go!");
		}
		if (event instanceof GuildMessageReceivedEvent) {
			GuildMessageReceivedEvent msgEvent = (GuildMessageReceivedEvent) event;
			if (!msgEvent.getAuthor().isBot()) {
				if (msgEvent.getMessage().getContentRaw().startsWith("!")) {/*This is the prefix to use. would also recommend having this read from a file*/
					Message msg = msgEvent.getMessage();
					if (msg.getContentRaw().substring(1).startsWith("ping")) {
						msgEvent.getChannel().sendMessage("Pong! ("+msgEvent.getJDA().getPing()+"ms)").queue(m -> Logger.logInfo("Pong!"));;
					} else if (msg.getContentRaw().substring(1).startsWith("addme")) {
						//Do stuff here
						
					} else if (msg.getContentRaw().substring(1).startsWith("addteam")) {
						//Do stuff here
						
					} else if (msg.getContentRaw().substring(1).startsWith("removeme")) {
						//Do stuff here
						
					} else if (msg.getContentRaw().substring(1).startsWith("removeteam")) {
						//Do stuff here
						
					} else if (msg.getContentRaw().substring(1).startsWith("pick")) {
						//Do stuff here
						
					} else if (msg.getContentRaw().substring(1).startsWith("open")) {
						//Do stuff here
						
					} else if (msg.getContentRaw().substring(1).startsWith("close")) {
						//Do stuff here
						
					} else if (msg.getContentRaw().substring(1).startsWith("help")) {
						//Do stuff here
						
					}
				}
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
 * !pick - call pick() and print - admin cmd
 * !removeme - call removeUser() 
 * 		Delete user's message upon successful removal
 * !removeteam - call removeTeam()
 * 		Delete user's message upon successful removal
 * !open - TeamList() and allow user commands - admin cmd 
 * 		Response
 * !close - Disallow user commands - admin cmd
 * 		Response
 * !help - DM
 */
}
