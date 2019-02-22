package fr.higouro.higouapi;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandHub extends Command {

	public CommandHub(String name) {
		super(name, "hub.teleport");

	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;
			player.sendMessage(new TextComponent ("§eVous avez teleporter au hub de notre serveur"));
			player.connect(ProxyServer.getInstance().getServerInfo("Lobby"));
			
		}


	}

}
