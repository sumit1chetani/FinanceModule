/**
 *
 */
package com.dci.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author paragon
 *
 */
@Component
public class MailConstants {

	public static String username;
	public static String password;
	public static String fromName;
	public static String fromMail;
	public static String sSubject;
	public static String sBodyTop;
	public static String sBody;
	public static String sBodyBtm;
	public static String sCategories;
	public static String tHead;
	public static String tBody;
	public static String tFoot;

	public static String senderId;
	public static String senderPass;
	public static String smtpHost;
	public static String smtpPort;
	public static String pendingRecepitHead;
	public static String pendingRecepitBody;
	public static String pendingRecepitFoot;
	public static String pendingRecepitBodyTop;
	public static String pendingRecepitBodyBtm;
	public static String pendingRecepitSubject;

	@Value("${SEND_GRID_USER}")
	public void setUserName(String username) {
		MailConstants.username = username;
	}

	@Value("${SEND_GRID_PASS}")
	public void setPassword(String password) {
		MailConstants.password = password;
	}

	@Value("${SEND_GRID_FROM_NAME}")
	public void setFromName(String fromName) {
		MailConstants.fromName = fromName;
	}

	@Value("${SEND_GRID_FROM_MAIL}")
	public void setFromMail(String fromMail) {
		MailConstants.fromMail = fromMail;
	}

	@Value("${RFQ_MAIL_SUBJECT}")
	public void setsSubject(String sSubject) {
		MailConstants.sSubject = sSubject;
	}

	@Value("${RFQ_MAIL_BODY_TOP}")
	public void setsBodyTop(String sBodyTop) {
		MailConstants.sBodyTop = sBodyTop;
	}

	@Value("${RFQ_MAIL_BODY}")
	public void setsBody(String sBody) {
		MailConstants.sBody = sBody;
	}

	@Value("${RFQ_MAIL_BODY_BTM}")
	public void setsBodyBtm(String sBodyBtm) {
		MailConstants.sBodyBtm = sBodyBtm;
	}

	@Value("${RFQ_MAIL_CATEGORIES}")
	public void setsCategories(String sCategories) {
		MailConstants.sCategories = sCategories;
	}

	@Value("${MAIL_TABLE_THEAD}")
	public void settHead(String tHead) {
		MailConstants.tHead = tHead;
	}

	@Value("${MAIL_TABLE_TBODY}")
	public void settBody(String tBody) {
		MailConstants.tBody = tBody;
	}

	@Value("${MAIL_TABLE_TFOOT}")
	public void settFoot(String tFoot) {
		MailConstants.tFoot = tFoot;
	}

	@Value("${SENDER_ID}")
	public void setSenderId(String senderId) {
		MailConstants.senderId = senderId;
	}

	@Value("${SENDER_PASS}")
	public void setSenderPass(String senderPass) {
		MailConstants.senderPass = senderPass;
	}

	@Value("${SMTP_HOST}")
	public void setSMTPHost(String smtpHost) {
		MailConstants.smtpHost = smtpHost;
	}

	@Value("${SMTP_PORT}")
	public void setSMTPPort(String smtpPort) {
		MailConstants.smtpPort = smtpPort;
	}

}
