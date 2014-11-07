package com.edsolstice.educationportal.chat;

import java.util.Set;

import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

public class ChatWebSocket implements OnTextMessage {
private Connection connection;
private Set<ChatWebSocket> users;

public ChatWebSocket(Set users ) {
	this.users = users;
}
public void onMessage(String data) {
    System.out.println(data);
	for (ChatWebSocket user : users) {
		try {
			user.connection.sendMessage(data);
		} catch (Exception e) {
		}
	}

}
@Override
public void onOpen(Connection connection) {
    System.out.println("open");
	this.connection = connection;
	users.add(this);
}
@Override
public void onClose(int closeCode, String message) {
	users.remove(this);
      }
}	
		