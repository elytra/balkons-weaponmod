package com.elytradev.weaponmod.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemCrossbow extends ItemShooter {
    public IIcon iconIndexLoaded;

    public ItemCrossbow(String id, RangedComponent rangedcomponent, MeleeComponent meleecomponent) {
        super(id, rangedcomponent, meleecomponent);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass) {
        if (RangedComponent.isReloaded(stack)) {
            return iconIndexLoaded;
        }
        return super.getIcon(stack, renderPass);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        super.registerIcons(par1IconRegister);
        iconIndexLoaded = par1IconRegister.registerIcon(getIconString() + "-loaded");
    }
}
