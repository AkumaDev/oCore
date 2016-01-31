package io.ohho.oCore.listeners.SpawnTag;

import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SpawnTagHandler {
    public static final int MAX_SPAWN_TAG = 60;
    private static HashMap<String, Long> spawnTags = new HashMap();

    public static void removeTag(Player player) {
        spawnTags.remove(player.getName());
    }

    public static void addSeconds(Player player, int seconds) {
        if (SpawnTagHandler.isTagged(player)) {
            int secondsTaggedFor = (int)((spawnTags.get(player.getName()) - System.currentTimeMillis()) / 1000);
            int newSeconds = Math.min(secondsTaggedFor + seconds, 60);
            spawnTags.put(player.getName(), System.currentTimeMillis() + (long)newSeconds * 1000);
        } else {
            player.sendMessage((Object)ChatColor.YELLOW + "You have been spawn-tagged for \u00a7c" + seconds + " \u00a7eseconds!");
            spawnTags.put(player.getName(), System.currentTimeMillis() + (long)seconds * 1000);
        }
    }

    public static long getTag(Player player) {
        return spawnTags.get(player.getName()) - System.currentTimeMillis();
    }

    public static boolean isTagged(Player player) {
        if (spawnTags.containsKey(player.getName()) && spawnTags.get(player.getName()) > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public static HashMap<String, Long> getSpawnTags() {
        return spawnTags;
    }
}

