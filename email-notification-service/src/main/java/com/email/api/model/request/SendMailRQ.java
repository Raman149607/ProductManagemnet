package com.email.api.model.request;

import java.util.Map;

public class SendMailRQ {
	
	private String to;

    private String subject;

    private Long templateNumber;

    private Map<String, Object> values;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getTemplateNumber() {
		return templateNumber;
	}

	public void setTemplateNumber(Long templateNumber) {
		this.templateNumber = templateNumber;
	}

	public Map<String, Object> getValues() {
		return values;
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}

}
