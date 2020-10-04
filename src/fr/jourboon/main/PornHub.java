package fr.jourboon.main;

import javax.swing.JFrame;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

@SuppressWarnings("serial")
public class PornHub extends JFrame{

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		
		f.setVisible(true);
		f.setSize(200, 300);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setResizable(true);
		f.setTitle("PornhubPremium x)");
		
		DiscordRPC lib = DiscordRPC.INSTANCE;
        String applicationId = "762360619370020864";
        String steamId = "";
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        lib.Discord_Initialize(applicationId, handlers, true, steamId);
        DiscordRichPresence presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
        presence.details = "Regarde PornHub Premium";
        presence.largeImageKey = "pornhub2";
        presence.smallImageKey = "pornhub";
        presence.state = "En plein action..";
        lib.Discord_UpdatePresence(presence);
        // in a worker thread
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
            }
        });
	}

}
