package com.camunda.bpm.servicesdemo.schedule;

import com.camunda.bpm.servicesdemo.services.impl.EmailService;
import com.camunda.bpm.servicesdemo.model.notification.Email;
import com.camunda.bpm.servicesdemo.repositories.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.camunda.bpm.servicesdemo.util.PropertyNames.SCHEDULER_EMAIL_DELAYTIME;

@Component
@RequiredArgsConstructor
public class ScheduleTasks {

    private final EmailRepository repository;
    private final EmailService emailAdapter;

    @Scheduled(fixedDelayString = SCHEDULER_EMAIL_DELAYTIME)
    public void sendEmails(){
        List<Email> emailsToSend = repository.findBySent(false);
        if(emailsToSend.size() > 0){
            List<Email> emailsSent = emailAdapter.sendBatch(emailsToSend);
            repository.saveAll(emailsSent);
        }
    }
}
