package ghost.mode.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import ghost.mode.GhostModeModClient;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WButton;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CustomButton extends WButton {
    private final Identifier textureYes;
    private final Identifier textureNo;

    public CustomButton(Text label, Identifier textureYes, Identifier textureNo) {
        super(label);
        this.textureYes = textureYes;
        this.textureNo = textureNo;
    }

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY, float delta) {
        // Selecciona la textura dependiendo del estado de canSeeSpectators
        Identifier texture = GhostModeModClient.canSeeSpectators ? textureYes : textureNo;

        // Dibuja la textura
        MinecraftClient.getInstance().getTextureManager().bindTexture(texture);
        drawSprite(matrices, x, y, 0, 0, this.getWidth(), this.getHeight(), this.getWidth(), this.getHeight());
    }
}


