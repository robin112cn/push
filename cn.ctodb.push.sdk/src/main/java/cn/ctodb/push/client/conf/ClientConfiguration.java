package cn.ctodb.push.client.conf;

import cn.ctodb.push.client.ClientHandler;
import cn.ctodb.push.client.handler.HandshakeHandler;
import cn.ctodb.push.core.PacketReceiver;
import cn.ctodb.push.handler.ErrorHandler;

/**
 * Created by cc on 2017/8/21.
 */
public class ClientConfiguration {

    private static PacketReceiver packetReceiver;

    static {
        init();
    }

    public static void init() {
        packetReceiver = new PacketReceiver();
        packetReceiver.addHandler(new HandshakeHandler());
        packetReceiver.addHandler(new ErrorHandler());
    }

    public static PacketReceiver packetReceiver() {
        return packetReceiver;
    }

    public static ClientHandler clientHandler() {
        return new ClientHandler(packetReceiver());
    }

}
