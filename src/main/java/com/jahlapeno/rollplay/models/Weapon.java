package com.jahlapeno.rollplay.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Weapon extends Item {
    ItemType itemType = ItemType.WEAPON;

    Double baseDamage;
    Integer diceCount;
    Integer diceRoll;
    Integer penetration;
    Integer range;
}