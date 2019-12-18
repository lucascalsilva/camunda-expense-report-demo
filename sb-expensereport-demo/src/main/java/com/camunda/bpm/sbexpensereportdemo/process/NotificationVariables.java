package com.camunda.bpm.sbexpensereportdemo.process;

import com.camunda.bpm.model.common.Participant;
import com.camunda.bpm.sbexpensereportdemo.notification.impl.EmailType;
import org.camunda.bpm.engine.delegate.DelegateExecution;

public class NotificationVariables {

    public static Participant getParticipant(DelegateExecution delegateExecution){
        return (Participant) delegateExecution.getVariableLocal(ProcessConstants.VARIABLELOCAL_PARTICIPANT_NAME);
    }

    public static EmailType getEmailType(DelegateExecution delegateExecution){
        return EmailType.valueOf((String) delegateExecution.getVariableLocal(ProcessConstants.VARIABLELOCAL_EMAILTYPE_NAME));
    }
}
