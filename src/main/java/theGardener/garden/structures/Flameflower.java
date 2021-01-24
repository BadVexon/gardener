package theGardener.garden.structures;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theGardener.util.TextureLoader;

public class Flameflower extends AbstractPlant {
    public Flameflower() {
        growMax = 3;
        tex = TextureLoader.getTexture(ezpath("Flameflower"));
    }

    @Override
    public String getName() {
        return "Flameflower";
    }

    @Override
    public String getDesc() {
        return "#yHarvest: Deal #b8 damage to ALL enemies.";
    }

    @Override
    public void onHarvest() {
        atb(new DamageAllEnemiesAction(AbstractDungeon.player, DamageInfo.createDamageMatrix(8, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
    }
}
