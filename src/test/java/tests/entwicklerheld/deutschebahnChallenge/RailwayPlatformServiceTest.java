package tests.entwicklerheld.deutschebahnChallenge;

import static java.time.LocalDateTime.parse;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
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
//        assertEquals("ICE 698", actual.get(0).trainNumber);
//        assertEquals("ICE 94", actual.get(1).trainNumber);
//        assertEquals("ICE 34", actual.get(2).trainNumber);
//        assertEquals("ICE 17", actual.get(3).trainNumber);
//        assertEquals("ICE 90", actual.get(4).trainNumber);
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
//        assertEquals("ICE 698", actual.get(0).trainNumber);
//        assertEquals("ICE 94", actual.get(1).trainNumber);
//        assertEquals("ICE 34", actual.get(2).trainNumber);
//        assertEquals("ICE 17", actual.get(3).trainNumber);
//        assertEquals("ICE 90", actual.get(4).trainNumber);
    }

    @Test
    public void scenario2BTest() {
        //given
        List<Board> arrivals =
                List.of(
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
//        assertEquals("ICE 698", actual.get(0).trainNumber);
//        assertEquals("ICE 94", actual.get(1).trainNumber);
//        assertEquals("ICE 34", actual.get(2).trainNumber);
//        assertEquals("ICE 17", actual.get(3).trainNumber);
//        assertEquals("ICE 90", actual.get(4).trainNumber);
    }

    @Test
    public void minNumbersTest() {
        //GIVEN
        List<TrainStop> trainStopList = new ArrayList<>();
        trainStopList.add(TrainStop.builder()
                                .trainNumber("ICE 618")
                                .arrival(LocalDateTime.of(2021, 8, 1, 9, 0))
                                .departure(LocalDateTime.of(2021, 8, 1, 9, 10))
                                .build());
        trainStopList.add(TrainStop.builder()
                                .trainNumber("ICE 618")
                                .arrival(LocalDateTime.of(2021, 8, 1, 9, 40))
                                .departure(LocalDateTime.of(2021, 8, 1, 12, 0))
                                .build());
        trainStopList.add(TrainStop.builder()
                                .trainNumber("ICE 618")
                                .arrival(LocalDateTime.of(2021, 8, 1, 9, 50))
                                .departure(LocalDateTime.of(2021, 8, 1, 11, 50))
                                .build());
        trainStopList.add(TrainStop.builder()
                                .trainNumber("ICE 618")
                                .arrival(LocalDateTime.of(2021, 8, 1, 11, 0))
                                .departure(LocalDateTime.of(2021, 8, 1, 11, 30))
                                .build());
        trainStopList.add(TrainStop.builder()
                                .trainNumber("ICE 618")
                                .arrival(LocalDateTime.of(2021, 8, 1, 15, 0))
                                .departure(LocalDateTime.of(2021, 8, 1, 19, 0))
                                .build());
        trainStopList.add(TrainStop.builder()
                                .trainNumber("ICE 618")
                                .arrival(LocalDateTime.of(2021, 8, 1, 18, 0))
                                .departure(LocalDateTime.of(2021, 8, 1, 20, 0))
                                .build());
        //WHEN
        int minPlatforms = railwayPlatformService.calculateMinimumNumberOfPlatforms(trainStopList);

        //THEN
        assertEquals(3, minPlatforms);
    }

    @Test
    public void minNumbersSimpleTest() {
        //GIVEN
        List<TrainStop> trainStopList = new ArrayList<>();
        trainStopList.add(TrainStop.builder()
                .trainNumber("ICE 618")
                .arrival(LocalDateTime.of(2021, 8, 1, 9, 0))
                .departure(LocalDateTime.of(2021, 8, 1, 9, 10))
                .build());
        trainStopList.add(TrainStop.builder()
                .trainNumber("ICE 618")
                .arrival(LocalDateTime.of(2021, 8, 1, 9, 10))
                .departure(LocalDateTime.of(2021, 8, 1, 9, 20))
                .build());
        //WHEN
        int minPlatforms = railwayPlatformService.calculateMinimumNumberOfPlatforms(trainStopList);

        //THEN
        assertEquals(2, minPlatforms);
    }


    @Test
    public void ulmTest() throws IOException {
        //GIVEN
        ObjectMapper mapper = new ObjectMapper();
        List<Board> arrivals =
                Arrays.asList(mapper.readValue(new ClassPathResource("uml_arrivals.json", getClass().getClassLoader()).getInputStream(), Board[].class));
        List<Board> departures =
                Arrays.asList(mapper.readValue(new ClassPathResource("uml_departures.json", getClass().getClassLoader()).getInputStream(), Board[].class));

        //WHEN
        List<TrainStop> actual = railwayPlatformService.convertBoardsToTrainStops(arrivals, departures);
        int minPlatforms = railwayPlatformService.calculateMinimumNumberOfPlatforms(actual);

        //THEN
        assertEquals(6852, actual.size());
        assertEquals(3, minPlatforms);
    }

    @Test
    public void dresdenTest() throws IOException {
        //GIVEN
        ObjectMapper mapper = new ObjectMapper();
        List<Board> arrivals =
                Arrays.asList(mapper.readValue(new ClassPathResource("dresden_arrivals.json", getClass().getClassLoader()).getInputStream(), Board[].class));
        List<Board> departures =
                Arrays.asList(mapper.readValue(new ClassPathResource("dresden_departures.json", getClass().getClassLoader()).getInputStream(), Board[].class));

        //WHEN
        List<TrainStop> actual = railwayPlatformService.convertBoardsToTrainStops(arrivals, departures);
        int minPlatforms = railwayPlatformService.calculateMinimumNumberOfPlatforms(actual);

        //THEN
        assertEquals(11662, actual.size());
        assertEquals(3, minPlatforms);
    }

    @Test
    public void berlinTest() throws IOException {
        //GIVEN
        ObjectMapper mapper = new ObjectMapper();
        List<Board> arrivals =
                Arrays.asList(mapper.readValue(new ClassPathResource("berlin_arrivals.json", getClass().getClassLoader()).getInputStream(), Board[].class));
        List<Board> departures =
                Arrays.asList(mapper.readValue(new ClassPathResource("berlin_departures.json", getClass().getClassLoader()).getInputStream(), Board[].class));

        //WHEN
        List<TrainStop> actual = railwayPlatformService.convertBoardsToTrainStops(arrivals, departures);
        int minPlatforms = railwayPlatformService.calculateMinimumNumberOfPlatforms(actual);

        //THEN
        assertEquals(13523, actual.size());
        assertEquals(6, minPlatforms);
    }

    @Test
    public void customTest() throws IOException {
        //GIVEN
        List<String> allLinesText = Files.readAllLines(new ClassPathResource("custom.txt", getClass().getClassLoader()).getFile().toPath(), Charset.defaultCharset());
        List<TrainStop> actual = extractTrainStop(allLinesText);

        //WHEN

        int minPlatforms = railwayPlatformService.calculateMinimumNumberOfPlatforms(actual);

        //THEN
        assertEquals(3, minPlatforms);
    }

    private List<TrainStop> extractTrainStop(List<String> allLinesText) {
        List<TrainStop> trainStopList = new ArrayList<>();

        for(String line: allLinesText) {
            int datesSize = " 2021-05-03T04:59 - 2021-05-03T05:19".length();
            int lineSize = line.length();

            String trainName = line.substring(0, lineSize-datesSize).trim();
            String[] dateTimes = line.substring(lineSize-datesSize).trim().split(" - ");
            String arrivalDateTime = dateTimes[0].trim();
            String departureDateTime = dateTimes[1].trim();

            trainStopList.add(TrainStop.builder()
                    .trainNumber(trainName)
                    .arrival(parse(arrivalDateTime, ISO_DATE_TIME))
                    .departure(parse(departureDateTime, ISO_DATE_TIME))
                    .build());
        }


        return trainStopList;
    }
}