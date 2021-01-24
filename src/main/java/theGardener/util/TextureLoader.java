package theGardener.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.HashMap;

import static theGardener.GardenMod.*;


public class TextureLoader {
    private static HashMap<String, Texture> textures = new HashMap<>();

    /**
     * @param textureString - String path to the texture you want to load relative to resources,
     *                      Example: makeImagePath("missing.png")
     * @return <b>com.badlogic.gdx.graphics.Texture</b> - The texture from the path provided
     */
    public static Texture getTexture(final String textureString) {
        if (textures.get(textureString) == null) {
            try {
                loadTexture(textureString, true);
            } catch (GdxRuntimeException e) {
                try {
                    return getTexture(makeImagePath("/ui/Rose.png"));
                } catch (GdxRuntimeException ex) {
                    return null;
                }
            }
        }
        return textures.get(textureString);
    }

    public static Texture getTexture(final String textureString, boolean linear) {
        if (textures.get(textureString) == null) {
            try {
                loadTexture(textureString, linear);
            } catch (GdxRuntimeException e) {
                try {
                    return getTexture(makeImagePath("missing.png"));
                } catch (GdxRuntimeException ex) {
                    return null;
                }
            }
        }
        return textures.get(textureString);
    }

    public static Texture getTextureNull(final String textureString) {
        if (textures.get(textureString) == null) {
            try {
                loadTexture(textureString);
            } catch (GdxRuntimeException e) {
                return null;
            }
        }
        return textures.get(textureString);
    }

    public static String getCardTextureString(final String cardName, final AbstractCard.CardType cardType) {
        String textureString;


        textureString = makeImagePath("cards/" + cardName + ".png");

        if (textures.get(textureString) == null) {
            try {
                loadTexture(textureString);
            } catch (GdxRuntimeException e) {
                switch (cardType) {
                    case ATTACK:
                        textureString = makeImagePath("cards/Attack.png");
                        break;
                    case SKILL:
                        textureString = makeImagePath("cards/Skill.png");
                        break;
                    case POWER:
                        textureString = makeImagePath("cards/Power.png");
                        break;
                    default:
                        textureString = makeImagePath("missing.png");
                        break;
                }
            }
        }
        //no exception, file exists
        return textureString;
    }

    public static String getAndLoadCardTextureString(final String cardName, final AbstractCard.CardType cardType) {
        String textureString = getCardTextureString(cardName, cardType);

        if (textures.get(textureString) == null) {
            try {
                loadTexture(textureString);
            } catch (GdxRuntimeException e) {
                switch (cardType) {
                    case ATTACK:
                        textureString = makeImagePath("cards/Attack.png");
                        break;
                    case SKILL:
                        textureString = makeImagePath("cards/Skill.png");
                        break;
                    case POWER:
                        textureString = makeImagePath("cards/Power.png");
                        break;
                    default:
                        textureString = makeImagePath("missing.png");
                        break;
                }
            }
        }
        //no exception, file exists
        return textureString;
    }

    private static void loadTexture(final String textureString) throws GdxRuntimeException {
        loadTexture(textureString, false);
    }

    private static void loadTexture(final String textureString, boolean linearFilter) throws GdxRuntimeException {
        Texture texture = new Texture(textureString);
        if (linearFilter) {
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        } else {
            texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        }
        textures.put(textureString, texture);
    }

    public static Texture getPowerTexture(final String powerName) {
        String textureString = makePowerPath(powerName + ".png");
        return getTexture(textureString);
    }

    public static Texture getHiDefPowerTexture(final String powerName) {
        String textureString = makeLargePowerPath(powerName + ".png");
        return getTextureNull(textureString);
    }
}