package theGardener.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.PlacePlantAction;

public class Sprinklesprout extends AbstractGardenCard {

    public final static String ID = makeID("Sprinklesprout");

    //stupid intellij stuff skill, none, uncommon

    public Sprinklesprout() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        atb(new PlacePlantAction(new theGardener.garden.structures.Sprinklesprout()));
    }

    public void upp() {
    }
}