package banquemisr.challenge05.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class NotificationDTO {

    private Long notificationID;

    private String receiveEmail;

    private String content;
}
