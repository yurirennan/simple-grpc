package com.example.demo.server;

import com.example.demo.HelloRequest;
import com.example.demo.HelloResponse;
import com.example.demo.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(final HelloRequest request, final StreamObserver<HelloResponse> responseObserver) {

        System.out.println("Request received!");

        final String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        final HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
