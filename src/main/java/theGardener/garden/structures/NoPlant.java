package theGardener.garden.structures;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import theGardener.garden.plots.ScorchedEarth;

public class NoPlant extends AbstractPlant {
    public NoPlant() {

    }

    @Override
    public String getName() {
        if (myHome() instanceof ScorchedEarth)
            return "Scorched Earth";
        return "Empty Plot";
    }

    @Override
    public String makeDesc() {
        if (myHome() instanceof ScorchedEarth)
            return "A Plant may #rNOT be Planted here.";
        return "A Plant may be Planted here.";
    }

    @Override
    public String getDesc() {
        return "ERROR";
    }

    @Override
    public void grow() {

    }

    @Override
    public void harvest() {

    }

    @Override
    public void render(float x, float y, SpriteBatch sb) {

    }
}
