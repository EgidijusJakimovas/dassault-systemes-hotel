import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private int number;
    private double price;
    private Guest guest;
    private List<RoomOccupancyHistory> occupancyHistory;

    public Room(int number, double price) {
        this.number = number;
        this.price = price;
        this.occupancyHistory = new ArrayList<>();
    }

    public boolean isOccupied() {
        return guest != null;
    }

    public void addOccupancyHistory(RoomOccupancyHistory history) {
        occupancyHistory.add(history);
    }
}
