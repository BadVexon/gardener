package theGardener.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.PlacePlantAction;
import theGardener.actions.PlacePlantRandomSpotAction;
import theGardener.garden.structures.Bruteroot;

public class RootRout extends AbstractGardenCard {

    public final static String ID = makeID("RootRout");

    //stupid intellij stuff attack, enemy, common

    private static final int DAMAGE = 5;
    private static final int MAGIC = 1;

    public RootRout() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        if (!upgraded) {
            atb(new PlacePlantRandomSpotAction(new Bruteroot()));
        } else {
            atb(new PlacePlantAction(new Bruteroot()));
        }
    }

    public void upp() {
        upgradeDamage(2);
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}