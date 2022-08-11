package io.lihongbin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

@Slf4j
@SpringBootApplication
public class LiveApplication {

    public static void main(String[] args) throws IOException {
//        SpringApplication.run(LiveApplication.class, args);
        DatagramSocket datagramSocket = new DatagramSocket(9);
        while (true) {
            byte[] bytes = new byte[60 * 1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
            datagramSocket.receive(datagramPacket);
            for (int i = 0; i < bytes.length; i++) {
                System.out.print(bytes[i]);
//                System.out.print(Integer.toString(bytes[i], 16));
            }
            System.out.println();
        }
    }

}
