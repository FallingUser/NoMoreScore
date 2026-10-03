package com.frogastudios.nomorescore.mixin;

import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(DeathScreen.class)
public class MixinDeathScreen {
    @ModifyArgs(method = "drawTitles", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/font/DrawnTextConsumer;text(Lnet/minecraft/client/font/Alignment;IILnet/minecraft/text/Text;)V"))
    private void replaceScoreText(Args args) {
        int y = args.get(2);
        if (y == 100) {
            args.set(3, Text.literal(""));
        }
    }
}
