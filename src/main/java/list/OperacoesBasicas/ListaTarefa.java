package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    // Atributos
    private List<Tarefa> tarefas;

    public ListaTarefa() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        this.tarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        for(Tarefa tarefa : tarefas){
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefas.remove(tarefa);
            }
        }
        // OU
        // tarefas.removeIf(tarefa -> tarefa.getDescricao().equalsIgnoreCase(descricao));
    }

    public int obterNumeroTotalTarefas(){
        return tarefas.size();
    }

    public void obterDescricoesTarefas(){
        for (Tarefa tarefa : tarefas){
            System.out.println(tarefa.getDescricao());
        }
        // OU
        // System.out.println(tarefas);
    }

    public static void main(String[] args) {
        ListaTarefa tarefas = new ListaTarefa();
        System.out.println("Tarefas: " + tarefas.obterNumeroTotalTarefas());

        tarefas.adicionarTarefa("Estudar Java");
        tarefas.adicionarTarefa("Fazer compras");
        tarefas.adicionarTarefa("Limpar a casa");
        tarefas.adicionarTarefa("Jogar Video Game");
        tarefas.adicionarTarefa("Ler um livro");
        System.out.println("Tarefas: " + tarefas.obterNumeroTotalTarefas());

        tarefas.removerTarefa("Jogar Video Game");
        System.out.println("Tarefas: " + tarefas.obterNumeroTotalTarefas());

        tarefas.obterDescricoesTarefas();
    }
}
