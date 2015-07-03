package au.gov.nla.dao;

import java.util.List;

import au.gov.nla.model.Person;

public interface PersonDAO
{
	public List<Person> getPersonList();

	public void addPerson(Person person);
}
