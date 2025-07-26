package com.api.models.request;

public class PatientRegisterReq {
	
	    private String name;
	    private String phone;
	    private String dateofbirth;
	    private String gender;

	    // Default constructor
	    public PatientRegisterReq() {}

	    public PatientRegisterReq(String name, String phone, String dateofbirth, String gender) {
			super();
			this.name = name;
			this.phone = phone;
			this.dateofbirth = dateofbirth;
			this.gender = gender;
		}

		// Getters and Setters
	    public String getName() {
	        return name;
	    }

	    @Override
		public String toString() {
			return "PatientRegisterReq [name=" + name + ", phone=" + phone + ", dateofbirth=" + dateofbirth
					+ ", gender=" + gender + "]";
		}

		public void setName(String name) {
	        this.name = name;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getDateofbirth() {
	        return dateofbirth;
	    }

	    public void setDateofbirth(String dateofbirth) {
	        this.dateofbirth = dateofbirth;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }
	    
	    //Builder Design Pattern
	    //inner class
	    public static class Builder{
	    	private String name;
		    private String phone;
		    private String dateofbirth;
		    private String gender;
		    
		    public Builder name(String name) {
		    	this.name=name;
		    	return this; //returning current object
		    }
		    public Builder phone(String phone) {
		    	this.phone=phone;
		    	return this; //returning current object
		    }
		    public Builder dateofbirth(String dateofbirth) {
		    	this.dateofbirth=dateofbirth;
		    	return this; //returning current object
		    }
		    public Builder gender(String gender) {
		    	this.gender=gender;
		    	return this; //returning current object
		    }
		    
		    public PatientRegisterReq build() {
		    	PatientRegisterReq patientRegisReq=new PatientRegisterReq(name, phone, dateofbirth, gender);
		    	return patientRegisReq;
		    }
	    	
	    }

}
