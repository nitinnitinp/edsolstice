
package com.edsolstice.educationportal.websocket.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.edsolstice.educationportal.websocket.service.ChatConnections;


public class ChatWebSocketHandler extends TextWebSocketHandler {
  
  @Autowired
  private ChatConnections chatConnections;
  
  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    System.out.println("New connection");
    chatConnections.registerOpenConnection(session);
  }
  
  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      chatConnections.registerCloseConnection(session);
    
  }
  
  @Override
  public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
      chatConnections.registerCloseConnection(session);
    
  }
  
  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    System.out.println("New message: " + message.getPayload());
    chatConnections.processMessage(session, message.getPayload());
  }

}
