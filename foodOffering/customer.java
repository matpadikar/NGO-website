package com.ptc.demo.model;

public class customer {
	
	private String firstname;
    private String lastname;
     
    public customer(){}
     
    public customer(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }
     
    // firstname
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
     
    // lastname
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}


