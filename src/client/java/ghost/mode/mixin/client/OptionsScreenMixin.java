package ghost.mode.mixin.client;

import ghost.mode.GhostModeModClient;
import ghost.mode.ModMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Method;

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin extends Screen {

    protected OptionsScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    private void addModButton(CallbackInfo ci) {
        int buttonWidth = 80; // Ancho del botón
        int buttonHeight = 20; // Altura del botón
        int buttonX = this.width - buttonWidth - 10; // Posición X del botón (10 píxeles desde el borde derecho)
        int buttonY = 10; // Posición Y del botón (10 píxeles desde el borde superior)

        ButtonWidget button = ButtonWidget.builder(Text.of(GhostModeModClient.canSeeSpectators ? "Sí" : "No"),
                        new ButtonWidget.PressAction() {
                            @Override
                            public void onPress(ButtonWidget button) {
                                // Cambia el valor de canSeeSpectators cuando se presiona el botón.
                                GhostModeModClient.canSeeSpectators = !GhostModeModClient.canSeeSpectators;
                                // Actualiza el texto del botón.
                                button.setMessage(Text.of(GhostModeModClient.canSeeSpectators ? "Sí" : "No"));
                            }
                        })
                .dimensions(buttonX, buttonY, buttonWidth, buttonHeight)
                .tooltip(Tooltip.of(Text.of("Cambia si puedes ver a otros espectadores")))
                .build();

        this.addDrawableChild(button);
    }


}

