package banquemisr.challenge05.mapper;

import banquemisr.challenge05.DTO.TaskDTO;
import banquemisr.challenge05.entities.Task;

public class TasksMapper {
    public static TaskDTO mapToTasksDTO(Task tasks) {
        return new TaskDTO(
                tasks.getTaskId(),
                tasks.getTitle(),
                tasks.getDescription(),
                tasks.getStatus(),
                tasks.getPriority(),
                tasks.getDueDate()


        );
    }

    public static Task mapToTasks(TaskDTO tasksDTO) {
        return new Task(
                tasksDTO.getTaskId(),
                tasksDTO.getTitle(),
                tasksDTO.getDescription(),
                tasksDTO.getStatus(),
                tasksDTO.getPriority(),
                tasksDTO.getDueDate()

        );


    }
}
