package net.minemora.beehivestrees.config;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

public final class ConfigMain extends Config {
	
	private static ConfigMain instance;
	
	private static float chanceToHaveNest;
	private static int minBeesPerNest;
	private static int maxBeesPerNest;
	private static boolean allowAllTrees;
	private static boolean allowAllBiomes;
	private static boolean allowBonemeal;
	private static List<String> treeTypes = new ArrayList<>();
	private static List<String> biomes = new ArrayList<>();

	private ConfigMain() {
		super("config.yml");
	}

	@Override
	public void load(boolean firstCreate) {
		chanceToHaveNest = (float) getConfig().getDouble("chance-to-have-a-bee-nest", 0.05);
		minBeesPerNest = getConfig().getInt("min-bees-per-nest", 1);
		maxBeesPerNest = getConfig().getInt("max-bees-per-nest", 3);
		allowAllTrees = getConfig().getBoolean("allow-all-tree-types", false);
		allowAllBiomes = getConfig().getBoolean("allow-all-biomes", false);
		allowBonemeal = getConfig().getBoolean("allow-bonemeal", false);
		treeTypes = getConfig().getStringList("allowed-tree-types");
		biomes = getConfig().getStringList("allowed-biomes");
	}
	
	public static FileConfiguration get() {
		return getInstance().config;
	}

	public static ConfigMain getInstance() {
		if (instance == null) {
            instance = new ConfigMain();
        }
        return instance;
	}

	@Override
	public void update() {
		return;
	}

	public static float getChanceToHaveNest() {
		return chanceToHaveNest;
	}

	public static boolean isAllowAllTrees() {
		return allowAllTrees;
	}

	public static boolean isAllowAllBiomes() {
		return allowAllBiomes;
	}
	public static List<String> getTreeTypes() {
		return treeTypes;
	}

	public static List<String> getBiomes() {
		return biomes;
	}

	public static boolean isAllowBonemeal() {
		return allowBonemeal;
	}

	public static int getMinBeesPerNest() {
		return minBeesPerNest;
	}

	public static int getMaxBeesPerNest() {
		return maxBeesPerNest;
	}
}