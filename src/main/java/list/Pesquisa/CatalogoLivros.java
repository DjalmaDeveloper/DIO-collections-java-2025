package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livros;

    public CatalogoLivros() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> pesquisa = new ArrayList<>();
        if(!livros.isEmpty()){
            for(Livro livro : livros){
                if(livro.getAutor().equalsIgnoreCase(autor)){
                    pesquisa.add(livro);
                }
            }
        }
        return pesquisa;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> pesquisa = new ArrayList<>();
        if (!livros.isEmpty()) {
            for(Livro livro : livros){
                if(livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal){
                    pesquisa.add(livro);
                }
            }
        }
        return pesquisa;
    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro resultado = null;
        if(!livros.isEmpty()){
            for(Livro livro : livros){
                if(livro.getTitulo().equalsIgnoreCase(titulo)){
                    resultado = livro;
                    break;
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        CatalogoLivros biblioteca = new CatalogoLivros();
        biblioteca.adicionarLivro("Harry Potter Pedra Filosofal", "J.K. Rowling", 1997);
        biblioteca.adicionarLivro("Harry Potter Câmara Secreta", "J.K. Rowling", 1998);
        biblioteca.adicionarLivro("Nação Dopamina", "Dra. Anna Lembke", 2021);
        biblioteca.adicionarLivro("Mentes Perigosas", "Ana Beatriz Barbosa Silva", 2014);
        biblioteca.adicionarLivro("As 48 Leis do Poder", "Robert Greene", 1998);
        biblioteca.adicionarLivro("As 48 Leis do Poder", "Robert Greene", 2000);

//        System.out.println(biblioteca.pesquisarPorAutor("J.K. Rowling"));
//        System.out.println(biblioteca.pesquisarPorIntervaloAnos(1990, 2000));
        System.out.println(biblioteca.pesquisarPorTitulo("Harry Potter Pedra Filosofal"));
    }
}
