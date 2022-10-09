package fr.roguire.cutclean.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import fr.roguire.cutclean.CutClean;
import fr.roguire.cutclean.utils.Check;
import fr.roguire.cutclean.utils.Fortune;
import fr.roguire.cutclean.utils.Looting;

public class CutCleanListeners implements Listener {
	
	private CutClean plugin;
	private List<ItemStack> loots;
	
	public CutCleanListeners(CutClean cutClean) {
		plugin = cutClean;
		loots = new ArrayList<>();
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		if(!Check.checkBlock(e.getBlock())) return;
		
		if(!plugin.getStatus()) return;
		
		if(e.getPlayer().getGameMode() != GameMode.SURVIVAL) return;
		
		Block block = e.getBlock();
		World world = block.getWorld();
		ItemStack ore = null;
		Material handIt = e.getPlayer().getItemInHand().getType();
		
		switch (e.getBlock().getType()) {
		case GOLD_ORE:
			if(handIt == Material.IRON_PICKAXE || handIt == Material.GOLD_PICKAXE || handIt == Material.DIAMOND_PICKAXE) {
				ore = new ItemStack(Material.GOLD_INGOT);
				e.setExpToDrop(4);
				break;
			}else return;
			
		case IRON_ORE:
			ore = new ItemStack(Material.IRON_INGOT);
			e.setExpToDrop(5);
			break;
		default:
			break;
		}
		
		ore.setAmount(Fortune.getQuantity(e.getPlayer().getItemInHand()));
		world.dropItemNaturally(block.getLocation(), ore);
		
		e.getBlock().setType(Material.AIR);
		
	}
	
	@EventHandler
	public void onEntityKill(EntityDeathEvent e) {
		
		if(!Check.checkEntity(e.getEntity())) return;
		
		if(!plugin.getStatus()) return; 
		
		ItemStack loot = null;
		
		switch(e.getEntityType()) {
		
		case MUSHROOM_COW:
		case COW:
			addLoot(e.getDrops(),Material.RAW_BEEF);
			loot = new ItemStack(Material.COOKED_BEEF);
			break;
			
		case CHICKEN:
			addLoot(e.getDrops(),Material.RAW_CHICKEN);
			loot = new ItemStack(Material.COOKED_CHICKEN);
			break;
		
		case PIG:
			addLoot(e.getDrops(),Material.PORK);
			loot = new ItemStack(Material.GRILLED_PORK);
			break;
			
		case RABBIT:
			addLoot(e.getDrops(),Material.RABBIT);
			loot = new ItemStack(Material.COOKED_RABBIT);
			break;
			
		case SHEEP:
			addLoot(e.getDrops(),Material.MUTTON);
			loot = new ItemStack(Material.COOKED_MUTTON);
			break;
			
		default:
			break;
		}
		
		e.getDrops().clear();
		
		for(ItemStack it: loots)
			e.getDrops().add(it);
		
		loot.setAmount(Looting.getQuantity(e.getEntityType(), e.getEntity().getKiller().getItemInHand()));
		e.getDrops().add(loot);
		
	}
	
	private void addLoot(List<ItemStack> list, Material mat) {
		loots.clear();
		for(ItemStack it: list)
			if(it.getType() != mat)
				loots.add(it);
	}

}
