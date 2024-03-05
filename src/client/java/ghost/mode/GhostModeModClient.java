package ghost.mode;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class GhostModeModClient implements ClientModInitializer {
	// Esta variable controlará si los jugadores en modo espectador pueden ver a otros jugadores en modo espectador.
	public static boolean canSeeSpectators = false;
	//private KeyBinding keyBinding;

	@Override
	public void onInitializeClient() {

		//CODIGO COMENTADO ES PARA AGREGAR LA OPCION A UNA TECLA POR EJEMPLO A LA G
		//keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
		//		"key.ghostmode.toggle", // La ubicación de la traducción del nombre de la tecla
		//		InputUtil.Type.KEYSYM, // El tipo de la tecla (KEYSYM para teclas del teclado, MOUSE para teclas del ratón)
		//		GLFW.GLFW_KEY_G, // El código de la tecla
		//		"category.ghostmode" // La ubicación de la traducción de la categoría de la tecla
	//	));

		// Código que hace que cambie la vista del jugador
		//ClientTickCallback.EVENT.register(client -> {
		//	while (keyBinding.wasPressed()) {
			//	canSeeSpectators = !canSeeSpectators; // Cambia el valor de canSeeSpectators cada vez que se presiona la tecla
			//	client.setScreen(new ModMenuScreen(Text.of("Mod Menu")));
			}

}

