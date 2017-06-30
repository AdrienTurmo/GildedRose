import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void normal_item_should_decrease_in_quality() {
        Item vest = new Item("Vest", 10, 10);
        Item[] items = new Item[] {vest};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(vest.toString()).isEqualTo("Vest, 9, 9");
    }

    @Test
    public void normal_item_should_decrease_in_quality_twice_as_fast_if_sell_date_passed() {
        Item vest = new Item("Vest", 0, 10);
        Item[] items = new Item[] {vest};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(vest.toString()).isEqualTo("Vest, -1, 8");
    }

    @Test
    public void item_quality_should_not_be_negative() throws Exception {
        Item vest = new Item("Vest", 2, 0);
        Item[] items = new Item[] {vest};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(vest.toString()).isEqualTo("Vest, 1, 0");
    }

    @Test
    public void aged_brie_should_increase_in_quality_even_when_expired() throws Exception {
        Item agedBrie = new Item("Aged Brie", 5, 5);
        Item[] items = new Item[] {agedBrie};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(agedBrie.toString()).isEqualTo("Aged Brie, 4, 6");
    }

    @Test
    public void aged_brie_quality_increase_twice_as_fast_when_expired() throws Exception {
        Item agedBrie = new Item("Aged Brie", -1, 7);
        Item[] items = new Item[] {agedBrie};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(agedBrie.toString()).isEqualTo("Aged Brie, -2, 9");
    }

    @Test
    public void aged_brie_should_not_have_more_that_50_in_quality() throws Exception {
        Item agedBrie = new Item("Aged Brie", 5, 50);
        Item[] items = new Item[] {agedBrie};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(agedBrie.toString()).isEqualTo("Aged Brie, 4, 50");
    }

    @Test
    public void sulfura_should_never_change_in_sell_and_its_quality_is_always_80() throws Exception {
        Item sulfura = new Item("Sulfuras, Hand of Ragnaros", 5, 80);
        Item[] items = new Item[] {sulfura};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(sulfura.toString()).isEqualTo("Sulfuras, Hand of Ragnaros, 5, 80");
    }

    @Test
    public void backstage_ticket_should_increase_in_quality_by_one_if_more_than_ten_days_is_left() throws Exception {
        Item backstageTicket = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10);
        Item[] items = new Item[] {backstageTicket};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(backstageTicket.toString()).isEqualTo("Backstage passes to a TAFKAL80ETC concert, 19, 11");
    }

    @Test
    public void backstage_ticket_should_increase_in_quality_by_two_if_less_than_ten_days_and_more_than_three_days_are_left() throws Exception {
        Item backstageTicket = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 10);
        Item[] items = new Item[] {backstageTicket};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(backstageTicket.toString()).isEqualTo("Backstage passes to a TAFKAL80ETC concert, 7, 12");
    }

    @Test
    public void backstage_ticket_should_increase_in_quality_by_three_if_less_than_three_days_is_left() throws Exception {
        Item backstageTicket = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 10);
        Item[] items = new Item[] {backstageTicket};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(backstageTicket.toString()).isEqualTo("Backstage passes to a TAFKAL80ETC concert, 1, 13");
    }

    @Test
    public void backstage_ticket_quality_should_drop_to_zero_if_no_sell_day_left() throws Exception {
        Item backstageTicket = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 45);
        Item[] items = new Item[] {backstageTicket};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(backstageTicket.toString()).isEqualTo("Backstage passes to a TAFKAL80ETC concert, -1, 0");
    }

    @Test
    public void backstage_ticket_quality_should_not_be_more_than_50() throws Exception {
        Item backstageTicket = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50);
        Item[] items = new Item[] {backstageTicket};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(backstageTicket.toString()).isEqualTo("Backstage passes to a TAFKAL80ETC concert, 3, 50");
    }
}