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
public class Portion implements Serializable{

    public int getContract_number() {
        return contract_number;
    }

    public void setContract_number(int contract_number) {
        this.contract_number = contract_number;
    }

    public double getPortion_value() {
        return portion_value;
    }

    public void setPortion_value(float portion_value) {
        this.portion_value = portion_value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    
    int contract_number;
    float portion_value;
    String status;
    int day;
    int month;
    int year;
}
