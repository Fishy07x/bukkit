package com.fishy07x.bukkit.antibypass;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener{
	private AntiByPassPlugin abp;
	
	public PlayerListener(AntiByPassPlugin abp) {
		this.abp = abp;
	}
	@EventHandler
	public void onLogin(PlayerJoinEvent e){	
		abp.playerData.add(new CustomPlayerData(e.getPlayer()));
	}
	
	@EventHandler
	public void onLogout(PlayerQuitEvent e){
		for (int i = 0; i < abp.playerData.size(); i++) {
			if(e.getPlayer().getEntityId() == abp.playerData.get(i).getEntityId()) {
				abp.playerData.remove(i);
				break;
			}
		}
	}
}
