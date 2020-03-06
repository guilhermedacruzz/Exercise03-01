package com.company;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public String nome;
    public  int fichas;
    public int fichasGanhas;
    public int fichasPerdidas;
    public int rodadas;

    public Game(String nome, int fichas) {
        this.nome = nome;
        this.fichas = fichas;
    }

    public int fazerAposta(int aposta, int palpite) {
        int dado1 = new Random().nextInt(6) + 1;
        int dado2 = new Random().nextInt(6) + 1;

        if(palpite == dado1 + dado2){
            this.fichas += aposta * 2;
            this.fichasGanhas += 1;
            aposta *= 2;
        }
        else if(Math.abs(palpite - dado1 + dado2) == 1) {
            this.fichas += aposta / 2;
            this.fichasGanhas  += 1;
            aposta /= 2;
        }
        else{
            this.fichas -= aposta;
            this.fichasPerdidas += 1;
            aposta *= -1;
        }

        this.rodadas += 1;
        return aposta;
    }

    @Override
    public String toString() {
        return "Game{" +
                "nome='" + nome + '\'' +
                ", fichas=" + fichas +
                ", fichasGanhas=" + fichasGanhas +
                ", fichasPerdidas=" + fichasPerdidas +
                ", rodadas=" + rodadas +
                '}';
    }
}
