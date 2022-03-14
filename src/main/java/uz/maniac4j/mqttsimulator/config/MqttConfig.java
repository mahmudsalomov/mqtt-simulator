package uz.maniac4j.mqttsimulator.config;


import io.moquette.broker.config.IConfig;
import io.moquette.broker.config.IResourceLoader;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig extends IConfig {

    @Override
    public void setProperty(String s, String s1) {
    }

    @Override
    public String getProperty(String s) {
        return null;
    }

    @Override
    public String getProperty(String s, String s1) {
        return null;
    }

    @Override
    public IResourceLoader getResourceLoader() {
        return null;
    }
    void assignDefaults() {
        this.setProperty("port", Integer.toString(1883));
        this.setProperty("host", "0.0.0.0");
        this.setProperty("password_file", "");
        this.setProperty("allow_anonymous", Boolean.TRUE.toString());
        this.setProperty("authenticator_class", "");
        this.setProperty("authorizator_class", "");
        this.setProperty("netty.mqtt.message_size", String.valueOf(8092));
    }
}
