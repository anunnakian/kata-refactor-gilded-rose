package com.arolla.refactoring.gildedrose;

class AgedBrie extends WarehouseItem {

  public AgedBrie(Item item) {
    super(item);
  }

  @Override
  public void update() {
    decreaseSellIn();

    increaseQuality();

    increaseOver(0);
  }
}
