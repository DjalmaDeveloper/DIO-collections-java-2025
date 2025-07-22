package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private final Map<String, Integer> contatosMap;

    public AgendaContatos() {
        this.contatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        contatosMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if(!contatosMap.isEmpty()) {
            if(contatosMap.containsKey(nome)) {
                contatosMap.remove(nome);
                System.out.println("Contato " + nome + " removido");
            }
            else{
                System.out.println("Contato não existe no conjunto");
            }
        }
        else{
            System.out.println("Conjunto vazio");
        }
    }

    public void exibirContatos(){
        if(!contatosMap.isEmpty()) {
            System.out.println(contatosMap);
        }
        else{
            System.out.println("Conjunto vazio");
        }
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome = null;
        if(!contatosMap.isEmpty()){
            if(contatosMap.containsKey(nome)) {
                numeroPorNome = contatosMap.get(nome);
            }
            if(numeroPorNome == null){
                System.out.println("Contato não encontrado");
            }
        }
        else{
            System.out.println("Conjunto vazio");
        }
        return numeroPorNome;
    }


    public static void main(String[] args) {
        AgendaContatos contatos = new AgendaContatos();

        contatos.adicionarContato("Djalma", 86260292);
        contatos.adicionarContato("Djalma Casa", 32232514);
        contatos.adicionarContato("Virginia", 87417949);
        contatos.adicionarContato("Denis", 88217674);
        contatos.adicionarContato("Edu", 88043519);
        contatos.adicionarContato("Simone", 88274286);
        contatos.adicionarContato("Fulano", 88005555);

        contatos.exibirContatos();

        contatos.removerContato("Fulano");
        contatos.removerContato("Siclano");

        System.out.println(contatos.pesquisarPorNome("Plok"));
        System.out.println(contatos.pesquisarPorNome("Virginia"));
    }
}
