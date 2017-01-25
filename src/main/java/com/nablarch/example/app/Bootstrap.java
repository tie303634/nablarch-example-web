package com.nablarch.example.app;

import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;

public class Bootstrap {

    public static void main(String[] args) throws BootstrapException {
        PayaraMicro.getInstance()
                   .addDeployment("target/nablarch-example-web-5u8-dev.war")
                   .bootStrap();
    }
}
