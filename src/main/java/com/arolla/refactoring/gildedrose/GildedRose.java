package com.arolla.refactoring.gildedrose;

import java.util.Arrays;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    Arrays.stream(items).forEach(this::updateItem);
  }

  private void updateItem(Item item) {
    WarehouseItems.get(item).update();
  }
}
