import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private Item[] items;

    private List<ItemForAdventurer> itemTosell;

    public GildedRose(Item[] items) {
        itemTosell = Arrays.stream(items)
                .map(Mapper::CreateItemAdventurerFrom)
                .collect(Collectors.toList());

        this.items = items;
    }

    public void updateQuality() {
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            ItemForAdventurer itemForAdventurer = itemTosell.get(index);

            switch (item.name) {
                case AGED_BRIE:
                    itemForAdventurer.updateDaysLeftToSell();
                    itemForAdventurer.updateQuality();
                    Mapper.updateItemFromItemForAdventurer(item, itemForAdventurer);

                    break;
                case BACKSTAGE_PASSES:
                    itemForAdventurer.updateDaysLeftToSell();
                    itemForAdventurer.updateQuality();
                    Mapper.updateItemFromItemForAdventurer(item, itemForAdventurer);

                    break;
                case SULFURAS_HAND_OF_RAGNAROS:
                    itemForAdventurer.updateDaysLeftToSell();
                    itemForAdventurer.updateQuality();
                    Mapper.updateItemFromItemForAdventurer(item, itemForAdventurer);

                    break;
                default:
                    normalItemBehavior(item);

                    break;
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

}
