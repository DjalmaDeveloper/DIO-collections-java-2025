package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private final Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula){
        Aluno exclusao = null;
        if(!alunoSet.isEmpty()){
            for(Aluno a : alunoSet){
                if(a.getMatricula() == matricula){
                    exclusao = a;
                }
            }
            if(exclusao != null){
                alunoSet.remove(exclusao);
                System.out.println("Aluno removido");
            }
            else{
                System.out.println("Aluno não existe no conjunto");
            }
        }
        else{
            System.out.println("Conjunto vazio");
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> listaPorNome = new TreeSet<>(alunoSet);
        return listaPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota(){
        Set<Aluno> listaPorNota = new TreeSet<>(new CompararNota());
        listaPorNota.addAll(alunoSet);
        return listaPorNota;
    }

    public void exibirAlunos(){
        if(!alunoSet.isEmpty()){
            System.out.println(alunoSet);
        }
        else{
            System.out.println("Conjunto vazio");
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos alunos = new GerenciadorAlunos();

        alunos.adicionarAluno("Djalma", 2024101L, 9.5);
        alunos.adicionarAluno("Jessica", 2024102L, 9.9);
        alunos.adicionarAluno("Guilherme", 2024103L, 9);
        alunos.adicionarAluno("Emanuel", 2024104L, 8.5);
        alunos.adicionarAluno("Gabriel", 2024105L, 8);
        alunos.adicionarAluno("Priscila", 2024106L, 9.7);
        alunos.adicionarAluno("Beatriz", 2024107L, 9);

        System.out.println(alunos.alunoSet);

        System.out.println("Removendo 2024107");
        alunos.removerAluno(2024107L);
        System.out.println("Removendo 2024104");
        alunos.removerAluno(2024104L);

        System.out.println("Lista alunos:");
        alunos.exibirAlunos();

        System.out.println("Lista alfabética:\n" + alunos.exibirAlunosPorNome());

        System.out.println("Ordem de notas:\n" + alunos.exibirAlunosPorNota());
    }
}
