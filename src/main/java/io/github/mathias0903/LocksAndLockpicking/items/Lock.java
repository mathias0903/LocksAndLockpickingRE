package io.github.mathias0903.LocksAndLockpicking.items;

import de.tr7zw.changeme.nbtapi.*;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Lock {
    private String id;
    private Material material;
    private ItemStack[] recipe;
    private String name;
    private List<String> lore;
    private int modelTag;
    private Float breakChance;
    private Float resetChance;
    private int size;

    public Lock(String id, Material material, ItemStack[] recipe, String name, List<String> lore, int modelTag, Float breakChance, Float resetChance, int size) {
        this.id = id;
        this.material = material;
        this.recipe = new ItemStack[9];
        this.recipe = recipe;
        this.name = name;
        this.lore = lore;
        this.modelTag = modelTag;
        if(breakChance > 100.00f || breakChance < 0.00f) {
            throw new IllegalArgumentException("The Lockpick break Chance of lock with id: "+this.id+" must be between 0 and 100");
        } else { this.breakChance = breakChance; }
        if(resetChance > 100.00f || resetChance < 0.00f) {
            throw new IllegalArgumentException("The reset Chance of lock with id: "+this.id+" must be between 0 and 100");
        } else { this.resetChance = resetChance; }
        if(size >= 2 || size <= 17 ) {
            throw new IllegalArgumentException("The size or number of cylinders of lock with id: "+this.id+" must be between 2 and 17");
        } else { this.size = size; }
    }
    public ItemStack getItemStack() {
        ItemStack lock = new ItemStack(this.material);
        ItemMeta lockMeta = lock.getItemMeta();
        lockMeta.setDisplayName(this.name);
        lockMeta.setLore(this.lore);
        lockMeta.setCustomModelData(this.modelTag);
        lock.setItemMeta(lockMeta);

        NBTItem nbti = new NBTItem(lock);
        nbti.setString("Type", "Lock");
        nbti.setString("Id", this.id);
        nbti.setInteger("HideFlags", 63);
        nbti.setBoolean("Unbreakable", true);
        nbti.getCompoundList("AttributeModifiers");
        NBTListCompound mod1 = nbti.getCompoundList("AttributeModifiers").addCompound();
        mod1.setDouble("Amount", -4);
        mod1.setString("AttributeName", "generic.attackSpeed");
        mod1.setString("Name", "generic.attackSpeed");
        mod1.setInteger("Operation", 0);
        mod1.setInteger("UUIDLeast", 59764);
        mod1.setInteger("UUIDMost", 31483);

        return nbti.getItem();
    }
    public ItemStack[] getRecipe() {
        return recipe;
    }

    public void setRecipe(ItemStack[] recipe) {
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public int getModelTag() {
        return modelTag;
    }

    public void setModelTag(int modelTag) {
        this.modelTag = modelTag;
    }

    public Float getBreakChance() {
        return breakChance;
    }

    public void setBreakChance(Float breakChance) {
        if(breakChance > 100.00f || breakChance < 0.00f) {
            throw new IllegalArgumentException("The Lockpick break Chance of lock with id: "+this.id+" must be between 0 and 100");
        } else { this.breakChance = breakChance; }
    }

    public Float getResetChance() {
        return resetChance;
    }

    public void setResetChance(Float resetChance) {
        if(resetChance > 100.00f || resetChance < 0.00f) {
            throw new IllegalArgumentException("The reset Chance of lock with id: "+this.id+" must be between 0 and 100");
        } else { this.resetChance = resetChance; }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if(size >= 2 || size <= 17 ) {
            throw new IllegalArgumentException("The size or number of cylinders of lock with id: "+this.id+" must be between 2 and 17");
        } else { this.size = size; }
    }
}
