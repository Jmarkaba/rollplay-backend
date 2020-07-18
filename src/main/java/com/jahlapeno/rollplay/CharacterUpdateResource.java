package com.jahlapeno.rollplay;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
@ServerEndpoint("/api/v1/{gameId}/character/{characterId}")
public class CharacterUpdateResource {

    Map<String, Session> sessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session,
                       @PathParam("gameId") String gameId,
                       @PathParam("characterId") String characterId) {
        sessions.put(String.format("%s:%s", gameId, characterId), session);
        broadcast(String.format("User %s:%s joined", gameId, characterId));
    }

    @OnClose
    public void onClose(Session session,
                        @PathParam("gameId") String gameId,
                        @PathParam("characterId") String characterId) {
        sessions.remove(String.format("%s:%s", gameId, characterId));
        broadcast(String.format("User %s:%s joined", gameId, characterId));
    }

    @OnError
    public void onOpen(Session session,
                       @PathParam("gameId") String gameId,
                       @PathParam("characterId") String characterId,
                       Throwable throwable) {
        sessions.remove(String.format("%s:%s", gameId, characterId));
        broadcast(String.format("User %s:%s joined", gameId, characterId));
    }

    @OnMessage
    public void onMessage(String message, @PathParam("username") String username) {
        broadcast(">> " + username + ": " + message);
    }

    private void broadcast(String message) {
        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(message, result ->  {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                }
            });
        });
    }

}
