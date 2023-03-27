package com.rj.bd;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.resource.PathResourceManager;

import java.io.File;

public class App {
    public static void main(String[] args) {
        File file = new File("D:\\Tool");

        Undertow.Builder builder = Undertow.builder();
        builder.addHttpListener(8083, "localhost");
        builder.setHandler(Handlers.resource(new PathResourceManager(file.toPath(), 100)).setDirectoryListingEnabled(true));
        Undertow undertow = builder.build();

        undertow.start();
    }
}
