package tests.entwicklerheld.deutschebahnChallenge;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;
import tests.entwicklerheld.deutschebahnChallenge.models.Board;
import tests.entwicklerheld.deutschebahnChallenge.models.TrainStop;

public class RailwayPlatformServiceTest {

    RailwayPlatformService railwayPlatformService = new RailwayPlatformService();

    @Test
    public void scenario1Test() {
        //given
        List<Board> arrivals =
            List.of(
                    Board.builder().boardId("ICE 698").name("ICE 698").dateTime("2021-01-08T09:00:00+00:00").build(),
                    Board.builder().boardId("ICE 94").name("ICE 94").dateTime("2021-10-01T13:03:00+00:00").build(),
                    Board.builder().boardId("ICE 34").name("ICE 34").dateTime("2021-05-02T13:13:00+00:00").build(),
                    Board.builder().boardId("ICE 17").name("ICE 17").dateTime("2021-01-08T15:07:00+00:00").build(),
                    Board.builder().boardId("ICE 90").name("ICE 90").dateTime("2021-08-03T12:03:00+00:00").build()
                    );
        List<Board> departures =
                List.of(
                        Board.builder().boardId("ICE 698").name("ICE 698").dateTime("2021-01-08T09:10:00+00:00").build(),
                        Board.builder().boardId("ICE 94").name("ICE 94").dateTime("2021-10-01T13:15:00+00:00").build(),
                        Board.builder().boardId("ICE 34").name("ICE 34").dateTime("2021-05-02T13:19:00+00:00").build(),
                        Board.builder().boardId("ICE 17").name("ICE 17").dateTime("2021-01-08T15:20:00+00:00").build(),
                        Board.builder().boardId("ICE 90").name("ICE 90").dateTime("2021-08-03T12:09:00+00:00").build()
                        );
        //when
        List<TrainStop> actual = railwayPlatformService.convertBoardsToTrainStops(arrivals, departures);

        //then
        assertEquals(5, actual.size());
        assertEquals("ICE 698", actual.get(0).trainNumber);
        assertEquals("ICE 94", actual.get(1).trainNumber);
        assertEquals("ICE 34", actual.get(2).trainNumber);
        assertEquals("ICE 17", actual.get(3).trainNumber);
        assertEquals("ICE 90", actual.get(4).trainNumber);
    }

    @Test
    public void scenario2ATest() {
        //given
        List<Board> arrivals =
                List.of(
                        Board.builder().boardId("ICE 698").name("ICE 698").dateTime("2021-01-08T09:00:00+00:00").build(),
                        Board.builder().boardId("ICE 94").name("ICE 94").dateTime("2021-10-01T13:03:00+00:00").build(),
                        Board.builder().boardId("ICE 34").name("ICE 34").dateTime("2021-05-02T13:13:00+00:00").build(),
                        Board.builder().boardId("ICE 17").name("ICE 17").dateTime("2021-01-08T15:07:00+00:00").build(),
                        Board.builder().boardId("ICE 90").name("ICE 90").dateTime("2021-08-03T12:03:00+00:00").build()
                );
        List<Board> departures =
                List.of(
                        Board.builder().boardId("ICE 90").name("ICE 90").dateTime("2021-08-03T12:09:00+00:00").build()
                );
        //when
        List<TrainStop> actual = railwayPlatformService.convertBoardsToTrainStops(arrivals, departures);

        //then
        assertEquals(5, actual.size());
        assertEquals("ICE 698", actual.get(0).trainNumber);
        assertEquals("ICE 94", actual.get(1).trainNumber);
        assertEquals("ICE 34", actual.get(2).trainNumber);
        assertEquals("ICE 17", actual.get(3).trainNumber);
        assertEquals("ICE 90", actual.get(4).trainNumber);
    }
}