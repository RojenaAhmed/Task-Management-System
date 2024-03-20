package banquemisr.challenge05.service;
import banquemisr.challenge05.DTO.TasksDTO;
import banquemisr.challenge05.entities.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
public interface TasksService {
 TasksDTO createTasks(TasksDTO tasksDTO);

 TasksDTO getTasksById(Long taskId);

 List<TasksDTO> getAllEmployees();

 TasksDTO updateTasks(Long tasksId, TasksDTO updatedTasks);

 void deleteTasks(Long tasksId);

Page <Tasks> filterAndPaginate(String title , Pageable pageable);
}




