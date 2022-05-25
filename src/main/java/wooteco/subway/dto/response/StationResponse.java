package wooteco.subway.dto.response;

import wooteco.subway.domain.station.Station;

public class StationResponse {
    private Long id;
    private String name;

    private StationResponse() {
    }

    public StationResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static StationResponse from(Long id, Station station) {
        String name = station.getName();
        return new StationResponse(id, name);
    }

    public static StationResponse from(Station station) {
        return from(station.getId(), station);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "StationResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
