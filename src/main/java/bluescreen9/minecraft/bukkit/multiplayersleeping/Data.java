package bluescreen9.minecraft.bukkit.multiplayersleeping;

import java.util.ArrayList;

import org.bukkit.World;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;


public class Data { 
		protected static ArrayList<Player> SleepingPlayerList = new ArrayList<Player>();
		protected static BossBar Night ;
		protected static boolean IsTasking = false;
		protected static World OverWorld;
		protected static String TitleType;
}
