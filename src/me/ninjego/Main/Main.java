package me.ninjego.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
  public void onEnable() {
	  this.saveDefaultConfig();
    Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
  }
  
  public void onDisable() {}
  
  @EventHandler
  public void on(PlayerTeleportEvent event) {
    if (event.getPlayer().getWorld().getWorldBorder() == null || event.getCause() != PlayerTeleportEvent.TeleportCause.ENDER_PEARL)
      return; 
    double worldborder = event.getPlayer().getWorld().getWorldBorder().getSize() / 2.0D;
    if (event.getPlayer().getWorld().getWorldBorder().getCenter().getX() + worldborder < event.getTo().getX()) {
      event.setCancelled(true);
      event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("cannot-teleport-message")));
      event.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENDER_PEARL, 1) });
      return;
    } 
    if (event.getPlayer().getWorld().getWorldBorder().getCenter().getX() - worldborder > event.getTo().getX()) {
      event.setCancelled(true);
      event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("cannot-teleport-message")));
      event.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENDER_PEARL, 1) });
      return;
    } 
    if (event.getPlayer().getWorld().getWorldBorder().getCenter().getZ() + worldborder < event.getTo().getZ()) {
      event.setCancelled(true);
      event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("cannot-teleport-message")));
      event.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENDER_PEARL, 1) });
      return;
    } 
    if (event.getPlayer().getWorld().getWorldBorder().getCenter().getZ() - worldborder > event.getTo().getZ()) {
      event.setCancelled(true);
      event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("cannot-teleport-message")));
      event.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENDER_PEARL, 1) });
      return;
    } 
  }
}
