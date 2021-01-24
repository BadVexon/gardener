package theGardener.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.PlacePlantAction;
import theGardener.garden.structures.Guardsprout;

public class Guardsprouts extends AbstractGardenCard {

    public final static String ID = makeID("Guardsprouts");

    //stupid intellij stuff SKILL, SELF, COMMON

    private static final int MAGIC = 3;
    private static final int UPG_MAGIC = 1;

    public Guardsprouts() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++)
            atb(new PlacePlantAction(new Guardsprout()));
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}