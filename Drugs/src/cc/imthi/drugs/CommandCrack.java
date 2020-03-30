package cc.imthi.drugs;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class CommandCrack implements CommandExecutor {

	
	
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player)  {
            Player player = (Player) sender;
			boolean playerInventoryEmpty = true;
		     for (ItemStack item : player.getInventory().getContents() ) {
		       if ( item != null ) {
		         playerInventoryEmpty = false;
		         break;
		       }
		     }
		
		if ( playerInventoryEmpty) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 650, 4));
            player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 650, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 650, 2));
            player.setHealthScale(4);
            
            
            player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Enjoy your crack!");
        } else {
        	player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You must empty your inventory before smoking rock.");
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
		return false;

	}
}
