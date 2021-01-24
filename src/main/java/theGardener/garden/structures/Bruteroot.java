package theGardener.garden.structures;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.watcher.VigorPower;
import theGardener.util.TextureLoader;

public class Bruteroot extends AbstractPlant {
    public Bruteroot() {
        growMax = 3;
        tex = TextureLoader.getTexture(ezpath("Bruteroot"));
    }

    @Override
    public void onGrow() {
        applyToSelf(new VigorPower(AbstractDungeon.player, 2));
    }

    @Override
    public String getName() {
        return "Bruteroot";
    }

    @Override
    public String getDesc() {
        return "#yGrow: Gain #b2 #yVigor. NL #yHarvest: Gain #b3 temporary #yStrength.";
    }

    @Override
    public void onHarvest() {
        applyToSelf(new StrengthPower(AbstractDungeon.player, 3));
        applyToSelf(new LoseStrengthPower(AbstractDungeon.player, 3));
    }
}
