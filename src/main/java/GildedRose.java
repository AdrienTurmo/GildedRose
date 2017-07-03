import itemforadventurer.ItemForAdventurer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {

    private Item[] items;
    private List<ItemForAdventurer> itemTosell;

    GildedRose(Item[] items) {
        itemTosell = Arrays.stream(items)
                .map(Mapper::CreateItemAdventurerFrom)
                .collect(Collectors.toList());

        this.items = items;
    }

    void updateQuality() {
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            ItemForAdventurer itemForAdventurer = itemTosell.get(index);

            itemForAdventurer.aDayHasPassed();
            itemForAdventurer.updateQuality();
            Mapper.updateItemFromItemForAdventurer(item, itemForAdventurer);

        }
    }

}
