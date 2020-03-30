package cc.imthi.drugs;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;


public class CommandSober implements CommandExecutor {

	
	
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player)  {
            Player player = (Player) sender;

            for (PotionEffect effect : player.getActivePotionEffects())
                player.removePotionEffect(effect.getType());
            player.setHealthScale(20);
            player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Rehab successful");
            DrugsPlugin.playEffect(player, CameraEffect.Normal);
        } 

        // If the player (or console) uses our command correct, we can return true
        return true;
    
		

	}
}
