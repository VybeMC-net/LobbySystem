package net.vybemc.lobbysystem.util;

import org.apache.commons.lang.Validate;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * This Item Builder
 * was created by
 * Revax812
 */

public class ItemBuilder extends ItemStack {

    protected static boolean translateAlternateColorCodes = true;
    protected boolean unsafeStackSize = true;
    protected boolean hideUnbreakable = true;

    //Inits ItemBuilder with ItemID
    @Deprecated
    public ItemBuilder(int id) {
        super(id);
    }

    //Inits ItemBuilder with Material
    public ItemBuilder(Material mat) {
        super(mat);
    }

    //Inits ItemBuilder with ItemStack
    public ItemBuilder(ItemStack is) {
        super(is);
    }

    //Inits ItemBuilder with ItemID and amount
    @Deprecated
    public ItemBuilder(int id, int amount) {
        super(id);
        setCustomAmount(amount);
    }

    //Inits ItemBuilder with material and amount
    public ItemBuilder(Material mat, int amount) {
        super(mat);
        setCustomAmount(amount);
    }

    //Inits ItemBuilder with ItemStack and amount
    public ItemBuilder(ItemStack is, int amount) {
        super(is);
        setCustomAmount(amount);
    }

    //Inits ItemBuilder with ItemID, amount and short
    @Deprecated
    public ItemBuilder(int id, int amount, short damage) {
        super(id);
        setCustomAmount(amount);
        setDamage(damage);
    }

    //Inits ItemBuilder with ItemID, amount and damage
    @Deprecated
    public ItemBuilder(int id, int amount, int damage) {
        super(id);
        setCustomAmount(amount);
        setDamage(damage);
    }

    //Inits ItemBuilder with material, amount and short
    public ItemBuilder(Material mat, int amount, short damage) {
        super(mat);
        setCustomAmount(amount);
        setDamage(damage);
    }

    //Inits ItemBuilder with material, amount and damage
    public ItemBuilder(Material mat, int amount, int damage) {
        super(mat);
        setCustomAmount(amount);
        setDamage(damage);
    }

    //Inits ItemBuilder with ItemStack, amount and short
    public ItemBuilder(ItemStack is, int amount, short damage) {
        super(is);
        setCustomAmount(amount);
        setDamage(damage);
    }

    //Inits ItemBuilder with ItemStack, amount and damage
    public ItemBuilder(ItemStack is, int amount, int damage) {
        super(is);
        setCustomAmount(amount);
        setDamage(damage);
    }

