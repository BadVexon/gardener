package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import theGardener.garden.GardenPanel;
import theGardener.garden.structures.AbstractPlant;

public class GrowPlantAction extends AbstractGameAction {
    private AbstractPlant card;

    public GrowPlantAction(AbstractPlant card) { //set a coordinate to -1 to use original coordinate
        this.actionType = ActionType.SPECIAL;
        this.card = card;
    }

    @Override
    public void update() {
        card.grow();
        isDone = true;
    }
}