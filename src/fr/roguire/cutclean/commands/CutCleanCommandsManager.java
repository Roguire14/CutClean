package fr.roguire.cutclean.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.roguire.cutclean.CutClean;

public class CutCleanCommandsManager implements CommandExecutor {
	
	private CutClean plugin;
	
	public CutCleanCommandsManager(CutClean cutClean) {
		
		plugin = cutClean;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		boolean success = false;
		
		if(sender instanceof Player) {
			
			Player player = (Player)sender;
			
			if(args.length == 0) {
				
				if(cmd.getName().equals("activate")) {
					
					if(!player.hasPermission("cc.change")) {
						
						player.sendMessage(plugin.getStringFromConfig("no-permission"));
						return true;
					}
					
					if(plugin.getStatus()) {
						
						player.sendMessage(plugin.getStringFromConfig("already-on"));
						return true;
						
					}
					
					plugin.setStatus(true);
					player.sendMessage(plugin.getStringFromConfig("activation"));
					success = true;
					
				}else if(cmd.getName().equals("desactivate")) {
					
					if(!player.hasPermission("cc.change")) {
						
						player.sendMessage(plugin.getStringFromConfig("no-permission"));
						return true;
					
					}
					
					if(!plugin.getStatus()) {
						
						player.sendMessage(plugin.getStringFromConfig("already-off"));
						return true;
						
					}
					
					plugin.setStatus(false);
					player.sendMessage(plugin.getStringFromConfig("desactivation"));
					success = true;
					
				}
				
			}
			
			else if(args.length == 1) {
				
				if(args[0].equals("on")) {
					
					if(!player.hasPermission("cc.change")) {
						
						player.sendMessage(plugin.getStringFromConfig("no-permission"));
						return true;
						
					}
					
					if(plugin.getStatus()) {
						
						player.sendMessage(plugin.getStringFromConfig("already-on"));
						return true;
						
					}
					
					plugin.setStatus(true);
					player.sendMessage(plugin.getStringFromConfig("activation"));
					success = true;
					
				}else if(args[0].equals("off")) {
					
					if(!player.hasPermission("cc.change")) {
						
						player.sendMessage(plugin.getStringFromConfig("no-permission"));
						return true;
						
					}
					
					if(!plugin.getStatus()) {
						
						player.sendMessage(plugin.getStringFromConfig("already-off"));
						return true;
						
					}
					
					plugin.setStatus(false);
					player.sendMessage(plugin.getStringFromConfig("desactivation"));
					success = true;
					
				}
				
			}
			
		}
		
		return success;
		
	}

}
