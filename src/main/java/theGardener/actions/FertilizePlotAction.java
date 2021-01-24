package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.vfx.SmokePuffEffect;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.garden.plots.FertilizerPlot;
import theGardener.garden.plots.RegularPlot;

import java.util.ArrayList;

public class FertilizePlotAction extends AbstractGameAction {
    private static final float DURATION = 0.1f;

    private boolean clicked = false;

    public FertilizePlotAction() {
        this.actionType = ActionType.SPECIAL;

        this.startDuration = this.duration = DURATION;
    }

    public static AbstractPlot hoveredPiece() {
        for (ArrayList<AbstractPlot> a : GardenPanel.map) {
            for (AbstractPlot p : a) {
                if (p.hb.hovered && p instanceof RegularPlot) {
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public void update() {
        if (hoveredPiece() == null) {
            GardenPanel.renderPlot = false;
        } else {
            AbstractPlot p = hoveredPiece();
            GardenPanel.renderHover = true;
            GardenPanel.hoverPlot = new FertilizerPlot(-999, -999, -999, -999);
            GardenPanel.hoverX = p.x;
            GardenPanel.hoverY = p.y;
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
                addToTop(new SetPlotAction(new FertilizerPlot(p.boardx, p.boardy, p.x, p.y), p.boardx, p.boardy));
                GardenPanel.renderHover = false;
                GardenPanel.hoverPiece = null;
                GardenPanel.hoverX = -1;
                GardenPanel.hoverY = -1;
            }
        }
    }
}