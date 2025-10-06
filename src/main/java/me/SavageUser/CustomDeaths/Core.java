package me.SavageUser.CustomDeaths;

import me.SavageUser.CustomDeaths.CFGUtil.BlacklistCFG;
import me.SavageUser.CustomDeaths.CFGUtil.Config;
import me.SavageUser.CustomDeaths.CFGUtil.PlayerDataCFG;
import me.SavageUser.CustomDeaths.Commands.CommandCDM;
import me.SavageUser.CustomDeaths.Commands.CommandCDMAdmin;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Core extends JavaPlugin implements Listener {

    public Config mainCFG;
    public BlacklistCFG blacklistCFG;
    public PlayerDataCFG playerDataCFG;

    @Override
    public void onEnable() {
        this.mainCFG = new Config(new File(this.getDataFolder(), "config.yml"));
        this.blacklistCFG = new BlacklistCFG(new File(this.getDataFolder(), "blacklist.yml"));
        this.playerDataCFG = new PlayerDataCFG(new File(this.getDataFolder(), "player-data.yml"));
        List<String> blacklisted = this.blacklistCFG.getStringList("Blacklist", new ArrayList<>());

        for (String blacklist : blacklisted) {
            Bukkit.getServer().getLogger().info("Blacklisted Terms: " + blacklist);
        }

        new CommandCDM(this);
        new CommandCDMAdmin(this);

        DeathHandler handler = new DeathHandler(this);

        getServer().getPluginManager().registerEvents(handler, this);
        getServer().getPluginManager().registerEvent(Event.Type.PLAYER_JOIN, handler, Event.Priority.Normal, this);

    }

    @Override
    public void onDisable() {
    }
//  Creation Method
    public void createSettings(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) == null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_ARROW", "§8%player% §7was gunned down.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_CACTUS", "§8%player% §7hugged a cactus.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_DROWNING", "§8%player% §7forgot to breath.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_EXPLOSION", "§8%player% §7was hit too hard.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_FALLING", "§8%player% §7forgot their shoes.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_FIRE", "§8%player% §7was too hot.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_LAVA", "§8%player% §7was too hot.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_LIGHTNING", "§8%player% §7was struck by lightning.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_PLAYER", "§8%player% §7was brutally murdered by §8%killer%§7.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SKELETON", "§8%player% §7was gunned down.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SPIDER", "§8%player% §7was hit too hard.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SUFFOCATION", "§8%player% §7forgot to breath.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SUICIDE", "§8%player% §7killed themselves.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_VOID", "§8%player% §7fell out of the world.");
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_ZOMBIE", "§8%player% §7was munched on by a Zombie.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
//  Creation Method



//  Blacklist Methods
    public void addCharToBlacklist(String msg) {
        try {
            List<String> blacklisted = this.blacklistCFG.getStringList("Blacklist", new ArrayList<>());
            blacklisted.add(msg);
            this.blacklistCFG.setProperty("Blacklist", blacklisted);
            this.blacklistCFG.save();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void delCharFromBlacklist(String msg) {
        try {
            List<String> blacklisted = this.blacklistCFG.getStringList("Blacklist", new ArrayList<>());
            blacklisted.remove(msg);
            this.blacklistCFG.setProperty("Blacklist", blacklisted);
            this.blacklistCFG.save();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
//  Blacklist Methods



//  Set DeathMSG Methods
    public void setArrowDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_ARROW", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setCactusDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_CACTUS", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setDrowningDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_DROWNING", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setExplosionDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_EXPLOSION", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setFallingDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_FALLING", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setFireDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_FIRE", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setLavaDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_LAVA", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setLightningDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_LIGHTNING", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setPlayerDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_PLAYER", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setSkeletonDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SKELETON", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setSpiderDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SPIDER", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setSuffocationDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SUFFOCATION", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setSuicideDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SUICIDE", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setVoidDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_VOID", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void setZombieDeathMSG(Player player, String message) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_ZOMBIE", message);
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
//  Set DeathMSG Methods


//  Get DeathMSG Methods
    public String getArrowDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_ARROW");}
    public String getArrowDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_ARROW");}
    public String getCactusDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_CACTUS");}
    public String getCactusDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_CACTUS");}
    public String getDrowningDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_DROWNING");}
    public String getDrowningDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_DROWNING");}
    public String getExplosionDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_EXPLOSION");}
    public String getExplosionDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_EXPLOSION");}
    public String getFallingDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_FALLING");}
    public String getFallingDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_FALLING");}
    public String getFireDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_FIRE");}
    public String getFireDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_FIRE");}
    public String getLavaDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_LAVA");}
    public String getLavaDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_LAVA");}
    public String getLightningDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_LIGHTNING");}
    public String getLightningDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_LIGHTNING");}
    public String getPlayerDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_PLAYER");}
    public String getPlayerDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_PLAYER");}
    public String getSkeletonDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_SKELETON");}
    public String getSkeletonDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_SKELETON");}
    public String getSpiderDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_SPIDER");}
    public String getSpiderDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_SPIDER");}
    public String getSuffocationDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_SUFFOCATION");}
    public String getSuffocationDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_SUFFOCATION");}
    public String getSuicideDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_SUICIDE");}
    public String getSuicideDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_SUICIDE");}
    public String getVoidDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_VOID");}
    public String getVoidDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_VOID");}
    public String getZombieDeathMSG(Player player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_ZOMBIE");}
    public String getZombieDeathMSG(OfflinePlayer player) {return this.playerDataCFG.getString("Players." + player.getName() + ".DEATH_ZOMBIE");}
//  Get DeathMSG Methods



//  Reset DeathMSG Methods
    public void resetArrowDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_ARROW", "§8%player% §7was gunned down.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetCactusDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_CACTUS", "§8%player% §7hugged a cactus.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetDrowningDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_DROWNING", "§8%player% §7forgot to breath.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetExplosionDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_EXPLOSION", "§8%player% §7was hit too hard.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetFallingDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_FALLING", "§8%player% §7forgot their shoes.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetFireDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_FIRE", "§8%player% §7was too hot.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetLavaDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_LAVA", "§8%player% §7was too hot.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetLightningDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_LIGHTNING", "§8%player% §7was strucked by lightning.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetPlayerDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_PLAYER", "§8%player% §7was brutally murdered by §8%killer%§7.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetSkeletonDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SKELETON", "§8%player% §7was gunned down.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetSpiderDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SPIDER", "§8%player% §7was hit too hard.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetSuicideDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SUICIDE", "§8%player% §7killed themselves.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetSuffocationDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_SUFFOCATION", "§8%player% §7forgot to breath.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetVoidDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_VOID", "§8%player% §7fell out of the world.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
    public void resetZombieDeathMSG(Player player) {
        if (this.playerDataCFG.getConfigOption("Players." + player.getName()) != null) {
            try {
                this.playerDataCFG.setProperty("Players." + player.getName() + ".DEATH_ZOMBIE", "§8%player% §7was munched on by a Zombie.");
                this.playerDataCFG.save();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
//  Reset DeathMSG Methods
}
