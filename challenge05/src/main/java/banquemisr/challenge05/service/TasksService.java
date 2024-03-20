package banquemisr.challenge05.service;
import banquemisr.challenge05.DTO.TaskDTO;
import banquemisr.challenge05.entities.tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
public interface TasksService {
 TaskDTO createTasks(TaskDTO tasksDTO);

 TaskDTO getTasksById(Long taskId);

 List<TaskDTO> getAllEmployees();

 TaskDTO updateTasks(Long tasksId, TaskDTO updatedTasks);

 void deleteTasks(Long tasksId);

Page <tasks> filterAndPaginate(String title , Pageable pageable);
}




