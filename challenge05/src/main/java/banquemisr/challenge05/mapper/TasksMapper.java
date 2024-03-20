package banquemisr.challenge05.mapper;

import banquemisr.challenge05.DTO.TasksDTO;
import banquemisr.challenge05.entities.Tasks;

public class TasksMapper {
    public static TasksDTO mapToTasksDTO (Tasks tasks){
        return new TasksDTO(
                tasks.getTaskId(),
                tasks.getTitle(),
                tasks.getDescription(),
                tasks.getStatus(),
                tasks.getPriority(),
                tasks.getDueDate()


        );
    }
    public static Tasks mapToTasks(TasksDTO tasksDTO){
        return new Tasks (
                tasksDTO.getTaskId(),
                tasksDTO.getTitle(),
                tasksDTO.getDescription(),
                tasksDTO.getStatus(),
                tasksDTO.getPriority(),
                tasksDTO.getDueDate()

        );


    }
}
