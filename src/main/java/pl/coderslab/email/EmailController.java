package pl.coderslab.email;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail(EmailDetails details) {
        details.setToEmail("podaj tu maila");
        details.setMsgBody("Cześć! Twoje konto zostało utworzone.");
        details.setSubject("Simple Email Message");
        String status = emailService.sendSimpleMail(details);
        return status;
    }

//    @Autowired
//    private EmailService2 emailService2;
//
//    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
//    public String sendEmail(){
//        emailService2.send("podaj tu maila","Sending Email","Twoje konto zostało utworzone");
//        return "/index";
//    }
}
