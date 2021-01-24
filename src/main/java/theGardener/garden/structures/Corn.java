package theGardener.garden.structures;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.util.TextureLoader;

public class Corn extends AbstractPlant {
    public static String ID = "Corn";

    public Corn() {
        growMax = 3;
        tex = TextureLoader.getTexture(ezpath(ID));
    }

    @Override
    public String getName() {
        return ID;
    }

    @Override
    public String getDesc() {
        return "#yHarvest: Deal #b2 damage to a random enemy for each adjacent Corn.";
    }

    @Override
    public void onHarvest() {
        AbstractPlot p1 = GardenPanel.map.get(myHome().boardx + 1).get(myHome().boardy);
        if (p1.myPlant instanceof Corn)
            atb(new DamageRandomEnemyAction(new DamageInfo(AbstractDungeon.player, 2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        AbstractPlot p2 = GardenPanel.map.get(myHome().boardx - 1).get(myHome().boardy);
        if (p2.myPlant instanceof Corn)
            atb(new DamageRandomEnemyAction(new DamageInfo(AbstractDungeon.player, 2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        AbstractPlot p3 = GardenPanel.map.get(myHome().boardx).get(myHome().boardy + 1);
        if (p3.myPlant instanceof Corn)
            atb(new DamageRandomEnemyAction(new DamageInfo(AbstractDungeon.player, 2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        AbstractPlot p4 = GardenPanel.map.get(myHome().boardx).get(myHome().boardy - 1);
        if (p4.myPlant instanceof Corn)
            atb(new DamageRandomEnemyAction(new DamageInfo(AbstractDungeon.player, 2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }
}
