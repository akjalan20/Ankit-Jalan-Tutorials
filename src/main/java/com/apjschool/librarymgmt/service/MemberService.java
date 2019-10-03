package com.apjschool.librarymgmt.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apjschool.librarymgmt.controller.ServiceResponse;
import com.apjschool.librarymgmt.dao.BookDaoImpl;
import com.apjschool.librarymgmt.dao.BookIssuedDaoImpl;
import com.apjschool.librarymgmt.dao.MemberDaoImpl;
import com.apjschool.librarymgmt.dao.entity.Book;
import com.apjschool.librarymgmt.dao.entity.BookIssued;
import com.apjschool.librarymgmt.dao.entity.Member;
import com.apjschool.librarymgmt.dto.BookDTO;
import com.apjschool.librarymgmt.dto.BookIssuedDTO;
import com.apjschool.librarymgmt.dto.MemberDTO;
import com.apjschool.librarymgmt.dto.MemberSearchDTO;
import com.apjschool.librarymgmt.dto.SearchFilterRequest;
import com.apjschool.librarymgmt.mapper.EntityDtoMapper;

@Service("memberService")
@Transactional
public class MemberService {

	@Autowired
	private MemberDaoImpl memberDaoImpl;

	@Autowired
	private BookIssuedDaoImpl bookIssuedDaoImpl;

	@Autowired
	private BookDaoImpl bookDaoImpl;

	private EntityDtoMapper mapper = new EntityDtoMapper();

	private static final Logger logger = LogManager.getLogger(MemberService.class);

