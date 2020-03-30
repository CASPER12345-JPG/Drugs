package cc.imthi.drugs.versions;

import net.minecraft.server.v1_15_R1.*;
import net.minecraft.server.v1_15_R1.PacketPlayInClientCommand.EnumClientCommand;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_15_R1.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import cc.imthi.drugs.DrugsPlugin;

public class R1_15 extends VersionHandler {
	
	public void forceRespawn(final Player player){
		Bukkit.getScheduler().scheduleSyncDelayedTask(DrugsPlugin.plugin, new Runnable(){
			@Override
			public void run() {
				if(player.isDead()){
	        		final PacketPlayInClientCommand packet = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
	        		
	        		((CraftPlayer) player).getHandle().playerConnection.a(packet);
				}
			}
		}, 2);
	}

	public void sendCameraPacket(Player player, Entity e){
		final PacketPlayOutCamera packet = new PacketPlayOutCamera(((CraftEntity) e).getHandle());
		
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}
}
