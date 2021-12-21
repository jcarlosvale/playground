package tests.entwicklerheld.deutschebahnChallenge;


import static java.time.LocalDateTime.parse;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
		Map<String, Board> arrivalsMap = arrivals.stream().collect(Collectors.toMap(board -> board.name, board -> board));
		Map<String, Board> departuresMap = departures.stream().collect(Collectors.toMap(board -> board.name, board -> board));

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

		Set<Board> usedDepartures = new HashSet<>();
		for(BoardTime boardTime : boardTimeList) {
			Board board = boardTime.getBoard();
			String trainName = board.name;
			if (boardTime.isArrival()) {
				LocalDateTime departureDateTime;
				if (departuresMap.containsKey(trainName)
						&& !usedDepartures.contains(departuresMap.get(trainName))
						&& 0 <= dateTimeDiff(departuresMap.get(trainName).dateTime, board.dateTime)
						&& dateTimeDiff(departuresMap.get(trainName).dateTime, board.dateTime) <= MAX_INTERVAL_IN_MINUTES
				) {
					usedDepartures.add(departuresMap.get(trainName));
					departureDateTime = toDateTime(departuresMap.get(trainName).dateTime);
				} else {
					departureDateTime = boardTime.getDateTime().plusMinutes(BLOCK_PERIOD_IN_MINUTES);
				}
				TrainStop trainStop = new TrainStop(trainName, boardTime.getDateTime(), departureDateTime);
				trainStopList.add(trainStop);
			} else {
				if(!usedDepartures.contains(board)) {
					TrainStop trainStop =
							new TrainStop(trainName, boardTime.getDateTime().minusMinutes(BLOCK_PERIOD_IN_MINUTES), toDateTime(board.dateTime));
					trainStopList.add(trainStop);
				}
			}
		}
		return trainStopList;
	}

	private LocalDateTime toDateTime(String dateTime) {
		return  parse(dateTime, ISO_DATE_TIME);
	}

	private static long dateTimeDiff(String strDepartureDateTime, String strArrivalDateTime) {
		LocalDateTime departureDateTime = parse(strDepartureDateTime, ISO_DATE_TIME);
		LocalDateTime arrivalDateTime = parse(strArrivalDateTime, ISO_DATE_TIME);
		return Duration.between(arrivalDateTime, departureDateTime).toMinutes();
	}

	public int calculateMinimumNumberOfPlatforms(List<TrainStop> trainStops) {
		return 0;
	}


	public static void main(String[] args) {
		System.out.println(dateTimeDiff("2021-12-21T16:52:32+00:00", "2021-12-21T16:32:32+00:00"));
		System.out.println(dateTimeDiff("2021-12-21T16:52:32+00:00", "2021-12-21T17:52:32+00:00"));

	}

}