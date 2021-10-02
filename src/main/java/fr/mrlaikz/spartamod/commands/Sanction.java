package fr.mrlaikz.spartamod.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mrlaikz.spartamod.SpartaMod;

public class Sanction implements CommandExecutor {

	private SpartaMod plugin;
	
	public Sanction(SpartaMod plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			if(p.hasPermission("spartamod.use")) {
				
				if(args.length == 0 || args.length > 1) {
					p.sendMessage(plugin.strConfig("message.syntax"));
				}
				
				if(args.length == 1) {
					
					OfflinePlayer c = Bukkit.getPlayer(args[0]);
					if(c != null) {
						
						plugin.getSanctionManager().insertSanction(p, c);
						
					} else {
						p.sendMessage(plugin.strConfig("message.invalid_player"));
					}
					
				}
				
			} else {
				p.sendMessage(plugin.strConfig("message.permission"));
			}
			
			
		}
		
		return false;
	}

}
