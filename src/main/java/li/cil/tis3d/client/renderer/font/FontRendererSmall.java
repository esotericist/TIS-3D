package li.cil.tis3d.client.renderer.font;

import li.cil.tis3d.api.API;
import net.minecraft.util.Identifier;

public final class FontRendererSmall extends AbstractFontRenderer {
    public static final FontRenderer INSTANCE = new FontRendererSmall();

    private static final Identifier LOCATION_FONT_TEXTURE = new Identifier(API.MOD_ID, "textures/font/small.png");
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890:#-,?+!=()'.";

    // --------------------------------------------------------------------- //
    // FontRenderer

    @Override
    public int getCharWidth() {
        return 3;
    }

    @Override
    public int getCharHeight() {
        return 4;
    }

    // --------------------------------------------------------------------- //
    // AbstractFontRenderer

    @Override
    protected CharSequence getCharacters() {
        return CHARS;
    }

    @Override
    protected Identifier getTextureLocation() {
        return LOCATION_FONT_TEXTURE;
    }

    @Override
    protected int getResolution() {
        return 32;
    }

    @Override
    protected int getGapU() {
        return 1;
    }

    @Override
    protected int getGapV() {
        return 1;
    }

    // --------------------------------------------------------------------- //

    private FontRendererSmall() {
    }
}
