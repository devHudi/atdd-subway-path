package wooteco.subway.service;

import java.util.List;
import org.springframework.stereotype.Service;
import wooteco.subway.dao.SectionDao;
import wooteco.subway.dao.StationDao;
import wooteco.subway.domain.fare.Age;
import wooteco.subway.domain.path.Path;
import wooteco.subway.domain.section.Section;
import wooteco.subway.domain.station.Station;
import wooteco.subway.dto.PathResponse;
import wooteco.subway.exception.NotFoundStationException;

@Service
public class PathService {

    private final SectionDao sectionDao;
    private final StationDao stationDao;

    public PathService(SectionDao sectionDao, StationDao stationDao) {
        this.sectionDao = sectionDao;
        this.stationDao = stationDao;
    }

    public PathResponse getPath(Long sourceStationId, Long targetStationId, Integer ageValue) {
        List<Section> sections = sectionDao.findAll();

        Station departure = stationDao.findById(sourceStationId).orElseThrow(NotFoundStationException::new);
        Station arrival = stationDao.findById(targetStationId).orElseThrow(NotFoundStationException::new);
        Age age = new Age(ageValue);

        return new PathResponse(new Path(sections, departure, arrival, age));
    }
}
