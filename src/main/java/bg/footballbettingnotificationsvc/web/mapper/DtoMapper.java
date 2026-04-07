package bg.footballbettingnotificationsvc.web.mapper;

import bg.footballbettingnotificationsvc.model.Notification;
import bg.footballbettingnotificationsvc.web.dto.NotificationResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoMapper {


    public NotificationResponse mapFromNotification(Notification notification) {



        return NotificationResponse.builder()
                .id(notification.getId())
                .title(notification.getTitle())
                .message(notification.getMessage())
                .type(notification.getType())
                .status(notification.getStatus())
                .createdOn(notification.getCreatedOn())
                .isRead(notification.getIsRead())
                .build();
    }
}
