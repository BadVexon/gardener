package theGardener.garden.structures;

import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import theGardener.util.TextureLoader;

public class Coffee extends AbstractPlant {
    public static String ID = "Coffee";

    public Coffee() {
        growMax = 3;
        tex = TextureLoader.getTexture(ezpath(ID));
    }

    @Override
    public String getName() {
        return ID;
    }

    @Override
    public String getDesc() {
        return "#yHarvest: Gain [E] .";
    }

    @Override
    public void onHarvest() {
        atb(new GainEnergyAction(1));
    }
}
