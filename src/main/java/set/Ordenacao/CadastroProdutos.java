package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> listaPorNome = new TreeSet<>(produtoSet);
        return  listaPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtoPorPreco = new TreeSet<>(new CompararPorPreco());
        produtoPorPreco.addAll(produtoSet);
        return produtoPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos produtos = new CadastroProdutos();

        produtos.adicionarProduto(1, "Playstation 5", 4999.90, 150);
        produtos.adicionarProduto(2, "Smart Tv LG 50'", 3999.90, 50);
        produtos.adicionarProduto(2, "Tv Portátil 5'", 299.90, 120);
        produtos.adicionarProduto(3, "Antena Century", 499.90, 80);
        produtos.adicionarProduto(4, "Detector de metal", 799.90, 130);

        System.out.println(produtos.exibirProdutosPorNome());
        System.out.println(produtos.exibirProdutosPorPreco());
    }
}
