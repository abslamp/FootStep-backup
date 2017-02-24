package tech.timer.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/24/2017.
 */
public interface ReportMapper {
    List<Report> queryDateOrderByDate(Date jmt);
}
