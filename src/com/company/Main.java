package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String nome;
        int fichas;
        Scanner sc = new Scanner(System.in);

        System.out.printf("\nCadastro\n\n");
        System.out.printf("Digite o seu nome:\t");
        nome =  sc.nextLine();

        do{
            System.out.printf("Digite o número de fichas:\t");
            fichas = sc.nextInt();
        }while(fichas <= 0);

        Game jogo = new Game(nome, fichas);

        do{

            jogo.fazerAposta();

        }while(jogo.verificarContinuidade());
        jogo.status();
    }
}
