package theGardener.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.PlacePlantAction;

public class Loneshroom extends AbstractGardenCard {

    public final static String ID = makeID("Loneshroom");

    //stupid intellij stuff SKILL, NONE, COMMON

    public Loneshroom() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.ENEMY);
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        atb(new PlacePlantAction(new theGardener.garden.structures.Loneshroom()));
    }

    public void upp() {
    }
}