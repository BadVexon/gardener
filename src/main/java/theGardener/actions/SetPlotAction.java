package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;

public class SetPlotAction extends AbstractGameAction {
    private AbstractPlot card;
    private int destinationX;
    private int destinationY;

    public SetPlotAction(AbstractPlot card, int destinationX, int destinationY) { //set a coordinate to -1 to use original coordinate
        this.actionType = ActionType.SPECIAL;
        this.card = card;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }

    @Override
    public void update() {
        GardenPanel.map.get(destinationX).set(destinationY, card);
        isDone = true;
    }
}