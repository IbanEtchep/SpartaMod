package fr.mrlaikz.spartamod.menus;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.mrlaikz.spartamod.SpartaMod;

public class SanctionChatInventory {

	private SpartaMod plugin;
	private FileConfiguration config;
	
	public SanctionChatInventory(SpartaMod plugin) {
		this.plugin = plugin;
		this.config = plugin.getConfig();
	}
	
	public Inventory sanctionChatInventory() {
		
	    Inventory inv = Bukkit.createInventory(null, 54, plugin.strConfig("inventory.sanction.chat.name"));
	    
	    ItemStack flood = new ItemStack(plugin.matConfig("inventory.sanction.chat.flood.item"));
	    ItemStack spam = new ItemStack(plugin.matConfig("inventory.sanction.chat.spam.item"));
	    ItemStack insulte1 = new ItemStack(plugin.matConfig("inventory.sanction.chat.insulte1.item"));
	    ItemStack insulte2 = new ItemStack(plugin.matConfig("inventory.sanction.chat.insulte1.item"));
	    
	    ItemMeta floodM = flood.getItemMeta();
	    ItemMeta spamM = spam.getItemMeta();
	    ItemMeta insulte1M = insulte1.getItemMeta();
	    ItemMeta insulte2M = insulte2.getItemMeta();
	    
	    floodM.setDisplayName(plugin.strConfig("inventory.sanction.chat.flood.name"));
	    spamM.setDisplayName(plugin.strConfig("inventory.sanction.chat.spam.name"));
	    insulte1M.setDisplayName(plugin.strConfig("inventory.sanction.chat.insulte1.name"));
	    insulte2M.setDisplayName(plugin.strConfig("inventory.sanction.chat.insulte2.name"));
	    
	    if (config.getBoolean("inventory.sanction.chat.flood.enchant")) {
	    	floodM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	floodM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    if (config.getBoolean("inventory.sanction.chat.spam.enchant")) {
	    	spamM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	spamM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    if (config.getBoolean("inventory.sanction.chat.insulte1.enchant")) {
	    	insulte1M.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	insulte1M.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    if (config.getBoolean("inventory.sanction.chat.insulte2.enchant")) {
	    	insulte2M.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	insulte2M.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    flood.setItemMeta(floodM);
	    spam.setItemMeta(spamM);
	    insulte1.setItemMeta(insulte1M);
	    insulte2.setItemMeta(insulte2M);
	    
	    inv.setItem(11, flood);
	    inv.setItem(15, spam);
	    inv.setItem(29, insulte1);
	    inv.setItem(33, insulte2);
	    
	    return inv;
	    
	}
	
	
	
}
