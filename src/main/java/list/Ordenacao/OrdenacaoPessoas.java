package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoas;

    public OrdenacaoPessoas() {
        this.pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura){
        pessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> resultado = new ArrayList<>(pessoas);
        Collections.sort(resultado);
        return resultado;
    }

    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> resultado = new ArrayList<>(pessoas);
        Collections.sort(resultado, new CompararAltura());
        return resultado;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas order = new OrdenacaoPessoas();

        order.adicionarPessoa("Djalma", 32, 1.63);
        order.adicionarPessoa("Virginia", 71, 1.60);
        order.adicionarPessoa("Eurides", 92, 1.58);
        order.adicionarPessoa("Sara", 8, 1.20);

        System.out.println(order.ordenarPorIdade());
        System.out.println(order.ordenarPorAltura());
    }
}
