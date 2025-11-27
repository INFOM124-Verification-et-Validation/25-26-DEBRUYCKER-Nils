package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                age(items[i]);
                items[i].sellIn = items[i].sellIn - 1;
                if (items[i].sellIn < 0) {
                    age_at_selling(items[i]);
                }
            }
        }
    }

    private void age(Item item) {
        if (!item.name.equals("Aged Brie")
            && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                    item.quality = item.quality - 1;
            }
        } else {
            age_special_aging_items(item);
        }
    }

    private void update_ticket(Item item) {
        if (item.sellIn < 11) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
                if (item.sellIn < 6) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }


    private void age_at_selling(Item item) {
        if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                        item.quality = item.quality - 1;
                }
            } else {
            age_special_item_at_sellin(item);
        }

    }

    private void age_special_aging_items(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                update_ticket(item);
            }
        }
    }

    private void age_special_item_at_sellin(Item item){
            if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            item.quality = 0;}
     else if (item.name.equals("Aged Brie")){
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}
