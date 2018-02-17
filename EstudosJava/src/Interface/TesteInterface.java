/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marmh
 */
public class TesteInterface {
        float auxiliarTotal = 0;
    
    public Object excluirRenda(ArrayList array ){
        Object[] vetDescricao = new Object[array.size()];
        for(int i = 0; i < array.size(); i++){
            vetDescricao[i] = array.get(i);
        }
        Object escolhaApagar = JOptionPane.showInputDialog(null, "Qual você deseja excluir?", "NOMES",
               JOptionPane.QUESTION_MESSAGE, null, vetDescricao,null);
        
        return escolhaApagar;
    }
    
    public void cadastraRenda(ArrayList array1, ArrayList array2, String descricao, String valor, JLabel label){
       String descricaoR = JOptionPane.showInputDialog(descricao);
       array1.add(descricaoR);
       
       String valorR = JOptionPane.showInputDialog(valor);
       array2.add(valorR);
        
       float auxiliar = Float.parseFloat(valorR);
       auxiliarTotal += auxiliar;
       
       label.setText("R$ " + auxiliarTotal);
    }
    
    public String cadastraGastoTabela(JTable table){
        
        String descricao = JOptionPane.showInputDialog("Descreva a que se refere o custo:");
        String valor = JOptionPane.showInputDialog("Informe o valor do custo:");
        String mesReferencia = JOptionPane.showInputDialog("Informe qual a data do custo:");
        String comenta = JOptionPane.showInputDialog("Faça algum comentário que pode ser útil");
        DefaultTableModel tabela = (DefaultTableModel) table.getModel();
        Object[] dados = {descricao, valor, mesReferencia, comenta};
        tabela.addRow(dados);
        return valor;
    }
    
    public void calculaSaldo(float totalGastos,float auxRendaFixa, float auxRendaExtra, JLabel label){
      float saldo = auxRendaFixa + auxRendaExtra - totalGastos;
      label.setText("R$ " + saldo);
    }
}
