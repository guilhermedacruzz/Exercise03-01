package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String nome;
        int fichas, aposta, palpite;
        boolean isRunning = true;
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
            System.out.printf("\nDeseja apostar quantas fichas ?\t");
            do{
                aposta = sc.nextInt();
            }while(aposta <= 0 || aposta > jogo.fichas);

            System.out.printf("\nPalpite do resulatado: \t");
            do{
                palpite = new Scanner(System.in).nextInt();
            }while(palpite < 1);

            System.out.printf("Resultado da rodada:\t%d fichas\n", jogo.fazerAposta(aposta, palpite));

            if(jogo.fichas == 0){
                break;
            }

            System.out.println("Deseja continuar jogando? (S/N)");
            char escolha = sc.next().charAt(0);

            if(Character.toLowerCase(escolha) == 'n')
                isRunning = false;
        }while(isRunning);

        System.out.println(jogo.toString());
    }
}
