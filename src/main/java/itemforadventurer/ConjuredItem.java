package itemforadventurer;

public class ConjuredItem extends ItemForAdventurer {

    public ConjuredItem(int sellIn, int quality) {
        super(sellIn,quality);
    }

    @Override
    public void updateQuality() {
        super.decreaseQuality();
        super.decreaseQuality();
        if (hasExpired()) {
            super.decreaseQuality();
            super.decreaseQuality();
        }
    }
}
