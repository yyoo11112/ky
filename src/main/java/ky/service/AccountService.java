package ky.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ky.dao.AccountDAO;
import ky.entity.account.Account;
import ky.entity.account.Profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/account")
public class AccountService {
	
	final static Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	AccountDAO accountDAO;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Account getAccount(@QueryParam("id") Long id) {
		
		logger.debug("Hmmmm... I received it! " + id);
		
		Account temp = accountDAO.getAccount(id);
		
		if (temp == null){

			Account account = new Account();
			account.setId(1l);
			account.setFirstName("Youngwook");
			account.setLastName("Yoo");

			return account;
		}else{
			return temp;
		}
	}
	
	@POST
	public void SetAccount(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName,
			@QueryParam("email") String email) {
		
		Account temp = new Account();
		temp.setFirstName(firstName);
		temp.setLastName(lastName);
		temp.setUID(firstName);
		temp.setEmail(email);
		
		Profile profile = new Profile();
		profile.setRank(1);
		profile.setAccount(temp);
		
		temp.setProfile(profile);
		
		accountDAO.saveAccount(temp);
		
		logger.debug("New ID ::: " + temp.getId());
		
	}

}
