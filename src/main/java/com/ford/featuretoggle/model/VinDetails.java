package com.ford.featuretoggle.model;

import java.util.Date;

public class VinDetails {

    private String vin;
    private String color;
    private Date soldDate;
    private String source;

    public VinDetails(String vin, String color, Date soldDate, String source) {
        this.vin = vin;
        this.color = color;
        this.soldDate = soldDate;
        this.source = source;
    }

    public VinDetails() {

    }

    public String getVin() {
        return vin;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Vin:"+vin+ " source:"+source+ " soldDate:"+soldDate + " color:"+color;
    }
}
