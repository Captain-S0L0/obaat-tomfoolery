package com.terriblefriends.obaatcollector.mixin;

import com.terriblefriends.obaatcollector.ObaatCollector;
import net.minecraft.class_7323;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.network.MessageType;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(FallingBlockEntity.class)
public abstract class FallingBlockEntityMixin extends Entity {
    private FallingBlockEntity FBE_instance = (FallingBlockEntity) (Object) this;

    public FallingBlockEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method="tick",at=@At("HEAD"))
    private void tickInject(CallbackInfo ci) {
        boolean glowing = false;
        Item item = class_7323.method_42881(FBE_instance.getBlockState());
        if (ObaatCollector.desireableItems.contains(item) || item instanceof SpawnEggItem || ObaatCollector.desireableBlocks.contains(FBE_instance.getBlockState().getBlock())) {
            glowing = true;
            if (!FBE_instance.isGlowing()) {
                String name = "";
                if (item != null) {
                    name = item.getTranslationKey();
                }
                else if (FBE_instance.getBlockState().getBlock() != null) {
                    name = FBE_instance.getBlockState().getBlock().getTranslationKey();
                }
                MinecraftClient.getInstance().inGameHud.addChatMessage(MessageType.SYSTEM, Text.of("Desireable found! "+name), UUID.randomUUID());
            }
        }
        FBE_instance.setGlowing(glowing);
    }
}
