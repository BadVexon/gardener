package theGardener.util;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import theGardener.cards.AbstractGardenCard;

public class SillyVariable extends DynamicVariable {

    @Override
    public String key() {
        return "gardensilly";
    } //TODO: Change this so your mod doesn't conflict!

    @Override
    public boolean isModified(AbstractCard card) {
        return ((AbstractGardenCard) card).isSillyModified;
    }

    @Override
    public int value(AbstractCard card) {
        return ((AbstractGardenCard) card).silly;
    }

    public void setIsModified(AbstractCard card, boolean v) {
        if (card instanceof AbstractGardenCard) {
            ((AbstractGardenCard) card).isSillyModified = v;
        }
    }

    @Override
    public int baseValue(AbstractCard card) {
        return ((AbstractGardenCard) card).baseSilly;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        return ((AbstractGardenCard) card).upgradedSilly;
    }
}