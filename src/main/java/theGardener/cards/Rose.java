package theGardener.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.PlacePlantAction;
import theGardener.actions.SetCardTargetCoordinatesAction;

public class Rose extends AbstractGardenCard {

    public final static String ID = makeID("Rose");

    //stupid intellij stuff SKILL, NONE, COMMON

    public Rose() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE);
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        atb(new PlacePlantAction(new theGardener.garden.structures.Rose()));
    }

    public void upp() {
    }
}