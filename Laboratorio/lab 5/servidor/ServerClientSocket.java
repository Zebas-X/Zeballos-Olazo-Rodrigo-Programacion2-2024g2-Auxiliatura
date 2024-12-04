package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerClientSocket extends Thread {
    private Socket clientSocket;
    private ObjectInputStream inDataServer;
    private ObjectOutputStream outDataServer;
    private Boolean isConnected;
    private SocketTcp server;
    private onEventLister listener;
    private String room = "";

    public ServerClientSocket(Socket clientSocket, SocketTcp server) {
        this.clientSocket = clientSocket;
        this.server = server;
        try {
            outDataServer