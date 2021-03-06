package itemforadventurer;

public class ItemForAdventurer {

    private static final int MAXIMUM_QUALITY = 50;
    public static final int SELLING_LIMIT = 0;
    private static final int MINIMUM_QUALITY = 0;

    private int daysLeftToSell;
    private int quality;

    public ItemForAdventurer(int sellIn, int quality) {
        this.daysLeftToSell = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        decreaseQuality();
        if (hasExpired()) {
            decreaseQuality();
        }
    }

    public void aDayHasPassed() {
        daysLeftToSell--;
    }

    public int getDaysLeftToSell() {
        return daysLeftToSell;
    }

    public int getQuality() {
        return quality;
    }

    boolean hasExpired() {
        return daysLeftToSell < SELLING_LIMIT;
    }

    void increaseQuality(){
        if (quality < MAXIMUM_QUALITY) {
            quality++;
        }
    }

    void decreaseQuality(){
        if (quality > MINIMUM_QUALITY) {
            quality--;
        }
    }

    void setToMinimumQuality() {
        quality = MINIMUM_QUALITY;
    }
}
