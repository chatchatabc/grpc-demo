package org.mvnsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * gRPC services server
 *
 * @author linux_china
 */
@SpringBootApplication
public class GrpcServicesServer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GrpcServicesServer.class, args);
    }
}
