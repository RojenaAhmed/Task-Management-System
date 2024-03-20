package banquemisr.challenge05.mapper;

import banquemisr.challenge05.DTO.TaskDTO;
import banquemisr.challenge05.entities.tasks;

public class TasksMapper {
    public static TaskDTO mapToTasksDTO (tasks tasks){
        return new TaskDTO(
                tasks.getTaskId(),
                tasks.getTitle(),
                tasks.getDescription(),
                tasks.getStatus(),
                tasks.getPriority(),
                tasks.getDueDate()


        );
    }
    public static tasks mapToTasks(TaskDTO tasksDTO){
        return new tasks(
                tasksDTO.getTaskId(),
                tasksDTO.getTitle(),
                tasksDTO.getDescription(),
                tasksDTO.getStatus(),
                tasksDTO.getPriority(),
                tasksDTO.getDueDate()

        );


    }
}
