package com.jahlapeno.rollplay.models;

import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class Character extends PanacheMongoEntity{
    @BsonId
    ObjectId acterId;

    String name;
    String optionalBio;
    String imageUrl;

    Integer level;
    Integer xp;

    Double health;
    Double maxHealth;

    Inventory inventory;
    List<Attribute> stats;
}
