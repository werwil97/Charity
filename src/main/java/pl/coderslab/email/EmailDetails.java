package pl.coderslab.email;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {

    private String toEmail;
    private String msgBody;
    private String subject;
    private String attachment;
}
