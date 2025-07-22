package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoque;

    public EstoqueProdutos() {
        this.estoque = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoque.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        System.out.println(estoque);
    }

    public double calcularValorTotalEstoque() {
        double valorTotal = 0;
        if (!estoque.isEmpty()) {
            for (Produto p : estoque.values()) {
                valorTotal += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        Produto maisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!estoque.isEmpty()) {
            for (Produto p : estoque.values()) {
                if (p.getPreco() > maiorPreco) {
                    maisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }
        return maisCaro;
    }

    public Produto obterProdutoMaisBarato(){
        Produto maisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if (!estoque.isEmpty()){
            for(Produto p : estoque.values()){
                if(p.getPreco() < menorPreco){
                    maisBarato = p;
                    menorPreco = p.getPreco();
                }
            }
        }
        return  maisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto maiorQuantidadeValorTotal = null;
        double maiorPrecoQuantidade = Double.MIN_VALUE;
        if(!estoque.isEmpty()){
            for(Produto p : estoque.values()){
                if(p.getPreco() * p.getQuantidade() > maiorPrecoQuantidade){
                    maiorQuantidadeValorTotal = p;
                    maiorPrecoQuantidade = p.getQuantidade() * p.getPreco();
                }
            }
        }
        return maiorQuantidadeValorTotal;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        estoque.adicionarProduto(1, "Arroz", 30, 3.50);
        estoque.adicionarProduto(2, "Feijão", 23, 2.50);
        estoque.adicionarProduto(3, "Macarrão", 21, 3.00);
        estoque.adicionarProduto(4, "Molho de Tomate", 15, 5.00);

        estoque.exibirProdutos();
        System.out.println("Valor Total do Estoque: R$" + estoque.calcularValorTotalEstoque());
        System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());
        System.out.println("Produto mais barato: " + estoque.obterProdutoMaisBarato());
        System.out.println("Produto de Maior Quantidade em Valor Total no Estoque: " + estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
