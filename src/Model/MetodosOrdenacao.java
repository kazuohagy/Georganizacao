/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.Double.parseDouble;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kazuo
 */
public class MetodosOrdenacao {

    //Faz comparacoes com element em posicoes consevurivas se o elment[n+1] for menor que elem elment[n] troca a posicao
    public void bubbleSort(List<Queimadas> dados, String campo) {
        int it; //n-1 é a interação
        int pos;
        Queimadas temp;

        for (it = 0; it < dados.size() - 1; it++) {
            for (pos = 0; pos < dados.size() - it - 1; pos++) {

                if (dados.get(pos).getCampo(campo) == null) {
                    return;
                }
                if (ehInt(String.valueOf(dados.get(pos).getCampo(campo)))) {
                    if (transformaDouble( dados.get(pos).getCampo(campo)) > transformaDouble( dados.get(pos + 1).getCampo(campo))) {
                        temp = dados.get(pos + 1);
                        dados.set(pos +1,dados.get(pos));
                        dados.set(pos, temp);
           
                        

                    }
                } else {
                    if (String.valueOf(dados.get(pos).getCampo(campo)).compareToIgnoreCase(String.valueOf(dados.get(pos + 1).getCampo(campo))) > 0) {
                        temp = dados.get(pos + 1);
                        dados.set(pos +1,dados.get(pos));
                        dados.set(pos, temp);

                    }

                }

            }
            //System.out.println("-----------> Final da iteração: " + it);
            //mostrar(mario);

        }

    }

    private boolean ehInt(String str) {
        return str != null && str.matches("[0-9]*");
    }

    //Ele procura o primeiro valor que seja o menor da lista e troca a posicao dos elements
    //depois o segundo valor menor da lista e coloca no v[1] e troca a posicao dos elements
    //depois o terceiro valor menor da lista e coloca no v[2] e troca a posicao dos elements
    public void selection(List<Queimadas> dados, String campo) {

        int it;
        Queimadas temp;
        int posMenorInicial;
        int posMenor;
        int i;

        for (it = 0; it < dados.size() - 1; it++) {
            posMenorInicial = it;
            posMenor = it + 1;

            for (i = posMenorInicial + 1; i < dados.size(); i++) {
                if (ehInt(String.valueOf(dados.get(i).getCampo(campo)))) {
                    if (transformaDouble( dados.get(i).getCampo(campo)) < transformaDouble( dados.get(posMenor).getCampo(campo))) {
                        posMenor = i;

                    }
                } else {
                    if (String.valueOf(dados.get(i).getCampo(campo)).compareToIgnoreCase(String.valueOf(dados.get(posMenor).getCampo(campo))) < 0) {
                        posMenor = i;

                    }

                }

            }

            if (ehInt(String.valueOf(dados.get(posMenor).getCampo(campo)))) {
                if (transformaDouble( dados.get(posMenor).getCampo(campo)) < transformaDouble( dados.get(posMenorInicial).getCampo(campo))) {
                    temp = dados.get(posMenorInicial);
                    dados.set(posMenorInicial, dados.get(posMenor));
                    dados.set(posMenor, temp);

                }
            } else {
                if (String.valueOf(dados.get(posMenor).getCampo(campo)).compareToIgnoreCase(String.valueOf(dados.get(posMenorInicial).getCampo(campo))) < 0) {
                    temp = dados.get(posMenorInicial);
                    dados.set(posMenorInicial, dados.get(posMenor));
                    dados.set(posMenor, temp);
                    

                }

            }

        }

    }

    //tempo ao quadrado o selection e o bubble insertion
    public void insertion(int[] lista) {
        int carta, j;
        //a iteracao vai selecionar a carta da vez e puxar todos que são maiores 
        for (int i = 0; i < lista.length; i++) {
            carta = lista[i];
            for (j = i - 1; (j >= 0) && (lista[j] > carta); j--) {
                lista[j + 1] = lista[j]; //trocando todos que são maiores do que eu

            }
            lista[j + 1] = carta;
        }
    }

    public void quick(List<Queimadas> dados, String campo, int esquerda, int direita) {
        if (esquerda < direita) {
            int p = particao(dados, campo, esquerda, direita);
            quick(dados, campo, esquerda, p);
            quick(dados, campo, p + 1, direita);
        }
    }

    public int particao(List<Queimadas> dados, String campo, int esquerda, int direita) {
        int meio = (int) (esquerda + direita) / 2;
        Object pivot = dados.get(meio).getCampo(campo);
        int i = esquerda - 1;
        int j = direita + 1;
        boolean test1 = false;
        boolean test2 = false;
        while (true) {
            do {
               
                i++;
                test1 = false;
                if (ehInt(String.valueOf(dados.get(i).getCampo(campo)))) {
                    if (transformaDouble(dados.get(i).getCampo(campo))  < transformaDouble(pivot)) {
                        test1 = true;

                    }
                } else {
                    if (String.valueOf(dados.get(i).getCampo(campo)).compareToIgnoreCase(String.valueOf(pivot)) < 0) {
                        test1 = true;

                    }

                }
            } while (test1);
            do {
               
                j--;
                test2 = false;
                if (ehInt(String.valueOf(dados.get(j).getCampo(campo)))) {
                    if (transformaDouble(dados.get(j).getCampo(campo)) > transformaDouble(pivot)) {
                        test2 = true;

                    }
                } else {
                    if (String.valueOf(dados.get(j).getCampo(campo)).compareToIgnoreCase(String.valueOf(pivot)) > 0) {
                        test2 = true;

                    }

                }
            } while (test2);
            if (i >= j) {
                return j;
            }
            Queimadas aux = dados.get(i);

            
            dados.set(i, dados.get(j));
            dados.set(j, aux);
            
            //.setCampo(aux, campo);
            

        }
    }

    public void mostrar(int mario[]) {
        for (int i = 0; i < mario.length; i++) {
            System.out.println(mario[i] + "  ");
        }
        System.out.println("");
    }
    public double transformaDouble(Object obj){
        String str = String.valueOf(obj);
        if(str == null) return - 10000;
        if (str == ""){
            return 0;
        }
        return parseDouble(str);
    }

}