	public ServiceResponse<MemberDTO> addMember(MemberDTO memberDTO) {
		ServiceResponse<MemberDTO> response = new ServiceResponse<MemberDTO>();
		try {
			Member member = mapper.populateMemberEntity(memberDTO);
			Integer id = memberDaoImpl.addMember(member);
			member = memberDaoImpl.getMemberById(id);
			memberDTO = mapper.populateMemberDTO(member);
			response.setResult(memberDTO);
		} catch (HibernateException e) {
			logger.error("HibernateException while adding member " + memberDTO.getFirstName() + " " + e.getMessage());
			response.addError(
					"HibernateException while adding member " + memberDTO.getFirstName() + " " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception while adding member " + memberDTO.getFirstName() + " " + e.getMessage());
			response.addError("Exception while adding member " + memberDTO.getFirstName() + " " + e.getMessage());
		}
		return response;
	}

	public ServiceResponse<Void> updateMember(MemberDTO memberDTO) {
		ServiceResponse<Void> response = new ServiceResponse<>();
		try {
			Member member = mapper.populateMemberEntity(memberDTO);
			memberDaoImpl.updateMember(member);
		} catch (HibernateException e) {
			logger.error("Exception while updating member " + memberDTO.getFirstName() + " " + e.getMessage());
			response.addError("Exception while updating member " + memberDTO.getFirstName() + " " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while updating member " + memberDTO.getFirstName() + " " + e.getMessage());
			response.addError("Exception while updating member " + memberDTO.getFirstName() + " " + e.getMessage());
		}
		return response;
	}

	public ServiceResponse<Void> deleteMember(MemberDTO memberDTO) {
		ServiceResponse<Void> response = new ServiceResponse<>();
		try {
			Member member = mapper.populateMemberEntity(memberDTO);
			memberDaoImpl.deleteMember(member);
		} catch (HibernateException e) {
			logger.error("Exception while deleting member " + memberDTO.getFirstName() + " " + e.getMessage());
			response.addError("Exception while deleting member " + memberDTO.getFirstName() + " " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while deleting member " + memberDTO.getFirstName() + " " + e.getMessage());
			response.addError("Exception while deleting member " + memberDTO.getFirstName() + " " + e.getMessage());
		}
		return response;
	}

	public ServiceResponse<List<MemberDTO>> searchMember(SearchFilterRequest searchFilter) {
		ServiceResponse<List<MemberDTO>> response = new ServiceResponse<>();
		try {
			List<Member> members = memberDaoImpl.searchMember(searchFilter);
			// List<MemberDTO> bookDtoList = mapper.populateMemberDTOList(members);
			// response.setResult(bookDtoList);
		} catch (HibernateException e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
		}
		return response;

	}

	public ServiceResponse<MemberDTO> getMemberById(Integer id) {
		Member member = null;
		ServiceResponse<MemberDTO> response = new ServiceResponse<>();
		MemberDTO memberDTO = null;
		try {
			member = memberDaoImpl.getMemberById(id);
			memberDTO = mapper.populateMemberDTO(member);
			if (memberDTO != null) {
				response.setResult(memberDTO);
			} else {
				response.addError("Requested member with Id " + id + " not found.");
			}
		} catch (HibernateException e) {
			logger.error("Exception while searching member" + e.getMessage());
			response.addError("Exception while searching member" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching member" + e.getMessage());
			response.addError("Exception while searching member" + e.getMessage());
		}
		return response;
	}

	public ServiceResponse<List<MemberDTO>> getAllMember() {
		ServiceResponse<List<MemberDTO>> response = new ServiceResponse<>();
		try {
			List<Member> members = memberDaoImpl.getAllMember();
			List<MemberDTO> memberDTOs = mapper.populateMemberDTOList(members);
			response.setResult(memberDTOs);
		} catch (HibernateException e) {
			logger.error("Exception while searching Member" + e.getMessage());
			response.addError("Exception while searching Member" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching Member" + e.getMessage());
			response.addError("Exception while searching Member" + e.getMessage());
		}
		return response;
	}

	public ServiceResponse<List<MemberDTO>> searchMember(MemberSearchDTO searchDTO) {
		ServiceResponse<List<MemberDTO>> response = new ServiceResponse<>();
		List<Member> members = new ArrayList<>();
		try {
			if (searchDTO != null) {
				members = memberDaoImpl.searchMember(searchDTO);
			} else {
				members = memberDaoImpl.getAllMember();
			}
			List<MemberDTO> membersDtoList = mapper.populateMemberDTOList(members);
			response.setResult(membersDtoList);
		} catch (HibernateException e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	public ServiceResponse<Void> issueBook(BookIssuedDTO bookIssuedDto) {
		ServiceResponse<Void> response = new ServiceResponse<>();
		try {
			BookDTO bookDto = bookIssuedDto.getBookDTO();
			Book bookEntity = bookDaoImpl.getBookById(bookDto.getBookId());
			Member memberEntity = memberDaoImpl.getMemberById(bookIssuedDto.getMemberDTO().getMemberId());
			if (bookEntity.getNoOfCopies() > bookEntity.getNoOfCopyIssued()) {
				BookIssued bookIssued = new BookIssued();
				Calendar cal = Calendar.getInstance();
				Date issueDate = cal.getTime();
				cal.add(Calendar.DATE, 21);
				Date dueDate = cal.getTime();
				bookIssued.setIssuedDate(issueDate);
				bookIssued.setDueDate(dueDate);
				bookIssued.setReturnedDate(null);
				bookIssued.setBook(bookEntity);
				bookIssued.setMember(memberEntity);
				memberEntity.getBookIssued().add(bookIssued);
				memberDaoImpl.updateMember(memberEntity);
				// bookIssuedDaoImpl.saveEntity(bookIssued);
				bookEntity.setNoOfCopyIssued(bookEntity.getNoOfCopyIssued() + 1);
				bookDaoImpl.updateEntity(bookEntity);
			} else {
				response.addError("There are no available copies of this book to be issued.");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			logger.error("Exception while issuing member" + e.getMessage());
			response.addError("Exception while issuing Book" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception while issuing member" + e.getMessage());
			response.addError("Exception while issuing Book" + e.getMessage());
		}
		return response;
	}

	public ServiceResponse<Void> returnBook(BookIssuedDTO bookIssuedDto) {
		ServiceResponse<Void> response = new ServiceResponse<>();
		try {

			BookDTO bookDto = bookIssuedDto.getBookDTO();
			Book bookEntity = bookDaoImpl.getBookById(bookDto.getBookId());
			BookIssued bookIssued = null;
			Member memberEntity = memberDaoImpl.getMemberById(bookIssuedDto.getMemberDTO().getMemberId());
			Boolean bookIssuedIn = false;
			if (memberEntity.getBookIssued() != null && memberEntity.getBookIssued().size() > 0) {
				Set<BookIssued> bookIssuedList = memberEntity.getBookIssued();
				for (BookIssued bi : bookIssuedList) {
					if (bi.getBook().getBookId() == bookEntity.getBookId()) {
						bookIssued = bi;
						bookIssuedIn = true;
						break;
					}
				}
				if (bookIssuedIn) {
					bookIssued.setReturnedDate(new Date());
					memberEntity.getBookIssued().add(bookIssued);
					memberDaoImpl.updateMember(memberEntity);
					bookEntity.setNoOfCopyIssued(bookEntity.getNoOfCopyIssued() - 1);
					bookDaoImpl.updateEntity(bookEntity);
				} else {
					response.addError("This book is not issued to this member.");
				}
			} else {
				response.addError("There are no books issued to this member.");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			logger.error("Exception while returning member" + e.getMessage());
			response.addError("Exception while returning Book" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception while returning member" + e.getMessage());
			response.addError("Exception while returning Book" + e.getMessage());
		}
		return response;
	}

}
