package bg.footballbettingnotificationsvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

      @ExceptionHandler(NotificationNotFoundException.class)
      public ResponseEntity<String> handleNotificationNotFoundException(NotificationNotFoundException ex) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .body(ex.getMessage());
      }


      @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAnyException(Exception exception) {

          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body("Unexpected server error");

      }

      @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException exception) { // Добре е параметър да е грешката, която обработваме
          return ResponseEntity.badRequest().body("Invalid notification request");
      }
}
