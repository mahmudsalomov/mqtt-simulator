package uz.maniac4j.mqttsimulator;

import io.moquette.broker.Server;

import java.io.File;
import java.io.IOException;

public class ServerTest {
    public static void main(String[] args) throws IOException {
        Server server=new Server();
        File file = new File("/home/kali/IdeaProjects/mqtt-simulator/src/main/java/uz/maniac4j/mqttsimulator/mqtt.conf");

        server.startServer(file);
        System.out.println(server.getPort());
        System.out.println(server.getSslPort());
    }
}
