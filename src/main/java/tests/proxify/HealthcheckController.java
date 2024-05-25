package tests.proxify;
//
//import com.fasterxml.jackson.annotation.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.http.*;
//
//import java.time.*;
//
//@RestController
//class HealthcheckController {
//
//    // Your solution
//
//    @GetMapping(value = "/healthcheck", produces = "application/json")
//    public ResponseEntity<HealthDto> healthcheck(@RequestParam(value = "format") final String format) {
//        if ("short".equals(format)) {
//            return ResponseEntity.ok(new HealthDto("OK", null));
//        }
//        if ("full".equals(format)) {
//            return ResponseEntity.ok(new HealthDto("OK", LocalDateTime.now()));
//        }
//
//        return ResponseEntity.badRequest().build();
//    }
//
//    @PutMapping(value = "/healthcheck", produces = "application/json")
//    public ResponseEntity<Void> healthcheckPut() {
//        return ResponseEntity.status(405).build();
//    }
//
//    @PostMapping(value = "/healthcheck", produces = "application/json")
//    public ResponseEntity<Void> healthcheckPost() {
//        return ResponseEntity.status(405).build();
//    }
//
//
//    @DeleteMapping(value = "/healthcheck", produces = "application/json")
//    public ResponseEntity<Void> healthcheckDelete() {
//        return ResponseEntity.status(405).build();
//    }
//
//}
//
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//class HealthDto {
//
//    private String status;
//
//    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//    private LocalDateTime currentTime;
//
//    public HealthDto(final String status, final LocalDateTime currentTime) {
//        this.status = status;
//        this.currentTime = currentTime;
//    }
//
//    public String getStatus() {
//        return this.status;
//    }
//
//    public void setStatus(final String status) {
//        this.status = status;
//    }
//
//    public LocalDateTime getCurrentTime() {
//        return this.currentTime;
//    }
//
//    public void setCurrentTime(final LocalDateTime currentTime) {
//        this.currentTime = currentTime;
//    }
//
//}