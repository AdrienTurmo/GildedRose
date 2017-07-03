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

            itemForAdventurer.updateDaysLeftToSell();
            itemForAdventurer.updateQuality();
            Mapper.updateItemFromItemForAdventurer(item, itemForAdventurer);

        }
    }

}
