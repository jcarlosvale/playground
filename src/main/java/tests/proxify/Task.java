//package tests.proxify;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Objects;
//import java.util.Optional;
//import java.util.logging.Logger;
//
//@Entity
//class Task {
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String description;
//    private Long priority;
//
//    public Task() {}
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setPriority(Long priority) {
//        this.priority = priority;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public TaskDto toDto() {
//        return new TaskDto(description, priority);
//    }
//}
//
//@RestController
//@RequestMapping("/tasks")
//class TaskController {
//  private static Logger log = Logger.getLogger("Solution");
//  // log.info("You can use 'log' for debug messages");
//
//
//    private final TaskRepository repository;
//
//    TaskController(final TaskRepository repository) {
//        this.repository = repository;
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<TaskDto> updateOne(@PathVariable("id") long id, @RequestBody TaskDto dto) {
//        final Optional<Task> optionalEntity = repository.findById(id);
//
//        if (optionalEntity.isEmpty())
//            return ResponseEntity.status(404).body(new TaskDto("Cannot find task with given id", 404));
//
//        if (Objects.isNull(dto.getDescription()))
//            return ResponseEntity.status(400).body(new TaskDto("Task description is required", 400));
//
//        var entity = optionalEntity.get();
//        entity.setDescription(dto.getDescription());
//        entity.setPriority(dto.getPriority());
//        repository.save(entity);
//        return ResponseEntity.status(200).body(new TaskDto(dto.getDescription(), dto.getPriority()));
//    }
//}
//
//@Repository
//interface TaskRepository extends JpaRepository<Task, Long> {
//
//}
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//class TaskDto {
//    private String description;
//    private String message;
//    private Long priority;
//    private Integer status;
//
//    public TaskDto(String message, Integer status) {
//        this.message = message;
//        this.status = status;
//    }
//
//    public TaskDto(String description, Long priority) {
//        this.description = description;
//        this.priority = priority;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public Long getPriority() {
//        return priority;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public static void main(String[] args) {
//        String s = "red2";
//        System.out.println(s.substring(s.length()-1, s.length()) + s.substring(0, s.length()-1));
//    }
//}
