package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.garden.plots.ScorchedEarth;
import theGardener.garden.structures.AbstractPlant;

import java.util.ArrayList;

public class ScorchRandomEarthAction extends AbstractGameAction {

    public ScorchRandomEarthAction() { //set a coordinate to -1 to use original coordinate
        this.actionType = ActionType.SPECIAL;
    }

    @Override
    public void update() {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for (ArrayList<AbstractPlot> a : GardenPanel.map) {
            for (AbstractPlot p : a) {
                if (p.canPlantHere()) {
                    x.add(p.boardx);
                    y.add(p.boardy);
                }
            }
        }
        int destinationX = x.get(AbstractDungeon.cardRandomRng.random(x.size() - 1));
        int destinationY = y.get(AbstractDungeon.cardRandomRng.random(y.size() - 1));
        AbstractPlot p = GardenPanel.map.get(destinationX).get(destinationY);
        AbstractPlot q = new ScorchedEarth(destinationX, destinationY, p.x, p.y);
        GardenPanel.map.get(destinationX).set(destinationY, q);
        isDone = true;
    }
}