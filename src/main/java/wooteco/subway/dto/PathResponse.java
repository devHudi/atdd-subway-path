package wooteco.subway.dto;


import java.util.List;
import java.util.stream.Collectors;
import wooteco.subway.domain.path.Path;

public class PathResponse {

    private final List<StationResponse> stations;
    private final int distance;
    private final int fare;

    public PathResponse(Path path) {
        this.stations = path.getStations()
                .stream()
                .map(station -> new StationResponse(station.getId(), station.getName()))
                .collect(Collectors.toList());
        this.distance = path.getDistance().getValue();
        this.fare = path.getFare().getValue();
    }

    public List<StationResponse> getStations() {
        return stations;
    }

    public int getDistance() {
        return distance;
    }

    public int getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return "PathResponse{" +
                "stations=" + stations +
                ", distance=" + distance +
                ", fare=" + fare +
                '}';
    }
}
