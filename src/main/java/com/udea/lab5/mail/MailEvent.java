package com.udea.lab5.mail;

import com.udea.lab5.com.udea.lab5.modelo.User;

public class MailEvent {

    private final User user;
    private final String subjectTemplate;
    private final String contentTemplate;

    public MailEvent(User user, String subjectTemplate, String contentTemplate) {
        this.user = user;
        this.subjectTemplate = subjectTemplate;
        this.contentTemplate = contentTemplate;
    }

    public User getUser() {
        return user;
    }

    public String getSubjectTemplate() {
        return subjectTemplate;
    }

    public String getContentTemplate() {
        return contentTemplate;
    }

}
