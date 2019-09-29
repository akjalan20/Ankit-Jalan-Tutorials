package com.apjschool.librarymgmt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.apjschool.librarymgmt.config.SpringConfiguration;
import com.apjschool.librarymgmt.dao.entity.Address;
import com.apjschool.librarymgmt.dao.entity.Book;
import com.apjschool.librarymgmt.dao.entity.BookIssued;
import com.apjschool.librarymgmt.dao.entity.Member;
import com.apjschool.librarymgmt.dto.AddressDTO;
import com.apjschool.librarymgmt.dto.AuthorDTO;
import com.apjschool.librarymgmt.dto.BookCategoryDTO;
import com.apjschool.librarymgmt.dto.BookDTO;
import com.apjschool.librarymgmt.dto.LanguageDTO;
import com.apjschool.librarymgmt.dto.PublisherDTO;
import com.apjschool.librarymgmt.service.BookService;
import com.apjschool.librarymgmt.service.MemberService;
import com.apjschool.librarymgmt.service.MiscService;

public class LibraryDaoTest {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		BookService bookSrvc = (BookService) context.getBean("bookService");
		MemberService membrSrvc = (MemberService) context.getBean("memberService");
		MiscService miscSrvc = (MiscService) context.getBean("miscService");

		/*
		 * addBook(context); updateBook(); deleteBook(); searchBook();
		 * getBook();
		 */

		/*
		 * addMember(); updateMember(); deleteMember(); searchMember();
		 * getMember(); issueBook(); returnBook();
		 */

		/*
		 * addAuthor(); addBookCategory(); addLanguage(); addPublisher();
		 */

		


		//List<Member> srchMembers = membrSrvc.searchMember(searchFilterReq);

		System.out.println("*************************");
		//System.out.println(srchMembers.size());


		/*
		 * List<Member> member = membrSrvc.getAllMember();
		 * System.out.println("*************************");
		 * System.out.println(member);
		 * 
		 * if (member != null) { for (Member member2 : member) { Set<BookIssued>
		 * bookIssued = member2.getBookIssued();
		 * //System.out.println(bookIssued); for (BookIssued bookIssued2 :
		 * bookIssued) { BookIssuedId bookIssuedId =
		 * bookIssued2.getBookIssuedId();
		 * System.out.println(bookIssuedId.getBook().getBookName());
		 * System.out.println(bookIssuedId.getMember().getFirstName());
		 * 
		 * } } }
		 */

		bookSrvc.addBook(getBook());

		/*
		 * List<Author> authors = librarySrvc.getAuthor();
		 * System.out.println(authors);
		 */

		/*
		 * List<Book> books = librarySrvc.getBooks(); System.out.println(books);
		 */

		// membrSrvc.addMember(getMember());
		//membrSrvc.issueBook(issueBook());
	}

	private static BookIssued issueBook() {
		BookIssued bookIssued = new BookIssued();
		Book book = new Book();
		book.setBookId(1);
		bookIssued.getBookIssuedId().setBook(book);
		Member member = new Member();
		member.setMemberId(1);
		bookIssued.getBookIssuedId().setMember(member);
		bookIssued.setLostFlag("N");
		bookIssued.setIssuedDate(new Date());
		bookIssued.setDueDate(addDays(new Date(), 15));
		bookIssued.setReturnedDate(null);
		return bookIssued;
	}

	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	public static Member getMember() {
		Member member = new Member();
		member.setRegistrationNo(1031262);
		member.setFirstName("Pulkit");
		member.setLastName("Jalan");
		SimpleDateFormat dtFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date utilDate = null;
		try {
			utilDate = dtFormat.parse("20-06-1985");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		member.setDateofBirth(utilDate);
		member.setGender("Male");
		//member.setPhoneNo(7684352);
		//member.setSemester("Sixth");
		member.setAddress(new Address(1));

		// member.setBookIssued(bookIssued);

		return member;
	}

	public static BookDTO getBook() {
		AddressDTO pubAddress = new AddressDTO();
		// pubAddress.setAddressId(1);
		pubAddress.setAddressLine1("Addr1");
		pubAddress.setCity("New York");
		pubAddress.setCountry("USA");

		AuthorDTO author1 = new AuthorDTO("Sidney", "Sheldon", "k.sierra@gmail.com");
		//author1.setAuthorId(1);
		AuthorDTO author2 = new AuthorDTO("Bert", "Bates", "b.bates@gmail.com");
		// author2.setAuthorId(2);
		Set<AuthorDTO> authors = new HashSet<>();
		authors.add(author1);
		//authors.add(author2);
		// dao.saveAuthor(author1);
		// dao.deleteAuthor(author1);

		PublisherDTO publisher = new PublisherDTO();
		// publisher.setPublisherId(1);
		publisher.setPublisherName("McGraw-Hill Education");
		publisher.setPublisherAddress(pubAddress);

		BookCategoryDTO category = new BookCategoryDTO("Computer Programming");
		//category.setBookCategoryId(1);

		LanguageDTO language = new LanguageDTO("English");
		// language.setLanguageId(1);

		BookDTO book = new BookDTO();
		book.setBookName("Programming in Python");
		book.setBookIsdn("0071772032");
		book.setPrice(28.82);
		book.setPublishYear(2012);
		book.setPages(768);
		book.setNoOfCopies(2);
		book.setAuthors(authors);
		book.setPublisher(publisher);
		book.setBookCategory(category);
		book.setLanguage(language);
		return book;
	}

}
