package com.apiplayground.model;
import  java.util.Date;


public class RealEstateRecord {
    private Id _id;

    public RealEstateRecord(String streetNum, String street, String propertyType, int zip_code, String state, java.sql.Date lastSalesDate, float lastSalesAmt, float maxSalesAmt, int totalRecords, int realEstateId, java.sql.Date lastModifiedDate) {
    }

    public Id get_id() {
        return _id;
    }

    public void set_id(Id _id) {
        this._id = _id;
    }

    public Date getLastSalesDate() {
        return lastSalesDate;
    }

    public void setLastSalesDate(Date lastSalesDate) {
        this.lastSalesDate = lastSalesDate;
    }


    public int getTotalRecords() {
        return TotalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        TotalRecords = totalRecords;
    }

    private Date lastSalesDate;

    public void setLastSalesAmount(double lastSalesAmount) {
        this.lastSalesAmount = lastSalesAmount;
    }

    public void setMaxSalesAmount(double maxSalesAmount) {
        this.maxSalesAmount = maxSalesAmount;
    }

    public double getLastSalesAmount() {
        return lastSalesAmount;
    }

    public double getMaxSalesAmount() {
        return maxSalesAmount;
    }

    private double lastSalesAmount;
    private double maxSalesAmount;
    private int TotalRecords;

    // Getters and setters
}
