package main.java.map.Pesquisa;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> palavras;

    public ContagemPalavras() {
        this.palavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        palavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if(!palavras.isEmpty()){
            if(palavras.containsKey(palavra)){
                palavras.remove(palavra);
                System.out.println("Palavra removida");
            }
            else{
                System.out.println("Palavra não existe no conjunto");
            }
        }
        else{
            System.out.println("Conjunto vazio");
        }
    }

    public void exibirContagemPalavras(){
        Integer total = 0;
        if(!palavras.isEmpty()) {
            for(int c : palavras.values()) {
                total += c;
            }
            System.out.println(palavras);
            System.out.println("Total: " + total);
        }
        else{
            System.out.println("Conjunto vazio");
        }
    }

    public String encontrarPalavraMaisFrequente(){
        int maisFrequente = Integer.MIN_VALUE;
        String palavra = null;
        if(!palavras.isEmpty()){
            for(Map.Entry<String, Integer> entry : palavras.entrySet()){
                if(entry.getValue() > maisFrequente){
                    maisFrequente = entry.getValue();
                    palavra = entry.getKey();
                }
            }
            return palavra + ": " + maisFrequente;
        }
        else{
            System.out.println("Conjunto vazio");
            return null;
        }
    }

    public static void main(String[] args) {
        ContagemPalavras palavras = new ContagemPalavras();

        palavras.adicionarPalavra("Dev", 7);
        palavras.adicionarPalavra("C#", 10);
        palavras.adicionarPalavra("Java", 9);
        palavras.adicionarPalavra("Python", 5);
        palavras.adicionarPalavra("C", 3);

        palavras.exibirContagemPalavras();
        System.out.println("-Removendo Go-");
        palavras.removerPalavra("Go");
        System.out.println("-Removendo Dev-");
        palavras.removerPalavra("Dev");

        System.out.println("Palavra mais frequente: " + palavras.encontrarPalavraMaisFrequente());
    }
}
