package au.gov.nla.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.gov.nla.dao.PersonDAO;
import au.gov.nla.model.Person;

@Service
public class PersonServiceImpl implements PersonService
{
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO)
	{
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public List<Person> getPersonList()
	{
		return this.personDAO.getPersonList();
	}

	@Override
	@Transactional
	public void addPerson(Person person)
	{
		this.personDAO.addPerson(person);
	}

}
