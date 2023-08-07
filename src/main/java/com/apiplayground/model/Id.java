package com.apiplayground.model;

public class Id {
    public String getSTREET_NUMBER() {
        return STREET_NUMBER;
    }

    public void setSTREET_NUMBER(String STREET_NUMBER) {
        this.STREET_NUMBER = STREET_NUMBER;
    }

    public String getSTREET() {
        return STREET;
    }

    public void setSTREET(String STREET) {
        this.STREET = STREET;
    }

    public String getPROPERTY_TYPE() {
        return PROPERTY_TYPE;
    }

    public void setPROPERTY_TYPE(String PROPERTY_TYPE) {
        this.PROPERTY_TYPE = PROPERTY_TYPE;
    }

    public String getZIPCODE() {
        return ZIPCODE;
    }

    public void setZIPCODE(String ZIPCODE) {
        this.ZIPCODE = ZIPCODE;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    private String STREET_NUMBER;
    private String STREET;
    private String PROPERTY_TYPE;
    private String ZIPCODE;
    private String STATE;

    // Getters and setters
}
