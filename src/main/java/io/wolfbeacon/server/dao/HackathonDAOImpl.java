package io.wolfbeacon.server.dao;

import io.wolfbeacon.server.model.Hackathon;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class HackathonDAOImpl extends AbstractHibernateDAO<Hackathon, Long> implements HackathonDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<Hackathon> queryHackathonsBetweenDates(Date startDate, Date endDate, String sortBy, Integer count) {
        Criteria criteria = getCurrentSession().createCriteria(Hackathon.class);
        if (startDate != null) {
            criteria.add(Restrictions.ge("startDate", startDate));
        }
        if (endDate != null) {
            criteria.add(Restrictions.lt("endDate", endDate));
        }
        if (count != null) {
            criteria.setMaxResults(count);
        }
        if (sortBy == null || !sortBy.equals("distance")) {
            criteria.addOrder(Order.asc("startDate"));
        }
        return criteria.list();
    }
}
