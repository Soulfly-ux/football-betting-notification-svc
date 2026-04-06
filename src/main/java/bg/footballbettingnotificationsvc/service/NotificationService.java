package bg.footballbettingnotificationsvc.service;

import bg.footballbettingnotificationsvc.model.Notification;
import bg.footballbettingnotificationsvc.model.NotificationStatus;
import bg.footballbettingnotificationsvc.repository.NotificationRepository;
import bg.footballbettingnotificationsvc.web.dto.NotificationRequest;
import bg.footballbettingnotificationsvc.web.dto.NotificationResponse;
import bg.footballbettingnotificationsvc.web.mapper.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Service
public class NotificationService {


   private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    public NotificationResponse createNotification(NotificationRequest notificationRequest) {

        Notification notification = Notification.builder()
                .userId(notificationRequest.getUserId())
                .title(notificationRequest.getTitle())
                .message(notificationRequest.getMessage())
                .type(notificationRequest.getType())
                .status(NotificationStatus.SUBMITTED)
                .createdOn(LocalDateTime.now())
                .isRead(false)
                .build();

        Notification savedNotification = notificationRepository.save(notification);


        return DtoMapper.mapFromNotification(savedNotification);
    }

    public List<NotificationResponse> getUserNotifications(UUID userId) {

        return notificationRepository.findByUserIdOrderByCreatedOnDesc(userId).stream()
                .map(DtoMapper::mapFromNotification).toList();
    }

    public NotificationResponse markAsRead(UUID notificationId) {

        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setIsRead(true);

        Notification savedNotification = notificationRepository.save(notification);


        return DtoMapper.mapFromNotification(savedNotification);
    }
}
