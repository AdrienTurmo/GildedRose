public class BackstagePasse extends ItemForAdventurer {

    public BackstagePasse(int sellIn, int quality) {
        super(sellIn,quality);
    }

    private void backstageTicketBehavior(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    @Override
    public void updateQuality() {
        if (this.getDaysLeftToSell() > 10) {
            super.increaseQuality();
        }
        if (this.getDaysLeftToSell() <= 10 && this.getDaysLeftToSell() > 5 ) {
            super.increaseQuality();
            super.increaseQuality();
        }
        if (this.getDaysLeftToSell() <= 5 && this.getDaysLeftToSell() >= 0) {
            super.increaseQuality();
            super.increaseQuality();
            super.increaseQuality();
        }
        if (hasExpired()) {
            setToMinimumQuality();
        }
    }

}
