package com.zero.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

/***
 * 
 * Copyright: Copyright (c) 2020 DHC SOFTWARE CO.,LTD
 * 
 * @Description: 发送邮件间接工具类
 *
 * @author: zhangbolu
 * @date: Jun 13, 2020 9:06:17 PM
 *
 */
public class BaseSendMailUtil {
	/***
	 * @Description: 发送邮件
	 *
	 * @param host      SMTP服务器的主机号
	 * @param username  去除@后面的邮箱账号
	 * @param password  开启POP3/SMTP设置的密码
	 * @param from      发件人
	 * @param toAddress 收件人
	 * @param subject   主题
	 * @param content   正文
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: zhangbolu
	 * @date: Jun 13, 2020 9:12:20 PM
	 *
	 */
	public static void baseSend(String host, String username, String password, String from, String toAddress,
			String subject, String content) {
		Properties prop = new Properties();
		prop.setProperty("mail.host", host);                                         //虚拟主机
		prop.setProperty("mail.smtp.auth", "true");                                  //指定验证为true
		Authenticator auth = new Authenticator() {                                   //创建验证器
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		try {
			MimeMessage msg = new MimeMessage(Session.getInstance(prop, auth));
			msg.setFrom(new InternetAddress(from));                                  //设置发件人
			msg.addRecipients(RecipientType.TO, toAddress);                          //设置收件人
			msg.setSubject(subject);                                                 //设置主题
			MimeMultipart parts = new MimeMultipart();                               //创建部件集对象
			MimeBodyPart part = new MimeBodyPart();                                  //创建一个部件
			part.setContent(content, "text/html;charset=utf-8");                     //设置邮件文本内容
			parts.addBodyPart(part);
			msg.setContent(parts);
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
