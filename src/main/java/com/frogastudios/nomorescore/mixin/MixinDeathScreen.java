package com.frogastudios.nomorescore.mixin;

import net.minecraft.client.gui.ActiveTextCollector;
import net.minecraft.client.gui.TextAlignment;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DeathScreen.class)
public class MixinDeathScreen {
    @Redirect(method = "visitText", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/ActiveTextCollector;accept(Lnet/minecraft/client/gui/TextAlignment;IILnet/minecraft/network/chat/Component;)V"))
    private void nomorescore$hideDeathScore(ActiveTextCollector collector, TextAlignment alignment, int x, int y, Component text) {if (y == 100) {
            return;
        }
        collector.accept(alignment, x, y, text);
    }
}
