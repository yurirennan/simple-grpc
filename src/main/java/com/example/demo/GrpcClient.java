package com.example.demo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.example.demo.HelloServiceGrpc.*;

public class GrpcClient {

    public static void main(String[] args) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        final HelloServiceBlockingStub stub = com.example.demo.HelloServiceGrpc.newBlockingStub(channel);

        final com.example.demo.HelloRequest request = com.example.demo.HelloRequest.newBuilder()
                .setFirstName("Blue")
                .setLastName("World").build();

        com.example.demo.HelloResponse response = stub.hello(request);

        System.out.println("Response received from server:\n" + response);

        channel.shutdown();
    }

}
