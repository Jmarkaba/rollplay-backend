package com.jahlapeno.rollplay;

import org.bson.types.ObjectId;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jahlapeno.rollplay.events.CharacterUpdate;
import com.jahlapeno.rollplay.models.Character;

@RegisterRestClient
@Path("/api/v1/game/{gameId}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

    @Inject
    Event<CharacterUpdate> characterUpdateEvent;

    @POST
    @Path("/character")
    Character registerNewCharacter(@PathParam("gameId") ObjectId gameId, Character character) {
        character.persist();
        return character;
    }

    @PUT
    @Path("/character/{characterId}")
    Character updateCharacter(@PathParam("gameId") ObjectId gameId, 
                            @PathParam("characterId") ObjectId characterId,
                            Character character) {
        characterUpdateEvent.fireAsync(CharacterUpdate.builder()
            .character(character)
            .characterId(character.id)
            .gameId(gameId)
            .build());
        return null;
    }
}
