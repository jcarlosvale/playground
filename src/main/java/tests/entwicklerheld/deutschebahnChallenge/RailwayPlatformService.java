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
import java.util.stream.Collectors;
import tests.entwicklerheld.deutschebahnChallenge.models.Board;
import tests.entwicklerheld.deutschebahnChallenge.models.TrainStop;

class BoardTime {

	private final Board board;
	private final boolean isArrival;
	private final LocalDateTime dateTime;

	public BoardTime(Board board, boolean isArrival, LocalDateTime dateTime) {
		this.board = board;
		this.isArrival = isArrival;
		this.dateTime = dateTime;
	}

	public Board getBoard() {
		return board;
	}

	public boolean isArrival() {
		return isArrival;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}
}

public class RailwayPlatformService {

	private static final int BLOCK_PERIOD_IN_MINUTES = 20;
	private static final int MAX_INTERVAL_IN_MINUTES = 60;

	public List<TrainStop> convertBoardsToTrainStops(List<Board> arrivals, List<Board> departures) {

		List<TrainStop> trainStopList = new ArrayList<>();
		Map<String, Board> arrivalsMap = new HashMap<>();

		List<BoardTime> boardTimeList =
				arrivals
				.stream()
				.map(board -> new BoardTime(board, true, toDateTime(board.dateTime)))
				.collect(Collectors.toList());
		boardTimeList.addAll(
				departures
						.stream()
						.map(board -> new BoardTime(board, false, toDateTime(board.dateTime)))
						.collect(Collectors.toList()));
		boardTimeList.sort(Comparator.comparing(BoardTime::getDateTime));

		LocalDateTime departureDateTime;
		LocalDateTime arrivalDateTime;
		for(BoardTime boardTime : boardTimeList) {

			Board board = boardTime.getBoard();
			String trainName = board.name;

			if (boardTime.isArrival()) {
				if (arrivalsMap.containsKey(trainName)) {
					arrivalDateTime = toDateTime(arrivalsMap.get(trainName).dateTime);
					departureDateTime = toDateTime(arrivalsMap.get(trainName).dateTime).plusMinutes(BLOCK_PERIOD_IN_MINUTES);

					TrainStop trainStop = new TrainStop(trainName, arrivalDateTime, departureDateTime);
					trainStopList.add(trainStop);
				}
				arrivalsMap.put(trainName, board);
			} else { //departures
				if (arrivalsMap.containsKey(trainName)) {
					if (isValidInterval(arrivalsMap.get(trainName).dateTime, board.dateTime)) {
						arrivalDateTime = toDateTime(arrivalsMap.get(trainName).dateTime);
						arrivalsMap.remove(trainName);
					} else {
						arrivalDateTime = toDateTime(board.dateTime).minusMinutes(BLOCK_PERIOD_IN_MINUTES);
					}
				} else {
					arrivalDateTime = toDateTime(board.dateTime).minusMinutes(BLOCK_PERIOD_IN_MINUTES);
				}
				departureDateTime = toDateTime(board.dateTime);
				TrainStop trainStop = new TrainStop(trainName, arrivalDateTime, departureDateTime);
				trainStopList.add(trainStop);
			}
		}

		//ARRIVALS without DEPARTURES
		for (Board board : arrivalsMap.values()) {
			arrivalDateTime = toDateTime(board.dateTime);
			departureDateTime = toDateTime(board.dateTime).plusMinutes(BLOCK_PERIOD_IN_MINUTES);

			TrainStop trainStop = new TrainStop(board.name, arrivalDateTime, departureDateTime);
			trainStopList.add(trainStop);
		}


		return trainStopList;
	}

	private boolean isValidInterval(String strArrivalDateTime, String strDepartureDateTime) {
		LocalDateTime departureDateTime = parse(strDepartureDateTime, ISO_DATE_TIME);
		LocalDateTime arrivalDateTime = parse(strArrivalDateTime, ISO_DATE_TIME);
		long diff = Duration.between(arrivalDateTime, departureDateTime).toMinutes();
		return  (diff >= 0) && (diff <= MAX_INTERVAL_IN_MINUTES);
	}

	private LocalDateTime toDateTime(String dateTime) {
		return  parse(dateTime, ISO_DATE_TIME);
	}


	public int calculateMinimumNumberOfPlatforms(List<TrainStop> trainStops) {

		if(trainStops.isEmpty()) return 0;

		trainStops.sort(Comparator.comparing(o -> o.arrival));
		int maxCount = Integer.MIN_VALUE;
		LocalDateTime minArrival = trainStops.get(0).arrival;
		LocalDateTime maxDeparture = trainStops.get(0).departure;
		int i = 0;

		while(i < trainStops.size()) {
			int count = 0;

			if (intersect(trainStops.get(i), minArrival, maxDeparture)) {
				while(i < trainStops.size() && intersect(trainStops.get(i), minArrival, maxDeparture)) {
					count++;
					minArrival = trainStops.get(i).arrival.isBefore(minArrival) ? trainStops.get(i).arrival : minArrival;
					maxDeparture = trainStops.get(i).departure.isAfter(maxDeparture) ? trainStops.get(i).departure : maxDeparture;
					i++;
				}
				if(count == 6) {
					System.out.println("DEBUG");
				}
				maxCount = Math.max(maxCount, count);
				if(i >= trainStops.size()) break;
				minArrival = trainStops.get(i).arrival;
				maxDeparture = trainStops.get(i).departure;
			} else {
				i++;
			}
		}


		return maxCount;
	}

	private boolean intersect(TrainStop trainStop, LocalDateTime minArrival, LocalDateTime maxDeparture) {
		return (trainStop.arrival.isAfter(minArrival) || trainStop.arrival.isEqual(minArrival))
				&&
				(trainStop.arrival.isBefore(maxDeparture) || trainStop.arrival.isEqual(maxDeparture));
	}
}