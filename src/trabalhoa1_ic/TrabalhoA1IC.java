/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoa1_ic;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        
        Gulosa g = new Gulosa(pt.getCustos(), pt.getCoordenadas(),  0);
        int[] rota=g.getRota();
        String aux="";
        for(int i=0; i<rota.length;i++){
            aux += "--"+rota[i];
        }
        JOptionPane.showMessageDialog(null, aux);
        
        
        Calculos c = new Calculos(pt.getCustos(), g.getRota(), pt.getCoordenadas());
        JFrame s_gulosa = new JFrame("Método Guloso");
        s_gulosa.add(c);
        s_gulosa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s_gulosa.setSize(altura,largura);
        s_gulosa.setVisible(true);
        
        //Busca local All Pairs Aleatório
        BuscaLocalAllPairs bl = new BuscaLocalAllPairs(0,pt.getCustos());
        Calculos c2 = new Calculos(pt.getCustos(), bl.getRota(), pt.getCoordenadas());
        JFrame buscaAleatoria = new JFrame("Busca Local All Pairs Aleatório");
        buscaAleatoria.add(c2);
        buscaAleatoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buscaAleatoria.setSize(altura,largura);
        buscaAleatoria.setVisible(true);
        
        //Busca local All Pairs com rota do Método Guloso
        BuscaLocalAllPairs b2 = new BuscaLocalAllPairs(0,pt.getCustos(), g.getRota());
        Calculos c3 = new Calculos(pt.getCustos(), b2.getRota(), pt.getCoordenadas());
        JFrame buscaAllPairs = new JFrame("Busca Local All Pairs com rota do Método Guloso");
        buscaAllPairs.add(c3);
        buscaAllPairs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buscaAllPairs.setSize(altura,largura);
        buscaAllPairs.setVisible(true);
        
        //Busca local Vizinhança API
        BuscaLocalVizinhancaAPI b3 = new BuscaLocalVizinhancaAPI(0,pt.getCustos());
        Calculos c4 = new Calculos(pt.getCustos(), b3.getRota(), pt.getCoordenadas());
        JFrame buscaVizinhaAPI = new JFrame("Busca Local Vizinhança APi com rota do Método Guloso");
        buscaVizinhaAPI.add(c4);
        buscaVizinhaAPI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buscaVizinhaAPI.setSize(altura,largura);
        buscaVizinhaAPI.setVisible(true);
    }
    
}
