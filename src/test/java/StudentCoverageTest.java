import edu.course.eventplanner.model.Guest;
import edu.course.eventplanner.model.Venue;
import edu.course.eventplanner.service.SeatingPlanner;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class StudentCoverageTest {
    @Test
    void testSeatingPlannerCoverage() {
        Venue v = new Venue("TestVenue", 100, 10, 5, 2);
        SeatingPlanner planner = new SeatingPlanner(v);
        Map<Integer, List<Guest>> result = planner.generateSeating(Collections.emptyList());
        assertNotNull(result);
    }
}