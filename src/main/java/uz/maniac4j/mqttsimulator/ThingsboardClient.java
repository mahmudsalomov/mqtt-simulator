package uz.maniac4j.mqttsimulator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThingsboardClient {
    public static void main(String[] args) throws MqttException, JsonProcessingException, InterruptedException {
        MqttConnectOptions options = new MqttConnectOptions();

        char[] chars={'a'};
        options.setUserName("a");
        options.setPassword(chars);

        MqttClient client=new MqttClient("tcp://localhost:1883","a");

        client.connect(options);
        System.out.println(client.isConnected());
        Map<String,Double> map=new HashMap<>();

        while (true){
//            client.publish("t",new MqttMessage(new ObjectMapper().writeValueAsString(map).getBytes()));
//            client.publish("t",new MqttMessage(String.valueOf(new Random().nextDouble()*20).getBytes()));
//            client.publish("p",new MqttMessage(String.valueOf(new Random().nextDouble()*20).getBytes()));
            map.put("TT",new Random().nextDouble()*100);
            map.put("PT",new Random().nextDouble()*100);
            map.put("PP",new Random().nextDouble()*100);
            map.put("PG",new Random().nextDouble()*100);
            map.put("PQ",new Random().nextDouble()*100);
            client.publish("v1/devices/me/attributes",new MqttMessage(new ObjectMapper().writeValueAsBytes(map)));

            Thread.sleep(200);

//            new MqttClient("tcp://localhost:1884",String.valueOf(UUID.randomUUID())).connect();


//            System.out.println("Count = "+server.listConnectedClients().size());
//            Thread.sleep(100);
        }

    }
}
