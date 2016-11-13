package io.wolfbeacon.server.service;

import io.wolfbeacon.server.dao.HackathonDAO;
import io.wolfbeacon.server.model.Hackathon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class HackathonServiceImpl implements HackathonService {

    @Autowired
    HackathonDAO hackathonDAO;

    @Override
    public List<Hackathon> getHackathonsBetweenDate(Date startDate, Date endDate, String sortBy, Integer count) {
        return hackathonDAO.queryHackathonsBetweenDates(startDate, endDate, sortBy, count);
    }
}
