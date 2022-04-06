package uz.maniac4j.mqttsimulator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.moquette.broker.Server;
import io.moquette.broker.config.IConfig;
import io.moquette.interception.BrokerInterceptor;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import netscape.javascript.JSObject;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.StandardIntegrationFlow;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import uz.maniac4j.modbus.client.ModbusClient;
import uz.maniac4j.modbus.exceptions.ModbusStormException;
import uz.maniac4j.mqttsimulator.config.InterceptHandlerImpl;
import uz.maniac4j.mqttsimulator.config.MqttConfig;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Test {


    public static void main(String[] args) throws IOException, MqttException, InterruptedException, ModbusStormException {

//        Server server=new Server();
//        File file = new File("D:\\Projects\\mqtt-simulator\\src\\main\\java\\uz\\maniac4j\\mqttsimulator\\mqtt.conf");
//
//        server.startServer(file);
//        System.out.println(server.getPort());
//        System.out.println(server.getSslPort());

        MqttClient client=new MqttClient("tcp://localhost:1884","test");
        MqttClient client2=new MqttClient("tcp://localhost:1884","test2");


        client.connect();
        client2.connect();
        System.out.println(client.isConnected());


//        client2.subscribe("t",((topic, message) -> {
////            System.out.println(topic);
////            System.out.println(message);
//        }));

        Map<String,Double> map=new HashMap<>();




        ModbusClient modbusClient=new ModbusClient();
        modbusClient.setIpAddress("10.10.24.50");
        modbusClient.setPort(502);
        modbusClient.Connect();



        while (true){
//            client.publish("t",new MqttMessage(String.valueOf(ModbusClient.ConvertRegistersToFloat(modbusClient.ReadInputRegisters(512, 2), ModbusClient.RegisterOrder.HighLow)).getBytes()));
            client.publish("t",new MqttMessage(String.valueOf(new Random().nextDouble()*100).getBytes()));
//            client.publish("t",new MqttMessage(new ObjectMapper().writeValueAsString(map).getBytes()));
//            client.publish("t",new MqttMessage(String.valueOf(new Random().nextDouble()*20).getBytes()));
//            client.publish("p",new MqttMessage(String.valueOf(new Random().nextDouble()*20).getBytes()));
//            map.put("TT",new Random().nextDouble()*100);
            map.put("PT", (double) ModbusClient.ConvertRegistersToFloat(modbusClient.ReadHoldingRegisters(520, 2), ModbusClient.RegisterOrder.HighLow));
//            map.put("TT", new Random().nextDouble()*100);
//            map.put("PT",new Random().nextDouble()*100);
//            map.put("PP",new Random().nextDouble()*100);
//            map.put("PG",new Random().nextDouble()*100);
//            map.put("PQ",new Random().nextDouble()*100);
            client2.publish("json",new MqttMessage(new ObjectMapper().writeValueAsBytes(map)));


//            new MqttClient("tcp://localhost:1884",String.valueOf(UUID.randomUUID())).connect();


//            System.out.println("Count = "+server.listConnectedClients().size());
//            Thread.sleep(100);
        }



    }
}
