package itemforadventurer;

public class BackstagePasse extends ItemForAdventurer {


    private static final int FIRST_TRESHOLD = 10;
    private static final int SECOND_TRESHOLD = 5;

    public BackstagePasse(int sellIn, int quality) {
        super(sellIn,quality);
    }

    @Override
    public void updateQuality() {
        if (this.getDaysLeftToSell() > FIRST_TRESHOLD) {
            super.increaseQuality();
        }
        if (this.getDaysLeftToSell() <= FIRST_TRESHOLD && this.getDaysLeftToSell() > SECOND_TRESHOLD) {
            super.increaseQuality();
            super.increaseQuality();
        }
        if (this.getDaysLeftToSell() <= SECOND_TRESHOLD && !hasExpired()) {
            super.increaseQuality();
            super.increaseQuality();
            super.increaseQuality();
        }
        if (hasExpired()) {
            setToMinimumQuality();
        }
    }

}
