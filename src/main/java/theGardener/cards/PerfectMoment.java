package theGardener.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;

import java.util.ArrayList;

public class PerfectMoment extends AbstractGardenCard {

    public final static String ID = makeID("PerfectMoment");

    //stupid intellij stuff SKILL, SELF, COMMON

    private static final int BLOCK = 10;
    private static final int UPG_BLOCK = 3;

    public PerfectMoment() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = BLOCK;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        if (!haveMature()) {
            blck();
        }
    }

    @Override
    public void triggerOnGlowCheck() {
        glowColor = !haveMature() ? GOLD_BORDER_GLOW_COLOR : BLUE_BORDER_GLOW_COLOR;
    }

    private static boolean haveMature() {
        for (ArrayList<AbstractPlot> a : GardenPanel.map) {
            for (AbstractPlot q : a) {
                if (q.myPlant.isMature()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void upp() {
        upgradeBlock(UPG_BLOCK);
    }
}