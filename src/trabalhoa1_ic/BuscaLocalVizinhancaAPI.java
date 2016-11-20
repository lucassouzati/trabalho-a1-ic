/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoa1_ic;

/**
 *
 * @author lsiqueira
 */
public class BuscaLocalVizinhancaAPI {
    private int ponto_partida;
    private double[][] custos;
    private int[] rota;

    public BuscaLocalVizinhancaAPI(int ponto_partida, double[][] custos, int[] rota) {
        this.ponto_partida = ponto_partida;
        this.custos = custos;
        this.rota = rota;
    }

    public BuscaLocalVizinhancaAPI(int ponto_partida, double[][] custos) {
        this.ponto_partida = ponto_partida;
        this.custos = custos;
        
    }
    
    public void vinzinhaAPI(){
        int[] melhorRota = new int[this.rota.length];
        int[] rotaAtual = new int[this.rota.length];
        double custoRotaAtual, custoMelhorRota;
        
        //Inicialmente a melhor rota e a rota atual são iguais ao vetor rota
        for(int i=0;i<this.rota.length;i++){
            melhorRota[i]=this.rota[i];
            rotaAtual[i]=this.rota[i];
        }
        
        Calculos calc = new Calculos(this.custos, rotaAtual);
        custoRotaAtual = calc.custoRota();
        custoMelhorRota = custoRotaAtual;
        
        //Aplicando a busca local
        int troca;
        for(int i=0;i<this.rota.length-1;i++){
            
                troca=rotaAtual[i];
                rotaAtual[i]=rotaAtual[i+1];
                rotaAtual[i+1]=troca;
                
                //Calculando o custo desta rota
                calc.setRota(rotaAtual);
                custoRotaAtual=calc.custoRota();
                
                //Este custo foi menor?
                if(custoRotaAtual<custoMelhorRota){
                    //Melhorou atualizando a melhor rota
                    for(int k=0;k<rotaAtual.length;k++){
                        melhorRota[k]=rotaAtual[k];
                    }
                    custoMelhorRota=custoRotaAtual;
                }
                
                //Voltando com a rota original
                for(int k=0;k<rotaAtual.length;k++){
                    rotaAtual[k]=this.rota[k];
                }
            
            //Atualizando a rota original
            for(int k=0;k<rotaAtual.length;k++){
                rota[k]=melhorRota[k];
            }
        
        } 
    }

    public int getPonto_partida() {
        return ponto_partida;
    }

    public void setPonto_partida(int ponto_partida) {
        this.ponto_partida = ponto_partida;
    }

    public double[][] getCustos() {
        return custos;
    }

    public void setCustos(double[][] custos) {
        this.custos = custos;
    }

    public int[] getRota() {
        return rota;
    }

    public void setRota(int[] rota) {
        this.rota = rota;
    }
    
    
}
