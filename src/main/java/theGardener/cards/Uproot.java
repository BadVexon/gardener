package theGardener.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.HarvestEarlyAction;

public class Uproot extends AbstractGardenCard {

    public final static String ID = makeID("Uproot");

    //stupid intellij stuff ATTACK, ENEMY, COMMON

    private static final int DAMAGE = 14;
    private static final int UPG_DAMAGE = 4;

    public Uproot() {
        super(ID, 2, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        atb(new HarvestEarlyAction());
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}