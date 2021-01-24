package theGardener.garden.plots;

import com.badlogic.gdx.graphics.Color;

public class FertilizerPlot extends AbstractPlot {
    public FertilizerPlot(int bx, int by, float x, float y) {
        super(bx, by, x, y);
    }

    @Override
    public void onHarvestPlant() {
        myPlant.onHarvest();
    }

    @Override
    public Color getColor() {
        return Color.PURPLE.cpy();
    }
}
