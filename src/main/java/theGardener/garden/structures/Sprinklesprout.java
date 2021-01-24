package theGardener.garden.structures;

import theGardener.actions.GrowPlantAction;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.util.TextureLoader;

public class Sprinklesprout extends AbstractPlant {
    public static String ID = "Sprinklesprout";

    public Sprinklesprout() {
        growMax = 3;
        tex = TextureLoader.getTexture(ezpath(ID));
    }

    @Override
    public String getName() {
        return ID;
    }

    @Override
    public String getDesc() {
        return "#yHarvest: #yWater all adjacent Plants.";
    }

    @Override
    public void onHarvest() {
        if (myHome().boardx != GardenPanel.map.size() - 1) {
            AbstractPlot p1 = GardenPanel.map.get(myHome().boardx + 1).get(myHome().boardy);
            atb(new GrowPlantAction(p1.myPlant));
        }
        if (myHome().boardx != 0) {
            AbstractPlot p2 = GardenPanel.map.get(myHome().boardx - 1).get(myHome().boardy);
            atb(new GrowPlantAction(p2.myPlant));
        }
        if (myHome().boardy != GardenPanel.map.size() - 1) {
            AbstractPlot p3 = GardenPanel.map.get(myHome().boardx).get(myHome().boardy + 1);
            atb(new GrowPlantAction(p3.myPlant));
        }
        if (myHome().boardy != 0) {
            AbstractPlot p4 = GardenPanel.map.get(myHome().boardx).get(myHome().boardy - 1);
            atb(new GrowPlantAction(p4.myPlant));
        }
    }
}
