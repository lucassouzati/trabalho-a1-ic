/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoa1_ic;

/**
 *
 * @author Usuario
 */
public class Gulosa {
    private double[][] custos;
    private int[] rota;
    private int[][] coordenadas;
    private int ponto_partida;
    
    public Gulosa(double[][] custos, int[][] coordenadas, int ponto_partida){
        this.custos = custos;
        this.coordenadas = coordenadas;
        this.ponto_partida = ponto_partida;
        
        rota=new int[this.custos.length];
        
        //Esvaziando o vetor
        for(int i=0;i<this.custos.length;i++){
            rota[i]=-1;
        }
        rota[0]=ponto_partida;
        
        //Calculando a rota
        calcula_rota(ponto_partida, 0);
        
    }
    
    public int[] getRota() {
        return rota;
    }
    
    private double[][] calcula_custos(int ponto){
        double[][] aux = new double[this.custos.length][2];
        double troca;
        for(int i=0;i<aux.length;i++){
            aux[i][0] = i;
            aux[i][1] = this.custos[ponto][i];
        }
        //Ordenando de forma crescente
        for(int i=0;i<aux.length-1;i++){
            for(int j=i+1;j<aux.length;j++){
                if(aux[i][1]>aux[j][1]){
                    troca=aux[i][1];
                    aux[i][1]=aux[j][1];
                    aux[j][1] = troca;
                    
                    troca=aux[i][0];
                    aux[i][0]=aux[j][0];
                    aux[j][0] = troca;  
                }
            }
        }
        return aux;
    }
    
    private boolean usado(int ponto){
        //Ponto é a próxima cidade a ser visitada
        boolean aux=false;
        for (int i=0;i<this.custos.length;i++){
            if(this.rota[i]==ponto){
                aux=true;
            }
        }
        return aux;
    }
    
    private void calcula_rota(int ponto_atual, int cont_rota){
        double[][]custos_do_ponto_atual = calcula_custos(ponto_atual);
        
        //Verifica se este ponto já foi usado na rota
        int i=0;
        while(usado((int)custos_do_ponto_atual[i][0])){
            i++;
        }
        cont_rota++;
        this.rota[cont_rota] = (int)custos_do_ponto_atual[i][0];
        ponto_atual=(int)custos_do_ponto_atual[i][0];
        
        //Chamada recursiva até preencher a rota
        if(cont_rota<this.custos.length-1){
            calcula_rota(ponto_atual, cont_rota);
        }
    }
}
