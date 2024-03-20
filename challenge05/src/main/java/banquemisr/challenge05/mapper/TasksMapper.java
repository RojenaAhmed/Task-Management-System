package banquemisr.challenge05.mapper;

import banquemisr.challenge05.DTO.TaskDTO;
import banquemisr.challenge05.entities.task;

public class TasksMapper {
    public static TaskDTO mapToTasksDTO(task tasks) {
        return new TaskDTO(
                tasks.getTaskId(),
                tasks.getTitle(),
                tasks.getDescription(),
                tasks.getStatus(),
                tasks.getPriority(),
                tasks.getDueDate()


        );
    }

    public static task mapToTasks(TaskDTO tasksDTO) {
        return new task(
                tasksDTO.getTaskId(),
                tasksDTO.getTitle(),
                tasksDTO.getDescription(),
                tasksDTO.getStatus(),
                tasksDTO.getPriority(),
                tasksDTO.getDueDate()

        );


    }
}
