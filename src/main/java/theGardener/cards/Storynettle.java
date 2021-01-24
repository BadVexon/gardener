package theGardener.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.PlacePlantAction;
import theGardener.actions.SetCardTargetCoordinatesAction;

public class Storynettle extends AbstractGardenCard {

    public final static String ID = makeID("Storynettle");

    //stupid intellij stuff SKILL, NONE, UNCOMMON

    public Storynettle() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        atb(new PlacePlantAction(new theGardener.garden.structures.Storynettle()));
    }

    public void upp() {
        upgradeBaseCost(0);
    }
}