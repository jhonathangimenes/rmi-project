/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import java.io.Serializable;
/**
 *
 * @author Jhonathan
 */
public class Employee implements Serializable{

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getGross_income() {
        return gross_income;
    }

    public void setGross_income(float gross_income) {
        this.gross_income = gross_income;
    }

    public double getConsignable_margin() {
        return consignable_margin;
    }

    public void setConsignable_margin(double consignable_margin) {
        this.consignable_margin = consignable_margin;
    }

    int registration;
    String name;
    String last_name;
    String office;
    float gross_income;
    double consignable_margin;
}
