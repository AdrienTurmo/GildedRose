import itemforadventurer.*;

class Mapper {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_ITEM = "Conjured";

    static ItemForAdventurer CreateItemAdventurerFrom(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            return new AgedBrie(item.sellIn,item.quality);
        }
        if (item.name.equals(BACKSTAGE_PASSES)) {
            return new BackstagePasse(item.sellIn,item.quality);
        }
        if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            return new Sulfuras(item.sellIn);
        }
        if (item.name.contains(CONJURED_ITEM)) {
            return new ConjuredItem(item.sellIn,item.quality);
        }
        return new ItemForAdventurer(item.sellIn,item.quality);
    }

    static void updateItemFromItemForAdventurer(Item item, ItemForAdventurer itemForAdventurer) {
        item.sellIn = itemForAdventurer.getDaysLeftToSell();
        item.quality = itemForAdventurer.getQuality();
    }

}