    //Inits ItemBuilder with ItemID and displayname
    @Deprecated
    public ItemBuilder(int id, String displayname) {
        super(id);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material and displayname
    public ItemBuilder(Material mat, String displayname) {
        super(mat);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with ItemStack and displayname
    public ItemBuilder(ItemStack is, String displayname) {
        super(is);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with ItemID, amount and displayname
    @Deprecated
    public ItemBuilder(int id, int amount, String displayname) {
        super(id);
        setCustomAmount(amount);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material, amount and displayname
    public ItemBuilder(Material mat, int amount, String displayname) {
        super(mat);
        setCustomAmount(amount);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with ItemStack, amount and displayname
    public ItemBuilder(ItemStack is, int amount, String displayname) {
        super(is);
        setCustomAmount(amount);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with ItemID, amount, short and displayname
    @Deprecated
    public ItemBuilder(int id, int amount, short damage, String displayname) {
        super(id);
        setCustomAmount(amount);
        setDamage(damage);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with ItemID, amount, damage and displayname
    @Deprecated
    public ItemBuilder(int id, int amount, int damage, String displayname) {
        super(id);
        setCustomAmount(amount);
        setDamage(damage);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material, amount, short and displayname
    public ItemBuilder(Material mat, int amount, short damage, String displayname) {
        super(mat);
        setCustomAmount(amount);
        setDamage(damage);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material, amount, damage and displayname
    public ItemBuilder(Material mat, int amount, int damage, String displayname) {
        super(mat);
        setCustomAmount(amount);
        setDamage(damage);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with ItemStack, amount, short and displayname
    public ItemBuilder(ItemStack is, int amount, short damage, String displayname) {
        super(is);
        setCustomAmount(amount);
        setDamage(damage);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with ItemStack, amount, damage and displayname
    public ItemBuilder(ItemStack is, int amount, int damage, String displayname) {
        super(is);
        setCustomAmount(amount);
        setDamage(damage);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material and SkullType
    public ItemBuilder(Material mat, SkullType type) {
        super(mat, 1, (short) type.ordinal());
    }

    //Inits ItemBuilder with Material, amount and SkullType
    public ItemBuilder(Material mat, int amount, SkullType type) {
        super(mat, 1, (short) type.ordinal());
        setCustomAmount(amount);
    }

    //Inits ItemBuilder with Material, SkullType and displayname
    public ItemBuilder(Material mat, SkullType type, String displayname) {
        super(mat, 1, (short) type.ordinal());
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material, amount, SkullType and displayname
    public ItemBuilder(Material mat, int amount, SkullType type, String displayname) {
        super(mat, 1, (short) type.ordinal());
        setCustomAmount(amount);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material and SandstoneType
    public ItemBuilder(Material mat, SandstoneType type) {
        super(mat, 1, (short) type.ordinal());
    }

    //Inits ItemBuilder with Material, amount and SandstoneType
    public ItemBuilder(Material mat, int amount, SandstoneType type) {
        super(mat, 1, (short) type.ordinal());
        setCustomAmount(amount);
    }

    //Inits ItemBuilder with Material, SandstoneType and displayname
    public ItemBuilder(Material mat, SandstoneType type, String displayname) {
        super(mat, 1, (short) type.ordinal());
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material, amount, SandstoneType and displayname
    public ItemBuilder(Material mat, int amount, SandstoneType type, String displayname) {
        super(mat, 1, (short) type.ordinal());
        setCustomAmount(amount);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material and CoalType
    public ItemBuilder(Material mat, CoalType type) {
        super(mat, 1, (short) type.ordinal());
    }

    //Inits ItemBuilder with Material, amount and CoalType
    public ItemBuilder(Material mat, int amount, CoalType type) {
        super(mat, 1, (short) type.ordinal());
        setCustomAmount(amount);
    }

    //Inits ItemBuilder with Material, CoalType and displayname
    public ItemBuilder(Material mat, CoalType type, String displayname) {
        super(mat, 1, (short) type.ordinal());
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material, amount, CoalType and displayname
    public ItemBuilder(Material mat, int amount, CoalType type, String displayname) {
        super(mat, 1, (short) type.ordinal());
        setCustomAmount(amount);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material and GrassSpecies
    public ItemBuilder(Material mat, GrassSpecies type) {
        super(mat, 1, (short) type.ordinal());
    }

    //Inits ItemBuilder with Material, amount and GrassSpecies
    public ItemBuilder(Material mat, int amount, GrassSpecies type) {
        super(mat, 1, (short) type.ordinal());
        setCustomAmount(amount);
    }

    //Inits ItemBuilder with Material, GrassSpecies and displayname
    public ItemBuilder(Material mat, GrassSpecies type, String displayname) {
        super(mat, 1, (short) type.ordinal());
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material, amount, GrassSpecies and displayname
    public ItemBuilder(Material mat, int amount, GrassSpecies type, String displayname) {
        super(mat, 1, (short) type.ordinal());
        setCustomAmount(amount);
        setDisplayName(displayname);
    }

    //Inits ItemBuilder with Material and DyeColor
    @Deprecated
    public ItemBuilder(Material mat, DyeColor color) {
        super(mat, 1);
        if (mat == Material.INK_SACK) setDamage(color.getDyeData());
        else if (mat == Material.WOOL) setDamage(color.getWoolData());
        else setDamage(color.getData());
    }

    //Inits ItemBuilder with Material, amount and DyeColor
    @Deprecated
    public ItemBuilder(Material mat, int amount, DyeColor color) {
        super(mat, 1);
        setCustomAmount(amount);
        if (mat == Material.INK_SACK) setDamage(color.getDyeData());
        else if (mat == Material.WOOL) setDamage(color.getWoolData());
        else setDamage(color.getData());
    }

    //Inits ItemBuilder with Material, DyeColor and displayname
    @Deprecated
    public ItemBuilder(Material mat, DyeColor color, String displayname) {
        super(mat, 1);
        setDisplayName(displayname);
        if (mat == Material.INK_SACK) setDamage(color.getDyeData());
        else if (mat == Material.WOOL) setDamage(color.getWoolData());
        else setDamage(color.getData());
    }

    //Inits ItemBuilder with Material, amount, DyeColor and displayname
    @Deprecated
    public ItemBuilder(Material mat, int amount, DyeColor color, String displayname) {
        super(mat, 1);
        setCustomAmount(amount);
        setDisplayName(displayname);
        if (mat == Material.INK_SACK) setDamage(color.getDyeData());
        else if (mat == Material.WOOL) setDamage(color.getWoolData());
        else setDamage(color.getData());
    }

    //Sets the TypeID of the ItemStack
    @Deprecated
    public ItemBuilder setItemID(int id) {
        super.setTypeId(id);
        return this;
    }

    //Sets the material of the ItemStack
    public ItemBuilder setMaterial(Material mat) {
        if (mat == null) mat = Material.STONE;
        Validate.notNull(mat, "The Material is null.");
        super.setType(mat);
        return this;
    }

    //Sets the amount of the ItemStack
    public ItemBuilder setCustomAmount(int amount) {
        if (((amount > super.getType().getMaxStackSize()) || (amount <= 0)) && (!unsafeStackSize)) amount = 1;
        super.setAmount(amount);
        return this;
    }

    //Sets the damage of the ItemStack
    public ItemBuilder setDamage(short damage) {
        setDurability(damage);
        return this;
    }

    //Sets the damage of the ItemStack
    public ItemBuilder setDamage(int damage) {
        setDurability((short) damage);
        return this;
    }

    //Sets the durability of the ItemStack
    public ItemBuilder setDurability(int durability) {
        if (((durability > super.getType().getMaxDurability()) || (durability <= 0)) && (!unsafeStackSize))
            durability = super.getType().getMaxDurability();
        super.setDurability((short) durability);
        return this;
    }

    //Adds the enchantment-glow
    public ItemBuilder addEnchantmentGlow() {
        Material mat = super.getType();
        addUnsafeEnchantment(mat != Material.BOW ? Enchantment.ARROW_INFINITE : Enchantment.LUCK, 10);
        addFlag(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    //Removes the enchantment-glow
    public ItemBuilder removeEnchantmentGlow() {
        Material mat = super.getType();
        removeEnchantment(mat != Material.BOW ? Enchantment.ARROW_INFINITE : Enchantment.LUCK);
        removeFlag(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    //Enchants the ItemStack with enchantment on level one
    public ItemBuilder enchant(Enchantment enchantment) {
        Validate.notNull(enchantment, "The Enchantment is null.");
        super.addUnsafeEnchantment(enchantment, 1);
        return this;
    }

    //Enchants the ItemStack with enchantment and level
    public ItemBuilder enchant(Enchantment enchantment, int level) {
        Validate.notNull(enchantment, "The Enchantment is null.");
        super.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    //Enchants the ItemStack with enchantments and levels
    public ItemBuilder enchant(Map<Enchantment, Integer> enchantments) {
        Validate.notNull(enchantments, "The Enchantments are null.");
        super.addUnsafeEnchantments(enchantments);
        return this;
    }

    //Disenchants the ItemStack with enchantment
    public ItemBuilder disenchant(Enchantment enchantment) {
        Validate.notNull(enchantment, "The Enchantment mustn´t be null.");
        super.removeEnchantment(enchantment);
        return this;
    }

    //Disenchants the ItemStack with enchantments and levels
    public ItemBuilder disenchant(Map<Enchantment, Integer> enchantments) {
        Validate.notNull(enchantments, "The Enchantments mustn´t be null.");
        for (Enchantment e : enchantments.keySet()) {
            super.removeEnchantment(e);
        }
        return this;
    }

    //Disenchants the ItemStack with enchantment
    public int removeEnchantment(Enchantment enchantment) {
        Validate.notNull(enchantment, "The Enchantment mustn´t null.");
        return super.removeEnchantment(enchantment);
    }

    //Disenchants the ItemStack with enchantments and levels
    public ItemBuilder removeEnchantments(Map<Enchantment, Integer> enchantments) {
        Validate.notNull(enchantments, "The Enchantments mustn´t be null.");
        for (Enchantment e : enchantments.keySet()) {
            super.removeEnchantment(e);
        }
        return this;
    }

    //Clears the enchantments of the ItemStack
    public ItemBuilder clearEnchantmentsItemStack() {
        for (final Enchantment e : super.getEnchantments().keySet()) {
            super.removeEnchantment(e);
        }
        return this;
    }

    //Inits Lore
    public Lore lore() {
        return new Lore(this, super.getItemMeta(), this);
    }

    //Sets the DisplayName
    public ItemBuilder setDisplayName(String name) {
        ItemMeta meta = super.getItemMeta();
        Validate.notNull(name, "The Displayname is null.");
        name = translateAlternateColorCodes ? ChatColor.translateAlternateColorCodes('&', name) : name;
        meta.setDisplayName("§r§f" + name);
        super.setItemMeta(meta);
        return this;
    }

    //Sets the item unbreakable
    public ItemBuilder setUnbreakable(boolean unbreakable) {
        ItemMeta meta = super.getItemMeta();
        if (meta != null) {
            meta.spigot().setUnbreakable(unbreakable);
            if (hideUnbreakable) meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        }
        super.setItemMeta(meta);
        return this;
    }

    //Adds an ItemFlag
    public ItemBuilder addFlag(ItemFlag flag) {
        ItemMeta meta = super.getItemMeta();
        Validate.notNull(flag, "The flags are null.");
        meta.addItemFlags(flag);
        super.setItemMeta(meta);
        return this;
    }

    //Adds Itemflags
    public ItemBuilder addFlag(ItemFlag... flags) {
        ItemMeta meta = super.getItemMeta();
        Validate.notNull(flags, "The flags are null.");
        meta.addItemFlags(flags);
        super.setItemMeta(meta);
        return this;
    }

    //Removes an ItemFlag
    public ItemBuilder removeFlag(ItemFlag flag) {
        ItemMeta meta = super.getItemMeta();
        if (flag == null) throw new IllegalArgumentException("The flag mustn´t be null.");
        meta.removeItemFlags(flag);
        super.setItemMeta(meta);
        return this;
    }

    //Removes ItemFlags
    public ItemBuilder removeFlags(ItemFlag... flags) {
        ItemMeta meta = super.getItemMeta();
        if (flags == null) throw new IllegalArgumentException("The flags mustn´t be null.");
        meta.removeItemFlags(flags);
        super.setItemMeta(meta);
        return this;
    }

    //Clears all ItemFlags
    public ItemBuilder clearItemFlags() {
        ItemMeta meta = super.getItemMeta();

        if (meta.getItemFlags() != null) {
            List<ItemFlag> flags = (List<ItemFlag>) meta.getItemFlags();
            for (ItemFlag f : flags) {
                meta.removeItemFlags(f);
            }
        }
        super.setItemMeta(meta);
        return this;
    }

    //Sets the metadate (e.g. #metadata(Metadata.SKULL, (metadata) -> { metadata.setTexture(texture);})
    public <T> ItemBuilder metadata(Class<T> metadata, Consumer<T> consumer) {
        try {
            Constructor<T> constructor = metadata.getConstructor(ItemStack.class);
            consumer.accept(constructor.newInstance(this));
        } catch (InvocationTargetException |
                NoSuchMethodException |
                InstantiationException |
                IllegalAccessException exception) {
            exception.printStackTrace();
        }
        return this;
    }

    //Sets the ItemMeta
    public boolean setItemMeta(ItemMeta itemMeta) {
        return super.setItemMeta(itemMeta);
    }

    //Lore
    public static class Lore {

        private final ItemStack item;
        private final ItemMeta meta;
        private final ItemBuilder builder;

        //Inits Lore
        private Lore(ItemStack item, ItemMeta meta, ItemBuilder builder) {
            this.item = item;
            this.meta = meta;
            this.builder = builder;
        }

        //Goes back to the builder
        public ItemBuilder back() {
            return builder;
        }

        //Adds a line to the lore
        public Lore add(String line) {
            List<String> lore = meta.getLore();
            if (lore == null) lore = new ArrayList<>();
            lore.add(translateAlternateColorCodes ? ChatColor.translateAlternateColorCodes('&', "§r§f" + line) : "§r§f" + line);
            meta.setLore(lore);
            item.setItemMeta(meta);
            return this;
        }

        //Adds index and line to the lore
        public Lore add(int index, String line) {
            List<String> lore = meta.getLore();
            if (lore == null) lore = new ArrayList<>();

            if (lore.size() < index) {
                int cur = index - lore.size();
                for (int i = 0; i < cur; i++) {
                    lore.add("");
                }
            }
            index--;
            lore.add(index, translateAlternateColorCodes ? ChatColor.translateAlternateColorCodes('&', "§r§f" + line) : "§r§f" + line);
            meta.setLore(lore);
            item.setItemMeta(meta);
            return this;
        }

        //Adds lines via List to the lore
        public Lore add(List<String> notes) {
            List<String> lore = meta.getLore();
            if (lore == null) lore = new ArrayList<>();

            for (String note : notes) {
                lore.add(translateAlternateColorCodes ? ChatColor.translateAlternateColorCodes('&', "§r§f" + note) : "§r§f" + note);
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            return this;
        }

        //Adds index and lines via List to the lore
        public Lore add(int index, List<String> notes) {
            List<String> lore = meta.getLore();
            if (lore == null) lore = new ArrayList<>();

            if (lore.size() < index) {
                int cur = index - lore.size();
                for (int i = 0; i < cur; i++) {
                    lore.add("");
                }
            }
            index--;
            for (String note : notes) {
                lore.add(index, translateAlternateColorCodes ? ChatColor.translateAlternateColorCodes('&', "§r§f" + note) : "§r§f" + note);
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            return this;
        }

        //Adds lines via String... to the lore
        public Lore add(String... notes) {
            List<String> lore = meta.getLore();
            if (lore == null) lore = new ArrayList<>();

            for (String note : notes) {
                lore.add(translateAlternateColorCodes ? ChatColor.translateAlternateColorCodes('&', "§r§f" + note) : "§r§f" + note);
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            return this;
        }

        //Adds index and lines via String... to the lore
        public Lore add(int index, String... notes) {
            List<String> lore = meta.getLore();
            if (lore == null) lore = new ArrayList<>();

            if (lore.size() < index) {
                int cur = index - lore.size();
                for (int i = 0; i < cur; i++) {
                    lore.add("");
                }
            }
            index--;
            for (String note : notes) {
                lore.add(index, translateAlternateColorCodes ? ChatColor.translateAlternateColorCodes('&', "§r§f" + note) : "§r§f" + note);
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            return this;
        }

        //Sets index and line to the lore
        public Lore set(int index, String note) {
            List<String> lore = meta.getLore();
            if (lore == null) lore = new ArrayList<>();

            if (lore.size() < index) {
                int cur = index - lore.size();
                for (int i = 0; i < cur; i++) {
                    lore.add("");
                }
            }
            index--;
            lore.set(index, translateAlternateColorCodes ? ChatColor.translateAlternateColorCodes('&', "§r§f" + note) : "§r§f" + note);
            meta.setLore(lore);
            item.setItemMeta(meta);
            return this;
        }

        //Sets String... to the lore
        public Lore set(String... notes) {
            List<String> lore = meta.getLore();
            if (lore != null) lore.clear();
            lore = new ArrayList<>();

            for (String line : notes) {
                lore.add(translateAlternateColorCodes ? ChatColor.translateAlternateColorCodes('&', "§r§f" + line) : "§r§f" + line);
            }

            meta.setLore(lore);
            item.setItemMeta(meta);
            return this;
        }

        //Removes a line from the lore
        public Lore remove(String s) {
            List<String> lore = meta.getLore();
            if (lore == null || s == null) return this;
            s = translateAlternateColorCodes ? ChatColor.translateAlternateColorCodes('&', "§r§f" + s) : s;
            if (lore.contains(s)) lore.remove(s);
            meta.setLore(lore);
            item.setItemMeta(meta);
            return this;
        }

        //Clears the lore
        public Lore clear() {
            meta.setLore(new ArrayList<>());
            item.setItemMeta(meta);
            return this;
        }

        //Gets an index of the lore
        public String get(int index) {
            if (meta.getLore() == null) meta.setLore(new ArrayList<>());

            if (meta.getLore().size() >= (index - 1)) return meta.getLore().get(index - 1);
            else return null;
        }
    }

    //Toggle translateAlternateColorCodes
    public ItemBuilder translateAlternateColorCodes(final boolean replace) {
        translateAlternateColorCodes = replace;
        return this;
    }

    //Returns translateAlternateColorCodes
    public boolean getTranslateAlternateColorCodes() {
        return translateAlternateColorCodes;
    }

    //Toggle unsafeStackSize
    public ItemBuilder unsafeStackSize(final boolean allow) {
        this.unsafeStackSize = allow;
        return this;
    }

    //Returns unsafeStackSize
    public boolean getUnsafeStackSize() {
        return unsafeStackSize;
    }

    //Toggle hideUnbreakable
    public ItemBuilder hideUnbreakable(final boolean hide) {
        this.hideUnbreakable = hide;
        return this;
    }

    //Returns hideUnbreakable
    public boolean getHideUnbreakable() {
        return hideUnbreakable;
    }

    //Returns isUnbreakable
    public boolean isUnbreakable() {
        return super.getItemMeta().spigot().isUnbreakable();
    }

    //Returns the material
    public Material getMaterial() {
        return super.getType();
    }

    //Returns the type
    public Material getType() {
        return getMaterial();
    }

    //Returns the amount
    public int getAmount() {
        return super.getAmount();
    }

    //Returns the data
    public MaterialData getData() {
        return super.getData();
    }

    //Returns the durability
    public short getDurability() {
        return super.getDurability();
    }

    //Returns the maxStackSize
    public int getMaxStackSize() {
        return super.getMaxStackSize();
    }

    //Questions, if the Item has Enchantments
    public boolean hasEnchant(Enchantment enchantment) {
        return super.containsEnchantment(enchantment);
    }

    //Questions, if the Item contains Enchantments
    public boolean containsEnchantment(Enchantment enchantment) {
        return super.containsEnchantment(enchantment);
    }

    //Returns the enchantmentLevel
    public int getEnchantmentLevel(Enchantment enchantment) {
        return super.getEnchantmentLevel(enchantment);
    }

    //Returns the enchantments
    public Map<Enchantment, Integer> getEnchantments() {
        return super.getEnchantments();
    }

    //Questions, if the Item has conflictingEnchantments
    public boolean hasConflictingEnchant(Enchantment enchantment) {
        return super.getItemMeta().hasConflictingEnchant(enchantment);
    }

    //Questions, if the Item has a displayname
    public boolean hasName() {
        return super.getItemMeta().hasDisplayName();
    }

    //Returns the displayname
    public String getName() {
        return super.getItemMeta().getDisplayName();
    }

    //Returns the ItemFlags
    public List<ItemFlag> getFlags() {
        return new ArrayList<>(super.getItemMeta().getItemFlags());
    }

    //Returns the ItemMeta
    public ItemMeta getItemMeta() {
        return super.getItemMeta();
    }
}
