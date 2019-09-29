package com.apjschool.librarymgmt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.apjschool.librarymgmt.dto.MemberDTO;
import com.apjschool.librarymgmt.dto.SearchFilterRequest;
import com.apjschool.librarymgmt.mapper.EntityDtoMapper;

@Service("memberService")
@Transactional
public class MemberService {

	@Autowired
	private MemberDaoImpl memberDaoImpl;
	
	private EntityDtoMapper mapper = new EntityDtoMapper();
	
	private static final Logger logger = LogManager.getLogger(MemberService.class);

	public void addMember(Member member) {
		try {
			memberDaoImpl.addMember(member);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateMember(Member member) {
		try {
			memberDaoImpl.updateMember(member);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMember(Member member) {
		try {
			memberDaoImpl.deleteMember(member);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ServiceResponse<List<MemberDTO>> searchMember(SearchFilterRequest searchFilter) {
		ServiceResponse<List<MemberDTO>> response = new ServiceResponse<>();
		try {
			List<Member> members = memberDaoImpl.searchMember(searchFilter);
			//List<MemberDTO> bookDtoList = mapper.populateMemberDTOList(members);
			//response.setResult(bookDtoList);
		} catch (HibernateException e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
		}
		return response;
		
	}

	public Member getMemberById(Integer id) {
		Member member = null;
		try {
			member = memberDaoImpl.getMemberById(id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public List<Member> getAllMember() {
		List<Member> members = new ArrayList<>();
		try {
			members = memberDaoImpl.getAllMember();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return members;
	}
	
}
