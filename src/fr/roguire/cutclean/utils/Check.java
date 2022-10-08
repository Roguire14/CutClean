package fr.roguire.cutclean.utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public final class Check {
	
	public static boolean checkBlock(Block b) {
		
		Material matB = b.getType();
		
		return matB == Material.GOLD_ORE || matB == Material.IRON_ORE;
		
	}
	
	public static boolean checkEntity(Entity e) {
		
		EntityType eT = e.getType();
		
		return eT == EntityType.COW || eT == EntityType.PIG || eT == EntityType.MUSHROOM_COW || eT == EntityType.SHEEP || eT == EntityType.RABBIT || eT == EntityType.CHICKEN;
		
	}

}
