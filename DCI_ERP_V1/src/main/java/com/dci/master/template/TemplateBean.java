package com.dci.master.template;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "template_hdr", formCode = "F6152")
public class TemplateBean {

	private String templateName;
	private String description;
	private Boolean status;
	private int id;
	private String template_id;
	private String html_version;
	private String ccmail;
	private String bccmail;
	private String content;

	private String tomail;

	public String getTomail() {
		return tomail;
	}

	public void setTomail(String tomail) {
		this.tomail = tomail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@AuditLoggable(fieldName = "template_name", displayName = "TemplateName")

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	private String subject;

	@AuditLoggable(fieldName = "subject", displayName = "Subject")
	public String getSubject() {
		return subject;
	}

	@AuditLoggable(fieldName = "ccmail", displayName = "Ccmail")

	public String getCcmail() {
		return ccmail;
	}

	public void setCcmail(String ccmail) {
		this.ccmail = ccmail;
	}

	@AuditLoggable(fieldName = "bccmail", displayName = "Bccmail")

	public String getBccmail() {
		return bccmail;
	}

	public void setBccmail(String bccmail) {
		this.bccmail = bccmail;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@AuditLoggable(fieldName = "html_version", displayName = "Content")

	public String getHtml_version() {
		return html_version;
	}

	public void setHtml_version(String html_version) {
		this.html_version = html_version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	@AuditLoggable(fieldName = "description", displayName = "Description")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
