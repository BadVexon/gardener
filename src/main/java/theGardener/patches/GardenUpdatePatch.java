package theGardener.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theGardener.TheGardener;
import theGardener.garden.GardenPanel;

@SpirePatch(
        clz = AbstractPlayer.class,
        method = "combatUpdate"
)
public class GardenUpdatePatch {
    @SpirePostfixPatch
    public static void updateStuff(AbstractPlayer __instance) {
        if (AbstractDungeon.player instanceof TheGardener)
            GardenPanel.update();
    }
}