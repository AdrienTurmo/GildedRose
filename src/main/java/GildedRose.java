import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    List<ItemForAdventurer> itemTosell;

    public GildedRose(Item[] items) {

        itemTosell = Arrays.stream(items)
                .map(ItemForAdventurer::new)
                .collect(Collectors.toList());

        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(AGED_BRIE)) {
                agedBrieBehavior(item);
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                backstageTicketBehavior(item);
            } else if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                item.quality = 80;
            } else {
                normalItemBehavior(item);
            }
        }
    }

    private void normalItemBehavior(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;


        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
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

    private void agedBrieBehavior(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}
