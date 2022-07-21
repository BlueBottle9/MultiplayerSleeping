package bluescreen9.minecraft.bukkit.multiplayersleeping;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GetUP extends BukkitRunnable{
		public void run() {
			for(int i = 0;i < Data.SleepingPlayerList.size();i++) {
				Player player = Data.SleepingPlayerList.get(i);
				player.wakeup(true);
			}
		}
}
