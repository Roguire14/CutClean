package fr.roguire.cutclean;

import org.bukkit.plugin.java.JavaPlugin;

import fr.roguire.cutclean.commands.CutCleanCommandsManager;
import fr.roguire.cutclean.listeners.CutCleanListeners;

public class CutClean extends JavaPlugin {
	
	private boolean status;
	
	public CutClean() {
		
		setStatus(false);
		
	}
	
	@Override
	public void onEnable() {
		
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		getCommand("cutclean").setExecutor(new CutCleanCommandsManager(this));
		
		getServer().getPluginManager().registerEvents(new CutCleanListeners(this), this);
		
	}
	
	public String getStringFromConfig(String arg) {
		
		return getConfig().getString(arg).replace('&', '§');
		
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
