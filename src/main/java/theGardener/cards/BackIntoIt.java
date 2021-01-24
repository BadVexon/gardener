package theGardener.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theGardener.actions.GrowPlantAction;
import theGardener.garden.GardenPanel;

public class BackIntoIt extends AbstractGardenCard {

    public final static String ID = makeID("BackIntoIt");

    //stupid intellij stuff SKILL, NONE, BASIC

    public BackIntoIt() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 10;
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HEAVY);
        for (int i = 0; i < magicNumber; i++) {
            atb(new GrowPlantAction(GardenPanel.getRandomPlant()));
        }
        addToBot(new LoseHPAction(p, p, 5));
    }

    public void upp() {
        upgradeMagicNumber(1);
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}