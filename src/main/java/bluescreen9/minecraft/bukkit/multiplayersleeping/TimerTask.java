package bluescreen9.minecraft.bukkit.multiplayersleeping;

import org.bukkit.scheduler.BukkitRunnable;

public class TimerTask extends BukkitRunnable{
		public void run() {
			if (!Data.SleepingPlayerList.isEmpty()) {
			new SkipNightTask().runTask(Main.MultiplayerSleeping);
			}
		}
}
