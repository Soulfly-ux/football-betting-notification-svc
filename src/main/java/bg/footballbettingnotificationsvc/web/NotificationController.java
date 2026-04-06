package bg.footballbettingnotificationsvc.web;

import bg.footballbettingnotificationsvc.service.NotificationService;
import bg.footballbettingnotificationsvc.web.dto.NotificationRequest;
import bg.footballbettingnotificationsvc.web.dto.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications/")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PutMapping
    public ResponseEntity<NotificationResponse> create(@RequestBody NotificationRequest notificationRequest) {

        NotificationResponse createdNotification = notificationService.createNotification(notificationRequest);

        return ResponseEntity.status(HttpStatus.OK)
                .body(createdNotification);
    }



}
