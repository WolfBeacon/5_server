package io.wolfbeacon.server.dao;

import io.wolfbeacon.server.model.Hackathon;

import java.util.Date;
import java.util.List;

public interface HackathonDAO extends GenericDAO<Hackathon, Long> {
    List<Hackathon> queryHackathonsBetweenDates(Date startDate, Date endDate, String sortBy, Integer count);
}
