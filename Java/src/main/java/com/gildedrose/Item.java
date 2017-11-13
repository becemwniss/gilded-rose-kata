package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    boolean hasNotMaxQuality() {
        return quality < 50;
    }

    public int increaseQuality() {
        return quality++;
    }

    boolean isExpired() {
        return sellIn < 0;
    }

    int descreaseSellIn() {
        return sellIn--;
    }

    int decreaseQuality() {
        return quality--;
    }

    void updateQualityForCommonItem() {
        if (quality > 0) {
            decreaseQuality();
            if (isExpired()) {
                decreaseQuality();
            }
        }

        descreaseSellIn();
    }

    void updateQualityForBackstagePasses() {
        if (hasNotMaxQuality()) {
            increaseQuality();

            if (sellIn < 11) {
                increaseQuality();
            }

            if (sellIn < 6) {
                increaseQuality();
            }
        }

        if (isExpired()) {
            quality = 0;
        }

        descreaseSellIn();
    }

    void updateQualityForAgedBrie() {
        if (hasNotMaxQuality()) {
            increaseQuality();
            if (isExpired()) {
                increaseQuality();
            }
        }

        descreaseSellIn();
    }

    void updateQuality() {
        if (name.equals(GildedRose.AGED_BRIE)) {
            updateQualityForAgedBrie();

        } else if (name.equals(GildedRose.BACKSTAGE_PASSES)) {
            updateQualityForBackstagePasses();


        } else if (!name.equals(GildedRose.SULFURAS)) {
            updateQualityForCommonItem();
        }
    }
}
