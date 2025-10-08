package me.SavageUser.CustomDeaths.Commands;

import me.SavageUser.CustomDeaths.Core;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandCDMAdmin implements CommandExecutor {
    private final Core plugin;

    public CommandCDMAdmin(Core plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("cdmadmin").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cdmadmin")) {
            if (sender.isOp() || sender.hasPermission("customdeaths.admin") || sender.hasPermission("customdeaths.staff")) {
                if (args.length == 0) {
                    sender.sendMessage("§4CustomDeaths §cAdmin Commands:");
                    sender.sendMessage("§b/cdmadmin §3addtoblacklist §8- §7Adds a charecter to the blacklist.");
                    sender.sendMessage("§b/cdmadmin §3delfromblacklist §8- §7Deletes a charecter from the blacklist");
                    sender.sendMessage("§b/cdmadmin §3inspect §8- §7Inspects a player's list of set death messages.");
                    sender.sendMessage("§b/cdmadmin §3reload §8- §7Reloads all config files.");
                    return true;
                }
                List<String> blacklisted = plugin.blacklistCFG.getStringList("Blacklist", new ArrayList<>());


                if (args[0].equalsIgnoreCase("addtoblacklist")) {
                    if (sender.isOp() || sender.hasPermission("customdeaths.admin")) {
                        if (args.length != 2) {
                            sender.sendMessage("§cUsage: /cdmadmin addtoblacklist <character>");
                            return true;
                        }

                        if (args[1].contains("@") || args[1].contains("<") || args[1].contains(">")) {
                            sender.sendMessage("§cCharacters @, <, > are on the hard coded blacklist!");
                            return true;
                        }
                        else if (blacklisted.contains(args[1])) {
                            sender.sendMessage("§cCharacter " + args[1] + " is already blacklisted!");
                            return true;
                        }
                        else {
                            plugin.addCharToBlacklist(args[1]);
                            sender.sendMessage("§aCharacter " + args[1] + " added to the blacklist!");
                            return true;
                        }
                    }
                    else {
                        sender.sendMessage("§cI'm sorry, Dave. I'm afraid I can't do that.");
                        return true;
                    }
                }
                else if (args[0].equalsIgnoreCase("delfromblacklist")) {
                    if (sender.isOp() || sender.hasPermission("customdeaths.admin")) {
                        if (args.length != 2) {
                            sender.sendMessage("§cUsage: /cdmadmin delfromblacklist <character>");
                            return true;
                        }
                        if (args[1].contains("@") || args[1].contains("<") || args[1].contains(">")) {
                            sender.sendMessage("§cCharacters @, <, > are on the hard coded blacklist and can't be deleted!");
                            return true;
                        }
                        else if (!blacklisted.contains(args[1])) {
                            sender.sendMessage("§cCharacter " + args[1] + " is not on the blacklist!");
                            return true;
                        }
                        else {
                            plugin.delCharFromBlacklist(args[1]);
                            sender.sendMessage("§aCharacter " + args[1] + " removed from the blacklist!");
                            return true;
                        }
                    }
                    else {
                        sender.sendMessage("§cI'm sorry, Dave. I'm afraid I can't do that.");
                        return true;
                    }
                }
                else if (args[0].equalsIgnoreCase("inspect")) {
                    if (sender.isOp() || sender.hasPermission("customdeaths.admin") || sender.hasPermission("customdeaths.staff")) {
                        if (args.length != 2) {
                            sender.sendMessage("§cUsage: /cdmadmin inspect <player>");
                            return true;
                        }
                        Player other = Bukkit.getServer().getPlayer(args[1].toLowerCase());

                        if (other == null) {
                            OfflinePlayer offline = Bukkit.getServer().getOfflinePlayer(args[1].toLowerCase());

                            if (plugin.playerDataCFG.getConfigOption("Players." + offline.getName().toLowerCase()) == null) {
                                sender.sendMessage("§cPlayer " + offline.getName() + "'s data doesn't exist!");
                                return true;
                            }
                            sender.sendMessage("§3-= §b" + offline.getName().toUpperCase() + "'s DEATH MSGS §3=-");
                            sender.sendMessage("§dDEATH_ARROW§5: §f" + plugin.getArrowDeathMSG(offline));
                            sender.sendMessage("§dDEATH_CACTUS§5: §f" + plugin.getCactusDeathMSG(offline));
                            sender.sendMessage("§dDEATH_DROWNING§5: §f" + plugin.getDrowningDeathMSG(offline));
                            sender.sendMessage("§dDEATH_EXPLOSION§5: §f" + plugin.getExplosionDeathMSG(offline));
                            sender.sendMessage("§dDEATH_FALLING§5: §f" + plugin.getFallingDeathMSG(offline));
                            sender.sendMessage("§dDEATH_FIRE§5: §f" + plugin.getFireDeathMSG(offline));
                            sender.sendMessage("§dDEATH_LAVA§5: §f" + plugin.getLavaDeathMSG(offline));
                            sender.sendMessage("§dDEATH_LIGHTNING§5: §f" + plugin.getLightningDeathMSG(offline));
                            sender.sendMessage("§dDEATH_PLAYER§5: §f" + plugin.getPlayerDeathMSG(offline));
                            sender.sendMessage("§dDEATH_SKELETON§5: §f" + plugin.getSkeletonDeathMSG(offline));
                            sender.sendMessage("§dDEATH_SPIDER§5: §f" + plugin.getSpiderDeathMSG(offline));
                            sender.sendMessage("§dDEATH_SUFFOCATION§5: §f" + plugin.getSuffocationDeathMSG(offline));
                            sender.sendMessage("§dDEATH_SUICIDE§5: §f" + plugin.getSuicideDeathMSG(offline));
                            sender.sendMessage("§dDEATH_VOID§5: §f" + plugin.getVoidDeathMSG(offline));
                            sender.sendMessage("§dDEATH_ZOMBIE§5: §f" + plugin.getZombieDeathMSG(offline));
                            return true;
                        }

                        if (plugin.playerDataCFG.getConfigOption("Players." + other.getName().toLowerCase()) == null) {
                            sender.sendMessage("§cPlayer " + other.getName() + "'s data doesn't exist!");
                            return true;
                        }
                        sender.sendMessage("§3-= §b" + other.getName().toUpperCase() + "'s DEATH MSGS §3=-");
                        sender.sendMessage("§dDEATH_ARROW§5: §f" + plugin.getArrowDeathMSG(other));
                        sender.sendMessage("§dDEATH_CACTUS§5: §f" + plugin.getCactusDeathMSG(other));
                        sender.sendMessage("§dDEATH_DROWNING§5: §f" + plugin.getDrowningDeathMSG(other));
                        sender.sendMessage("§dDEATH_EXPLOSION§5: §f" + plugin.getDrowningDeathMSG(other));
                        sender.sendMessage("§dDEATH_FALLING§5: §f" + plugin.getExplosionDeathMSG(other));
                        sender.sendMessage("§dDEATH_FIRE§5: §f" + plugin.getFireDeathMSG(other));
                        sender.sendMessage("§dDEATH_LAVA§5: §f" + plugin.getLavaDeathMSG(other));
                        sender.sendMessage("§dDEATH_LIGHTNING§5: §f" + plugin.getLightningDeathMSG(other));
                        sender.sendMessage("§dDEATH_PLAYER§5: §f" + plugin.getPlayerDeathMSG(other));
                        sender.sendMessage("§dDEATH_SKELETON§5: §f" + plugin.getSkeletonDeathMSG(other));
                        sender.sendMessage("§dDEATH_SPIDER§5: §f" + plugin.getSpiderDeathMSG(other));
                        sender.sendMessage("§dDEATH_SUFFOCATION§5: §f" + plugin.getSuffocationDeathMSG(other));
                        sender.sendMessage("§dDEATH_SUICIDE§5: §f" + plugin.getSuicideDeathMSG(other));
                        sender.sendMessage("§dDEATH_VOID§5: §f" + plugin.getVoidDeathMSG(other));
                        sender.sendMessage("§dDEATH_ZOMBIE§5: §f" + plugin.getZombieDeathMSG(other));
                        return true;
                    }
                    else {
                        sender.sendMessage("§cI'm sorry, Dave. I'm afraid I can't do that.");
                        return true;
                    }
                }

                else if (args[0].equalsIgnoreCase("reload")) {
                    if (sender.isOp() || sender.hasPermission("customdeaths.admin")) {
                        try {
                            plugin.mainCFG.reload();
                            plugin.blacklistCFG.reload();
                            plugin.playerDataCFG.reload();
                            sender.sendMessage("§aReloaded all config files!");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            sender.sendMessage("§cError while reloading config files!");
                            sender.sendMessage("§cSee console for details!");
                        }
                        return true;
                    }
                    else {
                        sender.sendMessage("§cI'm sorry, Dave. I'm afraid I can't do that.");
                        return true;
                    }
                }
                else {
                    sender.sendMessage("§4CustomDeaths §cAdmin Commands:");
                    sender.sendMessage("§b/cdmadmin §3addtoblacklist §8- §7Adds a charecter to the blacklist.");
                    sender.sendMessage("§b/cdmadmin §3delfromblacklist §8- §7Deletes a charecter from the blacklist");
                    sender.sendMessage("§b/cdmadmin §3inspect §8- §7Inspects a player's list of set death messages.");
                    sender.sendMessage("§b/cdmadmin §3reload §8- §7Reloads all config files.");
                    return true;
                }
            }
            else {
                sender.sendMessage("§cI'm sorry, Dave. I'm afraid I can't do that.");
                return true;
            }
        }
        return true;
    }
}
