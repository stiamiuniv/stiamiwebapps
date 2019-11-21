package com.stiamiwebapps.stiami.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.google.gson.Gson;
import com.stiamiwebapps.stiami.config.Mail;
import com.stiamiwebapps.stiami.config.MailConfig;
import com.stiamiwebapps.stiami.config.MailEnvirontment;
import com.stiamiwebapps.stiami.constants.Constant;
import com.stiamiwebapps.stiami.model.Environtment;
import com.stiamiwebapps.stiami.model.Users;


public class MailUtility {
	private Util util = new Util();
	private Environtment env = new Environtment();
	private MailConfig config;
	private Gson gson = new Gson();

	public MailUtility() {
		this.getMailConfig();
	}

	public void getMailConfig() {
		String mailConfig = util.getStringJsonFile(Constant.MAIL_CONFIG_PATH);
		Mail mailconfig = gson.fromJson(mailConfig, Mail.class);
		ArrayList<MailEnvirontment> mailEnvirontment = mailconfig.getMailconfig();
		for(int i = 0; i < mailEnvirontment.size(); i++) {
			MailEnvirontment mail = mailEnvirontment.get(i);
			if(mail.getEnv().equals(env.getEnvirontment())) {
				config = mail.getConfig();
				break;
			}
		}
	} 

	public MailConfig getConfig() {
		return config;
	}

	public void sendMail(String messageBody, String pathAttachment, String to, String subject) {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", config.getPort());
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", config.getPort());
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
		Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(config.getUsername(), config.getPassword());
                    }
                });
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(config.getUsername()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			Multipart multipart = new MimeMultipart();

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(messageBody, "text/html");

			if(!pathAttachment.equals("")) {
				MimeBodyPart attachmentBodyPart = new MimeBodyPart();
				attachmentBodyPart.attachFile(new File(pathAttachment));
				multipart.addBodyPart(attachmentBodyPart);
			}
			multipart.addBodyPart(mimeBodyPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getEmailTemplate(String url) {
		String mailBody = util.getStringJsonFile(url);
		return mailBody;
	}

	public String getVerificationMailMessageBody(String template, Users users) {
		template = template.replace("{{username}}", users.getUsername());
		String verificationUrl = getBaseUrl()+"user/validation/"+ users.getStringId();
		template = template.replace("{{url}}", verificationUrl);
		return template;
	}

	public String getBaseUrl() {
		if(env.getEnvirontment().equals(Constant.DEV_ENV)){
			return Constant.BASE_URL_DEV;
		}else {
			return Constant.BASE_URL_PROD;
		}
	}
}
