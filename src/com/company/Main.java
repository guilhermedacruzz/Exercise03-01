package com.company;

public class Main {

    public static void metodo1(int x) {
        int y = 0;

        y = x + 1;

        System.out.println("Valor de y: " + y);
    }

    public static void main(String[] args) {
        System.out.println("Olá, Mundo!");

        metodo1(4);
    }
}
