package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import theGardener.garden.structures.AbstractPlant;

public class ResetPlantAction extends AbstractGameAction {
    private AbstractPlant card;

    public ResetPlantAction(AbstractPlant card) { //set a coordinate to -1 to use original coordinate
        this.actionType = ActionType.SPECIAL;
        this.card = card;
    }

    @Override
    public void update() {
        card.growAmt = 0;
        isDone = true;
    }
}