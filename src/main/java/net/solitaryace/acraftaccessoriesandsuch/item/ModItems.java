package net.solitaryace.acraftaccessoriesandsuch.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.solitaryace.acraftaccessoriesandsuch.AcraftAccessoriesAndSuch;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AcraftAccessoriesAndSuch.MOD_ID);

    // test item registry
    public static final RegistryObject<Item> TESTITEM = ITEMS.register("testitem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TESTCURIO = ITEMS.register("testcurio",
            TestCurio::new);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
