import java.util.Objects;

public class Mapper {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final int SULFURAS_QUALITY = 80;


    public static ItemForAdventurer CreateItemAdventurerFrom(Item item) {
        if (Objects.equals(item.name, AGED_BRIE)) {
            return new AgedBrie(item.name,item.sellIn,item.quality);
        }
        if (Objects.equals(item.name, BACKSTAGE_PASSES)) {
            return new BackstagePasse(item.name,item.sellIn,item.quality);
        }
        if (Objects.equals(item.name, SULFURAS_HAND_OF_RAGNAROS)) {
            return new Sulfuras(item.name,item.sellIn,SULFURAS_QUALITY);
        }
        return new ItemForAdventurer(item.name,item.sellIn,item.quality);
    }

}
