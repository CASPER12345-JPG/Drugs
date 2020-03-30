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

public class CommandSpeed implements CommandExecutor {

	
	
	
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
							player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 127));
				            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 127));
				            player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 1200, 127));
				            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1200, 127));
				            player.setHealthScale(3);
				            
				            player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + "gotta go fast");
				        
				            
						}
					}, 4);
					Bukkit.getScheduler().scheduleSyncDelayedTask(DrugsPlugin.plugin, new Runnable(){
						@Override
						public void run() {
							DrugsPlugin.playEffect(player, CameraEffect.Normal);	
							
					}
					}, 1200); 
					} else {
        	player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You must empty your inventory before taking speed.");
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
		return false;

	}
}
