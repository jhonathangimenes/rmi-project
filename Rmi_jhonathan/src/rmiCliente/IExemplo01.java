/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiCliente;

import java.rmi.RemoteException;

/**
 *
 * @author marinaldosantos
 */
public interface IExemplo01 extends java.rmi.Remote{
    
     //assinatura do métodos remotos
    public void setString(String s) throws RemoteException;

    public String getString() throws RemoteException;
    
}
