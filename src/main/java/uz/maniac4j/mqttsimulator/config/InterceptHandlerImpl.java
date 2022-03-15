package uz.maniac4j.mqttsimulator.config;

import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.*;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttQoS;

public class InterceptHandlerImpl extends InterceptPublishMessage {


    @Override
    public String getTopicName() {
        return super.getTopicName();
    }

    @Override
    public ByteBuf getPayload() {
        return super.getPayload();
    }

    @Override
    public String getClientID() {
        return super.getClientID();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isRetainFlag() {
        return super.isRetainFlag();
    }

    @Override
    public boolean isDupFlag() {
        return super.isDupFlag();
    }

    @Override
    public MqttQoS getQos() {
        return super.getQos();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public InterceptHandlerImpl(MqttPublishMessage msg, String clientID, String username) {
        super(msg, clientID, username);
    }
}
