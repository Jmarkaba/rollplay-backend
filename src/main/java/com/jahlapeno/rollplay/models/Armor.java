package com.jahlapeno.rollplay.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Armor extends Item {
    ItemType itemType = ItemType.ARMOR;
    
    Integer armorClass;
    Integer magicArmor;
    Integer defense; // or dodge
    Integer move;
}