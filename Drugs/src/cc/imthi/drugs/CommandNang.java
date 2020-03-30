package cc.imthi.drugs;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandNang implements CommandExecutor {

	
	
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player)  {
            Player player = (Player) sender;

            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 250, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 250, 3));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 250, 3));
            
            player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You just ruined a perfectly good balloon");
        } 

        // If the player (or console) uses our command correct, we can return true
        return true;
    
		

	}
}
