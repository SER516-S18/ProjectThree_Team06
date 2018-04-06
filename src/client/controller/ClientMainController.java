package client.controller;

import javax.websocket.Session;

import client.helper.ClientDataSingleton;
import client.listener.ConnectionListener;
import client.view.ClientFrame;
import server.controller.ServerApplicationController;
import server.controller.ServerMainController;

/**
 * Controller class to handle web socket connection between the client and the server
 **/
public class ClientMainController {

    public static void main(String args[]) {
        ClientDataSingleton.getInstance();
        ClientFrame clientFrame = new ClientFrame();
        setClientServerConnection(clientFrame);
    }

    private static void setClientServerConnection(ClientFrame clientFrame) {
        clientFrame.setConnectionListener(new ConnectionListener() {
            @Override
            public void startServer() {
                WebSocketClientMain webSocketClientMain = new WebSocketClientMain();
                if (!ClientDataSingleton.getInstance().isSessionMaintained()) {
                    webSocketClientMain.connectToServer();
                }
            }

            @Override
            public void reconnectServer(String url) {
                // TODO Auto-generated method stub

            }

            @Override
            public void initializeServer() {
                new ServerApplicationController();
            }
        });
    }
}
