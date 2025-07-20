package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidados;

    public ConjuntoConvidados() {
        this.convidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        convidados.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        Convidado search = null;
        if(!convidados.isEmpty()){
            for(Convidado x : convidados){
                if(x.getCodigoConvite() == codigoConvite){
                    search = x;
                    break;
                }
            }
            convidados.remove(search);
        }
        else{
            System.out.println("Lista vazia");
        }
    }

    public void contarConvidados(){
        System.out.println("Número de convidados: " + convidados.size());
    }

    public void exibirConvidados(){
        System.out.println(convidados);
    }

    public static void main(String[] args) {
        ConjuntoConvidados lista = new ConjuntoConvidados();
        lista.adicionarConvidado("Djalma", 1);
        lista.adicionarConvidado("Guilherme", 2);
        lista.adicionarConvidado("Fulano", 3);
        lista.adicionarConvidado("John", 3);
        lista.adicionarConvidado("Jessica", 4);
        lista.adicionarConvidado("Emanuel", 5);
        lista.adicionarConvidado("Beatriz", 6);
        lista.adicionarConvidado("Antonio", 7);
        lista.adicionarConvidado("Jane", 7);

        lista.contarConvidados();
        lista.exibirConvidados();
        System.out.println("-Removendo fulano-");
        lista.removerConvidadoPorCodigoConvite(3);
        lista.contarConvidados();
        lista.exibirConvidados();
    }
}
