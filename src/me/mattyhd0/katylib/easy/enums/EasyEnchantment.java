package me.mattyhd0.katylib.easy.enums;

import org.bukkit.enchantments.Enchantment;

public enum EasyEnchantment {

    AQUA_AFFINITY("WATER_WORKER"),
    BANE_OF_ARTHROPODS("DAMAGE_ARTHROPODS"),
    BLAST_PROTECTION("PROTECTION_EXPLOSIONS"),
    CHANNELING("CHANNELING"),
    CURSE_OF_BINDING("BINDING_CURSE"),
    CURSE_OF_VANISHING("VANISHING_CURSE"),
    DEPTH_STRIDER("DEPTH_STRIDER"),
    DURABILITY("DURABILITY"),
    EFFICIENCY("DIG_SPEED"),
    FEATHER_FALLING("PROTECTION_FALL"),
    FIRE_ASPECT("FIRE_ASPECT"),
    FIRE_PROTECTION("PROTECTION_FIRE"),
    FLAME("ARROW_FIRE"),
    FORTUNE("LOOT_BONUS_BLOCKS"),
    FROST_WALKER("FROST_WALKER"),
    IMPALING("IMPALING"),
    INFINITY("ARROW_INFINITE"),
    KNOCKBACK("KNOCKBACK"),
    LOOTING("LOOT_BONUS_MOBS"),
    LOYALTY("LOYALTY"),
    LUCK_OF_THE_SEA("LUCK"),
    LURE("LURE"),
    MENDING("MENDING"),
    MULTISHOT("MULTISHOT"),
    PERCING("PERCING"),
    POWER("ARROW_DAMAGE"),
    PROJECTILE_PROTECTION("PROTECTION_PROJECTILE"),
    PROTECTION("PROTECTION_ENVIRONMENTAL"),
    PUNCH("ARROW_KNOCKBACK"),
    QUICK_CHARGE("QUICK_CHARGE"),
    RESPIRATION("OXYGEN"),
    RIPTIDE("RIPTIDE"),
    SHARPNESS("DAMAGE_ALL"),
    SILK_TOUCH("SILK_TOUCH"),
    SMITE("DAMAGE_UNDEAD"),
    SOUL_SPEED("SOUL_SPEED"),
    SWEEPING_EDGE("SWEEPING_EDGE"),
    THORNS("THORNS");

    private final String enchantment;

    private EasyEnchantment(String enchantment){
        this.enchantment = enchantment;
    }

    public Enchantment parseEnchantment() {
        try {
            return Enchantment.getByName(enchantment);
        } catch (NullPointerException | IllegalArgumentException e){
            return null;
        }
    }
}
