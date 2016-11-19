/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoa1.ic;

import javax.swing.JFrame;

/**
 *
 * @author lsiqueira
 */
public class TrabalhoA1IC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int largura = 800, altura = 600;
        
        Pontos pt = new Pontos(13, largura, altura);
        JFrame application = new JFrame("Resultado");
        application.add(pt);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(altura,largura);
        application.setVisible(true);
    }
    
}
