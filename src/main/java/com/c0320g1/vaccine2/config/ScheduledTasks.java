package com.c0320g1.vaccine2.config;


import com.c0320g1.vaccine2.model.VaccineRoadDetails;
import com.c0320g1.vaccine2.service.EmailService;
import com.c0320g1.vaccine2.service.VaccineRoadDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private EmailService emailService;

    @Autowired
    private VaccineRoadDetailsService vaccineRoadDetailsService;

    @Scheduled(cron = "0 30 8 ? * *")
    public void remind() {
        List<VaccineRoadDetails> vaccineRoadDetailsList = this.vaccineRoadDetailsService.findAll();
        int todayInYear = LocalDateTime.now().getDayOfYear();
        vaccineRoadDetailsList.forEach(vaccineRoadDetails -> {
            LocalDate injectionDate = vaccineRoadDetails.getInjectionDate();
            if (injectionDate.getDayOfYear() - todayInYear == 1) {
                String email = vaccineRoadDetails.getVaccineRoad().getPatient().getEmail();
                String text = "Bạn có lịch tiêm chủng vào ngày " + injectionDate.getDayOfMonth() + " tháng " +
                        injectionDate.getMonthValue() + " tại trung tâm tiêm chủng vắc xin C0320G1-Center - Địa chỉ : " +
                        "295 Nguyễn Tất Thành, Đà nẵng. Khi đi vui lòng mang theo chứng minh thư, Xin cảm ơn!";
                try {
                    this.emailService.sendSimpleHTMLMessage(email,"Thư nhắc tiêm chủng",text);
                    logger.info("Đã gửi mail báo");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
