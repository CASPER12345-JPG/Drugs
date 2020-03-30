package cc.imthi.drugs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandWeed implements CommandExecutor {

	
	
	
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
					DrugsPlugin.playEffect(player, CameraEffect.Creeper);
					Bukkit.getScheduler().scheduleSyncDelayedTask(DrugsPlugin.plugin, new Runnable(){
						@Override
						public void run() {
							player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 4));
				            player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1200, 1));
				            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 1200, 1));
				            player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1200, 2));
				            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 1500, 2));
				            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1200, 2));
				            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "dont green out nigga");
						}
					}, 4);
					Bukkit.getScheduler().scheduleSyncDelayedTask(DrugsPlugin.plugin, new Runnable(){
						@Override
						public void run() {
							DrugsPlugin.playEffect(player, CameraEffect.Normal);	
							
					}
					}, 1650); 
					}	
					
					else {
        	player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You must empty your inventory before taking drugs.");
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
		return false;

	}
}
