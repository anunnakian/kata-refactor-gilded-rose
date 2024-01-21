package com.arolla.refactoring.gildedrose;

import java.util.Optional;

public class NormalItem extends WarehouseItem {

  public NormalItem(Item item) {
    super(item);
  }

  @Override
  void update() {
    decreaseSellIn();
    decreaseQuality();

    Optional.of(getSellIn()).filter(sellIn -> sellIn < 0).ifPresent(sellIn -> decreaseQuality());
  }
}
