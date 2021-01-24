package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.garden.structures.AbstractPlant;
import theGardener.garden.structures.NoPlant;

import java.util.ArrayList;

public class PlacePlantRandomSpotAction extends AbstractGameAction {
    private AbstractPlant card;

    public PlacePlantRandomSpotAction(AbstractPlant card) { //set a coordinate to -1 to use original coordinate
        this.actionType = ActionType.SPECIAL;
        this.card = card;
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
        int rx = x.get(AbstractDungeon.cardRandomRng.random(x.size() - 1));
        int ry = y.get(AbstractDungeon.cardRandomRng.random(y.size() - 1));
        addToTop(new SetPlantAction(card, rx, ry));
        isDone = true;
    }
}