/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author marinaldosantos
 */
public class Exemplo01 extends UnicastRemoteObject implements IExemplo01 {
    
    List<Employee> listEmployee = new ArrayList<>();
    List<Consignment> listConsignments = new ArrayList<>();
    List<Portion> listPortions = new ArrayList<>();

    public Exemplo01() throws RemoteException {
    }

    private String texto="Valor Inicial da variável";

    @Override
    public void addEmployee(Employee e) throws RemoteException {
        
        if(e == null){
            System.out.print("\nObjeto Funcionário vazio\n");
        }else{
            this.listEmployee.add(e);
            for(int i=0; i<this.listEmployee.size(); i++){
               System.out.print("\n:::::::Funcionario Cadastrado:::::::\n");
               System.out.print("Matricula do Funcionário: "+this.listEmployee.get(i).getRegistration()+"\n");
               System.out.print("Nome: "+this.listEmployee.get(i).getName()+"\n");
               System.out.print("Cargo: "+this.listEmployee.get(i).getOffice()+"\n");
               System.out.print("Renda Bruta: "+this.listEmployee.get(i).getGross_income()+"\n");
               System.out.print("Margem Consignavel: "+this.listEmployee.get(i).getConsignable_margin()+"\n");
            }
        }
    }

    @Override
    public List<Employee> getEmployee() throws RemoteException {
        return this.listEmployee;
    }

    @Override
    public void addConsignment(Consignment c) throws RemoteException {
        
        if(c == null){
            System.out.print("List Vazia Consignação");
        }else{
            this.listConsignments.add(c);
            for(int i=0; i<this.listConsignments.size(); i++){
            }
        }
    }

    @Override
    public List<Consignment> getConsigment() throws RemoteException {
        return this.listConsignments;
    }

    @Override
    public void addPortion(Portion p) throws RemoteException {
        
        if(p == null){
            System.out.print("erro ao adicionar parcelas na lista");
        }else{
            this.listPortions.add(p);
            for(int i=0; i<this.listPortions.size(); i++){
            }
        }
    }

    @Override
    public List<Portion> getPortions() throws RemoteException {
        return this.listPortions;
    }

    @Override
    public void payInstallment(int portion) throws RemoteException {
        
        for(int i = 0 ; i < listPortions.size() ; i++){
            if(portion == listPortions.get(i).getMonth()){
                listPortions.get(i).setStatus("Pago");
                System.out.print("Parcela do Mês: "+listPortions.get(i).getMonth());
            }
        }
    }

}
