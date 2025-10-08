# CustomDeaths

**Commands:**
- /cdm (death-type) (message) - Edit a death message based on the death type inputed.
- /cdm (death-type) reset - Reset a death message to its default message based on the death type inputed.
- /cdmadmin addtoblacklist (character) - Add a word/character to the blacklist of disallowed words.
- /cdmadmin delfromblacklist (character) - Remove a word/character from the blacklist of disallowed words.
- /cdmadmin inspect (player) - Inspect all death messages of a player.
- /cdmadmin reload - Reloads all config files. (blacklist.yml, config.yml, player-data.yml)

All Death Types: DEATH_ARROW, DEATH_CACTUS, DEATH_DROWNING,
DEATH_EXPLOSION, DEATH_FALLING, DEATH_FIRE,
DEATH_LAVA, DEATH_LIGHTNING, DEATH_PLAYER,
DEATH_SKELETON, DEATH_SPIDER, DEATH_SUFFOCATION,
DEATH_SUICIDE, DEATH_VOID, DEATH_ZOMBIE

**Permissions:**

`CustomDeaths.CDM` - Permission to use /cdm to change death messages.
`CustomDeaths.Admin` - Permission to use all /cdmadmin commands.
`CustomDeaths.Staff` - Permission to use only /cdmadmin inspect. Useful for mods to find out who has a explicit death message.

**Note:**
Additionally you can install ChatGuard to have blacklisted words show on discord.
