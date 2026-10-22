package net.solitaryace.acraftaccessoriesandsuch.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class TestCurio extends Item implements ICurioItem {
    public TestCurio() {
        super(new Item.Properties().stacksTo(1).defaultDurability(0));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        //logic
    }

}
