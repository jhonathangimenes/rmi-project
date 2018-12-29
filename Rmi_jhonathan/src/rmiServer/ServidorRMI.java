/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import java.awt.Frame;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author marinaldosantos
 */
public class ServidorRMI {
    
    
   

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, NotBoundException {

        Exemplo01 rmiExemplo01 = new Exemplo01();

        Registry registry = LocateRegistry.createRegistry(7000);

        registry.bind("ExemploRMI01", rmiExemplo01);

        System.out.println("Objetos distribuidos disponiveis");
        
        //Inicio t = new Inicio();
        //t.show();
    }

   
}
