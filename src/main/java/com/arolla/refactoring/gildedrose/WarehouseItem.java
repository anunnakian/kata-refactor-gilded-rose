package com.arolla.refactoring.gildedrose;

import java.util.Optional;

public abstract class WarehouseItem {

  private final Item item;

  public WarehouseItem(Item item) {
    this.item = item;
  }

  protected void increaseQuality() {
    item.quality = Math.min(item.quality + 1, 50);
  }

  protected int getSellIn() {
    return item.sellIn;
  }

  protected void qualityToZero() {
    Optional.of(getSellIn()).filter(sellIn -> sellIn < 0).ifPresent(value -> item.quality = 0);
  }

  protected void decreaseSellIn() {
    item.sellIn -= 1;
  }

  protected void decreaseQuality() {
    item.quality = Math.max(0, item.quality - 1);
  }

  protected void increaseOver(int sellIn) {
    Optional.of(getSellIn()).filter(value -> value < sellIn).ifPresent(value -> increaseQuality());
  }

  abstract void update();
}
