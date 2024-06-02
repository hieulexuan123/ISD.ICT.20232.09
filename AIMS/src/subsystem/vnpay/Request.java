package subsystem.vnpay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

public class Request {
	private int amount;
	private String content; 
	
	public Request(int amount, String content){
        this.amount = amount;
        this.content = content;
    }
	
	public int getAmount() {
		return amount;
	}
	public String getContent() {
		return content;
	}

}
