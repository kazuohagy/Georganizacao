/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;




import DAO.QueimadasDAO;
import View.TelaPrincipal;

/**
 *
 * @author kazuo
 */
public class Principal {
    public static void main (String[] args){
       new TelaPrincipal().setVisible(true);
       DAO.ConnectionFactory.getConnection();
       

        
    }
}
