package com.api.models.response;

public class DoctorRegisterResponse {
	
	private boolean isRegistered;
    private DoctorData docData;
    private String message;

    // Getters and Setters
    public boolean isRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    public DoctorData getData() {
        return docData;
    }

    public void setData(DoctorData data) {
        this.docData = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public DoctorRegisterResponse() {}

	public DoctorRegisterResponse(boolean isRegistered, DoctorData docData, String message) {
		super();
		this.isRegistered = isRegistered;
		this.docData = docData;
		this.message = message;
	}

	@Override
	public String toString() {
		return "DoctorRegisterResponse [isRegistered=" + isRegistered + ", docData=" + docData + ", message=" + message
				+ "]";
	}

}
