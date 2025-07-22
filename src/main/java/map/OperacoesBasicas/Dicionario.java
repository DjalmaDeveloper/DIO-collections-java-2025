package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        dicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        String word = null;
        if(!dicionario.isEmpty()){
            if(dicionario.containsKey(palavra)){
                dicionario.remove(palavra);
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

    public void exibirPalavras(){
        if(!dicionario.isEmpty()){
            System.out.println(dicionario);
        }
        else{
            System.out.println("Conjunto vazio");
        }
    }

    public String pesquisarPorPalavra(String palavra){
        String result = null;
        if(!dicionario.isEmpty()){
            if(dicionario.containsKey(palavra)){
                result = dicionario.get(palavra);
            }
            else{
                System.out.println("Palavra não existe no conjunto");
            }
        }
        else{
            System.out.println("Conjunto vazio");
        }
        return result;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Banana", "É uma fruta amarela que o macaco gosta. Mas gosta muito");
        dicionario.adicionarPalavra("Alho", "É uma planta que assusta o vampiro a ponto de ele preferir uma estocada no peito");
        dicionario.adicionarPalavra("Suborno", "É um pagamento ou presente para alguém que vai fazer algo indevido em troca");
        dicionario.adicionarPalavra("Sanduíche", "É duas fatias de pão juntas e o recheio vai no meio");
        dicionario.adicionarPalavra("Sanduíche", "É um lanche criado por meio de pães e outros aperetivos que servem de recheio");

        dicionario.exibirPalavras();

        dicionario.removerPalavra("Burro");
        dicionario.removerPalavra("Alho");

        dicionario.exibirPalavras();

        System.out.println("Pesquisando Hambúrguer");
        dicionario.pesquisarPorPalavra("Hamburguer");
        System.out.println("Pesquisando Sanduíche");
        System.out.println(dicionario.pesquisarPorPalavra("Sanduíche"));
    }
}
