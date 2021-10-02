package fr.mrlaikz.spartamod.database;

import fr.mrlaikz.spartamod.SpartaMod;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.OfflinePlayer;

public class Data {
	
	private SpartaMod plugin;
	private MySQL db;
	private final String table = plugin.strConfig("database.table");
  
	public Data(SpartaMod plugin, MySQL db) {
		this.plugin = plugin;
		this.db = db;
	}
  
	public void createTable() {
		try {
			PreparedStatement ps = db.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS " + table + " (id INT AUTO_INCREMENT PRIMARY KEY, player VARCHAR(255), amount INT(11), sanction VARCHAR(255))");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
  
	public void insertSanction(String sanction, OfflinePlayer p) {
		try {
			PreparedStatement ps = db.getConnection().prepareStatement("INSERT INTO " + table + " (sanction, player, amount) VALUES(?, ?, ?)");
			ps.setString(1, sanction);
			ps.setString(2, p.getName());
			ps.setInt(3, 1);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
  
	public void addSanction(String sanction, OfflinePlayer p) {
		try {
			PreparedStatement ps = db.getConnection().prepareStatement("UPDATE " + table + " SET amount = ? WHERE player = ? AND sanction = ?");
			ps.setInt(1, getSanctionAmount(p).get(getSanction(p).indexOf(sanction)).intValue() + 1);
			ps.setString(2, p.getName());
			ps.setString(3, sanction);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
  
	public List<String> getSanction(OfflinePlayer p) {
		ArrayList<String> list = new ArrayList<>();
		try {
			PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE player = ?");
			ps.setString(1, p.getName());
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				list.add(rs.getString("sanction")); 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}
  
  public List<Integer> getSanctionAmount(OfflinePlayer p) {
    ArrayList<Integer> list = new ArrayList<>();
    try {
      PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE player = ?");
      ps.setString(1, p.getName());
      ResultSet rs = ps.executeQuery();
      while (rs.next())
        list.add(Integer.valueOf(rs.getInt("amount"))); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return list;
  }
}
