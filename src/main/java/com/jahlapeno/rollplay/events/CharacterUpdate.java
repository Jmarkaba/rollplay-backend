package com.jahlapeno.rollplay.events;

import com.jahlapeno.rollplay.models.Character;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterUpdate {
    Long timestamp;
    ObjectId gameId;
    ObjectId characterId;
    Character character;
}