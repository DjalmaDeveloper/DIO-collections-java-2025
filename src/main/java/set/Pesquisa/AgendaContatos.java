package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> lista = new HashSet<>();
        if(!contatoSet.isEmpty()){
            for(Contato c : contatoSet){
                if(c.getNome().startsWith(nome)){
                    lista.add(c);
                }
            }
            return lista;
        }
        else{
            System.out.println("Conjunto vazio");
            return null;
        }
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato result = null;
        if(!contatoSet.isEmpty()){
            for(Contato c : contatoSet){
                if(c.getNome().equalsIgnoreCase(nome)){
                    c.setNumero(novoNumero);
                    result = c;
                }
            }
            return result;
        }
        else{
            System.out.println("Conjunto vazio");
            return null;
        }
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();

        agenda.adicionarContato("Djalma", 86260292);
        agenda.adicionarContato("Djalma", 32232514);
        agenda.adicionarContato("Virginia", 87417949);
        agenda.adicionarContato("Edu Celular", 88043519);
        agenda.adicionarContato("Edu Casa", 30325678);
        agenda.adicionarContato("Edu Trabalho", 3254789);
        agenda.adicionarContato("Fulano", 81547423);

        agenda.exibirContatos();
        System.out.println("-Pesquisando Edu");
        System.out.println(agenda.pesquisarPorNome("Edu"));

        System.out.println("-Pesquisando Bruno");
        System.out.println(agenda.pesquisarPorNome("Bruno"));

        System.out.println("Atualizando Fulano");
        System.out.println(agenda.atualizarNumeroContato("Fulano", 88005588));

        agenda.exibirContatos();

    }
}
