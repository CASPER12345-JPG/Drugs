package cc.imthi.drugs.versions;

import org.bukkit.Bukkit;

import cc.imthi.drugs.Console;
import cc.imthi.drugs.DrugsPlugin;

public enum Version {
	
	
	
	R1_15(15, R1_15.class);
	
	public static Version current;
	
	private final int number;
	private final Class<? extends VersionHandler> handlerClass;
	
	private VersionHandler handler;
	
	private Version(int number, Class<? extends VersionHandler> handlerClass){
		this.number = number;
		this.handlerClass = handlerClass;
	}
	
	public int getVersionNumber(){ return this.number; }
	
	public VersionHandler getHandler(){
		if(this.handler == null){
			try{
				this.handler = (VersionHandler) handlerClass.newInstance();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return this.handler;
	}
	
	public static boolean onEnable(){
		final String PATH = Bukkit.getServer().getClass().getPackage().getName();
		final String VERSION = PATH.substring(PATH.lastIndexOf(".")+1, PATH.length());
		String[] vs = VERSION.split("_");
		
		String bwVersionName = vs[2] + "_" + vs[1];
		
		try{
			Version.current = valueOf(bwVersionName);
			// version.raw = Bukkit.getVersion().split("-")[0];
		}catch(IllegalArgumentException e){
			// msg if no version
			if(Version.current  == null){
				Console.printWarn("IMPORTANT: Failed to work with your version. (" + VERSION + ")! Maybe it's unsupported?");
				Console.printWarn("Stopping the plugin...");
				Bukkit.getPluginManager().disablePlugin(DrugsPlugin.plugin);
				return false;
			}
		}
		
		return true;
	}
}
