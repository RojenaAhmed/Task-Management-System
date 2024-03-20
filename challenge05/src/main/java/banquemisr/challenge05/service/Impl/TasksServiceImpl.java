package banquemisr.challenge05.service.Impl;

import banquemisr.challenge05.DTO.TaskDTO;
import banquemisr.challenge05.email.EmailService;
import banquemisr.challenge05.entities.Task;
import banquemisr.challenge05.exception.TasksNotFoundExceptions;
import banquemisr.challenge05.mapper.TasksMapper;
import banquemisr.challenge05.repository.TasksRepository;
import banquemisr.challenge05.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TasksServiceImpl implements TasksService {

    private static final String ADMIN_EMAIL = "rojinaahmed@managementsystem.mailtrack.link";
    private static final String SUBJECT= "TASK UPDATE";
    private static final String BODY = "Kindly Check updates on tasks!";
    private final TasksRepository tasksRepository;
    private final EmailService emailService;
    @Override
    public TaskDTO createTasks(TaskDTO tasksDTO) {

        Task tasks = TasksMapper.mapToTasks(tasksDTO);
        Task savedTasks = tasksRepository.save(tasks);
        return TasksMapper.mapToTasksDTO(savedTasks);
    }

    @Override
    public TaskDTO getTasksById(Long tasksId) {
        Task tasks = tasksRepository.findById(tasksId)
                .orElseThrow(() ->
                        new TasksNotFoundExceptions("Tasks is not exist : " + tasksId));


        return TasksMapper.mapToTasksDTO(tasks);
    }


    @Override
    public List<TaskDTO> getAllEmployees() {
        List<Task> tasks = tasksRepository.findAll();
        return tasks.stream().map((tasks1) -> TasksMapper.mapToTasksDTO((Task) tasks))
                .collect(Collectors.toList());

    }


    @Override
    public TaskDTO updateTasks(Long tasksId, TaskDTO updatedTasks) {
        Task tasks = tasksRepository.findById(tasksId).orElseThrow(
                () -> new TasksNotFoundExceptions("Tasks is not exist" + tasksId)
        );
        tasks.setTaskId(updatedTasks.getTaskId());
        tasks.setDescription(updatedTasks.getDescription());
        tasks.setStatus(updatedTasks.getStatus());
        tasks.setPriority(updatedTasks.getPriority());
        tasks.setDueDate(updatedTasks.getDueDate());
        Task updatedTasksObj = tasksRepository.save(tasks);
        sendEmailToAdmin();
        return TasksMapper.mapToTasksDTO(updatedTasksObj);
    }


    @Override
    public void deleteTasks(Long tasksId) {
        Task tasks = tasksRepository.findById(tasksId).orElseThrow(
                () -> new TasksNotFoundExceptions("Tasks is not exist " + tasksId)

        );

        tasksRepository.deleteById(tasksId);
        sendEmailToAdmin();
    }

    private void sendEmailToAdmin() {
        emailService.sendEmail(ADMIN_EMAIL,SUBJECT,BODY);
    }

    @Override
    public Page<Task> filterAndPaginate(String title, Pageable pageable) {
        return tasksRepository.findByTitleContainingIgnoreCase(title,pageable);
    }


}
