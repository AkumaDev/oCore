package io.ohho.oCore.listeners;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EnderpearlListener
implements Listener {
    private static Map<String, Long> enderpearlCooldown = new HashMap<String, Long>();

    @SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.MONITOR)
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.isCancelled() || !(event.getEntity().getShooter() instanceof Player)) {
            return;
        }
        Player shooter = (Player)event.getEntity().getShooter();
        if (event.getEntity() instanceof EnderPearl) {
            enderpearlCooldown.put(shooter.getName(), System.currentTimeMillis() + 16000);
        }
    }

    @SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getItem() == null || event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK || event.getItem().getType() != Material.ENDER_PEARL) {
            return;
        }
        if (enderpearlCooldown.containsKey(event.getPlayer().getName()) && enderpearlCooldown.get(event.getPlayer().getName()) > System.currentTimeMillis()) {
            long millisLeft = enderpearlCooldown.get(event.getPlayer().getName()) - System.currentTimeMillis();
            double value = (double)millisLeft / 1000.0;
            double sec = (double)Math.round(10.0 * value) / 10.0;
            event.setCancelled(true);
            event.getPlayer().sendMessage((Object)ChatColor.RED + "You cannot use this for another " + (Object)ChatColor.BOLD + sec + (Object)ChatColor.RED + " seconds!");
            event.getPlayer().updateInventory();
        }
    }

    @EventHandler(priority=EventPriority.HIGH)
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (event.isCancelled() || event.getCause() != PlayerTeleportEvent.TeleportCause.ENDER_PEARL) {
            return;
        }
        Location target = event.getTo();
        Location from = event.getFrom();
        Material mat = event.getTo().getBlock().getType();
        if ((mat == Material.THIN_GLASS || mat == Material.IRON_FENCE) && this.clippingThrough(target, from, 0.65) || (mat == Material.FENCE || mat == Material.NETHER_FENCE) && this.clippingThrough(target, from, 0.45)) {
            event.setTo(from);
            return;
        }
        target.setX((double)target.getBlockX() + 0.5);
        target.setZ((double)target.getBlockZ() + 0.5);
        event.setTo(target);
    }

    public boolean clippingThrough(Location target, Location from, double thickness) {
        if (!(from.getX() > target.getX() && from.getX() - target.getX() < thickness || target.getX() > from.getX() && target.getX() - from.getX() < thickness || from.getZ() > target.getZ() && from.getZ() - target.getZ() < thickness || target.getZ() > from.getZ() && target.getZ() - from.getZ() < thickness)) {
            return false;
        }
        return true;
    }

    public static Map<String, Long> getEnderpearlCooldown() {
        return enderpearlCooldown;
    }
}

