package com.fisc.passwordservice.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
class PasswordResetRepositoryImpl implements PasswordResetRepository {
	@PersistenceContext
	protected EntityManager entityManager;

	public PasswordResetRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void resetPassword(String userId, String password) {

		Session session = entityManager.unwrap(Session.class);
		SQLQuery query = session
				.createSQLQuery("update tbl_user_profile set password= :password where user_id =:userId");
		query.setParameter("password", password);
		query.setParameter("userId", userId);
		query.executeUpdate();

	}
}
