package service;

import utility.EmailUtility;

public class EmailService {
	
	public void sendEmailToStudent(String host, String port, String gmail_user, String gmailPassword,
			String studentName,String studentUserName, String recipient, String userPassword){
		
        String subject = "Sending account details";
        String content = "Dear, " + studentName +", New Account is created for you. UserName:" + studentUserName 
        		+" Password: " + userPassword;
 
        try {
            EmailUtility.sendEmail(host, port, gmail_user, gmailPassword, recipient, subject,
                    content);
            System.out.println("The e-mail was sent successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("The e-mail was fail to sent");
        } 
	}
}