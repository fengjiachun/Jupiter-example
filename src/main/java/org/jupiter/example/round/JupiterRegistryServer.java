package org.jupiter.example.round;

import org.jupiter.registry.RegistryServer;

/**
 * jupiter-example
 * org.jupiter.example.round
 *
 * @author jiachun.fjc
 */
public class JupiterRegistryServer {

    public static void main(String[] args) {
        RegistryServer registryServer = RegistryServer.Default.createRegistryServer(20001, 1);      // ×¢²áÖÐÐÄ
        try {
            registryServer.startRegistryServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
