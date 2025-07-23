package main.java.map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    Map<String, Livro> livraria;

    public LivrariaOnline() {
        this.livraria = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        Livro livro = new Livro(titulo, autor, preco);
        livraria.put(link, livro);
    }

    public void removerLivro(String titulo){
        Livro livroRemover = null;
        if(!livraria.isEmpty()){
            for(Map.Entry<String, Livro> entry : livraria.entrySet()){
                if(entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                    livroRemover = entry.getValue();
                    livraria.remove(entry.getKey(), entry.getValue());
                    System.out.println("Livro removido");
                    break;
                }
            }
            if(livroRemover == null){
                System.out.println("Livro não existe");
            }
        }
        else{
            System.out.println("Map vazio");
        }
    }

    public Set<Livro> exibirLivrosOrdenadosPorPreco(){
        Set<Livro> livrosPorPreco = new TreeSet<>(new CompararPreco());
        if (!livraria.isEmpty()) {
            livrosPorPreco.addAll(livraria.values());
            return livrosPorPreco;
        }
        else{
            System.out.println("Map vazio");
            return  livrosPorPreco;
        }
    }

    public Set<Livro> pesquisarLivrosPorAutor(String autor){
        Set<Livro> livrosPorAutor = new HashSet<>();
        if(!livraria.isEmpty()) {
            for(Livro l : livraria.values()){
                if (l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }
            return livrosPorAutor;
        }
        else{
            System.out.println("Map vazio");
            return livrosPorAutor;
        }
    }

    public Livro obterLivroMaisCaro(){
        Livro maisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if(!livraria.isEmpty()){
            for(Livro l : livraria.values()){
                if(l.getPreco() > maiorPreco){
                    maisCaro = l;
                    maiorPreco = l.getPreco();
                }
            }
            return maisCaro;
        }
        else{
            System.out.println("Map vazio");
            return null;
        }
    }

    public Livro exibirLivroMaisBarato(){
        Livro maisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if(!livraria.isEmpty()){
            for(Livro l : livraria.values()){
                if(l.getPreco() < menorPreco){
                    maisBarato = l;
                    menorPreco = l.getPreco();
                }
            }
            return maisBarato;
        }
        else{
            System.out.println("Map vazio");
            return null;
        }
    }

    public static void main(String[] args) {
        LivrariaOnline livraria = new LivrariaOnline();

        livraria.adicionarLivro("9780545069670", "Harry Potter e a Pedra Filosofal (Capa dura)", "J.K. Rowling", 43.02);
        livraria.adicionarLivro("9788532530790", "Harry Potter e a Câmara Secreta", "J.K. Rowling", 41.90);
        livraria.adicionarLivro("9788532530806", "Harry Potter e o Prisioneiro de Azkaban (Capa dura)", "J.K. Rowling", 50.82);
        livraria.adicionarLivro("9788532530813", "Harry Potter e o Cálice de Fogo (Capa dura)", "J.K. Rowling", 74.90);
        livraria.adicionarLivro("9788532530820", "Harry Potter e a Ordem da Fênix", "J.K. Rowling", 72.60);
        livraria.adicionarLivro("9788525067326", "Mentes perigosas: O psicopata mora ao lado", "Dra. Ana Beatriz Barbosa Silva", 48.90);
        livraria.adicionarLivro("9788525058614", "Mentes inquietas (Kindle)", "Dra. Ana Beatriz Barbosa Silva", 44.90);
        livraria.adicionarLivro("9786586551709", "Nação dopamina", "Dra. Anna Lembke", 55.90);

        System.out.println("Livros por ordem de preço:\n" + livraria.exibirLivrosOrdenadosPorPreco());
        System.out.println("Livros por ordem de autor:\n" + livraria.pesquisarLivrosPorAutor("Dra. Ana Beatriz Barbosa Silva"));
        System.out.println("Livro mais caro:\n" + livraria.obterLivroMaisCaro());
        System.out.println("Livro mais barato:\n" + livraria.exibirLivroMaisBarato());

        System.out.println("-Remover Nação dopamina-");
        livraria.removerLivro("Nação dopamina");
        System.out.println("-Remover Diário de um Banana-");
        livraria.removerLivro("Diário de um Banana");
        System.out.println("Livros por ordem de preço:\n" + livraria.exibirLivrosOrdenadosPorPreco());
    }
}
