package entity.shipping;

public class DeliveryInfo {
	private String email;
    private String name;
    private String phone;
    private String city;
    private String address;
    private String note;
    private boolean isRush;
    private String rushTime;
    
    
    public boolean validateInfo() throws Exception{
    	if (validateName(name)&&validatePhone(phone) && validateEmail(email)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public DeliveryInfo(String email, String name, String phone, String city, String address, 
			boolean isRush, String rushTime, String rushInstruction) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.address = address;
	
		this.isRush = isRush;
		this.rushTime = rushTime;
		this.note = rushInstruction;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}


	public String getPhone() {
		return phone;
	}

	

	public String getCity() {
		return city;
	}

	

	public String getAddress() {
		return address;
	}

	

	public String getNote() {
		return note;
	}

	
	public boolean isRush() {
		return isRush;
	}

	

	public String getRushTime() {
		return rushTime;
	}

	

	private boolean validateName(String name) {
    	if (name.length()<50) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    private boolean validatePhone(String phone) {
    	if (phone.length() == 10) {
    		for (char c: phone.toCharArray()) {
    			if (c<'0' || c>'9'){
    				return false;
    			}
    		}
    		return true;
    	}
    	return false;
    }
    
    private boolean validateEmail(String email) {
    	return true;
    }
    
    private boolean validateEmptyFields() {
    	return true;
    }
}
