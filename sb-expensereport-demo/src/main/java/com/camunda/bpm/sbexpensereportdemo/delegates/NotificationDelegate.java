package com.camunda.bpm.sbexpensereportdemo.delegates;

import com.camunda.bpm.model.common.Participant;
import com.camunda.bpm.model.expenses.ExpenseReport;
import com.camunda.bpm.sbexpensereportdemo.notification.impl.EmailType;
import com.camunda.bpm.sbexpensereportdemo.notification.NotificationBuilder;
import com.camunda.bpm.sbexpensereportdemo.process.ProcessConstants;
import com.camunda.bpm.sbexpensereportdemo.services.NotificationService;
import com.camunda.bpm.model.notification.Email;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static com.camunda.bpm.sbexpensereportdemo.process.NotificationVariables.getEmailType;
import static com.camunda.bpm.sbexpensereportdemo.process.NotificationVariables.getParticipant;
import static com.camunda.bpm.sbexpensereportdemo.process.ProcessVariablesUtil.*;

@Component
@RequiredArgsConstructor
public class NotificationDelegate implements JavaDelegate {

    private final NotificationBuilder<Email, ExpenseReport, EmailType> notificationBuilder;
    private final NotificationService<Email> notificationService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Participant participant = getParticipant(delegateExecution);
        EmailType emailType = getEmailType(delegateExecution);

        Email email = notificationBuilder.build(ProcessConstants.VARIABLE_EXPENSEREPORT_NAME,
                getExpenseReport(delegateExecution), emailType, participant);
        notificationService.send(email);
    }
}
