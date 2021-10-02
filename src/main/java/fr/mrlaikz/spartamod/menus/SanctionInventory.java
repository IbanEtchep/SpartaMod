package fr.mrlaikz.spartamod.menus;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.mrlaikz.spartamod.SpartaMod;

public class SanctionInventory {

	private SpartaMod plugin;
	private FileConfiguration config;
	
	public SanctionInventory(SpartaMod plugin) {
		this.plugin = plugin;
		this.config = plugin.getConfig();
	}
	
	public Inventory sanctionInventory() {
		
		Inventory inv = Bukkit.createInventory(null, 54, plugin.strConfig("inventory.sanction.name"));
		
		ItemStack chat = new ItemStack(plugin.matConfig("inventory.sanction.chat.item"));
		ItemStack game = new ItemStack(plugin.matConfig("inventory.sanction.game.item"));
		
		ItemMeta chatM = chat.getItemMeta();
	    ItemMeta gameM = game.getItemMeta();
	    
	    chatM.setDisplayName(plugin.strConfig("inventory.sanction.chat.name"));
	    gameM.setDisplayName(plugin.strConfig("inventory.sanction.game.name"));
	    
	    if (config.getBoolean("inventory.sanction.chat.enchant")) {
	    	chatM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	chatM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    if (config.getBoolean("inventory.sanction.game.enchant")) {
	    	gameM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	gameM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    chat.setItemMeta(chatM);
	    game.setItemMeta(gameM);
	    
	    inv.setItem(20, chat);
	    inv.setItem(24, game);
		
	    return inv;
		
	}
	
	
}
