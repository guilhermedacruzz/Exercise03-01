package com.company;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private String nome;
    private int fichas;
    private int fichasGanhas;
    private int fichasPerdidas;
    private int rodadas;

    public Game(String nome, int fichas) {
        this.nome = nome;
        this.fichas = fichas;
    }

    public void fazerAposta() {
        int dado1 = new Random().nextInt(6) + 1;
        int dado2 = new Random().nextInt(6) + 1;
        int aposta, palpite;

        //System.out.println("Resultado da Soma dos Dados:    " + (dado1 + dado2));
        System.out.printf("\nDeseja apostar quantas fichas ?\t");
        do{
            aposta = new Scanner(System.in).nextInt();
        }while(aposta < 0 || aposta > this.fichas);

        System.out.printf("\nPalpite do resulatdo: \t");
        do{
            palpite = new Scanner(System.in).nextInt();
        }while(palpite < 1);


        if(palpite == dado1 + dado2){
            System.out.println("Você ganhou a rodada :( +" + (aposta * 2) + " fichas!");
            this.fichas += aposta * 2;
            this.fichasGanhas += 1;
        }
        else if(Math.abs(palpite - dado1 + dado2) == 1) {
            System.out.println("Você quase ganhou a rodada :( +" + (aposta / 2) + " fichas!");
            this.fichas += aposta / 2;
            this.fichasGanhas  += 1;
        }
        else{
            System.out.println("Você perdeu a rodada :( -" + aposta + " fichas!");
            this.fichas -= aposta;
            this.fichasPerdidas += 1;
        }

        this.rodadas += 1;
        System.out.println();
        System.out.println("Resultado da Rodada" + this.rodadas + " é " + dado1 + " " + dado2);
    }

    public void status()  {
        System.out.printf("\n\nRelatório\n\n");
        System.out.println("Nome: " + this.nome);
        System.out.println("Fichas restantes: " + this.fichas);
        System.out.println("Rodadas Jogadas: " + this.rodadas);
        System.out.println("Fichas Ganhas: " + this.fichasGanhas);
        System.out.println("Fichas Perdidas: " + this.fichasPerdidas);
    }

    public boolean verificarContinuidade() {
        if(fichas == 0)
            return false;

        System.out.println("Deseja continuar jogando? (S/N)");
        char escolha = new Scanner(System.in).next().charAt(0);

        if(Character.toLowerCase(escolha) == 'n')
            return false;

        return true;
    }

}
