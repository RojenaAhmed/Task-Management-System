package banquemisr.challenge05.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NotificationID;
    @Column(name = "receive_email", nullable = false, unique = true)
    private String ReceiveEmail;
    @Column(name = "content")
    private String Content;

}
