package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeros;

    public OrdenacaoNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeros.add(numero);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> list = new ArrayList<>(numeros);
        if(!numeros.isEmpty()) {
            Collections.sort(list);
            return list;
        }
        else{
            System.out.println("Lista vazia");
            return null;
        }
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> list = new ArrayList<>(numeros);
        if(!numeros.isEmpty()) {
//            Collections.sort(list);
            list.sort(Collections.reverseOrder());
            return list;
//            return list.reversed();
        }
        else{
            System.out.println("Lista vazia");
            return null;
        }
    }

    public List<Integer> exibirLista(){
        if(!numeros.isEmpty()){
            return numeros;
        }
        else{
            System.out.println("Lista vazia");
            return null;
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros nums = new OrdenacaoNumeros();
        nums.adicionarNumero(12);
        nums.adicionarNumero(69);
        nums.adicionarNumero(73);
        nums.adicionarNumero(31);
        nums.adicionarNumero(27);
        nums.adicionarNumero(58);
        nums.adicionarNumero(46);
        nums.adicionarNumero(9);
        nums.adicionarNumero(7);


        System.out.println("Ordem normal: " + nums.exibirLista());
        System.out.println("=====================================");
        System.out.println("Crescente:" + nums.ordenarAscendente());
        System.out.println("=====================================");
        System.out.println("Descrescente:" + nums.ordenarDescendente());
    }
}
