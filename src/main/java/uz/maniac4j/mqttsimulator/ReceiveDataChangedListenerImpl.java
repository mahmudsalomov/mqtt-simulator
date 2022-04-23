package uz.maniac4j.mqttsimulator;

import uz.maniac4j.modbus.client.ReceiveDataChangedListener;

public class ReceiveDataChangedListenerImpl implements ReceiveDataChangedListener {
    @Override
    public void ReceiveDataChanged() {
        System.out.println("Keldi");
    }
}
