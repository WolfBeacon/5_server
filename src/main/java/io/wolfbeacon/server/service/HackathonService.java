package io.wolfbeacon.server.service;

import io.wolfbeacon.server.model.Hackathon;

import java.util.Date;
import java.util.List;

public interface HackathonService {
    List<Hackathon> getHackathonsBetweenDate(Date startDate, Date endDate, String sortBy, Integer count);
}
