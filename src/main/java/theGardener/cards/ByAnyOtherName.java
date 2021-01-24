package theGardener.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.SetPlantAction;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.garden.structures.AbstractPlant;
import theGardener.garden.structures.Rose;

import java.util.ArrayList;

public class ByAnyOtherName extends AbstractGardenCard {

    public final static String ID = makeID("ByAnyOtherName");

    //stupid intellij stuff SKILL, NONE, RARE

    public ByAnyOtherName() {
        super(ID, 3, CardType.SKILL, CardRarity.RARE, CardTarget.NONE);
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                for (ArrayList<AbstractPlot> a : GardenPanel.map) {
                    for (AbstractPlot q : a) {
                        if (q.myPlant instanceof Rose) {
                            atb(new SetPlantAction(AbstractPlant.returnRandomNonRosePlant(), q.boardx, q.boardy));
                        }
                    }
                }
            }
        });
    }

    public void upp() {
        upgradeBaseCost(2);
    }
}