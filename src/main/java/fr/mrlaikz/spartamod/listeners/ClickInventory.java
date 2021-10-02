package fr.mrlaikz.spartamod.listeners;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.mrlaikz.spartamod.SpartaMod;

public class ClickInventory implements Listener {

	private SpartaMod plugin;
	
	public ClickInventory(SpartaMod plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		String name = e.getView().getTitle();
		OfflinePlayer c = plugin.getSanctionManager().getPlayer(p);
		if (name.equals(plugin.strConfig("inventory.sanction.name")) && plugin.getSanctionManager().containsModo(p)) {
		
			if(e.getCurrentItem() != null) {
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.chat.name"))) {
					p.closeInventory();
					p.performCommand("sanctiongui chat");
				} 
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.game.name"))) {
					p.closeInventory();
	        		p.performCommand("sanctiongui game");
				} 
        
				e.setCancelled(true);
	        
			} 
		}
		
		if (name.equals(plugin.strConfig("inventory.sanction.chat.name")) || name.equals(plugin.strConfig("inventory.sanction.game.name"))) {
			
			e.setCancelled(true);
			p.closeInventory();
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.chat.flood.name"))) {
				plugin.getSanctionManager().sanction(p, c, "flood");
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.chat.spam.name"))) {
				plugin.getSanctionManager().sanction(p, c, "spam"); 
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.chat.insulte1.name"))) {
				plugin.getSanctionManager().sanction(p, c, "insulte1");
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.chat.insulte2.name"))) {
				plugin.getSanctionManager().sanction(p, c, "insulte2"); 
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.game.xray.name"))) {
				plugin.getSanctionManager().sanction(p, c, "xray"); 
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.game.cheat.name"))) {
				plugin.getSanctionManager().sanction(p, c, "cheat"); 
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.game.vol.name"))) {
				plugin.getSanctionManager().sanction(p, c, "vol"); 
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.game.usebug.name"))) {
				plugin.getSanctionManager().sanction(p, c, "usebug"); 
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.game.eco.name"))) {
				plugin.getSanctionManager().sanction(p, c, "eco"); 
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.game.arnaque.name"))) {
				plugin.getSanctionManager().sanction(p, c, "arnaque"); 
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.game.afk.name"))) {
				plugin.getSanctionManager().sanction(p, c, "anti-afk"); 
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.strConfig("inventory.sanction.game.kill.name"))) {
				plugin.getSanctionManager().sanction(p, c, "kill"); 
			}
			
			plugin.getSanctionManager().removeSanction(p);
		} 
	}

}
