package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void should_general_item_decrease_sellin_and_quality_by_1_after_1_day() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    public void should_general_item_decrease_quality_by_2_after_1_day_when_sellin_lower_than_0() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    public void should_general_item_quality_remain_0_when_quality_is_0_and_sellin_lower_than_0() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void should_aged_brie_decrease_sellin_by_1_and_increase_quality_by_1_after_1_day() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    public void should_aged_brie_decrease_sellin_by_1_and_keep_quality_50_if_quality_is_50() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void should_sulfuras_never_change_sellin_and_quality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(20, app.items[0].quality);
    }

    @Test
    public void should_Backstage_decrease_sellin_by_1_and_increase_quality_by_1_after_1_day_when_sellin_greater_than_10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    public void should_Backstage_decrease_sellin_by_1_and_increase_quality_by_2_after_1_day_when_sellin_between_10_and_6() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(8, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    public void should_Backstage_decrease_sellin_by_1_and_increase_quality_by_3_after_1_day_when_sellin_lower_than_6() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    public void should_Backstage_decrease_sellin_by_1_and_set_quality_to_0_when_sellin_lower_than_0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
