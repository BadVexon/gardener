package theGardener.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;

import java.util.ArrayList;

public class GloveSmacks extends AbstractGardenCard {

    public final static String ID = makeID("GloveSmacks");

    //stupid intellij stuff ATTACK, ENEMY, COMMON

    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 1;

    public GloveSmacks() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseSecondDamage = secondDamage = 3;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        for (ArrayList<AbstractPlot> a : GardenPanel.map) {
            for (AbstractPlot q : a) {
                if (q.myPlant.isMature()) {
                    altdmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
                }
            }
        }
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
        upgradeSecondDamage(1);
    }
}