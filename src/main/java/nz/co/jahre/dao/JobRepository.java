package nz.co.jahre.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import nz.co.jahre.model.Job;

import org.springframework.stereotype.Repository;

@Repository
public class JobRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Job> getJobs() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Job> cq = cb.createQuery(Job.class);
		TypedQuery<Job> sq = em.createQuery(cq).setMaxResults(100);
		return sq.getResultList();
		
	}
}
