package fr.mrlaikz.spartamod.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.mrlaikz.spartamod.SpartaMod;

public class SanctionGui implements CommandExecutor {

	private SpartaMod plugin;
	
	public SanctionGui(SpartaMod plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender.hasPermission("spartamod.admin")) {
			plugin.reloadConfig();
			plugin.strConfig("message.config_reload");
		} else {
			sender.sendMessage(plugin.strConfig("message.permission"));
		}
		
		
		return false;
	}

}
