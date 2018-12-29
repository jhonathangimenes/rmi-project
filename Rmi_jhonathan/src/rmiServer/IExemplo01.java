/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author marinaldosantos
 */
public interface IExemplo01 extends java.rmi.Remote {

    public void addEmployee(Employee e) throws RemoteException;
    
    public List<Employee> getEmployee() throws RemoteException;
    
    public void addConsignment (Consignment c) throws RemoteException;
    
    public List<Consignment> getConsigment() throws RemoteException;
    
    public void addPortion(Portion p) throws RemoteException;
    
    public List<Portion> getPortions() throws RemoteException;
    
    public void payInstallment(int portion) throws RemoteException;
}
