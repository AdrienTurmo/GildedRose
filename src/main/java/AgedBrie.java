public class AgedBrie extends ItemForAdventurer {

    public AgedBrie(int sellIn, int quality) {
        super(sellIn, quality);
    }

    @Override
    public void updateQuality() {
        super.increaseQuality();
        if (hasExpired()) {
            super.increaseQuality();
        }
    }

    @Override
    public void updateDaysLeftToSell() {
        super.updateDaysLeftToSell();
    }

}
