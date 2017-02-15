package org.jupiter.example.provider;

/**
 * jupiter-example
 * org.jupiter.example.provider
 *
 * @author jiachun.fjc
 */

import org.jupiter.rpc.ServiceProvider;

@ServiceProvider(group = "test", name = "jupiterTestService")
public interface JupiterTestService {

    String hello(String word);
}
