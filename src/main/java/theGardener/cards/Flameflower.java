package theGardener.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.PlacePlantAction;

public class Flameflower extends AbstractGardenCard {

    public final static String ID = makeID("Flameflower");

    //stupid intellij stuff SKILL, NONE, BASIC

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    public Flameflower() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++)
            atb(new PlacePlantAction(new theGardener.garden.structures.Flameflower()));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}