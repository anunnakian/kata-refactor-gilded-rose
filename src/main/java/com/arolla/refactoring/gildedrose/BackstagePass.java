package com.arolla.refactoring.gildedrose;

class BackstagePass extends WarehouseItem {

  public BackstagePass(Item item) {
    super(item);
  }

  @Override
  public void update() {
    decreaseSellIn();

    increaseQuality();

    increaseOver(10);
    increaseOver(5);
    qualityToZero();
  }
}
