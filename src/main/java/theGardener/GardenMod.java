package theGardener;

import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.evacipated.cardcrawl.mod.stslib.Keyword;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import theGardener.cards.AbstractGardenCard;
import theGardener.garden.GardenPanel;
import theGardener.garden.plots.AbstractPlot;
import theGardener.relics.AbstractGardenRelic;
import theGardener.util.SecondDamage;
import theGardener.util.SillyVariable;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@SuppressWarnings({"unused", "WeakerAccess"})
@SpireInitializer
public class GardenMod implements
        EditCardsSubscriber,
        EditRelicsSubscriber,
        EditStringsSubscriber,
        EditKeywordsSubscriber,
        EditCharactersSubscriber,
        PreRoomRenderSubscriber,
        OnStartBattleSubscriber,
        PostBattleSubscriber,
        OnPlayerDamagedSubscriber {
    public static final String SHOULDER1 = "gardenmod/images/char/mainChar/shoulder.png";
    public static final String SHOULDER2 = "gardenmod/images/char/mainChar/shoulder2.png";
    public static final String CORPSE = "gardenmod/images/char/mainChar/corpse.png";
    private static final String ATTACK_S_ART = "gardenmod/images/512/attack.png";
    private static final String SKILL_S_ART = "gardenmod/images/512/skill.png";
    private static final String POWER_S_ART = "gardenmod/images/512/power.png";
    private static final String CARD_ENERGY_S = "gardenmod/images/512/energy.png";
    private static final String TEXT_ENERGY = "gardenmod/images/512/text_energy.png";
    private static final String ATTACK_L_ART = "gardenmod/images/1024/attack.png";
    private static final String SKILL_L_ART = "gardenmod/images/1024/skill.png";
    private static final String POWER_L_ART = "gardenmod/images/1024/power.png";
    private static final String CARD_ENERGY_L = "gardenmod/images/1024/energy.png";
    private static final String CHARSELECT_BUTTON = "gardenmod/images/charSelect/charButton.png";
    private static final String CHARSELECT_PORTRAIT = "gardenmod/images/charSelect/charBG.png";
    public static String modID;
    private static String artifactID;

    public static Color todoColor = new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 1); //TODO: Set this to your character's favorite color!

    public GardenMod() {

        BaseMod.subscribe(this);

        modID = "gardenmod"; //TODO: Change this!
        artifactID = "TheGardener"; //TODO: Change this, but make sure it matches the ArtifactID in your pom.

        BaseMod.addColor(TheGardener.Enums.GARDENER_GREEN, todoColor, todoColor, todoColor,
                todoColor, todoColor, todoColor, todoColor,
                ATTACK_S_ART, SKILL_S_ART, POWER_S_ART, CARD_ENERGY_S,
                ATTACK_L_ART, SKILL_L_ART, POWER_L_ART,
                CARD_ENERGY_L, TEXT_ENERGY);

    }

    public static String makePath(String resourcePath) {
        return modID + "/" + resourcePath;
    }
    public static String makeImagePath(String resourcePath) {
        return modID + "/images/" + resourcePath;
    }
    public static String makeLargePowerPath(String resourcePath) {
        return modID + "/images/powers/big/" + resourcePath;
    }
    public static String makeCharacterPath(String resourcePath) {
        return modID + "/images/character/" + resourcePath;
    }
    public static String makeDollPath(String resourcePath) {
        return modID + "/images/dolls/" + resourcePath;
    }
    public static String makeEffectPath(String resourcePath) {
        return modID + "/images/effects/" + resourcePath;
    }
    public static String makeOrbPath(String resourcePath) {
        return modID + "/images/orb/" + resourcePath;
    }
    public static String makeLocalizationPath(String resourcePath) {
        return modID + "/localization/" + resourcePath;
    }


    public static String makeCardPath(String resourcePath) {
        return modID + "/images/cards/" + resourcePath;
    }

    public static String makeRelicPath(String resourcePath) {
        return modID + "/images/relics/" + resourcePath;
    }

    public static String makeRelicOutlinePath(String resourcePath) {
        return modID + "/images/relics/outline/" + resourcePath;
    }

    public static String makePowerPath(String resourcePath) {
        return modID + "/images/powers/" + resourcePath;
    }

    public static void initialize() {
        GardenMod trainmod = new GardenMod();
    }

    public static String makeID(String idText) {
        return modID + ":" + idText;
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new TheGardener("the Conductor", TheGardener.Enums.THE_GARDENER),
                CHARSELECT_BUTTON, CHARSELECT_PORTRAIT, TheGardener.Enums.THE_GARDENER);
    }

    @Override
    public void receiveEditRelics() {
        new AutoAdd(artifactID)
                .packageFilter(AbstractGardenRelic.class)
                .any(AbstractGardenRelic.class, (info, relic) -> {
                    if (relic.color == null) {
                        BaseMod.addRelic(relic, RelicType.SHARED);
                    } else {
                        BaseMod.addRelicToCustomPool(relic, relic.color);
                    }
                    if (!info.seen) {
                        UnlockTracker.markRelicAsSeen(relic.relicId);
                    }
                });
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addDynamicVariable(new SillyVariable());
        BaseMod.addDynamicVariable(new SecondDamage());
        new AutoAdd(artifactID)
                .packageFilter(AbstractGardenCard.class)
                .setDefaultSeen(true)
                .cards();
    }


    @Override
    public void receiveEditStrings() {
        BaseMod.loadCustomStringsFile(CardStrings.class, modID + "/localization/eng/Cardstrings.json");

        BaseMod.loadCustomStringsFile(RelicStrings.class, modID + "/localization/eng/Relicstrings.json");

        BaseMod.loadCustomStringsFile(CharacterStrings.class, modID + "/localization/eng/Charstrings.json");
    }

    @Override
    public void receiveEditKeywords() {
        Gson gson = new Gson();
        String json = Gdx.files.internal(modID + "/localization/eng/Keywordstrings.json").readString(String.valueOf(StandardCharsets.UTF_8));
        com.evacipated.cardcrawl.mod.stslib.Keyword[] keywords = gson.fromJson(json, com.evacipated.cardcrawl.mod.stslib.Keyword[].class);

        if (keywords != null) {
            for (Keyword keyword : keywords) {
                BaseMod.addKeyword(modID, keyword.PROPER_NAME, keyword.NAMES, keyword.DESCRIPTION);
            }
        }
    }

    @Override
    public void receiveOnBattleStart(AbstractRoom abstractRoom) {
        if (AbstractDungeon.player instanceof TheGardener)
            GardenPanel.init();
    }

    @Override
    public void receivePreRoomRender(SpriteBatch spriteBatch) {
        if (AbstractDungeon.player instanceof TheGardener && !AbstractDungeon.isScreenUp && GardenPanel.shouldRender) {
            spriteBatch.setColor(Color.WHITE.cpy());
            GardenPanel.render(spriteBatch);
        }
    }

    @Override
    public void receivePostBattle(AbstractRoom abstractRoom) {
        GardenPanel.shouldRender = false;
    }

    @Override
    public int receiveOnPlayerDamaged(int i, DamageInfo damageInfo) {
        if (GardenPanel.shouldRender)
            for (ArrayList<AbstractPlot> p : GardenPanel.map) {
                for (AbstractPlot a : p) {
                    a.myPlant.onTakeDamage();
                }
            }
        return i;
    }
}
