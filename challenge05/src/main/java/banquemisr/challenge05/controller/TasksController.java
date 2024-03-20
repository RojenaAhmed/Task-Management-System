package banquemisr.challenge05.controller;

import banquemisr.challenge05.DTO.TasksDTO;
import banquemisr.challenge05.entities.Tasks;
import banquemisr.challenge05.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/api/tasks")
public class TasksController {

    private TasksService tasksService;



    // Build Add Tasks Rest API
    @PostMapping
    public ResponseEntity<TasksDTO> createTasks(@RequestBody TasksDTO tasksDTO) {
        TasksDTO savedTasks = tasksService.createTasks(tasksDTO);
        return new ResponseEntity<>(savedTasks, HttpStatus.CREATED);

    }

    //Build Get Tasks Rest API
    @GetMapping("{id}")
    public ResponseEntity<TasksDTO> getTasksById(@PathVariable("id") Long tasksId) {
        TasksDTO tasksDTO = tasksService.getTasksById(tasksId);
        return ResponseEntity.ok(tasksDTO);

}

    @GetMapping("/tasks")
    public Page<Tasks> filterAndPaginateTasks(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        return tasksService.filterAndPaginate(title,PageRequest.of(page,size));
    }


    // Build Get All Tasks Rest API
    public ResponseEntity<List<TasksDTO>> getAllTasks(){
    List<TasksDTO> tasks = tasksService.getAllEmployees();
      return ResponseEntity.ok(tasks);
    }

    // Build update Tasks Rest API
    @PutMapping("{id}")
    public ResponseEntity<TasksDTO> updateTask(@PathVariable("id")Long tasksId ,@RequestBody TasksDTO updatedTasks){
        TasksDTO tasksDTO = tasksService.updateTasks(tasksId , updatedTasks);
        return ResponseEntity.ok(tasksDTO);
    }

    // Build Delete Tasks Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTasks(Long tasksId){
        tasksService.deleteTasks(tasksId);
        return ResponseEntity.ok("Tasks deleted successfully!.");
    }


}
