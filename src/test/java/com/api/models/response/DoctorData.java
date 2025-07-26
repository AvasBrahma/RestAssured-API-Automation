package com.api.models.response;

public class DoctorData {
	
	 private String username;
     private String password;
     private String name;
     private String _id;
     private int __v;

     // Getters and Setters
     public String getUsername() {
         return username;
     }

     @Override
	public String toString() {
		return "DoctorData [username=" + username + ", password=" + password + ", name=" + name + ", _id=" + _id
				+ ", __v=" + __v + "]";
	}
    public DoctorData() {}
     
	public DoctorData(String username, String password, String name, String _id, int __v) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
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

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
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
