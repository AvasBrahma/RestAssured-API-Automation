package com.api.models.response;

public class DoctorData {
	
	 private String fullname;
	 private String username;
     private String password;
     private String _id;
     private int __v;

     // Getters and Setters
     public String getUsername() {
         return username;
     }

     @Override
	public String toString() {
		return "DoctorData [fullname=" + fullname + ",username=" + username + ", password=" + password + ", _id=" + _id
				+ ", __v=" + __v + "]";
	}
    public DoctorData() {}
     
	public DoctorData(String fullname, String username, String password, String _id, int __v) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this._id = _id;
		this.__v = __v;
	}

	public void setUsername(String username) {
         this.username = username;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     public String getFullname() {
         return fullname;
     }

     public void setFullname(String fullname) {
         this.fullname = fullname;
     }

     public String get_id() {
         return _id;
     }

     public void set_id(String _id) {
         this._id = _id;
     }

     public int get__v() {
         return __v;
     }

     public void set__v(int __v) {
         this.__v = __v;
     }

}
