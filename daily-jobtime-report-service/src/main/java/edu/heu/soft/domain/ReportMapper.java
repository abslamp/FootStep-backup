package edu.heu.soft.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/26/2017.
 */
public interface ReportMapper {
    List<Report> findByNameAndDate(String name,Date beginDate,Date endDate);
}
