package theGardener.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theGardener.TheGardener;
import theGardener.actions.GrowAllPlantsAction;

@SpirePatch(
        clz = GameActionManager.class,
        method = "callEndOfTurnActions"
)
public class EndOfTurnGrow {
    public static void Postfix(GameActionManager __instance) {
        if (AbstractDungeon.player instanceof TheGardener)
            AbstractDungeon.actionManager.addToBottom(new GrowAllPlantsAction());
    }
}