package com.edsolstice.educationportal.chat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class WebSocketChatServlet extends WebSocketServlet {
	public final Set users = new CopyOnWriteArraySet();

protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
}

@Override
public WebSocket doWebSocketConnect(HttpServletRequest arg0, String arg1) {
	return new ChatWebSocket(users);
}
}