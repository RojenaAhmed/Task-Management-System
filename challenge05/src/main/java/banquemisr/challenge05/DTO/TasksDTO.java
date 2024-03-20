package banquemisr.challenge05.DTO;


import banquemisr.challenge05.AlertStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TasksDTO {

    private Long taskId;

    private String title;

    private String description;

    private AlertStatus status;

    private Long priority;

    private String dueDate;


}

