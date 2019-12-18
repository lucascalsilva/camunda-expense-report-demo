package com.camunda.bpm.servicesdemo.util;

public class PropertyNames {

    public static final String SPRING_MAIL_USERNAME = "${spring.mail.username}";
    public static final String SCHEDULER_EMAIL_DELAYTIME = "${scheduler.mail.delayTime}";
    public static final String CAMUNDA_REST_URL = "${camunda.rest.url}";
    public static final String CAMUNDA_REST_EXPENSE_REPORT_PROCESS_START_PATH = "${camunda.rest.expense-report-process.start-path}";
    public static final String CAMUNDA_REST_EXPENSE_REPORT_PROCESS_CANCEL_PATH = "${camunda.rest.expense-report-process.cancel-path}";
    public static final String CAMUNDA_REST_TIMEOUT = "${camunda.rest.timeout}";
}
