package me.SavageUser.CustomDeaths.Commands;

import me.SavageUser.CustomDeaths.Core;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandCDM implements CommandExecutor {
    private final Core plugin;

    public CommandCDM(Core plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("cdm").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cdm")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (player.isOp() || player.hasPermission("customdeaths.cdm")) {
                    if (args.length < 2) {
                        player.sendMessage("§cUsage: /cdm <death type> <message>");
                        player.sendMessage("§cAll Death Types: §bDEATH_ARROW§c, §bDEATH_CACTUS§c, §bDEATH_DROWNING§c,");
                        player.sendMessage("§bDEATH_EXPLOSION§c, §bDEATH_FALLING§c, §bDEATH_FIRE§c, §bDEATH_LAVA§c,");
                        player.sendMessage("§bDEATH_LIGHTNING§c, §bDEATH_PLAYER§c, §bDEATH_SKELETON§c,");
                        player.sendMessage("§bDEATH_SPIDER§c, §bDEATH_SUFFOCATION§c, §bDEATH_SUICIDE§c,");
                        player.sendMessage("§bDEATH_VOID§c, §bDEATH_ZOMBIE");
                        player.sendMessage("§cUse §b/cdm <death type> reset §cto reset a death message to the default one.");
                        return true;
                    }

                    //Death message
                    String msg = "";
                    for (int i = 1; i < args.length; i++) {
                        msg = msg + args[i] + " ";
                    }
                    msg = ChatColor.translateAlternateColorCodes('&', msg);

                    List<String> blacklisted = plugin.blacklistCFG.getStringList("Blacklist", new ArrayList<>());

                    if (args[0].equalsIgnoreCase("arrow") || args[0].equalsIgnoreCase("death_arrow")) { //DEATH_ARROW
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetArrowDeathMSG(player);
                            player.sendMessage("§aYour ARROW death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour arrow death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% was gunned down.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setArrowDeathMSG(player, msg);
                                    player.sendMessage("§aYour ARROW death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("cactus") || args[0].equalsIgnoreCase("death_cactus")) { //DEATH_CACTUS
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetCactusDeathMSG(player);
                            player.sendMessage("§aYour CACTUS death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour cactus death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% hugged a cactus.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setCactusDeathMSG(player, msg);
                                    player.sendMessage("§aYour CACTUS death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("drowning") || args[0].equalsIgnoreCase("death_drowning")) { //DEATH_DROWNING
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetDrowningDeathMSG(player);
                            player.sendMessage("§aYour DROWNING death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour drowning death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% forgot to breath.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setDrowningDeathMSG(player, msg);
                                    player.sendMessage("§aYour DROWNING death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("explosion") || args[0].equalsIgnoreCase("death_explosion")) { //DEATH_EXPLOSION
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetExplosionDeathMSG(player);
                            player.sendMessage("§aYour EXPLOSION death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour explosion death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% was hit too hard.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setExplosionDeathMSG(player, msg);
                                    player.sendMessage("§aYour EXPLOSION death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("falling") || args[0].equalsIgnoreCase("death_falling")) { //DEATH_FALLING
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetFallingDeathMSG(player);
                            player.sendMessage("§aYour FALLING death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour falling death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% forgot their shoes.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setFallingDeathMSG(player, msg);
                                    player.sendMessage("§aYour FALLING death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("fire") || args[0].equalsIgnoreCase("death_fire")) { //DEATH_FIRE
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetFireDeathMSG(player);
                            player.sendMessage("§aYour FIRE death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour fire death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% was too hot.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setFireDeathMSG(player, msg);
                                    player.sendMessage("§aYour FIRE death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("lava") || args[0].equalsIgnoreCase("death_lava")) { //DEATH_LAVA
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetLavaDeathMSG(player);
                            player.sendMessage("§aYour LAVA death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour lava death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% was too hot.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setLavaDeathMSG(player, msg);
                                    player.sendMessage("§aYour LAVA death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("lightning") || args[0].equalsIgnoreCase("death_lightning")) { //DEATH_LIGHTNING
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetLightningDeathMSG(player);
                            player.sendMessage("§aYour LIGHTNING death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour lightning death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% was struck by lightning.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setLightningDeathMSG(player, msg);
                                    player.sendMessage("§aYour LIGHTNING death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("player") || args[0].equalsIgnoreCase("death_player")) { //DEATH_PLAYER
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetPlayerDeathMSG(player);
                            player.sendMessage("§aYour PLAYER death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour player death message must contain the \"%player%\" and the \"%killer%\" variable.");
                                player.sendMessage("§cExample: §b%player% was brutally murdered by %killer%.");
                                return true;
                            }
                            if (!msg.contains("%killer%")) {
                                player.sendMessage("§cYour player death message must contain the \"%player%\" and the \"%killer%\" variable.");
                                player.sendMessage("§cExample: §b%player% was brutally murdered by %killer%.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setPlayerDeathMSG(player, msg);
                                    player.sendMessage("§aYour PLAYER death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("skeleton") || args[0].equalsIgnoreCase("death_skeleton")) { //DEATH_SKELETON
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetSkeletonDeathMSG(player);
                            player.sendMessage("§aYour SKELETON death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour skeleton death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% was gunned down by a skeleton.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setSkeletonDeathMSG(player, msg);
                                    player.sendMessage("§aYour SKELETON death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("spider") || args[0].equalsIgnoreCase("death_spider")) { //DEATH_SPIDER
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetSpiderDeathMSG(player);
                            player.sendMessage("§aYour SPIDER death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour spider death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% was killed by a spider.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setSpiderDeathMSG(player, msg);
                                    player.sendMessage("§aYour SPIDER death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("suffocation") || args[0].equalsIgnoreCase("death_suffocation")) { //DEATH_SUFFOCATION
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetSuffocationDeathMSG(player);
                            player.sendMessage("§aYour SUFFOCATION death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour suffocation death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% died in the walls.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setSuffocationDeathMSG(player, msg);
                                    player.sendMessage("§aYour SUFFOCATION death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("suicide") || args[0].equalsIgnoreCase("death_suicide")) { //DEATH_SUICIDE
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetSuicideDeathMSG(player);
                            player.sendMessage("§aYour SUICIDE death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour suicide death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% killed themselves.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setSuicideDeathMSG(player, msg);
                                    player.sendMessage("§aYour SUICIDE death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("void") || args[0].equalsIgnoreCase("death_void")) { //DEATH_VOID
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetVoidDeathMSG(player);
                            player.sendMessage("§aYour VOID death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour void death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% fell out of the world.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setVoidDeathMSG(player, msg);
                                    player.sendMessage("§aYour VOID death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("zombie") || args[0].equalsIgnoreCase("death_zombie")) { //DEATH_ZOMBIE
                        if (args[1].equalsIgnoreCase("reset") && args.length == 2) {
                            plugin.resetZombieDeathMSG(player);
                            player.sendMessage("§aYour ZOMBIE death message was reset!");
                            return true;
                        } else {
                            if (!msg.contains("%player%")) {
                                player.sendMessage("§cYour zombie death message must contain the \"%player%\" variable.");
                                player.sendMessage("§cExample: §b%player% was munched on by a Zombie.");
                                return true;
                            } else {
                                if (msg.contains("@") || msg.contains("<") || msg.contains(">")) {//Hard coded blacklist
                                    player.sendMessage("§cYou used a symbol thats on the hard coded blacklist!");
                                    player.sendMessage("§cPlease remove it and try the command again!");
                                    return true;
                                } else {
                                    for (String blacklist : blacklisted) {
                                        if (msg.toLowerCase().contains(blacklist)) {
                                            player.sendMessage("§cYou used a blacklisted word/symbol!");
                                            player.sendMessage("§cThis has been logged and reported to staff!");
                                            //Todo: Future Implementation of ChatGuard
                                            return true;
                                        }
                                    }

                                    plugin.setZombieDeathMSG(player, msg);
                                    player.sendMessage("§aYour ZOMBIE death message was changed!");
                                    return true;
                                }
                            }
                        }
                    } else { //Typed an invalid death type.
                        player.sendMessage("§cUsage: /cdm <death type> <message>");
                        player.sendMessage("§cAll Death Types: §bDEATH_ARROW§c, §bDEATH_CACTUS§c, §bDEATH_DROWNING§c,");
                        player.sendMessage("§bDEATH_EXPLOSION§c, §bDEATH_FALLING§c, §bDEATH_FIRE§c, §bDEATH_LAVA§c,");
                        player.sendMessage("§bDEATH_LIGHTNING§c, §bDEATH_PLAYER§c, §bDEATH_SKELETON§c,");
                        player.sendMessage("§bDEATH_SPIDER§c, §bDEATH_SUFFOCATION§c, §bDEATH_SUICIDE§c,");
                        player.sendMessage("§bDEATH_VOID§c, §bDEATH_ZOMBIE");
                        player.sendMessage("§cUse §b/cdm <death type> reset §cto reset a death message to the default one.");
                        return true;
                    }
                } else {
                    player.sendMessage("§cI'm sorry, Dave. I'm afraid I can't do that.");
                    return true;
                }
            } else {
                sender.sendMessage("§cCommand can only be executed by players!");
                return true;
            }
        }
        return true;
    }
}