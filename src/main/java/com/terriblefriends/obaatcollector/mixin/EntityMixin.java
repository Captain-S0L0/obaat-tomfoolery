package com.terriblefriends.obaatcollector.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Shadow private boolean glowing;

    @Inject(method="isGlowing",at=@At("HEAD"),cancellable = true)
    private void isGlowingClientFix(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(glowing);
        if (cir.isCancellable()) {cir.cancel();}
    }
}
