package tests.entwicklerheld.deutschebahnChallenge;


import static java.time.LocalDateTime.parse;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tests.entwicklerheld.deutschebahnChallenge.models.Board;
import tests.entwicklerheld.deutschebahnChallenge.models.TrainStop;

public class RailwayPlatformService {

	private static final int BLOCK_PERIOD_IN_MINUTES = 20;
	private static final int MAX_INTERVAL_IN_MINUTES = 60;

	public List<TrainStop> convertBoardsToTrainStops(List<Board> arrivals, List<Board> departures) {

		List<TrainStop> trainStopList = new ArrayList<>();
		Map<String, List<Board>> arrivalsMap = generateMapOfBoards(arrivals);
		for(Board departure: departures) {
			String trainName = departure.name;
			if (arrivalsMap.containsKey(trainName)) {
				List<Board> arrivalsCandidateList = arrivalsMap.get(trainName);
				arrivalsCandidateList.sort(Comparator.comparing(o -> o.dateTime));
				Board arrival = binarySearch(arrivalsCandidateList, departure, 0, arrivalsCandidateList.size() - 1);
				if (arrival != null) {
					TrainStop trainStop = new TrainStop(trainName, parse(arrival.dateTime, ISO_DATE_TIME), parse(departure.dateTime, ISO_DATE_TIME));
					trainStopList.add(trainStop);
				}
			}
		}
		return trainStopList;

	}

	private Board binarySearch(List<Board> arrivalsCandidateList, Board departure, int start, int end) {
		if (start > end) return null;
		int middle = (start + end) / 2;
		long dateTimeDiffInMinutes = dateTimeDiff(departure.dateTime, arrivalsCandidateList.get(middle).dateTime);
		if (dateTimeDiffInMinutes >=0 && dateTimeDiffInMinutes <= MAX_INTERVAL_IN_MINUTES) {
			return arrivalsCandidateList.get(middle);
		}
		if (dateTimeDiffInMinutes > MAX_INTERVAL_IN_MINUTES) {
			return binarySearch(arrivalsCandidateList, departure, middle+1, end);
		} else {
			return binarySearch(arrivalsCandidateList, departure, start, middle-1);
		}
	}

	private static long dateTimeDiff(String strDepartureDateTime, String strArrivalDateTime) {
		LocalDateTime departureDateTime = parse(strDepartureDateTime, ISO_DATE_TIME);
		LocalDateTime arrivalDateTime = parse(strArrivalDateTime, ISO_DATE_TIME);
		return Duration.between(arrivalDateTime, departureDateTime).toMinutes();
	}

	private Map<String, List<Board>> generateMapOfBoards(final List<Board> boards) {

		final Map<String, List<Board>> boardsMap = new HashMap<>();
		for(Board arrival: boards) {
			if(boardsMap.containsKey(arrival.name)) {
				boardsMap.get(arrival.name).add(arrival);
			} else {
				List<Board> boardList = new ArrayList<>();
				boardList.add(arrival);
				boardsMap.put(arrival.name, boardList);
			}
		}
		return boardsMap;
	}

	public int calculateMinimumNumberOfPlatforms(List<TrainStop> trainStops) {
		return 0;
	}


	public static void main(String[] args) {
		System.out.println(dateTimeDiff("2021-12-21T16:52:32+00:00", "2021-12-21T16:32:32+00:00"));
		System.out.println(dateTimeDiff("2021-12-21T16:52:32+00:00", "2021-12-21T17:52:32+00:00"));

	}

}