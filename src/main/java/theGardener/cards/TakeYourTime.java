package theGardener.cards;

import com.megacrit.cardcrawl.actions.watcher.PressEndTurnButtonAction;
import com.megacrit.cardcrawl.actions.watcher.SkipEnemiesTurnAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class TakeYourTime extends AbstractGardenCard {

    public final static String ID = makeID("TakeYourTime");

    //stupid intellij stuff skill, self, uncommon

    public TakeYourTime() {
        super(ID, -1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        if (!AbstractDungeon.actionManager.cardsPlayedThisTurn.isEmpty()) {
            cantUseMessage = "I've already worked too hard to rest.";
            return false;
        }
        return super.canUse(p, m);
    }

    public void us(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new SkipEnemiesTurnAction());// 36
        this.addToBot(new PressEndTurnButtonAction());// 37
    }

    public void upp() {
        selfRetain = true;
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}