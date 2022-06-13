package websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websockettest")
public class WebSocketEndpointTest {
    // 用來存放WebSocket已連接的Socket
    static CopyOnWriteArraySet<Session> sessions;
    @OnMessage
    public void onMessage(String message, Session session) throws IOException,
            InterruptedException, EncodeException {
    }
    @OnOpen
    public void onOpen(Session session) {
        //紀錄連接到sessions中
        if (sessions == null) {
            sessions = new CopyOnWriteArraySet<Session>();
        }
        sessions.add(session);
    }
    
    @OnClose
    public void onClose(Session session) {
        //將連接從sessions中移除
        if (sessions == null) {
            sessions = new CopyOnWriteArraySet<Session>();
        }
        sessions.remove(session); }
}
