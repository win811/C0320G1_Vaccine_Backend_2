package com.c0320g1.vaccine2.controller;


import com.c0320g1.vaccine2.model.Patient;
import com.c0320g1.vaccine2.model.VerifyToken;
import com.c0320g1.vaccine2.service.EmailService;
import com.c0320g1.vaccine2.service.VerifyTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class BookHistoryController {


    //    CREATE BY ANH ĐỨC
    @Autowired
    private VerifyTokenService verifyTokenService;
    @Autowired
    private EmailService emailService;

    //    CREATE BY ANH ĐỨC
    @PostMapping("bookHistory/verify")
    public ResponseEntity<Map<String, Object>> sendToken(@RequestBody String email) throws MessagingException {
        Map<String, Object> response = new HashMap<>();
        verifyTokenService.deleteAllByEmail(email);
        Random random = new Random();
        int number = random.nextInt(899999) + 100000;
        LocalDateTime timNow = LocalDateTime.now();
        VerifyToken verifyToken = new VerifyToken();
        verifyToken.setEmail(email);
        verifyToken.setCode(String.valueOf(number));
        verifyToken.setTimeCreate(timNow);
        verifyTokenService.save(verifyToken);
        String code = "Mã xác thực : " + String.valueOf(number);
        emailService.sendSimpleHTMLMessage(email, code, "");
        response.put("status", HttpStatus.OK);
        response.put("message", "Mã xác nhận đã được gửi về email của bạn, vui lòng kiểm tra email");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //    CREATE BY ANH ĐỨC
    @PostMapping("bookHistory/verifyCode")
    public ResponseEntity<Map<String, Object>> verifyCode(@RequestBody Patient patient) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (!verifyTokenService.checkTokenVerify(patient.getEmail(), patient.getCode())) {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Mã xác minh không chính xác hoặc đã hết hạn, vui lòng lấy mã xác minh mới");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Mã xác minh không chính xác hoặc đã hết hạn, vui lòng lấy mã xác minh mới");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        verifyTokenService.deleteAllByEmail(patient.getEmail());
        response.put("status", HttpStatus.OK);
        response.put("message", "Xác minh thành công ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //    CREATE BY ANH ĐỨC
    @PostMapping("injection/registration")
    public ResponseEntity<Map<String, Object>> registration(@RequestBody InjectionHistory injectionHistory) {
        Map<String, Object> response = new HashMap<>();
        if (vaccineService.findById(injectionHistory.getVaccine().getId()) == null) {
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Vắc xin này không tồn tại ");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            injectionHistory.setPatient(patientService.checkPatient(injectionHistory.getPatient()));
        } catch (Exception ex
        ) {
            System.out.println(ex);
        }
//        Kiểm tra xem bệnh nhân đã tồn tại hay chưa, nếu chưa sẽ tạo mới bệnh nhân vào database rồi trả về
        injectionHistory.setRegisterType("yêu cầu");
        injectionHistory.setIsInjected("chưa tiêm");
        injectionHistory.setReponseContent("chưa xác định");
        this.injectionHistoryService.save(injectionHistory);
        String email = injectionHistory.getPatient().getEmail();
        String text = "Bạn đã đăng ký tiêm chủng theo yêu cầu vào ngày " + injectionHistory.getInjectionDate().getDayOfMonth() + " tháng " +
                injectionHistory.getInjectionDate().getMonthValue() + " tại trung tâm tiêm chủng vắc xin C0320G1-Center - địa chỉ : " +
                "34 Cao Xuân Huy, Khuê trung, Cẩm Lệ, Đà nẵng. Khi đi vui lòng mang theo chứng minh thư, Xin cảm ơn!";
        try {
            this.emailService.sendSimpleHTMLMessage(email, "Đăng ký tiêm thành công", text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        response.put("status", HttpStatus.OK);
        response.put("message", "Đăng kí tiêm chủng theo yêu cầu thành công ! ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
