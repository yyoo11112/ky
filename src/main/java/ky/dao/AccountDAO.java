package ky.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ky.entity.account.Account;

@Repository("accountDAO")
@Transactional
public class AccountDAO {
	
	@PersistenceContext(unitName="ky_db")
	private EntityManager entityManager;
	
	public Account getAccount(long accountId) {
		String sqlString = null;
		sqlString = "SELECT p FROM Account p where p.id = :id";
		
		TypedQuery<Account> query = entityManager.createQuery(sqlString, Account.class);		
		query.setParameter("id", accountId);
		
		try{

			return query.getResultList().get(0);
		}catch(Exception e){
			return null;
		}
	}
	
	public void saveAccount(Account account){
		entityManager.merge(account);
		entityManager.flush();
		
	}
}
