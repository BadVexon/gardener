package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.vfx.SmokePuffEffect;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.garden.structures.AbstractPlant;

import java.util.ArrayList;

public class PlacePlantAction extends AbstractGameAction {
    private static final float DURATION = 0.1f;

    private AbstractPlant summon;
    private boolean clicked = false;

    public PlacePlantAction(AbstractPlant toSummon) {
        this.summon = toSummon;
        this.actionType = ActionType.SPECIAL;

        this.startDuration = this.duration = DURATION;
    }

    public static AbstractPlot hoveredPiece() {
        for (ArrayList<AbstractPlot> a : GardenPanel.map) {
            for (AbstractPlot p : a) {
                if (p.hb.hovered && p.canPlantHere()) {
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public void update() {
        if (hoveredPiece() != null) {
            AbstractPlot p = hoveredPiece();
            GardenPanel.renderHover = true;
            GardenPanel.hoverPiece = summon;
            GardenPanel.hoverX = p.x;
            GardenPanel.hoverY = p.y;
            if (InputHelper.justClickedLeft) {
                clicked = true;
            }
        } else {
            GardenPanel.renderHover = false;
        }
        AbstractPlot p = hoveredPiece();
        if (clicked && p != null) {
            if (this.duration == this.startDuration) {
                AbstractDungeon.effectList.add(new SmokePuffEffect(p.x, p.y));
            }
            tickDuration();
            if (this.isDone) {
                addToTop(new SetPlantAction(summon, p.boardx, p.boardy));
                GardenPanel.renderHover = false;
                GardenPanel.hoverPiece = null;
                GardenPanel.hoverX = -1;
                GardenPanel.hoverY = -1;
            }
        }
    }
}