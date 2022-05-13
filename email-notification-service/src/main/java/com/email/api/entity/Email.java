package com.email.api.entity;

import javax.persistence.*;

@Entity
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String templateName;

	@Column(unique = true)
	private Long templateNumber;

	@Lob
	@Column(length = 8192)
	private String template;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Long getTemplateNumber() {
		return templateNumber;
	}

	public void setTemplateNumber(Long templateNumber) {
		this.templateNumber = templateNumber;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
