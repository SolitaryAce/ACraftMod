package net.solitaryace.acraftaccessoriesandsuch.item;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.hollingsworth.arsnouveau.api.item.ArsNouveauCurio;
import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class HeavenlyRestrictionCurio extends ArsNouveauCurio{

    public final UUID MANA_REGEN_UUID = UUID.fromString("dd2ef345-1809-432b-a797-40188b5e2a8b");
    public final UUID MAX_MANA_UUID = UUID.fromString("45ea5103-db51-42ff-adcb-e79b039405f8");

    public HeavenlyRestrictionCurio() {
            super(new Item.Properties().stacksTo(1).defaultDurability(0));
    }

    public int getMaxManaBoost(ItemStack i) {
        return 50;
    }

    public double getManaRegenBonus(ItemStack i) {
        return -0.50;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack){
        Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();
        if (slotContext.identifier().equals("charm")){
            attributes.put(PerkAttributes.MAX_MANA.get(), new AttributeModifier(MAX_MANA_UUID, "max_mana_modifier_curio", this.getMaxManaBoost(stack), AttributeModifier.Operation.MULTIPLY_BASE));
            attributes.put(PerkAttributes.MANA_REGEN_BONUS.get(), new AttributeModifier(MANA_REGEN_UUID, "mana_regen_modifier_curio", this.getManaRegenBonus(stack), AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return attributes;
    }

}
