package com.bars.bars;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class voids {
	public static HashMap<Player, Integer> web = new HashMap<Player, Integer>(); 
	public static BossBar bs = Bukkit.createBossBar("title", Random(), BarStyle.SOLID);
	public static ChatColor tc=  ChatColor.GRAY;
	
	public static String watermark = "AdBars v1.1" + ChatColor.GRAY + " :Made by Team Dotmagic";
	public static String titles(int a) {
		if(a==0) return "1번 제목입니다.";
		if(a==1) return "2번 제목입니다.";
		if(a==2) return "3번 제목입니다.";
		if(a==3) return "4번 제목입니다.";
		if(a==4) return "5번 제목입니다.";
		if(a==5) return "6번 제목입니다.";
		if(a==6) return "7번 제목입니다.";
		if(a==7) return "없는 제목입니다.";
		return "ERROR";
	}
	
	public static void NewBarRegister(Player p) {
		bs.addPlayer(p);
		bs.setTitle(ChatColor.WHITE + watermark);
		int count;

		count = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getPlugin(main.class), new Runnable() {
			double total = 8*10;
			double point = total;

			@Override
			public void run() {
				bs.show();
				bs.setVisible(true);
				
				point = point - 1*1;
				
				if (point <= 0) {
					bs.removePlayer(p);
					
					bs.setColor(Random());
					bs.setTitle(RandomWriting());
					
					point = total;
					bs.addPlayer(p);
					
				}
				
				double nwp = point/total;
				bs.setProgress(nwp);
				//Bukkit.broadcastMessage(nwp + "nwp"+ point + "point");
			}
		}, 0L, 2L);
		
		web.put(p, count);

	}

	public static BarColor Random() { //not random, sequencial route.
		Random rand = new Random();
		int i = rand.nextInt(5);

		switch (i) {
		case 0:
			tc = ChatColor.RED;
			return BarColor.RED;
		case 1:
			tc = ChatColor.YELLOW;
			return BarColor.YELLOW;
		case 2:
			tc = ChatColor.GREEN;
			return BarColor.GREEN;
		case 3:
			tc = ChatColor.BLUE;
			return BarColor.BLUE;
		case 4:
			tc = ChatColor.DARK_PURPLE;
			return BarColor.PURPLE;
		default:
			return BarColor.YELLOW;
		}
	}

	public static String RandomWriting() {
		Random rand = new Random();
		int i = rand.nextInt(7);

		return tc + titles(i);
	}
}
