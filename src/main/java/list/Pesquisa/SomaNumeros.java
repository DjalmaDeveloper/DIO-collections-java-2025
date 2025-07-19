package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros() {
        numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;
        if(!numeros.isEmpty()){
            for(int n : numeros){
                soma += n;
            }
        }
        return soma;
    }

    public int encontrarMaiorNumero(){
        int maior = 0;
        if(!numeros.isEmpty()){
            for(int n : numeros){
                if(n > maior){
                    maior = n;
                }
            }
        }
        return maior;
    }

    public int encontrarMenorNumero(){
        int menor = encontrarMaiorNumero();
        if(!numeros.isEmpty()){
            for(int n : numeros){
                if(n < menor){
                    menor = n;
                }
            }
        }
        return menor;
    }

    public List<Integer> exibirNumeros(){
        List<Integer> list = new ArrayList<>();
        if(!numeros.isEmpty()){
            for(int n : numeros){
                list.add(n);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        SomaNumeros soma = new SomaNumeros();
        soma.adicionarNumero(5);
        soma.adicionarNumero(9);
        soma.adicionarNumero(10);
        soma.adicionarNumero(17);
        soma.adicionarNumero(3);
        soma.adicionarNumero(12);
        soma.adicionarNumero(21);

        System.out.println("Soma: " + soma.calcularSoma());
        System.out.println("Maior: " + soma.encontrarMaiorNumero());
        System.out.println("Menor: " + soma.encontrarMenorNumero());
        System.out.println("Todos os números: " + soma.exibirNumeros());
    }
}
