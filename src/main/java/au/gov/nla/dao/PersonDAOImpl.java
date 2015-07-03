package au.gov.nla.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.gov.nla.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Person> getPersonList()
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> persons = (List<Person>) session
				.createQuery("from Person").list();

		return persons;
	}

	@Override
	public void addPerson(Person person)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(person);
	}

}
