package com.apjschool.librarymgmt.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.apjschool.librarymgmt.dao.entity.Address;
import com.apjschool.librarymgmt.dao.entity.Author;
import com.apjschool.librarymgmt.dao.entity.Book;
import com.apjschool.librarymgmt.dao.entity.BookCategory;
import com.apjschool.librarymgmt.dao.entity.BookIssued;
import com.apjschool.librarymgmt.dao.entity.Language;
import com.apjschool.librarymgmt.dao.entity.Member;
import com.apjschool.librarymgmt.dao.entity.Publisher;
import com.apjschool.librarymgmt.dto.AddressDTO;
import com.apjschool.librarymgmt.dto.AuthorDTO;
import com.apjschool.librarymgmt.dto.BookCategoryDTO;
import com.apjschool.librarymgmt.dto.BookDTO;
import com.apjschool.librarymgmt.dto.BookIssuedDTO;
import com.apjschool.librarymgmt.dto.LanguageDTO;
import com.apjschool.librarymgmt.dto.MemberDTO;
import com.apjschool.librarymgmt.dto.PublisherDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityDtoMapper {

	public BookDTO populateBookDTO(Book entity) {
		BookDTO bookDto = null;
		if (entity != null) {
			bookDto = new BookDTO();
			bookDto.setBookId(entity.getBookId());
			bookDto.setBookName(entity.getBookName());
			bookDto.setBookIsdn(entity.getBookIsdn());
			bookDto.setPrice(entity.getPrice());
			bookDto.setPublishYear(entity.getPublishYear());
			bookDto.setPages(entity.getPages());
			bookDto.setNoOfCopies(entity.getNoOfCopies());
			bookDto.setNoOfCopyIssued(entity.getNoOfCopyIssued());

			Set<Author> authorEntityList = entity.getAuthors();
			if (authorEntityList != null && authorEntityList.size() > 0) {
				Set<AuthorDTO> authorDtoList = new HashSet<>();
				for (Author author : authorEntityList) {
					authorDtoList.add(populateAuthorDto(author));
				}
				bookDto.setAuthors(authorDtoList);
			}

			BookCategory category = entity.getCategory();
			if (category != null) {
				bookDto.setBookCategory(populateCategoryDto(category));
			}

			Language language = entity.getLanguage();
			if (language != null) {
				bookDto.setLanguage(populateLanguageDto(language));
			}

			Publisher publisher = entity.getPublisher();
			if (publisher != null) {
				bookDto.setPublisher(populatePublisherDto(publisher));
			}
		}
		return bookDto;
	}

	public Book populateBookEntity(BookDTO bookDto) {
		Book entity = new Book();
		if (bookDto != null) {
			entity.setBookId(bookDto.getBookId());
			entity.setBookName(bookDto.getBookName());
			entity.setBookIsdn(bookDto.getBookIsdn());
			entity.setPrice(bookDto.getPrice());
			entity.setPublishYear(bookDto.getPublishYear());
			entity.setPages(bookDto.getPages());
			entity.setNoOfCopies(bookDto.getNoOfCopies());
			entity.setNoOfCopyIssued(bookDto.getNoOfCopyIssued());

			Set<AuthorDTO> authorDtoList = bookDto.getAuthors();
			if (authorDtoList != null && authorDtoList.size() > 0) {
				Set<Author> authorEntityList = new HashSet<>();
				for (AuthorDTO authorDto : authorDtoList) {
					authorEntityList.add(populateAuthorEntity(authorDto));
				}
				entity.setAuthors(authorEntityList);
			}

			BookCategoryDTO categoryDto = bookDto.getBookCategory();
			if (categoryDto != null) {
				entity.setCategory(populateCategoryEntity(categoryDto));
			}

			LanguageDTO languageDTO = bookDto.getLanguage();
			if (languageDTO != null) {
				entity.setLanguage(populateLanguageEntity(languageDTO));
			}

			PublisherDTO publisherDTO = bookDto.getPublisher();
			if (publisherDTO != null) {
				entity.setPublisher(populatePublisherEntity(publisherDTO));
			}
		}
		return entity;
	}

	public Author populateAuthorEntity(AuthorDTO authorDto) {
		Author author = new Author();
		if (authorDto != null) {
			if (authorDto.getAuthorId() != null)
				author.setAuthorId(authorDto.getAuthorId());
			author.setFirstName(authorDto.getFirstName());
			author.setLastName(authorDto.getLastName());
			author.setAuthorEmail(authorDto.getAuthorEmail());
		}
		return author;
	}

	public AuthorDTO populateAuthorDto(Author entity) {
		AuthorDTO author = new AuthorDTO();
		if (entity != null) {
			author.setAuthorId(entity.getAuthorId());
			author.setFirstName(entity.getFirstName());
			author.setLastName(entity.getLastName());
			author.setAuthorEmail(entity.getAuthorEmail());
		}
		return author;
	}

	public BookCategory populateCategoryEntity(BookCategoryDTO dto) {
		BookCategory category = new BookCategory();
		if (dto != null) {
			category.setBookCategoryId(dto.getBookCategoryId());
			category.setCategoryDesc(dto.getCategoryDesc());
		}
		return category;
	}

	public BookCategoryDTO populateCategoryDto(BookCategory entity) {
		BookCategoryDTO category = new BookCategoryDTO();
		if (entity != null) {
			category.setBookCategoryId(entity.getBookCategoryId());
			category.setCategoryDesc(entity.getCategoryDesc());
		}
		return category;
	}

	public Language populateLanguageEntity(LanguageDTO dto) {
		Language language = new Language();
		if (dto != null) {
			language.setLanguageId(dto.getLanguageId());
			language.setLanguageDesc(dto.getLanguageDesc());
		}
		return language;
	}

	public LanguageDTO populateLanguageDto(Language entity) {
		LanguageDTO language = new LanguageDTO();
		if (entity != null) {
			language.setLanguageId(entity.getLanguageId());
			language.setLanguageDesc(entity.getLanguageDesc());
		}
		return language;
	}

	public Publisher populatePublisherEntity(PublisherDTO dto) {
		Publisher publisher = new Publisher();
		if (dto != null) {
			publisher.setPublisherId(dto.getPublisherId());
			publisher.setPublisherName(dto.getPublisherName());
			publisher.setPublisherPhoneNo(dto.getPublisherPhoneNo());
			publisher.setPublisherEmail(dto.getPublisherEmail());
			AddressDTO addressDTO = dto.getPublisherAddress();
			if (addressDTO != null) {
				publisher.setPublisherAddress(new Address());
				publisher.getPublisherAddress().setAddressId(addressDTO.getAddressId());
				publisher.getPublisherAddress().setAddressLine1(addressDTO.getAddressLine1());
				publisher.getPublisherAddress().setAddressLine2(addressDTO.getAddressLine2());
				publisher.getPublisherAddress().setCity(addressDTO.getCity());
				publisher.getPublisherAddress().setState(addressDTO.getState());
				publisher.getPublisherAddress().setCountry(addressDTO.getCountry());
				publisher.getPublisherAddress().setPinCode(addressDTO.getPinCode());
			}
		}
		return publisher;
	}

	public PublisherDTO populatePublisherDto(Publisher entity) {
		PublisherDTO publisher = new PublisherDTO();
		if (entity != null) {
			publisher.setPublisherId(entity.getPublisherId());
			publisher.setPublisherName(entity.getPublisherName());
			publisher.setPublisherPhoneNo(entity.getPublisherPhoneNo());
			publisher.setPublisherEmail(entity.getPublisherEmail());
			Address addrEntity = entity.getPublisherAddress();
			if (addrEntity != null) {
				publisher.setPublisherAddress(populateAddressDto(addrEntity));
			}
		}
		return publisher;
	}

	public List<BookDTO> populateBookDTOList(List<Book> bookEntityList) {
		List<BookDTO> bookDtoList = new ArrayList<BookDTO>();
		if (bookEntityList != null && bookEntityList.size() > 0) {
			for (Book book : bookEntityList) {
				bookDtoList.add(populateBookDTO(book));
			}
		}
		return bookDtoList;
	}

	public List<AuthorDTO> populateAuthorDTOList(List<Author> authorList) {
		List<AuthorDTO> authorDtoList = new ArrayList();
		if (authorList != null && authorList.size() > 0) {
			for (Author author : authorList) {
				authorDtoList.add(populateAuthorDto(author));
			}
		}
		return authorDtoList;
	}

	public List<PublisherDTO> populatePublisherDTOList(List<Publisher> publisherList) {
		List<PublisherDTO> publisherDtoList = new ArrayList();
		if (publisherList != null && publisherList.size() > 0) {
			for (Publisher publisher : publisherList) {
				publisherDtoList.add(populatePublisherDto(publisher));
			}
		}
		return publisherDtoList;
	}

	public List<LanguageDTO> populateLanguageDTOList(List<Language> languageList) {
		List<LanguageDTO> LanguageDtoList = new ArrayList();
		if (languageList != null && languageList.size() > 0) {
			for (Language language : languageList) {
				LanguageDtoList.add(populateLanguageDto(language));
			}
		}
		return LanguageDtoList;
	}

	public List<BookCategoryDTO> populateCategoryDTOList(List<BookCategory> categoryList) {
		List<BookCategoryDTO> categoryDtoList = new ArrayList();
		if (categoryList != null && categoryList.size() > 0) {
			for (BookCategory category : categoryList) {
				categoryDtoList.add(populateCategoryDto(category));
			}
		}
		return categoryDtoList;
	}

	public List<MemberDTO> populateMemberDTOList(List<Member> memberEntityList) {
		List<MemberDTO> memberDtoList = new ArrayList<MemberDTO>();
		if (memberEntityList != null && memberEntityList.size() > 0) {
			for (Member member : memberEntityList) {
				memberDtoList.add(populateMemberDTO(member));
			}
		}
		return memberDtoList;
	}

	public MemberDTO populateMemberDTO(Member member) {
		MemberDTO memberDTO = null;
		if (member != null) {
			memberDTO = new MemberDTO();
			memberDTO.setMemberId(member.getMemberId());
			memberDTO.setRegistrationNo(member.getRegistrationNo());
			memberDTO.setFirstName(member.getFirstName());
			memberDTO.setLastName(member.getLastName());
			memberDTO.setGender(member.getGender());
			memberDTO.setHobby(member.getHobby());
			memberDTO.setPhoneNo(member.getPhoneNo());
			memberDTO.setDateofBirth(member.getDateofBirth());
			memberDTO.setIdentificationType(member.getIdentificationType());
			memberDTO.setIdentificationNo(member.getIdentificationNo());
			
			/*Set<BookIssued> bookIssuedEntityList = member.getBookIssued();
			if (bookIssuedEntityList != null && bookIssuedEntityList.size() > 0) {
				Set<BookIssuedDTO> boolIssuedDtoList = new HashSet<>();
				for (BookIssued bookIssued : bookIssuedEntityList) {
					boolIssuedDtoList.add(populateBookIssuedDto(bookIssued));
				}
				memberDTO.setBookIssued(boolIssuedDtoList);
			}*/

			Address address = member.getAddress();
			if (address != null) {
				memberDTO.setAddress(populateAddressDto(address));
			}

		}
		return memberDTO;
	}

	public Member populateMemberEntity(MemberDTO memberDTO) {
		Member member = null;
		if (memberDTO != null) {
			member = new Member();
			member.setMemberId(memberDTO.getMemberId());
			member.setRegistrationNo(memberDTO.getRegistrationNo());
			member.setFirstName(memberDTO.getFirstName());
			member.setLastName(memberDTO.getLastName());
			member.setGender(memberDTO.getGender());
			member.setHobby(memberDTO.getHobby());
			member.setPhoneNo(memberDTO.getPhoneNo());
			member.setDateofBirth(memberDTO.getDateofBirth());
			member.setIdentificationType(memberDTO.getIdentificationType());
			member.setIdentificationNo(memberDTO.getIdentificationNo());
			
			Set<BookIssuedDTO> bookIssuedDTOList = memberDTO.getBookIssued();
			if (bookIssuedDTOList != null && bookIssuedDTOList.size() > 0) {
				Set<BookIssued> bookIssued = new HashSet<>();
				for (BookIssuedDTO bookIssuedDTO : bookIssuedDTOList) {
					bookIssued.add(populateBookIssuedEntity(bookIssuedDTO));
				}
				member.setBookIssued(bookIssued);
			}

			AddressDTO address = memberDTO.getAddress();
			if (address != null) {
				member.setAddress(populateAddressEntity(address));
			}

		}
		return member;
	}

	private BookIssued populateBookIssuedEntity(BookIssuedDTO bookIssuedDTO) {
		BookIssued bookIssued = null;
		if (bookIssuedDTO != null) {
			bookIssued = new BookIssued();
			bookIssued.setIssuedDate(bookIssuedDTO.getIssuedDate());
			bookIssued.setDueDate(bookIssuedDTO.getDueDate());
			bookIssued.setReturnedDate(bookIssuedDTO.getReturnedDate());
			bookIssued.setLostFlag(bookIssuedDTO.getLostFlag());
			MemberDTO memberDTO = bookIssuedDTO.getMemberDTO();
			if (memberDTO != null) {
				bookIssued.setMember(populateMemberEntity(memberDTO));
			}
			BookDTO bookDTO = bookIssuedDTO.getBookDTO();
			if (bookDTO != null) {
				bookIssued.setBook(populateBookEntity(bookDTO));
			}
		}

		return bookIssued;
	}

	public BookIssuedDTO populateBookIssuedDto(BookIssued bookIssued) {

		BookIssuedDTO bookIssuedDTO = null;
		if (bookIssued != null) {
			bookIssuedDTO = new BookIssuedDTO();
			bookIssuedDTO.setIssuedDate(bookIssued.getIssuedDate());
			bookIssuedDTO.setDueDate(bookIssued.getDueDate());
			bookIssuedDTO.setReturnedDate(bookIssued.getReturnedDate());
			bookIssuedDTO.setLostFlag(bookIssued.getLostFlag());
			Member member = bookIssued.getMember();
			if (member != null) {
				bookIssuedDTO.setMemberDTO(populateMemberDTO(member));
			}
			Book book = bookIssued.getBook();
			if (book != null) {
				bookIssuedDTO.setBookDTO(populateBookDTO(book));
			}
		}

		return bookIssuedDTO;
	}

	private Address populateAddressEntity(AddressDTO addressDTO) {
		Address address = null;
		if (addressDTO != null) {
			address = new Address();
			address.setAddressId(addressDTO.getAddressId());
			address.setAddressLine1(addressDTO.getAddressLine1());
			address.setAddressLine2(addressDTO.getAddressLine2());
			address.setCity(addressDTO.getCity());
			address.setState(addressDTO.getState());
			address.setCountry(addressDTO.getCountry());
			address.setPinCode(addressDTO.getPinCode());
		}
		return address;
	}

	public AddressDTO populateAddressDto(Address addrEntity) {
		AddressDTO address = null;
		if (addrEntity != null) {
			address = new AddressDTO();
			address.setAddressId(addrEntity.getAddressId());
			address.setAddressLine1(addrEntity.getAddressLine1());
			address.setAddressLine2(addrEntity.getAddressLine2());
			address.setCity(addrEntity.getCity());
			address.setState(addrEntity.getState());
			address.setCountry(addrEntity.getCountry());
			address.setPinCode(addrEntity.getPinCode());
		}
		return address;
	}

}
