/**
 * ��
 * �ʼ�����   Ⱥ�� ����ģ��
 * ����  SimpleMailSender   MyAuthenticator  MailSenderInfo  ������
 *
 *
 *
 *
 */

public class SendMailDemo {

	public static void main(String[] args) {
		  // �����ʼ���������Ϣ
		  MailSenderInfo mailInfo = new MailSenderInfo();
		  mailInfo.setMailServerHost("smtp.163.com");               //�����ʼ��ķ�������IP(��������ַ)
		  mailInfo.setMailServerPort("25");              			//�����ʼ��ķ������Ķ˿�
		  mailInfo.setValidate(true);
		  
		  // �����û���
		  mailInfo.setUserName("15030610683@163.com");
		  //   ʹ����Ȩ��
		  mailInfo.setPassword("zhoukaixuan123");
		  // ����������
		  mailInfo.setFromAddress("15030610683@163.com");
		  // �ռ�������
		  mailInfo.setToAddress("18246068557@163.com");
		  // �ʼ�����
		  mailInfo.setSubject("����Java�������ʼ�");
		  // �ʼ�����
		  StringBuffer buffer = new StringBuffer();
		  buffer.append("����ԤԼ����  ���");
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
