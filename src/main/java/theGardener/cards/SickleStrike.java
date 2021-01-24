package theGardener.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.garden.structures.NoPlant;

import java.util.ArrayList;

public class SickleStrike extends AbstractGardenCard {

    public final static String ID = makeID("SickleStrike");

    //stupid intellij stuff ATTACK, ENEMY, COMMON

    private static final int DAMAGE = 9;
    private static final int UPG_DAMAGE = 1;

    private static final int MAGIC = 4;
    private static final int UPG_MAGIC = -1;

    public SickleStrike() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseMagicNumber = magicNumber = MAGIC;
        tags.add(CardTags.STRIKE);
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
        if (hasColumnAmount()) {
            weaken(m, 2);
        }
    }

    @Override
    public void triggerOnGlowCheck() {
        glowColor = hasColumnAmount() ? GOLD_BORDER_GLOW_COLOR.cpy() : BLUE_BORDER_GLOW_COLOR.cpy();
    }

    private boolean hasColumnAmount() {
        for (ArrayList<AbstractPlot> a : GardenPanel.map) {
            int x = 0;
            for (AbstractPlot p : a) {
                if (!(p.myPlant instanceof NoPlant))
                    x++;
            }
            if (x >= magicNumber)
                return true;
        }
        return false;
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
        upgradeMagicNumber(UPG_MAGIC);
    }
}