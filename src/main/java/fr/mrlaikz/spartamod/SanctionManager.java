package fr.mrlaikz.spartamod;

import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import fr.mrlaikz.spartamod.database.Data;
import fr.mrlaikz.spartamod.menus.SanctionChatInventory;
import fr.mrlaikz.spartamod.menus.SanctionGameInventory;
import fr.mrlaikz.spartamod.menus.SanctionInventory;

public class SanctionManager {

	private Map<OfflinePlayer, OfflinePlayer> sanctions;
	
	private SanctionInventory sanctionInventory;
	private SanctionChatInventory sanctionChatInventory;
	private SanctionGameInventory sanctionGameInventory;
	
	private Data data;
	
	private SpartaMod plugin;
	
	public SanctionManager(SpartaMod plugin) {
		this.plugin = plugin;
	}
	
	public void insertSanction(Player modo, OfflinePlayer player) {
		sanctions.put(modo, player);
		openSanctionInventory(modo);
	}
	
	public void removeSanction(Player modo) {
		sanctions.remove(modo);
	}
	
	public void clearSanction() {
		sanctions.clear();
	}
	
	public boolean containsModo(Player modo) {
		return sanctions.containsKey(modo);
	}
	
	public boolean containsPlayer(OfflinePlayer player) {
		return sanctions.containsValue(player);
	}
	
	public OfflinePlayer getPlayer(Player modo) {
		return sanctions.get(modo);
	}
	
	public OfflinePlayer getModo(OfflinePlayer player) {
		for(Entry<OfflinePlayer, OfflinePlayer> entry : sanctions.entrySet()) {
			if(entry.getValue().equals(player) ) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	public void openSanctionInventory(Player modo) {
		modo.openInventory(sanctionInventory.sanctionInventory());
	}
	
	public void openChatInventory(Player modo) {
		modo.openInventory(sanctionChatInventory.sanctionChatInventory());
	}
	
	public void openGameInventory(Player modo) {
		modo.openInventory(sanctionGameInventory.sanctionGameInventory());
	}
	
	public void sanction(Player modo, OfflinePlayer c, String sanction) {
		if (!data.getSanction(c).contains(sanction)) {
			data.insertSanction(sanction, c);
			
			switch(sanction) {
				case "flood":
					modo.sendMessage(plugin.strConfig("message.avertissement").replace("%player%", c.getName()));
					break;
				case "spam":
					modo.sendMessage(plugin.strConfig("message.avertissement").replace("%player%", c.getName()));
					break;
				case "insulte1":
					modo.sendMessage(plugin.strConfig("message.avertissement").replace("%player%", c.getName()));
					mute(modo, c, "10m", "Insultes");
					break;
				case "insulte2":
					modo.sendMessage(plugin.strConfig("message.avertissement").replace("%player%", c.getName()));
					mute(modo, c, "30m", "Insultes");
					break;
				
				case "xray":
					modo.performCommand(plugin.strConfig("commands.clear").replace("%player%", c.getName()));
					tempban(modo, c, "1mo", "X-Ray");
					break;
				case "cheat":
					tempban(modo, c, "1mo", "Cheat");
					break;
				case "vol":
					tempban(modo, c, "12h", "Vol");
					break;
				case "usebug":
					ban(modo, c, "Usebug");
					break;
				case "eco":
					warn(modo, c, "Economie");
					break;
				case "arnaque":
					tempban(modo, c, "1d", "Arnaque");
					break;
				case "anti-afk":
					tempban(modo, c, "2d", "Anti-AFK");
					break;
				case "kill":
					modo.sendMessage(plugin.strConfig("message.avertissement").replace("%player%", c.getName()));
					break;
				default:
					modo.sendMessage();
					break;
			}

		} else if (data.getSanctionAmount(c).get(data.getSanction(c).indexOf(sanction)) == 1) {
			data.addSanction(sanction, c);
			
			switch(sanction) {
				case "flood":
					mute(modo, c, "30m", "Flood");
					break;
				case "spam":
					mute(modo, c, "1h", "Spam");
					break;
				case "insulte1":
					mute(modo, c, "1h", "Insultes");
					break;
				case "insulte2":
					warn(modo, c, "Insultes");
					mute(modo, c, "1h", "Insultes");
					break;
				
				case "xray":
					ban(modo, c, "X-Ray");
					break;
				case "cheat":
					ban(modo, c, "Cheat");
					break;
				case "vol":
					tempban(modo, c, "2w", "Vol");
					break;
				case "usebug":
					ban(modo, c, "Usebug");
					break;
				case "eco":
					warn(modo, c, "Economie");
					break;
				case "arnaque":
					tempban(modo, c, "3d", "Arnaque");
					break;
				case "anti-afk":
					tempban(modo, c, "4d", "Anti-AFK");
					break;
				case "kill":
					modo.performCommand(plugin.strConfig("commands.kick").replace("%player%", c.getName()).replace("%reason%", "Kill"));
					break;
				default:
					modo.sendMessage();
					break;
			}
			
		} else if (data.getSanctionAmount(c).get(data.getSanction(c).indexOf(sanction)) >= 2) {
			data.addSanction(sanction, c);
			
			switch(sanction) {
				case "flood":
					mute(modo, c, "1h", "Flood");
					break;
				case "spam":
					mute(modo, c, "2h", "Spam");
					break;
				case "insulte1":
					warn(modo, c, "Insultes");
					break;
				case "insulte2":
					tempban(modo, c, "1h", "Insultes");
					break;
				
				case "xray":
					ban(modo, c, "X-Ray");
					break;
				case "cheat":
					ban(modo, c, "Cheat");
					break;
				case "vol":
					ban(modo, c, "Vol");
					break;
				case "usebug":
					ban(modo, c, "Usebug");
					break;
				case "eco":
					warn(modo, c, "Economie");
					break;
				case "arnaque":
					ban(modo, c, "Arnaque");
					break;
				case "anti-afk":
					tempban(modo, c, "6d", "Anti-AFK");
					break;
				case "kill":
					tempban(modo, c, "2d", "Anti-AFK");
					break;
				default:
					modo.sendMessage();
					break;
			}
			
		} 
	}
  
	public void mute(Player modo, OfflinePlayer c, String time, String raison) {
		modo.performCommand(plugin.strConfig("commands.mute").replace("%player%", c.getName()).replace("%time%", time).replace("%reason%", raison));
	}
  
	public void tempban(Player modo, OfflinePlayer c, String time, String raison) {
		modo.performCommand(plugin.strConfig("commands.tempban").replace("%player%", c.getName()).replace("%time%", time).replace("%reason%", raison));
	}
  
	public void ban(Player modo, OfflinePlayer c, String raison) {
		modo.performCommand(plugin.strConfig("commands.ban").replace("%player%", c.getName()).replace("%reason%", raison));
	}
  
	public void warn(Player modo, OfflinePlayer c, String raison) {
		modo.performCommand(plugin.strConfig("commands.warn").replace("%player%", c.getName()).replace("%reason%", raison));
	}
	
	
}
