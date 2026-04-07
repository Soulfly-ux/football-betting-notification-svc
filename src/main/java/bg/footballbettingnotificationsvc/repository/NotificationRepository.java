package bg.footballbettingnotificationsvc.repository;

import bg.footballbettingnotificationsvc.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {

    List<Notification> findByUserIdOrderByCreatedOnDesc(UUID userId);

    List<Notification> findTop20ByUserIdOrderByCreatedOnDesc(UUID userId);

    Optional<Notification> findById (UUID notificationId);

    long countByUserIdAndIsReadFalse(UUID userId);

}
