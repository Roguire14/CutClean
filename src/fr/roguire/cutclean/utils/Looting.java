package fr.roguire.cutclean.utils;

import java.util.Random;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public final class Looting {
	
	public static int getQuantity(EntityType eT, ItemStack is) {
		
		int default_quantity = 0;
		
		switch(eT) {
		
		case PIG:
		case COW:
		case MUSHROOM_COW:
			default_quantity = 1 + new Random().nextInt(3);
			break;
			
		case SHEEP:
			default_quantity = 1 + new Random().nextInt(2);
			break;
			
		case RABBIT:
			default_quantity = new Random().nextInt(2);
			break;
		
		case CHICKEN:
			default_quantity = 1;
			
		default:
			break;		
		}
		
		int quantity = default_quantity;
		
		if(is.containsEnchantment(Enchantment.LOOT_BONUS_MOBS)) {
			
			int rdm = new Random().nextInt(101);
			
			int level_enchant = is.getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
			
			switch (level_enchant) {
			
			case 1:
				if(rdm < 50) quantity += 1;
				else quantity += 2;
				break;
				
			case 2:
				if(rdm < 25) quantity += 1;
				else if(rdm >= 25 && rdm < 75) quantity += 2;
				else quantity += 3;
				break;
				
			case 3:
				if(rdm < 17) quantity += 1;
				else if(rdm >= 17 && rdm < 40) quantity += 2;
				else if(rdm >= 40 && rdm < 73) quantity += 3;
				else quantity = 4;
				break;

			}
			
		}
		
		return quantity;
		
	}

}
