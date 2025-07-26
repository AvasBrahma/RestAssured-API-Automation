package com.api.models.response;

public class DoctorLoginResponse {
	
	private boolean isAuthenticated;
	private String token;
	public boolean getIsAuthenticated() {
		return isAuthenticated;
	}
	public void setIsAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "DoctorLoginResponse [isAuthenticated=" + isAuthenticated + ", token=" + token + "]";
	}
	public DoctorLoginResponse() {}
	public DoctorLoginResponse(boolean isAuthenticated, String token) {
		super();
		this.isAuthenticated = isAuthenticated;
		this.token = token;
	}
	

}
