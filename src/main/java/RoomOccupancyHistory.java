import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomOccupancyHistory {
    private String guestName;
    private String guestSurname;
    private String checkInDate;
    private String checkOutDate;
}
