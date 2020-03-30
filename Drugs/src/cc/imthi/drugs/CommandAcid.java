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





public class CommandAcid implements CommandExecutor {

	
	
	
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
			DrugsPlugin.playEffect(player, CameraEffect.Enderman);
			Bukkit.getScheduler().scheduleSyncDelayedTask(DrugsPlugin.plugin, new Runnable(){
				@Override
				public void run() {
					player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 650, 1));
		            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 650, 127));
		            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 650, 127));
		            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 650, 127));
		            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 650, 2));
		            
				}
			}, 4);
			Bukkit.getScheduler().scheduleSyncDelayedTask(DrugsPlugin.plugin, new Runnable(){
				@Override
				public void run() {
					DrugsPlugin.playEffect(player, CameraEffect.Normal);	
					
			}
			}, 650);
			
			
			
			
			
			
			
			

			player.setHealthScale(30);
            
            
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Have funnnn");
        } else {
        	player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You must clear your inventory before taking Acid.");
        }
		}
		return true;
		}
		

		
		

		
	
}
