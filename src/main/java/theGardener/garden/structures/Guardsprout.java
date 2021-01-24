package theGardener.garden.structures;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theGardener.garden.structures.AbstractPlant;
import theGardener.util.TextureLoader;

public class Guardsprout extends AbstractPlant {
    public static String ID = "Guardsprout";

    public Guardsprout() {
        growMax = 3;
        tex = TextureLoader.getTexture(ezpath(ID));
    }

    @Override
    public String getName() {
        return ID;
    }

    @Override
    public String getDesc() {
        return "#yGrows whenever you receive unblocked attack damage. NL #yHarvest: Gain #b4 #yBlock.";
    }

    @Override
    public void onTakeDamage() {
        grow();
    }

    @Override
    public void onHarvest() {
        atb(new GainBlockAction(AbstractDungeon.player, 4));
    }
}
