package fr.roguire.cutclean.utils;

import java.util.Random;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public final class Fortune {
	
	public static int getQuantity(ItemStack is) {
		
		int quantity = 1;
		
		if(is.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
			
			int rdm = new Random().nextInt(101);
			
			int level_enchant = is.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
			
			switch (level_enchant) {
			
			case 1:
				if(rdm < 66) quantity = 1;
				else quantity = 2;
				break;

			case 2:
				if(rdm < 50) quantity = 1;
				else if(rdm >= 50 && rdm < 75) quantity = 2;
				else quantity = 3;
				break;
				
			case 3:
				if(rdm < 40) quantity = 1;
				else if(rdm >= 40 && rdm < 60) quantity = 2;
				else if(rdm >= 60 && rdm < 80) quantity = 3;
				else quantity = 4;
				break;
				
			}
			
		}
		
		return quantity;
		
	}

}
