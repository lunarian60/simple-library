package au.gov.nla.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import au.gov.nla.model.Book;
import au.gov.nla.model.Person;
import au.gov.nla.service.BookService;
import au.gov.nla.service.PersonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
{

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private PersonService personService;

	private BookService bookService;

	@Autowired(required = true)
	@Qualifier(value = "bookService")
	public void setBookService(BookService bookService)
	{
		this.bookService = bookService;
	}

	@Autowired(required = true)
	@Qualifier(value = "personService")
	public void setPersonService(PersonService personService)
	{
		this.personService = personService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model)
	{
		List<Person> persons = this.personService.getPersonList();
		List<Book> books = this.bookService.getBookList();

		model.addAttribute("persons", persons);
		model.addAttribute("books", books);

		return "home";
	}

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String books(Model model,
			@RequestParam(value = "personId") String personId)
	{
		List<Book> books = this.bookService.getBookListByPerson(Integer
				.valueOf(personId));

		model.addAttribute("books", books);

		return "book";
	}

}
