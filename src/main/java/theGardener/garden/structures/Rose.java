package theGardener.garden.structures;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.ThornsPower;
import theGardener.util.TextureLoader;

public class Rose extends AbstractPlant {
    public Rose() {
        growMax = 3;
        tex = TextureLoader.getTexture(ezpath("Rose"));
    }

    @Override
    public void onGrow() {
        applyToSelf(new ThornsPower(AbstractDungeon.player, 1));
    }

    @Override
    public String getName() {
        return "Rose";
    }

    @Override
    public String getDesc() {
        return "#yGrow: Gain #b1 #yThorns. NL #yHarvest: Lose all #yThorns.";
    }

    @Override
    public void onHarvest() {
        atb(new RemoveSpecificPowerAction(AbstractDungeon.player, AbstractDungeon.player, ThornsPower.POWER_ID));
    }
}
