package uz.maniac4j.mqttsimulator;

import io.moquette.broker.Server;
import io.moquette.broker.config.IConfig;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.StandardIntegrationFlow;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import uz.maniac4j.mqttsimulator.config.MqttConfig;

import java.io.File;
import java.io.IOException;

public class Test {


    public static void main(String[] args) throws IOException, MqttException {

        Server server=new Server();
        File file = new File("/home/kali/IdeaProjects/mqtt-simulator/src/main/java/uz/maniac4j/mqttsimulator/mqtt.conf");
        server.startServer(file);
        System.out.println(server.getPort());
        System.out.println(server.getSslPort());

        MqttClient client=new MqttClient("tcp://localhost:1883","test");

        client.connect();
        System.out.println(client.isConnected());

        System.out.println(server.listConnectedClients());

    }
}
