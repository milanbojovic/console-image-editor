package com.onthemarket;

import com.onthemarket.editor.Simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Simulator sim = new Simulator();

        System.out.println("Welcome to interactive image editor\n");

        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println(sim.drawMenu());
                System.out.println("Enter command:");

                String line = br.readLine();
                sim.parseAndExecute(line);

                System.out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
