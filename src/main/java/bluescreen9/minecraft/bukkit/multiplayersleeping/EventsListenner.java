package bluescreen9.minecraft.bukkit.multiplayersleeping;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class EventsListenner implements Listener{
		@EventHandler
		public void onPlayerGoToBed(PlayerBedEnterEvent event) {
			Player player = event.getPlayer();
			long ticks = Main.MultiplayerSleeping.getServer().getWorld("world").getTime();
			if (ticks >= 12500 || ticks < 1000) {
			Data.Night.setProgress(0.0D);
			new SleepTask(player).runTaskLater(Main.MultiplayerSleeping, 5L);
			}
		}
		@EventHandler
		public void onPlayerLeaveBed(PlayerBedLeaveEvent event) {
			Player player = event.getPlayer();
			Data.SleepingPlayerList.remove(player);
			long tick1 = Main.MultiplayerSleeping.getServer().getWorld("world").getTime();
			if (tick1 < 1000 || tick1 > 23000) {
				player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1000.0F, 1.0F);
			}
			if (Data.SleepingPlayerList.isEmpty()) {
			Data.Night.removeAll();
			Data.Night.setVisible(false);
			}
		}
}
