package fr.higouro.higouapi;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.TextComponent;

public class BungeeListeners implements Listener {
	
	@EventHandler
	public void onJoin(PostLoginEvent event) {
		
		ProxiedPlayer player = event.getPlayer();
		player.setTabHeader(new TextComponent("§o§n§cMedievalTown"), new TextComponent("§aSite: §b§o§n medievaltown.fr"));
		
		Title title =  ProxyServer.getInstance().createTitle();
		title.title(new TextComponent ("§b  Bienvenue sur§d MedievalTown "));
		title.subTitle(new TextComponent ("§a Amuse toi bien !"));
		title.send(player);
	}

}
