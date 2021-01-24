package theGardener.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.PlacePlantRandomSpotAction;

public class Coffee extends AbstractGardenCard {

    public final static String ID = makeID("Coffee");

    //stupid intellij stuff skill, none, uncommon

    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;

    public Coffee() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++)
            atb(new PlacePlantRandomSpotAction(new theGardener.garden.structures.Coffee()));
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}