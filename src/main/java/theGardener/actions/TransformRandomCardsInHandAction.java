package theGardener.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import org.apache.commons.lang3.math.NumberUtils;

public class TransformRandomCardsInHandAction extends AbstractGameAction {
    private AbstractCard bomber;

    public TransformRandomCardsInHandAction(AbstractCard q, int amount) {
        target = AbstractDungeon.player;
        this.amount = amount;
        bomber = q;
        duration = startDuration = Settings.ACTION_DUR_FAST;
    }

    public TransformRandomCardsInHandAction(AbstractCard q) {
        this(q, 1);
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            if (AbstractDungeon.player.hand.isEmpty()) {
                this.isDone = true;
                return;
            }
            CardGroup tmp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
            AbstractCard c;
            amount = NumberUtils.min(amount, AbstractDungeon.player.hand.size());
            for (int i = 0; i < amount; i++) {
                c = AbstractDungeon.player.hand.getRandomCard(true);
                if (tmp.contains(c)) {
                    i--;
                    continue;
                }
                tmp.group.add(c);
                //AbstractDungeon.player.hand.removeCard(c);
            }

            for (AbstractCard card : tmp.group) {
                AbstractCard transformedCard = bomber.makeStatEquivalentCopy();
                transformedCard.current_x = card.current_x;
                transformedCard.current_y = card.current_y;
                transformedCard.target_x = card.target_x;
                transformedCard.target_y = card.target_y;
                int index = AbstractDungeon.player.hand.group.indexOf(card);
                AbstractDungeon.player.hand.group.remove(index);
                AbstractDungeon.player.hand.group.add(index, transformedCard);
                AbstractDungeon.player.hand.refreshHandLayout();
                transformedCard.superFlash();
            }
            AbstractDungeon.player.hand.refreshHandLayout();
            AbstractDungeon.player.hand.glowCheck();
        }
        tickDuration();
    }
}