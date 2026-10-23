package net.solitaryace.acraftaccessoriesandsuch.item;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class TestCurio extends Item implements ICurioItem {

    public final UUID MAX_HEALTH_MOD_UUID_STATIC = UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6");

    public TestCurio() {
        super(new Item.Properties().stacksTo(1).defaultDurability(0));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack){
        Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();
        if (slotContext.identifier().equals("ring")) {
            attributes.put(Attributes.MAX_HEALTH, new AttributeModifier(MAX_HEALTH_MOD_UUID_STATIC,"max_health_modifier_curio", 5.0, AttributeModifier.Operation.ADDITION));
        }
        return attributes;
    }

}
