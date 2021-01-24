package theGardener.garden.plots;

import com.badlogic.gdx.graphics.Color;

public class ScorchedEarth extends AbstractPlot {

    public ScorchedEarth(int bx, int by, float x, float y) {
        super(bx, by, x, y);
    }

    @Override
    public Color getColor() {
        return Color.FIREBRICK.cpy();
    }

    @Override
    public boolean canPlantHere() {
        return false;
    }
}