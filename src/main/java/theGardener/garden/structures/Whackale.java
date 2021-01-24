package theGardener.garden.structures;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theGardener.util.TextureLoader;

public class Whackale extends AbstractPlant {
    public Whackale() {
        growMax = 3;
        tex = TextureLoader.getTexture(ezpath("Whackale"));
    }

    @Override
    public void onGrow() {
        atb(new DamageAllEnemiesAction(AbstractDungeon.player, DamageInfo.createDamageMatrix(2, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }

    @Override
    public String getName() {
        return "Whackale";
    }

    @Override
    public String getDesc() {
        return "#yGrow: Deal #b2 damage to ALL enemies. NL #yHarvest: Deal #b4 damage to ALL enemies.";
    }

    @Override
    public void onHarvest() {
        atb(new DamageAllEnemiesAction(AbstractDungeon.player, DamageInfo.createDamageMatrix(4, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.BLUNT_LIGHT));

    }
}
