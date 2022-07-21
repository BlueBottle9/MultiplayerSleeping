package bluescreen9.minecraft.bukkit.multiplayersleeping;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SleepTask extends BukkitRunnable{
	private Player player;
		public void run() {
			if (player.isSleeping()) {
				Data.SleepingPlayerList.add(player);
				for (int i = 0;i < Data.OverWorld.getPlayers().size();i++) {
					Data.Night.addPlayer(Data.OverWorld.getPlayers().get(i));
				}
				Data.Night.setVisible(true);
				if (!Data.IsTasking) {
					new TimerTask().runTaskTimer(Main.MultiplayerSleeping, 0L, 5L);
					Data.IsTasking = true;
				}
				}
		}
		public SleepTask(Player player) {
			this.player = player;
		}
}
