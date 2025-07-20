package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ConjuntoPalavrasUnicas that = (ConjuntoPalavrasUnicas) o;
        return Objects.equals(palavrasUnicas, that.palavrasUnicas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(palavrasUnicas);
    }

    public void adicionarPalavra(String palavra){
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra){
        if(!palavrasUnicas.isEmpty()){
            if(palavrasUnicas.contains(palavra)){
                palavrasUnicas.remove(palavra);
            }
            else{
                System.out.println("Palavra NÃO existe no conjunto");
            }
        }
        else{
            System.out.println("Lista vazia");
        }
    }

    public void verificarPalavra(String palavra){
        String pesquisa = null;
        if(!palavrasUnicas.isEmpty()){
            for(String p : palavrasUnicas){
                if(p.equalsIgnoreCase(palavra)){
                    pesquisa = p;
                    break;
                }
            }
            if(pesquisa != null){
                System.out.println("A palavra " + pesquisa + " existe no conjunto");
            }
            else{
                System.out.println("A palavra NÃO existe no conjunto");
            }
        }
        else{
            System.out.println("Lista vazia");
        }
        // boolean = palavrasUnicas.contains(palavra);
    }

    public void exibirPalavrasUnicas(){
        if(!palavrasUnicas.isEmpty()){
            System.out.println(palavrasUnicas);
        }
        else{
            System.out.println("Lista vazia");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas words = new ConjuntoPalavrasUnicas();

        words.adicionarPalavra("Zelda");
        words.adicionarPalavra("Link");
        words.adicionarPalavra("Link");
        words.adicionarPalavra("Ganon");
        words.adicionarPalavra("Ganondorf");
        words.adicionarPalavra("Demise");
        words.adicionarPalavra("Midna");
        words.adicionarPalavra("Midna");
        words.adicionarPalavra("Fi");

        words.exibirPalavrasUnicas();

        System.out.println("-Checando palavra Ganondorf-");
        words.verificarPalavra("Ganondorf");

        System.out.println("-Checando palavra Kakariko-");
        words.verificarPalavra("Kakariko");

        System.out.println("-Removendo Ganon-");
        words.removerPalavra("Ganon");

        System.out.println("-Removendo Impa-");
        words.removerPalavra("Impa");
        words.exibirPalavrasUnicas();
    }
}
