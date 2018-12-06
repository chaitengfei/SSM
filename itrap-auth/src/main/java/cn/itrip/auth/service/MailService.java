package cn.itrip.auth.service;

/**
 * 邮件发送接口
 * @author A
 *
 */
public interface MailService {
	public void sendActivationMail(String mailTo, String activationCode);
}
