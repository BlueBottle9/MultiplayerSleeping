package bluescreen9.minecraft.bukkit.multiplayersleeping;

import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class SkipNightTask extends BukkitRunnable{
	public static double food = 0.0D;
		public void run() {
			World OverWorld = Data.OverWorld;
			long tick1 = OverWorld.getTime();
			double tick2 = Main.MultiplayerSleeping.getConfig().getLong("SleepSkipNightSpeed") *
					(((double)Data.SleepingPlayerList.size()) / ((double)OverWorld.getPlayers().size()));
			addTicks((long) tick2);
			double tick3 = Math.abs(12500.0D - ((double)tick1));
			double tick4 = tick3 / 12500.0D;
			for (int i = 0;i < Data.SleepingPlayerList.size();i++) {
				Player player = Data.SleepingPlayerList.get(i);
				if (player.getHealth() < 20.0D) {
					if (player.getHealth() + 0.5D < 20.0D) {
					player.setHealth(player.getHealth() + 0.5D);
					food = food + 0.2;
					if (food == 1.0D) {
					player.setFoodLevel(player.getFoodLevel() - 1);
					food = 0.0D;
					}
					}else {
						player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
					}
				}
			}
			double tick5 = 0.13D;
			if (tick4 + tick5 >= 1.0D) {
				Data.Night.setProgress(1.0D);
			}else {
				Data.Night.setProgress(tick4);
				Data.Night.setProgress(Data.Night.getProgress() + tick5);
			}
			Data.Night.setTitle(Data.TitleType.replaceAll("<%sleeping>", Data.SleepingPlayerList.size() + "").replaceAll("<%total>",
					"" +Data.OverWorld.getPlayers().size()));
			if (Data.Night.getProgress() == 1.0D) {
			new GetUP().runTaskLater(Main.MultiplayerSleeping, 60L);
			}
		}
		
		public static void addTicks(long ticks) {
			for (int i = 0;i < Main.Config.getInt("night-skip-speed");i++) {
				Data.OverWorld.setTime(Data.OverWorld.getTime() + 1);
			}
		}
}
