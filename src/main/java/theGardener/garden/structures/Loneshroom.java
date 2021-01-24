package theGardener.garden.structures;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.util.TextureLoader;

public class Loneshroom extends AbstractPlant {
    public Loneshroom() {
        growMax = 3;
        tex = TextureLoader.getTexture(ezpath("Loneshroom"));
        isMushroom = true;
    }

    @Override
    public String getName() {
        return "Loneshroom";
    }

    @Override
    public String getDesc() {
        return "#yGrow: Deal #b1 damage to a random enemy, increased by #b2 for each adjacent empty Plot.";
    }

    @Override
    public void onHarvest() {
        int x = 1;
        AbstractPlot p1 = GardenPanel.map.get(myHome().boardx + 1).get(myHome().boardy);
        if (p1.myPlant instanceof NoPlant) x += 2;
        AbstractPlot p2 = GardenPanel.map.get(myHome().boardx - 1).get(myHome().boardy);
        if (p2.myPlant instanceof NoPlant) x += 2;
        AbstractPlot p3 = GardenPanel.map.get(myHome().boardx).get(myHome().boardy + 1);
        if (p3.myPlant instanceof NoPlant) x += 2;
        AbstractPlot p4 = GardenPanel.map.get(myHome().boardx).get(myHome().boardy - 1);
        if (p4.myPlant instanceof NoPlant) x += 2;
        atb(new DamageRandomEnemyAction(new DamageInfo(AbstractDungeon.player, x, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }
}
