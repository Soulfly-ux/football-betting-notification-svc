package bg.footballbettingnotificationsvc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnreadNotificationCountResponse {

    private long count;
}
