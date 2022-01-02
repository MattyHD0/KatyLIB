package me.mattyhd0.katylib.easy.enums;

public enum EasyGameRule {

    ANNOUNCE_ADVANCEMENTS("announceAdvancements", true),
    COMMAND_BLOCK_OUTPUT("commandBlockOutput", true),
    DISABLE_ELYTRA_MOVEMENT_CHECK("disableElytraMovementCheck", false),
    DISABLE_RAIDS("disableRaids", false),
    DO_DAYLIGHT_CYCLE("doDaylightCycle", true),
    DO_ENTITY_DROPS("doEntityDrops", true),
    DO_FIRE_TICK("doFireTick", true),
    DO_IMMEDIATE_RESPAWN("doImmediateRespawn", false),
    DO_INSOMNIA("doInsomnia", true),
    DO_LIMITED_CRAFTING("doLimitedCrafting", false),
    DO_MOB_LOOT("doMobLoot", true),
    DO_MOB_SPAWNING("doMobSpawning", true),
    DO_PATROL_SPAWNING("doPatrolSpawning", true),
    DO_TILE_DROPS("doTileDrops", true),
    DO_TRADER_SPAWNING("doTraderSpawning", true),
    DO_WEATHER_CYCLE("doWeatherCycle", true),
    DROWING_DAMAGE("drowningDamage", true),
    FALL_DAMAGE("fallDamage", true),
    FIRE_DAMAGE("fireDamage", true),
    FORGIVE_DEAD_PLAYERS("forgiveDeadPlayers", true),
    FREEZE_DAMAGE("freezeDamage", true),
    KEEP_INVENTORY("keepInventory", false),
    LOG_ADMIN_COMMANDS("logAdminCommands", true),
    MAX_COMMAND_CHAIN_LENGTH("maxCommandChainLength", 65536),
    MAX_ENTITY_CRAMMING("maxEntityCramming", 24),
    MOB_GRIEFING("mobGriefing", true),
    NATURAL_REGENERATION("naturalRegeneration", true),
    PLAYERS_SLEEPING_PERCENTAGE("playersSleepingPercentage", 100),
    REDUCE_DEBUG_INFO("reducedDebugInfo", false),
    SEND_COMMAND_FEEDBACK("sendCommandFeedback", true),
    SHOW_DEATH_MESSAGES("showDeathMessages", true),
    SPAWN_RADIUS("spawnRadius", 10),
    SPECTATORS_GENERATE_CHUNKS("spectatorsGenerateChunks", true),
    UNIVERSAL_ANGER("universalAnger", false),
    RANDOM_TICK_SPEED("randomTickSpeed", 3);

    private final String gameruleString;
    private Object defaultValue;
    private EasyGameRule(String gameruleString, boolean defaultValue){
        this.gameruleString = gameruleString;
        this.defaultValue = defaultValue;
    }

    private EasyGameRule(String gameruleString, int defaultValue){
        this.gameruleString = gameruleString;
        this.defaultValue = defaultValue;
    }

    public Boolean getDefaultBooleanValue(){
        if(defaultValue instanceof Integer) return null;
        return (boolean)defaultValue;
    }

    public Integer getDefaultIntValue(){
        if(defaultValue instanceof Boolean) return null;
        return (int)defaultValue;
    }

}
