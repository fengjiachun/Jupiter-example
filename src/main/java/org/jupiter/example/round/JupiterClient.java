package org.jupiter.example.round;

import org.jupiter.example.provider.JupiterTestService;
import org.jupiter.rpc.DefaultClient;
import org.jupiter.rpc.JClient;
import org.jupiter.rpc.consumer.ProxyFactory;
import org.jupiter.serialization.SerializerType;
import org.jupiter.transport.JConnector;
import org.jupiter.transport.exception.ConnectFailedException;
import org.jupiter.transport.netty.JNettyTcpConnector;

/**
 * jupiter-example
 * org.jupiter.example.round
 *
 * @author jiachun.fjc
 */
public class JupiterClient {

    public static void main(String[] args) {
        JClient client = new DefaultClient().withConnector(new JNettyTcpConnector());

        // 连接RegistryServer
        client.connectToRegistryServer("127.0.0.1:20001");

        // 自动管理可用连接
        JConnector.ConnectionWatcher watcher = client.watchConnections(JupiterTestService.class, "1.0.0");
        // 等待连接可用
        if (!watcher.waitForAvailable(3000)) {
            throw new ConnectFailedException();
        }

        JupiterTestService service = ProxyFactory.factory(JupiterTestService.class)
                .version("1.0.0")
                .client(client)
                .serializerType(SerializerType.PROTO_STUFF)
                .newProxyInstance();

        String result = service.hello("jupiter");
        System.out.println(result);
    }
}
