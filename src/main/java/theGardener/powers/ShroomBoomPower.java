package theGardener.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theGardener.garden.structures.AbstractPlant;

import static theGardener.GardenMod.makeID;

public class ShroomBoomPower extends BasePower implements OnHarvestSubscriber {
    public static final String NAME = "ShroomBoom";
    public static final String POWER_ID = makeID(NAME);
    public static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    public static final boolean TURN_BASED = false;

    public ShroomBoomPower(int amount) {
        super(NAME, TYPE, TURN_BASED, AbstractDungeon.player, null, amount, false);
    }

    @Override
    public void onHarvest(AbstractPlant p) {
        if (p.isMushroom) {
            flash();
            addToBot(new DamageAllEnemiesAction(owner, DamageInfo.createDamageMatrix(amount), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
        }
    }

    public void updateDescription() {
        this.description = "Whenever you Harvest a Mushroom, deal #b" + amount + " damage to ALL enemies.";
    }
}