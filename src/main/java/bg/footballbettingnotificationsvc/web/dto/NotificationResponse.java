package bg.footballbettingnotificationsvc.web.dto;

import bg.footballbettingnotificationsvc.model.NotificationStatus;
import bg.footballbettingnotificationsvc.model.NotificationType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Builder
public class NotificationResponse {

    private UUID id;

    private String title;

    private String message;

    private NotificationType type;

    private NotificationStatus status;

    private LocalDateTime createdOn;
}
