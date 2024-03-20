package banquemisr.challenge05.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO {

    private Long historyId;

    private Long taskId;

    private String actionType;

    private Long userId;

    private String actionDate;
}
