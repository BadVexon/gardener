package theGardener.garden.structures;

import com.megacrit.cardcrawl.actions.common.BetterDiscardPileToHandAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import theGardener.util.TextureLoader;

public class Storynettle extends AbstractPlant {
    public Storynettle() {
        growMax = 3;
        tex = TextureLoader.getTexture(ezpath("Storynettle"));
    }

    @Override
    public String getName() {
        return "Storynettle";
    }

    @Override
    public String getDesc() {
        return "#yGrow: Draw #b1 card. NL #yHarvest: Put a card from your discard pile into your hand.";
    }

    @Override
    public void onGrow() {
        atb(new DrawCardAction(1));
    }

    @Override
    public void onHarvest() {
        atb(new BetterDiscardPileToHandAction(1));
    }
}
