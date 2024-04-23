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
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        final String multicastGroup = "230.0.0.1";
        final int port = 12345;

        try {
            InetAddress group = InetAddress.getByName(multicastGroup);
            DatagramSocket socket = new DatagramSocket();

            // Invia un messaggio di testo al gruppo multicast
            String message = "Messaggio di prova";
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), group, port);
            socket.send(packet);

            System.out.println("Messaggio inviato: " + message);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

