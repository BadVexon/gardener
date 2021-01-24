package theGardener.relics;

import theGardener.TheGardener;
import theGardener.actions.PlacePlantRandomSpotAction;
import theGardener.garden.structures.Bruteroot;

public class SimpleSeed extends AbstractGardenRelic {
    public static final String ID = makeID("SimpleSeed");

    public SimpleSeed() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, TheGardener.Enums.GARDENER_GREEN);
    }

    @Override
    public void atBattleStart() {
        flash();
        atb(new PlacePlantRandomSpotAction(new Bruteroot()));
    }
}
