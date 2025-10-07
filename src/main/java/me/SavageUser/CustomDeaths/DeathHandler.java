package me.SavageUser.CustomDeaths;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class DeathHandler extends PlayerListener {

    private final Core plugin;

    public DeathHandler(Core plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (plugin.playerDataCFG.getProperty("Players." + player.getName().toLowerCase()) == null) {
            plugin.createSettings(player);
        }
    }

    @EventHandler
    public void on(EntityDeathEvent event) {

        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION || player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.TNT_EXPLOSION) { //Passed.
                String msg = plugin.getExplosionDeathMSG(player);
                msg = msg.replace("%player%", player.getName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
            else if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.DROWNING) { // Passed.
                String msg = plugin.getDrowningDeathMSG(player);
                msg = msg.replace("%player%", player.getName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
            else if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL) { // Passed.
                String msg = plugin.getFallingDeathMSG(player);
                msg = msg.replace("%player%", player.getName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
            else if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FIRE || player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) { // Passed.
                String msg = plugin.getFireDeathMSG(player);
                msg = msg.replace("%player%", player.getName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
            else if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.LAVA) { // Passed.
                String msg = plugin.getLavaDeathMSG(player);
                msg = msg.replace("%player%", player.getName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
            else if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.LIGHTNING) { //Unknown. Too many other factors battling final damage with lightning.
                String msg = plugin.getLightningDeathMSG(player);
                msg = msg.replace("%player%", player.getName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
            else if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.SUFFOCATION) { // Passed.
                String msg = plugin.getSuffocationDeathMSG(player);
                msg = msg.replace("%player%", player.getName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
            else if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.SUICIDE) { // Passed.
                String msg = plugin.getSuicideDeathMSG(player);
                msg = msg.replace("%player%", player.getName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
            else if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.VOID) { // Passed.
                String msg = plugin.getVoidDeathMSG(player);
                msg = msg.replace("%player%", player.getName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
            else if (event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent) {
                EntityDamageByEntityEvent lastDamageCause = (EntityDamageByEntityEvent) event.getEntity().getLastDamageCause();

                if (lastDamageCause.getDamager() instanceof Arrow) { //Passed.
                    Arrow arrow = (Arrow) lastDamageCause.getDamager();
                    if (arrow.getShooter() instanceof Skeleton) {
                        String msg = plugin.getSkeletonDeathMSG(player);
                        msg = msg.replace("%player%", player.getName());
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    } else if (arrow.getShooter() instanceof Player) { //Passed.
                        String msg = plugin.getPlayerDeathMSG(player);
                        msg = msg.replace("%player%", player.getName());
                        msg = msg.replace("%killer%", ((Player) arrow.getShooter()).getName());
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    } else { //Passed.
                        String msg = plugin.getArrowDeathMSG(player);
                        msg = msg.replace("%player%", player.getName());
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                }

                if (lastDamageCause.getDamager() instanceof Fireball) { //Likely by a ghast or with /fireball. Passed.
                    String msg = plugin.getExplosionDeathMSG(player);
                    msg = msg.replace("%player%", player.getName());
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }

                if (lastDamageCause.getDamager() instanceof Spider) { // Passed.
                    String msg = plugin.getSpiderDeathMSG(player);
                    msg = msg.replace("%player%", player.getName());
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }

                if (lastDamageCause.getDamager() instanceof Zombie) { // Passed.
                    String msg = plugin.getZombieDeathMSG(player);
                    msg = msg.replace("%player%", player.getName());
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }

                if (lastDamageCause.getDamager() instanceof Player) { // Passed.
                    String msg = plugin.getPlayerDeathMSG(player);
                    msg = msg.replace("%player%", player.getName());
                    msg = msg.replace("%killer%", ((Player) lastDamageCause.getDamager()).getName());
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }
            }
            else if (event.getEntity().getLastDamageCause() instanceof EntityDamageByBlockEvent) { // Passed.
                EntityDamageByBlockEvent lastDamageCause = (EntityDamageByBlockEvent) event.getEntity().getLastDamageCause();
                if (lastDamageCause.getDamager().getType() == Material.CACTUS) {
                    String msg = plugin.getCactusDeathMSG(player);
                    msg = msg.replace("%player%", player.getName());
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }
            }
        }
    }
}
