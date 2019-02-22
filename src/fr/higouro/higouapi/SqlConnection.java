package fr.higouro.higouapi;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;




public class SqlConnection {
	private java.sql.Connection connection;
	private String urlbase,host,database,user,pass;

	public SqlConnection(String urlbase, String host, String database, String user, String pass) {
		this.urlbase = urlbase;
		this.host = host;
		this.database = database;
		this.user = user;
		this.pass = pass;
		
	}
	
		public void connection() {
			if(!isConnected()) {
			try {
				connection =  DriverManager.getConnection(urlbase + host + "/" + database, user , pass);
				System.out.println("connected ok");
			} catch (SQLException e) {
				e.printStackTrace();
				}
			}
		
	}
		
		/*
		 * INSERT
		 * UPDATE
		 * DELETE
		 * SELECT
		 * 
		 * PREPARER ?,?
		 * REMPLACER LES ? PAR DES VALEURS
		 * EXECUTE
		 * 
		 */
	
	public void disconnect() {
		if (isConnected()) {
			
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("connected off");
			e.printStackTrace();
			}
		
		}
	
	}
	
	public boolean isConnected() {
		return connection != null;
	}
		
		
	
	
	public void createAccount(Player player) {
		//INSERT
		if (!hasAccount(player) ) {
			
			try {
				PreparedStatement q = connection.prepareStatement("INSERT INTO joueurs (uuid, coins,grade) VALUES (?,?;?");
				q.setString(1, player.getUniqueId().toString());
				q.setInt(2, 100);
				q.setString(3, "joueur");
				q.execute();
				q.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
	}
		

	public boolean hasAccount (Player player) {
		//SELECT
		
		try {
			PreparedStatement q = connection.prepareStatement("SELECT uuid FROM joueurs WHERE uuid = ?");
		q.setString(1, player.getUniqueId().toString());
		ResultSet resultat = q.executeQuery();
		boolean hasAccount = resultat.next();
		q.close();
		return hasAccount;
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return false;	
	}
	

	 public int getBalance (Player player) {
		 return 0;
		 //SELECT
	 }
	 
	 public void addMonney (Player player,int amount) {
		 //UPDATE
	 }
	 public void removeMoney(Player player,int amount) {
		 //UPDATE
	 }

}

	


