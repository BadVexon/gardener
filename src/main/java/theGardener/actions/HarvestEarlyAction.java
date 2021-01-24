package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.vfx.SmokePuffEffect;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.garden.structures.NoPlant;

import java.util.ArrayList;

public class HarvestEarlyAction extends AbstractGameAction {
    private static final float DURATION = 0.1f;

    private boolean clicked = false;

    public HarvestEarlyAction() {
        this.actionType = ActionType.SPECIAL;

        this.startDuration = this.duration = DURATION;
    }

    public static AbstractPlot hoveredPiece() {
        for (ArrayList<AbstractPlot> a : GardenPanel.map) {
            for (AbstractPlot p : a) {
                if (p.hb.hovered && !(p.myPlant instanceof NoPlant) && !p.myPlant.isMature()) {
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public void update() {
        if (hoveredPiece() != null) {
            if (InputHelper.justClickedLeft) {
                clicked = true;
            }
        }
        AbstractPlot p = hoveredPiece();
        if (clicked && p != null) {
            if (this.duration == this.startDuration) {
                AbstractDungeon.effectList.add(new SmokePuffEffect(p.x, p.y));
            }
            tickDuration();
            if (this.isDone) {
                addToTop(new HarvestAction(p.myPlant));
            }
        }
    }
}