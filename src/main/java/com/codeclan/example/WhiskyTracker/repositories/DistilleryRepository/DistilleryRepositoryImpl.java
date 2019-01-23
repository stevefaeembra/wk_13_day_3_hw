package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

	@Autowired
	EntityManager entityManager;

	@Transactional
	public List<Whisky> findWhiskiesFromDistilleriesWithAge (String distilleryName, Integer age) {
		List<Whisky> results = null;
		Session session = entityManager.unwrap(Session.class);
		try {
			Criteria criteria = session.createCriteria(Distillery.class);
			criteria.add(Restrictions.eq("name", distilleryName));
			criteria.createAlias("whiskies","whiskyAlias");
			criteria.add(Restrictions.eq("whiskyAlias.age", age));
			results = criteria.list();
		} catch(Exception ex) {
			ex.printStackTrace();
		}

		return results;
	}
}
