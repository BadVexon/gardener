package theGardener.garden.plots;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.helpers.TipHelper;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import theGardener.garden.structures.AbstractPlant;
import theGardener.garden.structures.NoPlant;
import theGardener.util.TextureLoader;

public abstract class AbstractPlot {

    public int boardx;
    public int boardy;

    public Hitbox hb;

    public AbstractPlot(int bx, int by, float x, float y) {
        boardx = bx;
        boardy = by;
        this.x = x;
        this.y = y;
        hb = new Hitbox(x, y, tex.getWidth() * Settings.scale, tex.getHeight() * Settings.scale);
    }

    public float x;
    public float y;
    public static Texture tex = TextureLoader.getTexture(ezpath("BlankTile"));

    public Color getColor() {
        return Color.WHITE.cpy();
    }

    public void render(SpriteBatch sb) {
        sb.setColor(getColor());
        sb.draw(tex, x, y, tex.getWidth() / 2F, tex.getHeight() / 2F, tex.getWidth(), tex.getHeight(), Settings.scale, Settings.scale, 0, 0, 0, tex.getWidth(), tex.getHeight(), false, false);
        if (myPlant != null)
            myPlant.render(x, y, sb);
    }

    public void update() {
        hb.update();
        if (this.hb.hovered && myPlant != null) {
            TipHelper.renderGenericTip(this.x + 96.0F * Settings.scale, this.y + 64.0F * Settings.scale, myPlant.getName(), myPlant.makeDesc());
            if (InputHelper.justClickedLeft && myPlant.isMature()) {
                myPlant.harvest();
            }
        }
    }

    public void onHarvestPlant() {

    }

    public boolean canPlantHere() {
        return myPlant instanceof NoPlant;
    }

    public boolean hasPlant() {
        return !(myPlant instanceof NoPlant);
    }

    public static String ezpath(String s) {
        return "gardenmod/images/ui/" + s + ".png";
    }

    public AbstractPlant myPlant = new NoPlant();

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;

        this.hb.move(x + (tex.getWidth() / 2F * Settings.scale), y + (tex.getHeight() / 2F * Settings.scale));
    }
}
