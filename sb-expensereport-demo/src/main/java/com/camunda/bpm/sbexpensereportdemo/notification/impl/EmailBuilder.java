package com.camunda.bpm.sbexpensereportdemo.notification.impl;

import com.camunda.bpm.model.common.Participant;
import com.camunda.bpm.model.expenses.ExpenseReport;
import com.camunda.bpm.model.notification.Email;
import com.camunda.bpm.sbexpensereportdemo.config.TemplatesConfig;
import com.camunda.bpm.sbexpensereportdemo.exceptions.NotificationBuilderException;
import com.camunda.bpm.sbexpensereportdemo.notification.NotificationBuilder;
import com.camunda.bpm.sbexpensereportdemo.util.PropertyNames;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailBuilder implements NotificationBuilder<Email, ExpenseReport, EmailType> {

    private final Configuration freemarkerConfig;
    private final TemplatesConfig templatesConfig;

    public Email build(String key, ExpenseReport obj, EmailType emailType, Participant participant) throws NotificationBuilderException {

        String templateName = templatesConfig.getEmailTemplate().replace(templatesConfig.getTypeVariable(), emailType.getTypeName());
        String subjectTempName =  templatesConfig.getSubjectTemplate().replace(templatesConfig.getTypeVariable(), emailType.getTypeName());

        Template emailTemplate;
        Template subjectTemplate;

        try {
            emailTemplate = emailTemplate = freemarkerConfig.getTemplate(templateName);
            subjectTemplate = freemarkerConfig.getTemplate(subjectTempName);
        }
        catch(IOException e){
            throw new NotificationBuilderException(e);
        }

        Map model = new HashMap<String,String>();
        model.put(key, obj);

        Email email = new Email();
        email.setTo(participant.getEmail());
        try {
            email.setSubject(FreeMarkerTemplateUtils.processTemplateIntoString(subjectTemplate, model));
            email.setContent(FreeMarkerTemplateUtils.processTemplateIntoString(emailTemplate, model));
        } catch (IOException | TemplateException e) {
            throw new NotificationBuilderException(e);
        }

        return email;
    }
}
