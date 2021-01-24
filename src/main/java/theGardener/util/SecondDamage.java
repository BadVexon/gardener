package theGardener.util;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import theGardener.cards.AbstractGardenCard;

public class SecondDamage extends DynamicVariable {

    @Override
    public String key() {
        return "gardensecond";
    } //TODO: change to something else!

    @Override
    public boolean isModified(AbstractCard card) {
        return ((AbstractGardenCard) card).isSecondDamageModified;
    }

    public void setIsModified(AbstractCard card, boolean v) {
        if (card instanceof AbstractGardenCard) {
            ((AbstractGardenCard) card).isSecondDamageModified = v;
        }
    }

    @Override
    public int value(AbstractCard card) {
        return ((AbstractGardenCard) card).secondDamage;
    }

    @Override
    public int baseValue(AbstractCard card) {
        return ((AbstractGardenCard) card).baseSecondDamage;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        return ((AbstractGardenCard) card).upgradedSecondDamage;
    }
}