package com.hogar.hogarrpc.server;

import io.vertx.core.Vertx;

public class VertxHttpServer implements HttpServer{
    public void doStart(int port) {
        Vertx vertx = Vertx.vertx();

        io.vertx.core.http.HttpServer server = vertx.createHttpServer();

//        server.requestHandler(req -> {
//            System.out.println("Received request: " + req.method() + " " + req.uri());
//
//            req.response()
//                    .putHeader("content-type", "text/plain")
//                    .end("Hello from Vert.x HTTP Server");
//
//        });
        server.requestHandler(new HttpServerHandler());

        server.listen(port, result -> {
            if (result.succeeded()) {
                System.out.println("Server started on port " + port);
            } else {
                System.out.println("Failed to start server on port " + port + ": " + result.cause());
            }
        });
    }
}
