package com.arolla.refactoring.gildedrose;

import java.util.Map;
import java.util.function.Function;

class WarehouseItems {

  private static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
  private static final String BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
  private static final String AGED_BRIE_NAME = "Aged Brie";

  private static final Map<String, Function<Item, WarehouseItem>> ITEMS_FACTORIES = buildFactories();

  public static WarehouseItem get(Item item) {
    return ITEMS_FACTORIES.getOrDefault(item.name, NormalItem::new).apply(item);
  }

  private static Map<String, Function<Item, WarehouseItem>> buildFactories() {
    return Map.of(SULFURAS_NAME, Sulfuras::new, AGED_BRIE_NAME, AgedBrie::new, BACKSTAGE_PASSES_NAME, BackstagePass::new);
  }
}
