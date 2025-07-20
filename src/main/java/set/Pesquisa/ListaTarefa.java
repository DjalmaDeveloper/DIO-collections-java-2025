package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefa {
    private final Set<Tarefa> tarefasSet;

    public ListaTarefa() {
        this.tarefasSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefasSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa exclusao = null;
        if(!tarefasSet.isEmpty()) {
            for (Tarefa t : tarefasSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    exclusao = t;
                    tarefasSet.remove(exclusao);
                    System.out.println("Tarefa removida");
                    break;
                }
            }
            if(exclusao == null){
                System.out.println("Tarefa não existe");
            }
        }
        else{
            System.out.println("Conjunto vazio");
        }
    }

    public void exibirTarefas(){
        if(!tarefasSet.isEmpty()) {
            System.out.println(tarefasSet);
        }
        else{
            System.out.println("Conjunto vazio");
        }
    }

    public int contarTarefas(){
        return tarefasSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> concluidas = new HashSet<>();
        if(!tarefasSet.isEmpty()){
            for(Tarefa t : tarefasSet){
                if(t.isConcluido()){
                    concluidas.add(t);
                }
            }
            if(!concluidas.isEmpty()) {
                return concluidas;
            }
            else{
                System.out.println("Nenhuma tarefa foi concluída");
                return null;
            }
        }
        else{
            System.out.println("Conjunto vazio");
            return null;
        }
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> pendentes = new HashSet<>();
        if(!tarefasSet.isEmpty()){
            for(Tarefa t : tarefasSet){
                if(!t.isConcluido()){
                    pendentes.add(t);
                }
            }
            if(!pendentes.isEmpty()) {
                return pendentes;
            }
            else{
                System.out.println("Nenhuma tarefa pendente");
                return null;
            }
        }
        else{
            System.out.println("Conjunto vazio");
            return null;
        }
    }

    public void marcarTarefaConcluida(String descricao){
        Tarefa concluida = null;
        if(!tarefasSet.isEmpty()){
            for(Tarefa t : tarefasSet){
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setConcluido(true);
                    concluida = t;
                    break;
                }
            }
            if(concluida != null) {
                System.out.println("Tarefa concluída: " + concluida.getDescricao());
            }
            else{
                System.out.println("Tarefa não existe ou não foi concluída");
            }
        }
        else{
            System.out.println("Conjunto vazio");
        }
    }

    public void marcarTarefaPendente(String descricao){
        Tarefa pendente = null;
        if(!tarefasSet.isEmpty()){
            for(Tarefa t : tarefasSet){
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluido(false);
                    pendente = t;
                    break;
                }
            }
            if(pendente != null) {
                System.out.println("Tarefa pendente: " + pendente.getDescricao());
            }
            else{
                System.out.println("Tarefa não existe ou não está pendente");
            }
        }
        else{
            System.out.println("Conjunto vazio");
        }
    }

    public void limparListaTarefas(){
        if(!tarefasSet.isEmpty()) {
            tarefasSet.clear();
            System.out.println("Conjunto esvaziado");
        }
        else{
            System.out.println("O Conjunto já está vazio");
        }
    }

    public static void main(String[] args) {
        ListaTarefa tarefas = new ListaTarefa();

        tarefas.adicionarTarefa("Acordar cedo");
        tarefas.adicionarTarefa("Dormir cedo");
        tarefas.adicionarTarefa("Lavar carro");
        tarefas.adicionarTarefa("Varrer a casa");
        tarefas.adicionarTarefa("Lavar o banheiro");
        tarefas.adicionarTarefa("Lavar o banheiro");
        tarefas.exibirTarefas();
        System.out.println("Número de tarefas: " + tarefas.contarTarefas());
        System.out.println(tarefas.obterTarefasConcluidas());
        System.out.println(tarefas.obterTarefasPendentes());

        System.out.println("-Remover VARRER A CASA-");
        tarefas.removerTarefa("Varrer a casa");
        System.out.println("-Remover ESTUDAR JAVA-");
        tarefas.removerTarefa("Estudar Java");
        System.out.println("Lista de tarefas:");
        tarefas.exibirTarefas();
        System.out.println("Número de tarefas: " + tarefas.contarTarefas());
        System.out.println("Tarefas concluídas: " + tarefas.obterTarefasConcluidas());
        System.out.println("Tarefas pendentes: " + tarefas.obterTarefasPendentes());

        tarefas.marcarTarefaConcluida("Lavar carro");
        tarefas.marcarTarefaConcluida("Lavar o banheiro");
        System.out.println("Lista de tarefas:");
        tarefas.exibirTarefas();
        System.out.println("Número de tarefas: " + tarefas.contarTarefas());
        System.out.println(tarefas.obterTarefasConcluidas());
        System.out.println(tarefas.obterTarefasPendentes());


        tarefas.marcarTarefaPendente("Lavar o banheiro");
        System.out.println("Número de tarefas: " + tarefas.contarTarefas());
        System.out.println(tarefas.obterTarefasConcluidas());
        System.out.println(tarefas.obterTarefasPendentes());

        tarefas.limparListaTarefas();
    }
}
