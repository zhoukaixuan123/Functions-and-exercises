

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 * @Auther: kaixuan
 * @Date: 2019/2/13 10:34
 * @Description:    java 邮件发送
 */
public class JavaMailStudy {

    public static void main(String[] args) {
        // 设置邮件服务器信息
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");               //发送邮件的服务器的IP(或主机地址)
        mailInfo.setMailServerPort("25");              			//发送邮件的服务器的端口
        mailInfo.setValidate(true);

        // 邮箱用户名
        mailInfo.setUserName("m15140127373_1@163.com");
        // 邮箱密码
        mailInfo.setPassword("456258");
        // 发件人邮箱
        mailInfo.setFromAddress("m15140127373_1@163.com");
        // 收件人邮箱
        mailInfo.setToAddress("278473051@qq.com");
        // 邮件标题
        mailInfo.setSubject("测试Java程序发送邮件");
        // 邮件内容
        StringBuffer buffer = new StringBuffer();
        buffer.append("在线预约测试");
        mailInfo.setContent(buffer.toString());

        // 发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        // 发送文体格式
        sms.sendTextMail(mailInfo);
        // 发送html格式
        SimpleMailSender.sendHtmlMail(mailInfo);
        System.out.println("邮件发送完毕");
    }




}
