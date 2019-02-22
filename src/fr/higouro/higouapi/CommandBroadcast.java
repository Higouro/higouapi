package fr.higouro.higouapi;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
public class CommandBroadcast extends Command {

	public CommandBroadcast(String name) {
		super(name, "medievalbroadcast");

	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(args.length == 0) {
			sender.sendMessage(new TextComponent("Tapez /bc <votre message>"));
		}
		if (args.length >= 1) {
			StringBuilder bc = new StringBuilder();
			for(String part : args) {
				bc.append(part + " ");				
			}
			
			ProxyServer.getInstance().broadcast(new TextComponent("§c[MedievalTown]§d: " + bc.toString() ));
		}
	}

}
