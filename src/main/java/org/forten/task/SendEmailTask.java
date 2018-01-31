package org.forten.task;

import org.forten.scss.bo.SelectCourseBo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SendEmailTask {
    @Resource
    private SelectCourseBo bo;

    @Scheduled(cron="0 0 1/12 * * ?")
    public void sendWillBeginCourse(){
        bo.sendRemindEmail();
    }
}
