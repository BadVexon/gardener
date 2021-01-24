package theGardener.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.SetCardTargetCoordinatesAction;
import theGardener.actions.WaterPlusSpaceAction;

public class WateringCan extends AbstractGardenCard {

    public final static String ID = makeID("WateringCan");

    //stupid intellij stuff SKILL, NONE, BASIC

    public WateringCan() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.NONE);
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        addToBot(new WaterPlusSpaceAction());
    }

    public void upp() {
        upgradeBaseCost(0);
    }
}