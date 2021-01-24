package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import theGardener.garden.GardenPanel;
import theGardener.garden.structures.AbstractPlant;

public class SetPlantAction extends AbstractGameAction {
    private AbstractPlant card;
    private int destinationX;
    private int destinationY;

    public SetPlantAction(AbstractPlant card, int destinationX, int destinationY) { //set a coordinate to -1 to use original coordinate
        this.actionType = ActionType.SPECIAL;
        this.card = card;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }

    @Override
    public void update() {
        GardenPanel.map.get(destinationX).get(destinationY).myPlant = card;
        card.onPlant();
        isDone = true;
    }
}