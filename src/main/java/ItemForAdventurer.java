public class ItemForAdventurer {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;
    private int daysLeftToSell;
    private int quality;

    public ItemForAdventurer(int sellIn, int quality) {
        this.daysLeftToSell = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        decreaseQuality();
    }

    public void updateDaysLeftToSell() {
        daysLeftToSell--;
    }

    public boolean hasExpired() {
        return daysLeftToSell < 0;
    }

    public void increaseQuality(){
        if (quality < MAXIMUM_QUALITY) {
            quality++;
        }
    }
    public void decreaseQuality(){
        if (quality > MINIMUM_QUALITY) {
            quality--;
        }
    }

    public void setToMinimumQuality() {
        quality = MINIMUM_QUALITY;
    }

    public int getDaysLeftToSell() {
        return daysLeftToSell;
    }

    public int getQuality() {
        return quality;
    }
}
