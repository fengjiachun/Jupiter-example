package org.jupiter.example.round;

import org.jupiter.example.provider.JupiterTestService;
import org.jupiter.example.provider.JupiterTestServiceImpl;
import org.jupiter.rpc.DefaultServer;
import org.jupiter.rpc.JServer;
import org.jupiter.rpc.model.metadata.ServiceWrapper;
import org.jupiter.transport.netty.JNettyTcpAcceptor;

/**
 * jupiter-example
 * org.jupiter.example.round
 *
 * @author jiachun.fjc
 */
public class JupiterServer {

    public static void main(String[] args) throws Exception {
        JServer server = new DefaultServer().withAcceptor(new JNettyTcpAcceptor(18090));

        JupiterTestService service = new JupiterTestServiceImpl();

        ServiceWrapper provider = server.serviceRegistry()
                .provider(service)
                .register();

        server.connectToRegistryServer("127.0.0.1:20001");

        server.publish(provider);

        server.start();
    }
}
