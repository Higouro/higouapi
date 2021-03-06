package fr.higouro.higouapi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class HigouApi extends Plugin implements Listener, net.md_5.bungee.api.plugin.Listener {
	
	public SqlConnection sql;
	
	@Override
	public void onEnable() {
		sql = new SqlConnection("jdbc:mysql://","localhost","mtgrade","root","");
		sql.connection();
		getProxy().getPluginManager().registerListener(this, this);
		System.out.println("L'API FONCTIONNE");
		
		PluginManager pm = getProxy().getPluginManager();
		pm.registerCommand(this, new CommandHub ("hub"));
		pm.registerCommand(this, new CommandBroadcast ("bc"));
		pm.registerListener(this, new  BungeeListeners());
	}
	
	@Override
	public void onDisable() {
		sql.disconnect();
		System.out.println("L'API EST OFF");

	}
	
	@EventHandler
	public void join (PlayerJoinEvent e) {
		Player p = e.getPlayer();
		sql.createAccount(p);
	}

}
