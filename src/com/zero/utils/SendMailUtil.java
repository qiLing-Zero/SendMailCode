package com.zero.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/***
 * 
 * Copyright: Copyright (c) 2020 DHC SOFTWARE CO.,LTD
 * 
 * @Description: 发送邮件验证直接类
 *
 * @author: zhangbolu
 * @date: Jun 13, 2020 9:46:10 PM
 *
 */
public class SendMailUtil {
	/***
	 * 
	 * @Description: (这里用一句话描述这个方法的作用)
	 *
	 * @param toAddress 收件人邮箱号
	 * @param content   正文
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: zhangbolu
	 * @date: Jun 13, 2020 10:10:40 PM
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* Jun 13,
	 *        2020 zhangbolu v1.0.0 修改原因
	 */
	public static void send(String toAddress, String content) {
		Properties prop = new Properties();
		InputStream inStream = SendMailUtil.class.getClassLoader().getResourceAsStream("mail.properties");  //使用类加载器加载配置文件
		try {
			prop.load(inStream);
			String host = prop.getProperty("host");                                                         //主机号
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String from = prop.getProperty("from");
			String subject = prop.getProperty("subject");
			System.out.println("host="+host);
			System.out.println("username="+username);
			System.out.println("password="+password);
			System.out.println("from="+from);
			System.out.println("toAddress="+toAddress);
			System.out.println("subject="+subject);
			System.out.println("content="+content);
			BaseSendMailUtil.baseSend(host, username, password, from, toAddress, subject, content);         //发送
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
