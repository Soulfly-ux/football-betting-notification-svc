package bg.footballbettingnotificationsvc.web;


import bg.footballbettingnotificationsvc.service.NotificationService;
import bg.footballbettingnotificationsvc.web.dto.NotificationRequest;
import bg.footballbettingnotificationsvc.web.dto.NotificationResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<NotificationResponse> create(@Valid @RequestBody NotificationRequest notificationRequest) {

        NotificationResponse createdNotification = notificationService.createNotification(notificationRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdNotification);
    }


    @GetMapping("/users/{userId}")
    public ResponseEntity<List<NotificationResponse>> getNotificationsByUser(@PathVariable UUID userId) {


        List<NotificationResponse> userNotifications = notificationService.getUserNotifications(userId);


        return ResponseEntity.status(HttpStatus.OK)
                .body(userNotifications);
    }


    @PatchMapping("/{notificationId}/read")
    public ResponseEntity<NotificationResponse> markAsRead( @PathVariable UUID notificationId) {

        NotificationResponse notificationResponse = notificationService.markAsRead(notificationId);

        return ResponseEntity.ok(notificationResponse);
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> delete(@PathVariable UUID notificationId) {

        notificationService.delete(notificationId);

       return ResponseEntity.noContent().build();


    }


}
