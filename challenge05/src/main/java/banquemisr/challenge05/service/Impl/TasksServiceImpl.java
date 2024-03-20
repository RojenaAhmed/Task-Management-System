package banquemisr.challenge05.service.Impl;

import banquemisr.challenge05.DTO.TasksDTO;
import banquemisr.challenge05.email.EmailService;
import banquemisr.challenge05.entities.Tasks;
import banquemisr.challenge05.exception.TasksNotFoundExceptions;
import banquemisr.challenge05.mapper.TasksMapper;
import banquemisr.challenge05.repository.TasksRepository;
import banquemisr.challenge05.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public TasksDTO createTasks(TasksDTO tasksDTO) {

        Tasks tasks = TasksMapper.mapToTasks(tasksDTO);
        Tasks savedTasks = tasksRepository.save(tasks);
        return TasksMapper.mapToTasksDTO(savedTasks);
    }

    @Override
    public TasksDTO getTasksById(Long tasksId) {
        Tasks tasks = tasksRepository.findById(tasksId)
                .orElseThrow(() ->
                        new TasksNotFoundExceptions("Tasks is not exist : " + tasksId));


        return TasksMapper.mapToTasksDTO(tasks);
    }


    @Override
    public List<TasksDTO> getAllEmployees() {
        List<Tasks> tasks = tasksRepository.findAll();
        return tasks.stream().map((tasks1) -> TasksMapper.mapToTasksDTO((Tasks) tasks))
                .collect(Collectors.toList());

    }


    @Override
    public TasksDTO updateTasks(Long tasksId, TasksDTO updatedTasks) {
        Tasks tasks = tasksRepository.findById(tasksId).orElseThrow(
                () -> new TasksNotFoundExceptions("Tasks is not exist" + tasksId)
        );
        tasks.setTaskId(updatedTasks.getTaskId());
        tasks.setDescription(updatedTasks.getDescription());
        tasks.setStatus(updatedTasks.getStatus());
        tasks.setPriority(updatedTasks.getPriority());
        tasks.setDueDate(updatedTasks.getDueDate());
        Tasks updatedTasksObj = tasksRepository.save(tasks);
        sendEmailToAdmin();
        return TasksMapper.mapToTasksDTO(updatedTasksObj);
    }


    @Override
    public void deleteTasks(Long tasksId) {
        Tasks tasks = tasksRepository.findById(tasksId).orElseThrow(
                () -> new TasksNotFoundExceptions("Tasks is not exist " + tasksId)

        );

        tasksRepository.deleteById(tasksId);
        sendEmailToAdmin();
    }

    private void sendEmailToAdmin() {
        emailService.sendEmail(ADMIN_EMAIL,SUBJECT,BODY);
    }

    @Override
    public Page<Tasks> filterAndPaginate(String title, Pageable pageable) {
        return tasksRepository.findByTitleContainingIgnoreCase(title,pageable);
    }


}
