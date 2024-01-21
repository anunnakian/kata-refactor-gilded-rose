package com.arolla.refactoring.gildedrose;

class GildedRose {

  private static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
  private static final String BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
  private static final String AGED_BRIE_NAME = "Aged Brie";
  private Item[] items;

  public GildedRose(Item[] items) {
    this.setItems(items);
  }

  public void updateQuality() {
    for (Item item : getItems()) {
      if (SULFURAS_NAME.equals(item.name)) {
        continue;
      }

      item.sellIn = item.sellIn - 1;

      if (AGED_BRIE_NAME.equals(item.name)) {
        updateAgedBrie(item);
      } else if (BACKSTAGE_PASSES_NAME.equals(item.name)) {
        updateBackstagePass(item);
      } else {
        updateNormalItem(item);
      }
    }
  }

  private void updateAgedBrie(Item item) {
    increaseQuality(item);

    if (item.sellIn < 0) {
      increaseQuality(item);
    }
  }

  private void updateBackstagePass(Item item) {
    increaseQuality(item);

    if (item.sellIn < 10) {
      increaseQuality(item);
    }

    if (item.sellIn < 5) {
      increaseQuality(item);
    }

    if (item.sellIn < 0) {
      item.quality = 0;
    }
  }

  private void updateNormalItem(Item item) {
    decreaseQuality(item);

    if (item.sellIn < 0) {
      decreaseQuality(item);
    }
  }

  private void increaseQuality(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }
  }

  private void decreaseQuality(Item item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1;
    }
  }

  public Item[] getItems() {
    return items;
  }

  public void setItems(Item[] items) {
    this.items = items;
  }
}
