package fr.mrlaikz.spartamod;

import java.sql.SQLException;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import fr.mrlaikz.spartamod.commands.Sanction;
import fr.mrlaikz.spartamod.commands.SanctionGui;
import fr.mrlaikz.spartamod.database.MySQL;
import fr.mrlaikz.spartamod.listeners.ClickInventory;
import net.md_5.bungee.api.ChatColor;

public class SpartaMod extends JavaPlugin {

	private SanctionManager manager;
	private MySQL sql;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		manager = new SanctionManager(this);
		
		//SQL
		sql = new MySQL(this);
		try {
			sql.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		getCommand("sanction").setExecutor(new Sanction(this));
		getCommand("sanctiongui").setExecutor(new SanctionGui(this));
		
		getServer().getPluginManager().registerEvents(new ClickInventory(this), this);
		
	}
	
	@Override
	public void onDisable() {
		saveConfig();
	}
	
	public SanctionManager getSanctionManager() {
		return manager;
	}
	
	public String strConfig(String path) {
		return ChatColor.translateAlternateColorCodes('&', this.getConfig().getString(path));
	}
	
	public Material matConfig(String path) {
		return Material.matchMaterial(this.getConfig().getString(path));
	}
	
	
}
