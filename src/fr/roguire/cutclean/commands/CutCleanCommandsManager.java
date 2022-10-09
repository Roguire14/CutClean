package fr.roguire.cutclean.commands;

import org.bukkit.Bukkit;
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
			
			boolean state = plugin.getStatus();
			
			if(!player.hasPermission("cc.change")) {
				
				player.sendMessage(plugin.getStringFromConfig("no-permission"));
				return true;
				
			}
			
			if(state) {
				
				plugin.setStatus(false);
				Bukkit.broadcastMessage(plugin.getStringFromConfig("desactivation"));
				success = true;
								
			}else {
				
				plugin.setStatus(true);
				Bukkit.broadcastMessage(plugin.getStringFromConfig("activation"));
				success = true;
				
			}
			
		}
		
		return success;
		
	}

}
