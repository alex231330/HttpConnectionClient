package com.company;

import com.sun.deploy.util.SessionState;

import java.io.*;
import java.net.Socket;

public class Main {

    static Socket s;

    public static void main(String[] args) throws Throwable {
        s = new Socket("localhost", 8080);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out.println("Test mes");
        StringBuilder sb = new StringBuilder(8096);
        while (true) {
            if (input.ready()) {
                int i = 0;
                while (i != -1) {
                    i = input.read();
                    sb.append((char) i);
                }
                break;
            }
        }
        System.out.println(sb.toString());
        s.close();
    }
}
