package onion9000;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import onion9000.listeners.MessageListener;

import java.util.Scanner;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		try {
			Scanner tokenFile = new Scanner(new File("token.txt"));
			String token = tokenFile.nextLine();
			tokenFile.close();
			@SuppressWarnings("unused")
			JDA jda = new JDABuilder()
					.addEventListener(new MessageListener())
					.setAudioEnabled(false)
					.setToken(token)
					.build();
		} catch (LoginException e) {
			System.err.println("Login Exception!");
			e.printStackTrace();
		}
	}
	/*
	 * TO DO
	 * 
	 * 
	 */
}
