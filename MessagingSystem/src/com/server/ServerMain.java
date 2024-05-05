package com.server;

public class ServerMain {
    public static void main(String[] args) {
        int port = 5511;
        Server server = new Server(port);
        server.start();
    }
}