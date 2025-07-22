package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventoMap.put(data, evento);
    }

    public void exibirAgenda(){
        if(!eventoMap.isEmpty()) {
            Map<LocalDate, Evento> eventosOrdenados = new TreeMap<>(eventoMap);
            System.out.println(eventosOrdenados);
        }
        else{
            System.out.println("Map vazio");
        }
    }

    public void obterProximoEvento(){
        /*Set<LocalDate> dates = eventoMap.keySet();
        Collection<Evento> eventos = eventoMap.values();*/
        Evento proximoEvento = null;
        LocalDate hoje = LocalDate.now();
        if(!eventoMap.isEmpty()){
            Map<LocalDate, Evento> lista = new TreeMap<>(eventoMap);
            LocalDate dataProxima = LocalDate.MAX;
            for(Map.Entry<LocalDate, Evento> entry : lista.entrySet()){
                if(entry.getKey().isBefore(dataProxima) && (entry.getKey().isEqual(hoje) || entry.getKey().isAfter(hoje))){
                    dataProxima = entry.getKey();
                    proximoEvento = entry.getValue();
                }
            }
            System.out.println("Próximo evento: " + proximoEvento + "Data: " + dataProxima);
        }
        else{
            System.out.println("Map vazio");
        }
    }

    public static void main(String[] args) {
        AgendaEventos eventos = new AgendaEventos();

        eventos.adicionarEvento(LocalDate.of(2024, 2, 5), "Início da Faculdade", "Primeiro dia de Aula na faculdade");
        eventos.adicionarEvento(LocalDate.of(2024, Month.JUNE, 20), "1ª Semestre terminado", "Primeiro semestre da faculdade encerrado");
        eventos.adicionarEvento(LocalDate.of(2024, 8, 15), "2ª Semestre começa", "Segundo semestre da faculdade iniciado");
        eventos.adicionarEvento(LocalDate.of(2024, Month.DECEMBER, 17), "2ª Semestre termina", "Segundo semestre da faculdade terminado");
        eventos.adicionarEvento(LocalDate.of(2025, Month.FEBRUARY, 10), "3ª Semestre começa", "Terceiro semestre da faculdade iniciado");
        eventos.adicionarEvento(LocalDate.of(2025, 6, 17), "3ª Semestre termina", "Terceiro semestre da faculdade terminado");
        eventos.adicionarEvento(LocalDate.of(2025, Month.AUGUST, 18), "4ª Semestre começa", "Quarto semestre da faculdade iniciado");
        eventos.adicionarEvento(LocalDate.of(2025, 12, 16), "4ª Semestre termina", "Quarto semestre da faculdade terminado");
        eventos.adicionarEvento(LocalDate.of(2026, Month.FEBRUARY, 16), "5ª Semestre termina", "Quinto semestre da faculdade iniciado");
        eventos.adicionarEvento(LocalDate.of(2026, 6, 16), "5ª Semestre termina - Formatura", "Quinto semestre da faculdade terminado - Graduação Concluída");

        eventos.adicionarEvento(LocalDate.of(2025, 7, 22), "Hoje", "Terça-feira, dia 22");
        eventos.adicionarEvento(LocalDate.of(2025, 7, 23), "Amanhã", "Quarta-feira, dia 23");

        System.out.println("Agenda de Eventos");
        eventos.exibirAgenda();
        System.out.println("Próximo Evento");
        eventos.obterProximoEvento();

    }
}
