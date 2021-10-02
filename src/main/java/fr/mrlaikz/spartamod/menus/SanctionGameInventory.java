package fr.mrlaikz.spartamod.menus;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.mrlaikz.spartamod.SpartaMod;

public class SanctionGameInventory {

	private SpartaMod plugin;
	private FileConfiguration config;
	
	public SanctionGameInventory(SpartaMod plugin) {
		this.plugin = plugin;
		this.config = plugin.getConfig();
	}
	
	public Inventory sanctionGameInventory() {
		
	    Inventory inv = Bukkit.createInventory(null, 45, plugin.strConfig("inventory.sanction.game.name"));
	    
	    ItemStack xray = new ItemStack(plugin.matConfig("inventory.sanction.game.xray.item"));
	    ItemStack cheat = new ItemStack(plugin.matConfig("inventory.sanction.game.cheat.item"));
	    ItemStack vol = new ItemStack(plugin.matConfig("inventory.sanction.game.vol.item"));
	    ItemStack usebug = new ItemStack(plugin.matConfig("inventory.sanction.game.usebug.item"));
	    ItemStack eco = new ItemStack(plugin.matConfig("inventory.sanction.game.eco.item"));
	    ItemStack arnaque = new ItemStack(plugin.matConfig("inventory.sanction.game.arnaque.item"));
	    ItemStack afk = new ItemStack(plugin.matConfig("inventory.sanction.game.afk.item"));
	    ItemStack kill = new ItemStack(plugin.matConfig("inventory.sanction.game.kill.item"));
	    
	    ItemMeta xrayM = xray.getItemMeta();
	    ItemMeta cheatM = cheat.getItemMeta();
	    ItemMeta volM = vol.getItemMeta();
	    ItemMeta usebugM = usebug.getItemMeta();
	    ItemMeta ecoM = eco.getItemMeta();
	    ItemMeta arnaqueM = arnaque.getItemMeta();
	    ItemMeta afkM = afk.getItemMeta();
	    ItemMeta killM = kill.getItemMeta();
	    
	    xrayM.setDisplayName(plugin.strConfig("inventory.sanction.game.xray.name"));
	    cheatM.setDisplayName(plugin.strConfig("inventory.sanction.game.cheat.name"));
	    volM.setDisplayName(plugin.strConfig("inventory.sanction.game.vol.name"));
	    usebugM.setDisplayName(plugin.strConfig("inventory.sanction.game.usebug.name"));
	    ecoM.setDisplayName(plugin.strConfig("inventory.sanction.game.eco.name"));
	    arnaqueM.setDisplayName(plugin.strConfig("inventory.sanction.game.arnaque.name"));
	    afkM.setDisplayName(plugin.strConfig("inventory.sanction.game.afk.name"));
	    killM.setDisplayName(plugin.strConfig("inventory.sanction.game.kill.name"));
	    
	    if (config.getBoolean("inventory.sanction.game.xray.enchant")) {
	    	xrayM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	xrayM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    if (config.getBoolean("inventory.sanction.game.cheat.enchant")) {
	    	cheatM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	cheatM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    if (config.getBoolean("inventory.sanction.game.vol.enchant")) {
	    	volM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	volM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    if (config.getBoolean("inventory.sanction.game.usebug.enchant")) {
	    	usebugM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	usebugM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    if (config.getBoolean("inventory.sanction.game.eco.enchant")) {
	    	ecoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	ecoM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    if (config.getBoolean("inventory.sanction.game.arnaque.enchant")) {
	    	arnaqueM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	arnaqueM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    if (config.getBoolean("inventory.sanction.game.afk.enchant")) {
	    	afkM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	afkM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    if (config.getBoolean("inventory.sanction.game.kill.enchant")) {
	    	killM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	    	killM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    } 
	    
	    xray.setItemMeta(xrayM);
	    cheat.setItemMeta(cheatM);
	    vol.setItemMeta(volM);
	    usebug.setItemMeta(usebugM);
	    eco.setItemMeta(ecoM);
	    arnaque.setItemMeta(arnaqueM);
	    afk.setItemMeta(afkM);
	    kill.setItemMeta(killM);
	    
	    inv.setItem(2, xray);
	    inv.setItem(6, cheat);
	    inv.setItem(19, vol);
	    inv.setItem(22, usebug);
	    inv.setItem(25, eco);
	    inv.setItem(37, arnaque);
	    inv.setItem(40, afk);
	    inv.setItem(43, kill);
	    
	    return inv;
	    
	}
	
}
