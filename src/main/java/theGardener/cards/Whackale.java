package theGardener.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.GrowPlantAction;
import theGardener.actions.PlacePlantAction;
import theGardener.actions.SetCardTargetCoordinatesAction;
import theGardener.garden.structures.AbstractPlant;

public class Whackale extends AbstractGardenCard {

    public final static String ID = makeID("Whackale");

    //stupid intellij stuff ATTACK, ENEMY, COMMON

    private static final int DAMAGE = 4;

    public Whackale() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        AbstractPlant q = new theGardener.garden.structures.Whackale();
        atb(new PlacePlantAction(q));
        if (upgraded) {
            atb(new GrowPlantAction(q));
        }
    }

    public void upp() {
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}