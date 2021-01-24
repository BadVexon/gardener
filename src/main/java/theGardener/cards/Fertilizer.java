package theGardener.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.FertilizePlotAction;

public class Fertilizer extends AbstractGardenCard {

    public final static String ID = makeID("Fertilizer");

    //stupid intellij stuff skill, none, uncommon

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    public Fertilizer() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++)
            atb(new FertilizePlotAction());
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}