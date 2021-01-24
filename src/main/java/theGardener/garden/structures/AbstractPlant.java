package theGardener.garden.structures;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.vfx.DamageCurvy;
import theGardener.vfx.DamageLine;

import java.util.ArrayList;

public abstract class AbstractPlant {
    public Texture tex;
    protected int maxLines = 36;
    protected int stride = 360 / maxLines;
    protected float offset = MathUtils.random(-180.0F, 180.0F);

    public int growAmt = 0;
    public int growMax;

    public boolean isMushroom = false;

    public void render(float x, float y, SpriteBatch sb) {
        sb.draw(tex, x, y, tex.getWidth() / 2F, tex.getHeight() / 2F, tex.getWidth(), tex.getHeight(), Settings.scale, Settings.scale, 0, 0, 0, tex.getWidth(), tex.getHeight(), false, false);
        Color c = Color.WHITE.cpy();
        if (isMature())
            c = Color.GREEN.cpy();
        renderNumbers(x, y, growAmt, sb, c);
    }

    private void renderNumbers(float x, float y, int number, SpriteBatch sb, Color color) {
        FontHelper.renderFontCentered(sb, FontHelper.energyNumFontRed, String.valueOf(number), x + 34.0F, y + 32.0F, color);
    }

    public static String ezpath(String s) {
        return "gardenmod/images/ui/" + s + ".png";
    }

    public AbstractPlot myHome() {
        for (ArrayList<AbstractPlot> a : GardenPanel.map) {
            for (AbstractPlot p : a) {
                if (p.myPlant == this) {
                    return p;
                }
            }
        }
        return null; // this should never happen (but it probably will)
    }

    public void splat() {
        AbstractPlot p = myHome();
        for (int i = 0; i < maxLines; i++) {
            AbstractDungeon.effectList.add(new DamageLine(p.hb.cX, p.hb.cY, new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 1), ((stride * i) + MathUtils.random(-stride, stride) + offset)));
            if (i % 2 == 0) {
                AbstractDungeon.effectList.add(new DamageCurvy(p.hb.cX, p.hb.cY, new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 1)));
            }
        }
    }

    public boolean isMature() {
        return growAmt == growMax;
    }

    public void grow() {
        if (!isMature()) {
            if (growAmt < growMax)
                growAmt++;
            onGrow();
            if (growAmt == growMax)
                mature();
        }
    }

    public void mature() {
        splat();
        onMature();
    }

    public void harvest() {
        onHarvest();
        myHome().onHarvestPlant();
        myHome().myPlant = new NoPlant();
    }

    public String makeDesc() {
        String s = growAmt + "/" + growMax;
        if (growAmt == growMax)
            s = "#yMature";
        return s + ". NL " + getDesc();
    }

    public abstract String getName();

    public abstract String getDesc();

    /*public AbstractPlant makeCopy() {
        try {
            return (AbstractPlant) this.getClass().newInstance();// 51
        } catch (IllegalAccessException | InstantiationException var2) {// 52
            throw new RuntimeException("I FAILED MASTER!!!");// 53
        }
    }
    */

    public void onPlant() {

    }

    public void onGrow() {

    }

    public void onMature() {

    }

    public void onHarvest() {

    }

    public void onTakeDamage() {

    }

    public static AbstractPlant returnRandomPlant() {
        int x = AbstractDungeon.cardRandomRng.random(0, 4);
        switch (x) {
            case 0:
                return new Bruteroot();
            case 1:
                return new Flameflower();
            case 2:
                return new Rose();
            case 3:
                return new Storynettle();
            case 4:
                return new Whackale();
            default:
                return new NoPlant();
        }
    }

    public static AbstractPlant returnRandomNonRosePlant() {
        int x = AbstractDungeon.cardRandomRng.random(0, 3);
        switch (x) {
            case 0:
                return new Bruteroot();
            case 1:
                return new Flameflower();
            case 2:
                return new Storynettle();
            case 3:
                return new Whackale();
            default:
                return new NoPlant();
        }
    }

    public static void atb(AbstractGameAction a) {
        AbstractDungeon.actionManager.addToBottom(a);
    }

    public static void applyToSelf(AbstractPower po) {
        atb(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, po, po.amount));
    }

    public void dmg(AbstractMonster m, int amount, AbstractGameAction.AttackEffect fx) {
        atb(new DamageAction(m, new DamageInfo(AbstractDungeon.player, amount, DamageInfo.DamageType.THORNS), fx));
    }
}
