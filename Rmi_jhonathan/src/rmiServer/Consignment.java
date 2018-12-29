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
public class Consignment implements Serializable{

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

    public double getValue_consignment() {
        return value_consignment;
    }

    public void setValue_consignment(float value_consignment) {
        this.value_consignment = value_consignment;
    }

    public int getPlots() {
        return plots;
    }

    public void setPlots(int plots) {
        this.plots = plots;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getContract_number() {
        return contract_number;
    }

    public void setContract_number(int contract_number) {
        this.contract_number = contract_number;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    int registration;
    float value_consignment;
    int plots;
    String bank;
    int contract_number;
    int day;
    int month;
    int year;
}
