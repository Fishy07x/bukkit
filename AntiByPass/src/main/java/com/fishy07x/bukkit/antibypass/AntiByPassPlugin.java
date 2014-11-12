package com.fishy07x.bukkit.antibypass;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;


public final class AntiByPassPlugin extends JavaPlugin {
	private final PlayerListener playerListener = new PlayerListener(this);
	private final BlockListener blockListener = new BlockListener(this);
	
	public WorldGuardPlugin worldguard;

	public ArrayList<CustomPlayerData> playerData;
	
	@Override
	public void onEnable() {
		init();
	}
	
	@Override
	public void onDisable(){
		
	}
	
	public void init(){
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(playerListener, this);
		pm.registerEvents(blockListener, this);
		
		worldguard = getWorldGuard();
		
		//Make new playerData arraylist
		playerData = new ArrayList<CustomPlayerData> ();
		
		//Insert current online players into the playerData arraylist
		Player[] curPlayers = Bukkit.getServer().getOnlinePlayers();
		for (int i = 0; i < curPlayers.length; i++) {
			playerData.add(new CustomPlayerData(curPlayers[i]));
		}
	}
	
	private WorldGuardPlugin getWorldGuard() {
	    Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
	 
	    // WorldGuard may not be loaded
	    if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
	        return null; // Maybe you want throw an exception instead
	    }
	 
	    return (WorldGuardPlugin) plugin;
	}
	

}
