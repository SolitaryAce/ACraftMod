package net.solitaryace.acraftaccessoriesandsuch.item;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.hollingsworth.arsnouveau.api.item.ArsNouveauCurio;
import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import combat_dash.init.CombatDashModAttributes;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;
import java.util.UUID;

public class MorphRelicCurio extends ArsNouveauCurio {

    public final UUID MORPH_LUCK_UUID = UUID.fromString("dd2ef345-1809-432b-a797-40188b5e2a8b");
    public final UUID MORPH_DASH_AMOUNT_UUID = UUID.fromString("45ea5103-db51-42ff-adcb-e79b039405f6");
    public final UUID MORPH_MAX_MANA_UUID = UUID.fromString("dd2ef345-1809-432b-a797-40188b5e2a8a");
    public final UUID MORPH_ATTACK_SPEED_UUID = UUID.fromString("45ea5103-db51-42ff-adcb-e79b039405f8");
    public final UUID MORPH_SPEED_UUID = UUID.fromString("45ea5103-db51-42ff-adcb-e79b039405f9");
    public final UUID MORPH_JUMP_BOOST_UUID = UUID.fromString("45ea5103-db51-42ff-adcb-e79b039405f7");
    public final UUID MORPH_ARMOUR_TOUGHNESS_UUID = UUID.fromString("45ea5103-db51-42ff-adcb-e79b039405f5");
    public final UUID MORPH_ATTACK_DAMAGE_UUID = UUID.fromString("45ea5103-db51-42ff-adcb-e79b039405f4");

    public MorphRelicCurio() {
        super(new Item.Properties()
                .stacksTo((1))
                .defaultDurability(0));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();
        switch (slotContext.identifier()) {
            case "ring" ->
                    attributes.put(Attributes.ATTACK_SPEED, new AttributeModifier(MORPH_ATTACK_SPEED_UUID, "attack_speed_modifier_curio", 0.5, AttributeModifier.Operation.MULTIPLY_BASE));
            case "rings" ->
                    attributes.put(Attributes.ATTACK_SPEED, new AttributeModifier(MORPH_ATTACK_SPEED_UUID, "attack_speed_modifier_curio", 0.5, AttributeModifier.Operation.MULTIPLY_BASE));
            case "feet" ->
                    attributes.put(CombatDashModAttributes.MAXDASHAMOUNT.get(), new AttributeModifier(MORPH_DASH_AMOUNT_UUID, "dash_amount_modifier_curio", 1.0, AttributeModifier.Operation.ADDITION));
            case "head" ->
                    attributes.put(PerkAttributes.MAX_MANA.get(), new AttributeModifier(MORPH_MAX_MANA_UUID, "max_mana_modifier_curio", 0.2, AttributeModifier.Operation.MULTIPLY_BASE));
            case "charm" ->
                    attributes.put(Attributes.LUCK, new AttributeModifier(MORPH_LUCK_UUID, "luck_modifier_curio", 10.0, AttributeModifier.Operation.ADDITION));
            case "waist" ->
                    attributes.put(Attributes.JUMP_STRENGTH, new AttributeModifier(MORPH_JUMP_BOOST_UUID, "jump_modifier_curio", 0.5, AttributeModifier.Operation.MULTIPLY_BASE));
            case "belt" ->
                    attributes.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(MORPH_SPEED_UUID, "speed_modifier_curio", 0.5, AttributeModifier.Operation.MULTIPLY_BASE));
            case "necklace" ->
                    attributes.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(MORPH_ARMOUR_TOUGHNESS_UUID, "armour_toughness_modifier_curio", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));
            case "hands" ->
                    attributes.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(MORPH_ATTACK_DAMAGE_UUID, "attack_damage_modifier_curio", 0.5, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return attributes;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip2, TooltipFlag flagIn) {
        tooltip2.add(Component.translatable("tooltip.acraftaccessoriesandsuch.morphreliccurio"));
        super.appendHoverText(stack, worldIn, tooltip2, flagIn);
    }
}
