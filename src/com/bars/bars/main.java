package com.bars.bars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {

	@Override
	public void onDisable() {
	}

	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		voids.NewBarRegister(e.getPlayer());
	}

	@EventHandler
	public void OnPlayerQuit(PlayerQuitEvent e) {
		Bukkit.getScheduler().cancelTask(voids.web.get(e.getPlayer()));
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		ConsoleCommandSender consol = Bukkit.getConsoleSender();
		System.out.println(ChatColor.GREEN + "[AdBars v1.1] AdBars v1.1 Service has been started!");
	}

}
