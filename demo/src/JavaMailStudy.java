

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 * @Auther: kaixuan
 * @Date: 2019/2/13 10:34
 * @Description:    java �ʼ�����
 */
public class JavaMailStudy {

    public static void main(String[] args) {
        // �����ʼ���������Ϣ
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");               //�����ʼ��ķ�������IP(��������ַ)
        mailInfo.setMailServerPort("25");              			//�����ʼ��ķ������Ķ˿�
        mailInfo.setValidate(true);

        // �����û���
        mailInfo.setUserName("m15140127373_1@163.com");
        // ��������
        mailInfo.setPassword("456258");
        // ����������
        mailInfo.setFromAddress("m15140127373_1@163.com");
        // �ռ�������
        mailInfo.setToAddress("278473051@qq.com");
        // �ʼ�����
        mailInfo.setSubject("����Java�������ʼ�");
        // �ʼ�����
        StringBuffer buffer = new StringBuffer();
        buffer.append("����ԤԼ����");
        mailInfo.setContent(buffer.toString());

        // �����ʼ�
        SimpleMailSender sms = new SimpleMailSender();
        // ���������ʽ
        sms.sendTextMail(mailInfo);
        // ����html��ʽ
        SimpleMailSender.sendHtmlMail(mailInfo);
        System.out.println("�ʼ��������");
    }




}
