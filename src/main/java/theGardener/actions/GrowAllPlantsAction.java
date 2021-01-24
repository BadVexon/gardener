package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.garden.structures.NoPlant;

import java.util.ArrayList;

public class GrowAllPlantsAction extends AbstractGameAction {

    public GrowAllPlantsAction() { //set a coordinate to -1 to use original coordinate
        this.actionType = ActionType.SPECIAL;
    }

    @Override
    public void update() {
        for (ArrayList<AbstractPlot> a : GardenPanel.map) {
            for (AbstractPlot p : a) {
                if (!(p.myPlant instanceof NoPlant))
                    addToTop(new GrowPlantAction(p.myPlant));
            }
        }
        isDone = true;
    }
}