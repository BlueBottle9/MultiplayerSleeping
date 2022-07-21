package bluescreen9.minecraft.bukkit.multiplayersleeping;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
		protected static Plugin MultiplayerSleeping;
		protected static FileConfiguration Config;
		@Override
		public void onEnable() {
			MultiplayerSleeping = Main.getPlugin(Main.class);
			saveDefaultConfig();
			reloadConfig();
			Config = getConfig();
			getServer().getPluginManager().registerEvents(new EventsListenner(), this);
			getServer().getWorld("world").setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, 101);
			Data.TitleType = ChatColor.translateAlternateColorCodes('&', Config.getString("bar-title"));
			Data.Night = Bukkit.createBossBar(Data.TitleType,
					BarColor.valueOf(Config.getString("bar-color")),
					BarStyle.valueOf(Config.getString("bar-style")), BarFlag.CREATE_FOG);
			Data.Night.removeFlag(BarFlag.CREATE_FOG);
			Data.OverWorld = Bukkit.getWorld("world");
			new BukkitRunnable() {
				public void run() {
					for (Player p:Data.OverWorld.getPlayers()) {
							if (!p.isSleeping()) {
								Data.SleepingPlayerList.remove(p);
							}
					}
				}
			}.runTaskTimer(MultiplayerSleeping, 90L, 20L);
		}
}
