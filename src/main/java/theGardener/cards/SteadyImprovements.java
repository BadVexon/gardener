package theGardener.cards;

import com.megacrit.cardcrawl.actions.unique.ArmamentsAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SteadyImprovements extends AbstractGardenCard {

    public final static String ID = makeID("SteadyImprovements");

    //stupid intellij stuff SKILL, SELF, COMMON

    private static final int BLOCK = 7;
    private static final int UPG_BLOCK = 3;

    public SteadyImprovements() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = BLOCK;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        blck();
        atb(new ArmamentsAction(false));
    }

    public void upp() {
        upgradeBlock(UPG_BLOCK);
    }
}