package org.jupiter.example.provider;

import org.jupiter.rpc.ServiceProviderImpl;

/**
 * jupiter-example
 * org.jupiter.example.provider
 *
 * @author jiachun.fjc
 */
@ServiceProviderImpl(version = "1.0.0")
public class JupiterTestServiceImpl implements JupiterTestService {

    public String hello(String word) {
        return "hello " + word;
    }
}
