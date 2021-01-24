package theGardener.powers;

import theGardener.garden.structures.AbstractPlant;

public interface OnHarvestSubscriber {
    void onHarvest(AbstractPlant p);
}
