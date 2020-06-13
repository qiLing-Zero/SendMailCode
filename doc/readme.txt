使用邮箱发送验证码的步骤
1、注册一个进行发送邮件的邮箱(例如qq邮箱),在设置中开启邮箱的POP3/SMTP,注意注册邮箱的密码和开启POP3/SMTP设置的密码不一样,记住SMTP服务器的主机号,qq邮箱的是smtp.qq.com
2、在项目中加入jar包(mail.jar和activation.jar)
3、将此项目中com.zero.utils包下的两个工具类拷贝到项目中
4、在src目录下编写名为mail.properties的配置文件
   host=smtp.qq.com              //SMTP服务器的主机号,qq邮箱的是smtp.qq.com
   username=2582522704           //去除@后面的发件人邮箱账号
   password=                     //开启POP3/SMTP时得到的密码
   from=2582522704@qq.com        //发件人邮箱账号全名
   subject=\u9A8C\u8BC1\u7801    //邮件主题
5、使用
   SendMailUtil.send(toAddress,content)  参数1：收件人邮箱全称     参数2：收件人收到的正文(例如:您本次的验证码为+“6位随机数”+,于5分钟失效)
