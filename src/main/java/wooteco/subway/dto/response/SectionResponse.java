package wooteco.subway.dto.response;

import wooteco.subway.domain.section.Section;

public class SectionResponse {
    private final Long id;
    private final Long upStationId;
    private final Long downStationId;
    private final Integer distance;

    private SectionResponse(Long id, Long upStationId, Long downStationId, Integer distance) {
        this.id = id;
        this.upStationId = upStationId;
        this.downStationId = downStationId;
        this.distance = distance;
    }

    public SectionResponse(Section section) {
        this(section.getId(), section.getUpStation().getId(), section.getDownStation().getId(),
                section.getDistance().getValue());
    }

    public Long getId() {
        return id;
    }

    public Long getUpStationId() {
        return upStationId;
    }

    public Long getDownStationId() {
        return downStationId;
    }

    public Integer getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "SectionResponse{" +
                "id=" + id +
                ", upStationId=" + upStationId +
                ", downStationId=" + downStationId +
                ", distance=" + distance +
                '}';
    }
}
