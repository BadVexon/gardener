package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.vfx.SmokePuffEffect;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.garden.structures.NoPlant;

import java.util.ArrayList;

public class WaterPlusSpaceAction extends AbstractGameAction {
    private static final float DURATION = 0.1f;

    private boolean clicked = false;

    public WaterPlusSpaceAction() {
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
        if (clicked) {
            AbstractPlot p = hoveredPiece();
            if (p != null) {
                if (this.duration == this.startDuration) {
                    AbstractDungeon.effectList.add(new SmokePuffEffect(p.x, p.y));
                }
                tickDuration();
                if (this.isDone) {
                    addToTop(new GrowPlantAction(p.myPlant));
                    if (p.boardx != GardenPanel.map.size() - 1) {
                        System.out.println(p.boardx + "," + p.boardy);
                        AbstractPlot p1 = GardenPanel.map.get(p.boardx + 1).get(p.boardy);
                        addToTop(new GrowPlantAction(p1.myPlant));
                    }
                    if (p.boardx != 0) {
                        AbstractPlot p2 = GardenPanel.map.get(p.boardx - 1).get(p.boardy);
                        addToTop(new GrowPlantAction(p2.myPlant));
                    }
                    if (p.boardy != GardenPanel.map.size() - 1) {
                        AbstractPlot p3 = GardenPanel.map.get(p.boardx).get(p.boardy + 1);
                        addToTop(new GrowPlantAction(p3.myPlant));
                    }
                    if (p.boardy != 0) {
                        AbstractPlot p4 = GardenPanel.map.get(p.boardx).get(p.boardy - 1);
                        addToTop(new GrowPlantAction(p4.myPlant));
                    }
                }
            }
        }
    }
}