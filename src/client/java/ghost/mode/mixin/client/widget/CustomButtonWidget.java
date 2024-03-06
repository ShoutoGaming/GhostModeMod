package ghost.mode.mixin.client.widget;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class CustomButtonWidget extends CustomPressableWidget{
    //Misma clase del boton widget solo modificando que se extienda a nuestra clase CustomPressableWidget
    public static final int DEFAULT_WIDTH_SMALL = 120;
    public static final int DEFAULT_WIDTH = 150;
    public static final int DEFAULT_HEIGHT = 20;
    public static final int field_46856 = 8;
    protected static final CustomButtonWidget.NarrationSupplier DEFAULT_NARRATION_SUPPLIER = (textSupplier) -> {
        return (MutableText)textSupplier.get();
    };
    protected final CustomButtonWidget.PressAction onPress;
    protected final CustomButtonWidget.NarrationSupplier narrationSupplier;

    public static CustomButtonWidget.Builder builder(Text message, CustomButtonWidget.PressAction onPress) {
        return new CustomButtonWidget.Builder(message, onPress);
    }

    protected CustomButtonWidget(int x, int y, int width, int height, Text message, CustomButtonWidget.PressAction onPress, CustomButtonWidget.NarrationSupplier narrationSupplier) {
        super(x, y, width, height, message);
        this.onPress = onPress;
        this.narrationSupplier = narrationSupplier;
    }

    public void onPress() {
        this.onPress.onPress(this);
    }

    protected MutableText getNarrationMessage() {
        return this.narrationSupplier.createNarrationMessage(() -> {
            return super.getNarrationMessage();
        });
    }

    public void appendClickableNarrations(NarrationMessageBuilder builder) {
        this.appendDefaultNarrations(builder);
    }

    @Environment(EnvType.CLIENT)
    public static class Builder {
        private final Text message;
        private final CustomButtonWidget.PressAction onPress;
        @Nullable
        private Tooltip tooltip;
        private int x;
        private int y;
        private int width = 150;
        private int height = 20;
        private CustomButtonWidget.NarrationSupplier narrationSupplier;

        public Builder(Text message, CustomButtonWidget.PressAction onPress) {
            this.narrationSupplier = CustomButtonWidget.DEFAULT_NARRATION_SUPPLIER;
            this.message = message;
            this.onPress = onPress;
        }

        public CustomButtonWidget.Builder position(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public CustomButtonWidget.Builder width(int width) {
            this.width = width;
            return this;
        }

        public CustomButtonWidget.Builder size(int width, int height) {
            this.width = width;
            this.height = height;
            return this;
        }

        public CustomButtonWidget.Builder dimensions(int x, int y, int width, int height) {
            return this.position(x, y).size(width, height);
        }

        public CustomButtonWidget.Builder tooltip(@Nullable Tooltip tooltip) {
            this.tooltip = tooltip;
            return this;
        }

        public CustomButtonWidget.Builder narrationSupplier(CustomButtonWidget.NarrationSupplier narrationSupplier) {
            this.narrationSupplier = narrationSupplier;
            return this;
        }

        public CustomButtonWidget build() {
            CustomButtonWidget buttonWidget = new CustomButtonWidget(this.x, this.y, this.width, this.height, this.message, this.onPress, this.narrationSupplier);
            buttonWidget.setTooltip(this.tooltip);
            return buttonWidget;
        }
    }

    @Environment(EnvType.CLIENT)
    public interface PressAction {
        void onPress(CustomButtonWidget button);
    }

    @Environment(EnvType.CLIENT)
    public interface NarrationSupplier {
        MutableText createNarrationMessage(Supplier<MutableText> textSupplier);
    }
}
