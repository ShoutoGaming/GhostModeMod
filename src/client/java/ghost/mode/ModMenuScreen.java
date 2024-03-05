package ghost.mode;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ModMenuScreen extends Screen {
    public ButtonWidget button;

    public ModMenuScreen(Text title) {
        super(title);
    }

    @Override
    public void init() {
        button = ButtonWidget.builder(Text.of(GhostModeModClient.canSeeSpectators ? "Sí" : "No"), button -> {
                    // Cambia el valor de canSeeSpectators cuando se presiona el botón.
                    GhostModeModClient.canSeeSpectators = !GhostModeModClient.canSeeSpectators;
                    // Actualiza el texto del botón.
                    button.setMessage(Text.of(GhostModeModClient.canSeeSpectators ? "Sí" : "No"));
                })
                .dimensions(width / 2 - 100, height / 2 - 50, 200, 20)
                .tooltip(Tooltip.of(Text.of("Cambia si puedes ver a otros espectadores")))
                .build();

        addDrawableChild(button);
    }
}