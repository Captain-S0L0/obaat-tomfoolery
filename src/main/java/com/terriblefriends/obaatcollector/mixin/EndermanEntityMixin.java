package com.terriblefriends.obaatcollector.mixin;

import com.terriblefriends.obaatcollector.ObaatCollector;
import net.minecraft.class_7323;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.network.MessageType;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.UUID;

@Mixin(EndermanEntity.class)
public abstract class EndermanEntityMixin extends HostileEntity {
    private EndermanEntity EE_instance = (EndermanEntity) (Object) this;

    protected EndermanEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public void tick() {
        super.tick();
        boolean glowing = false;
        if (EE_instance.method_42800() != null) {
            Item item = class_7323.method_42881(EE_instance.method_42800());
            if (ObaatCollector.desireableItems.contains(item) || item instanceof SpawnEggItem || ObaatCollector.desireableBlocks.contains(EE_instance.method_42800().getBlock())) {
                glowing = true;
                if (!EE_instance.isGlowing()) {
                    String name = "";
                    if (item != null) {
                        name = item.getTranslationKey();
                    }
                    else if (EE_instance.method_42800().getBlock() != null) {
                        name = EE_instance.method_42800().getBlock().getTranslationKey();
                    }
                    MinecraftClient.getInstance().inGameHud.addChatMessage(MessageType.SYSTEM, Text.of("Desireable found! "+name), UUID.randomUUID());
                }
            }
        }
        EE_instance.setGlowing(glowing);
    }
}
