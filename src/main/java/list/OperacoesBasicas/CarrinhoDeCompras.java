package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        //itens.removeIf(item -> item.getNome().equalsIgnoreCase(nome));
        for(int i = 0; i < itens.size(); i++){
            if(itens.get(i).getNome().equalsIgnoreCase(nome)){
                itens.remove(i);
            }
        }
    }

    public double calcularValorTotal(){
        double total = 0;
        for(Item item : itens){
            total += item.getPreco() * item.getQuantidade();
        }
        // Formatar casas decimais para 2
        total = Math.round(total * 100.0) / 100.0;
        return total;
    }

    public void exibirItens(){
        for(Item item : itens){
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionarItem("Arroz", 5.99, 2);
        carrinho.adicionarItem("Farinha", 2.49, 1);
        carrinho.adicionarItem("Feijão", 4.99, 3);
        carrinho.adicionarItem("Macarrão", 3.49, 1);

        carrinho.exibirItens();
        System.out.println("Total: R$"+carrinho.calcularValorTotal());
        carrinho.removerItem("Farinha");

        carrinho.exibirItens();
        System.out.println("Novo Total: R$"+carrinho.calcularValorTotal());
    }
}
