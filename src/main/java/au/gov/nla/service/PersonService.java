package au.gov.nla.service;

import java.util.List;

import au.gov.nla.model.Person;

public interface PersonService
{
	public List<Person> getPersonList();

	public void addPerson(Person person);
}
