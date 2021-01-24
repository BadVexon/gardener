package theGardener.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.PlacePlantAction;
import theGardener.actions.SetCardTargetCoordinatesAction;
import theGardener.garden.structures.Rose;

public class HasItsThorn extends AbstractGardenCard {

    public final static String ID = makeID("HasItsThorn");

    //stupid intellij stuff SKILL, NONE, UNCOMMON

    private static final int MAGIC = 3;

    public HasItsThorn() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
        isEthereal = true;
        exhaust = true;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++) {
            atb(new PlacePlantAction(new Rose()));
        }
    }

    public void upp() {
        exhaust = false;
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}