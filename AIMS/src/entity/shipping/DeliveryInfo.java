package entity.shipping;

public class DeliveryInfo {
	private String email;
    private String name;
    private String phone;
    private String city;
    private String address;
    private String normalInstruction;
    private boolean isRush;
    private String rushTime;
    private String rushInstruction;
    
    public void validateInfo() throws Exception{
    	
    }
    
    private boolean validateName(String name) {
    	return true;
    }
    
    private boolean validatePhone(String phone) {
    	return true;
    }
    
    private boolean validateEmail(String email) {
    	return true;
    }
    
    private boolean validateEmptyFields() {
    	return true;
    }
}
