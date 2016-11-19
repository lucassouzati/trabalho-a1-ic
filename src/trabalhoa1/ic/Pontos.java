package trabalhoa1.ic;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab1
 */
import java.awt.Graphics;
import javax.swing.JPanel;

public class Pontos extends JPanel{
    private int vertices;
    private int[][] coordenadas;
    private double[][] custos;
    private int largura;
    private int altura;

    public Pontos(int vertices, int largura, int altura) {
        this.vertices=vertices;
        this.coordenadas = new int[this.vertices][2];
        this.custos = new double[this.vertices][this.vertices]; 
        this.largura =largura;
        this.altura = altura;
        gerar();
        calcula_custos();
    }
    public double[][] getCustos() {
        return custos;
    }

    public void setCustos(double[][] custos) {
        this.custos = custos;
    }
    
    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int[][] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int[][] coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    public void gerar(){
        
        int valoresX[] = {120, 180, 250, 380, 450, 530, 500, 310, 190, 165, 210, 155, 80};
        int valoresY[] = {122, 75, 90, 170, 200, 350, 510, 460, 500, 390, 310, 245, 190};

        for (int i = 0; i < this.vertices ; i++) {
            this.coordenadas[i][0] = valoresX[i];
            this.coordenadas[i][1] = valoresY[i];
        }
    }
     
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //desenhando os vertices geravados
         for (int i = 0; i < this.vertices ; i++) {
             g.drawOval(this.coordenadas[i][0], this.coordenadas[i][1], 10, 10);
             g.drawString(" "+(i), this.coordenadas[i][0], this.coordenadas[i][1]);
        }
        /*for (int i = 0; i < this.vertices; i++) {
            for (int j = 0; j < this.vertices; j++) {
                if(i!=j){
                    g.drawLine(this.coordenadas[i][0], this.coordenadas[i][1], this.coordenadas[j][0], this.coordenadas[j][1]);
                }
            }
        }*/
    }
    
    public void calcula_custos(){
        double h=0,a=0,b=0;
        for (int i = 0; i < this.vertices; i++) {
            for (int j = 0; j < this.vertices; j++) {
                if (i==j){
                    h=0;
                }else{
                    a= Math.abs(this.coordenadas[i][0] - this.coordenadas[j][0]);
                    b =Math.abs(this.coordenadas[i][1] - this.coordenadas[j][1]);
                    h = Math.sqrt(a*a+b*b);
                }
                this.custos[i][j]=h;
            }
        }
    }
    
    
   
}
