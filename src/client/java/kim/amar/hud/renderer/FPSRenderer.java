package kim.amar.hud.renderer;

import kim.amar.config.HUDConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class FPSRenderer extends Renderer {
    public FPSRenderer(DrawContext drawContext) {
        String fps = client.fpsDebugString.substring(0, client.fpsDebugString.indexOf('s') + 1);
        int fpsWidth = calculateBackgroundWidth(fps);

        HUDConfig config = HUDConfig.instance();

        int x = (int) ((client.getWindow().getScaledWidth() - fpsWidth) * config.fpsXPercentage / 100.0);
        int y = (int) (client.getWindow().getScaledHeight() * config.fpsYPercentage / 100.0) - 3;

        renderBackground(drawContext, x, y, calculateBackgroundWidth(fps) + 10, 17, config.fpsBgColor);
        renderText(drawContext, Text.of(fps), x + 5, y + 5, config.fpsTextColor);
    }
}
