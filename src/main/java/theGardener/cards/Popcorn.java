package theGardener.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.PlacePlantAction;
import theGardener.garden.structures.Corn;

public class Popcorn extends AbstractGardenCard {

    public final static String ID = makeID("Popcorn");

    //stupid intellij stuff attack, all_enemy, common

    private static final int DAMAGE = 2;
    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;

    public Popcorn() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        isMultiDamage = true;
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        allDmg(AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        for (int i = 0; i < magicNumber; i++)
            atb(new PlacePlantAction(new Corn()));
    }

    public void upp() {
        upgradeDamage(1);
        upgradeMagicNumber(UPG_MAGIC);
    }
}