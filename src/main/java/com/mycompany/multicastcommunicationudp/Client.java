/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.multicastcommunicationudp;

/**
 *
 * @author Studenti
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client {
    public static void main(String[] args) {
        final String multicastGroup = "230.0.0.1";
        final int port = 12345;

        try {
            InetAddress group = InetAddress.getByName(multicastGroup);
            MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(group);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Ricevi il pacchetto dal gruppo multicast
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());

            System.out.println("Messaggio ricevuto: " + message);

            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
