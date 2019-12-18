package com.camunda.bpm.sbexpensereportdemo.notification;

import com.camunda.bpm.model.common.Participant;
import com.camunda.bpm.sbexpensereportdemo.exceptions.NotificationBuilderException;

public interface NotificationBuilder<T,Y,Z> {

    T build(String key, Y obj, Z notificationType, Participant participant) throws NotificationBuilderException;


}
