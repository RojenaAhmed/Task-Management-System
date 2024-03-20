package banquemisr.challenge05.entities;

import banquemisr.challenge05.AlertStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table (name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TaskId ;

    @Column(name = "title")
    private String Title ;

    @Column(name = "description")
    private String Description ;

    @Enumerated(EnumType.STRING)
    private AlertStatus status;

    @Column(name = "priority")
    private Long Priority ;

    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    @Column(name = "duedate")
    private String DueDate ;

}
