/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoa1_ic;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Calculos extends JPanel{
    private double[][] custos;
    private int[] rota;
    private int[][] coordenadas;

    public Calculos(double[][] custos, int[] rota, int[][] coordenadas) {
        this.custos = custos;
        this.rota = rota;
        this.coordenadas = coordenadas;
    }

    public Calculos(double[][] custos, int[] rota) {
        this.custos = custos;
        this.rota = rota;
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
    
    public double custoRota(){
        double c=0;
        int de=0, para=0, i;
        for(i=0;i<rota.length-1;i++){
            de=rota[i];
            para=rota[i+1];
            c+=this.custos[de][para];
        }
        //Voltando para o ponto de partida
        de=para;
        para=rota[0];
        c+=this.custos[de][para];
        return c;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //Desenhando os vértices gerados
        for (int i=0; i<this.custos.length;i++){
           g.fillOval(this.coordenadas[i][0], this.coordenadas[i][1], 10, 10);
           g.drawString(" "+(i), this.coordenadas[i][0], this.coordenadas[i][1]);
        }
        
        //Desenhando uma linha interligando todos os vértices
        int x1, y1, x2, y2, i=0;
        for(i=0;i<this.rota.length-1;i++){
            if(i==0){
                g.setColor(Color.red);
            }else{
                g.setColor(Color.black);
            }
            x1=this.coordenadas[this.rota[i]][0];
            y1=this.coordenadas[this.rota[i]][1];
            x2=this.coordenadas[this.rota[i+1]][0];
            y2=this.coordenadas[this.rota[i+1]][1];
            g.drawLine(x1, y1, x2, y2);
        }
        
        //Volatndo ao ponto de origem
        g.setColor(Color.blue);
        x1=this.coordenadas[this.rota[i]][0];
        y1=this.coordenadas[this.rota[i]][1];
        x2=this.coordenadas[this.rota[0]][0];
        y2=this.coordenadas[this.rota[0]][1];
        g.drawLine(x1, y1, x2, y2);
        
        //Escrevendo o custo dessa rota
        g.drawString("Custo =" + custoRota(), 10, 500);
    } 
   
}
