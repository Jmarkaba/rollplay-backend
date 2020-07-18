package com.jahlapeno.rollplay.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

enum ItemType {WEAPON, ARMOR, OTHER};

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    ItemType itemType = ItemType.OTHER;

    String name;
    String description;
    Integer sellValue;
}