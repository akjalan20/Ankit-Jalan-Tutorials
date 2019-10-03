package com.apjschool.librarymgmt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.apjschool.librarymgmt.dao.entity.Book;
import com.apjschool.librarymgmt.dao.entity.BookIssued;
import com.apjschool.librarymgmt.dao.entity.BookIssuedId;
import com.apjschool.librarymgmt.dao.entity.Member;
import com.apjschool.librarymgmt.dto.BookSearchDTO;
import com.apjschool.librarymgmt.dto.MemberSearchDTO;
import com.apjschool.librarymgmt.dto.SearchFilter;
import com.apjschool.librarymgmt.dto.SearchFilterRequest;

@Repository("MemberDaoImpl")
public class MemberDaoImpl extends GenericDao<Member> implements MemberDao {

	public Integer addMember(Member member) {
		return saveEntity(member);
	}

	public void updateMember(Member member) {
		updateEntity(member);
	}

	public void deleteMember(Member member) {
		try {
			deleteEntity(member);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Member> getAllMember() {
		List<Member> member = new ArrayList<>(0);
		member = getEntity(Member.class);
		if (member != null) {
			for (Member member2 : member) {
				Set<BookIssued> bookIssued = member2.getBookIssued();
				for (BookIssued bookIssued2 : bookIssued) {
					/*
					 * BookIssuedId bookIssuedId =
					 * bookIssued2.getBookIssuedId();
					 * System.out.println(bookIssuedId.getBook().getBookName());
					 * System.out.println(bookIssuedId.getMember().getFirstName(
					 * ));
					 */
				}
			}
		}
		return member;
	}

	public Member getMemberById(Integer id) {
		Member member = getById(Member.class, id);
		System.out.println(member);
		if (member != null) {
			member.getBookIssued();
		}
		return member;
	}

	public List<Member> searchMember(SearchFilterRequest searchFilter) {
		Session session = getSession();
		List<Member> member = new ArrayList<>();

		Criteria criteria = session.createCriteria(Member.class);
		Conjunction conjunction = Restrictions.conjunction();
		Criterion criterion = null;

		for (SearchFilter filter : searchFilter.getSearchFilter()) {
			switch (filter.getName().trim()) {
			case "registrationNo":
				criterion = Restrictions.eq("registrationNo", Integer.parseInt(filter.getValue()));
				break;
			case "firstName":
				criterion = Restrictions.ilike("firstName", filter.getValue(), MatchMode.ANYWHERE);
				break;
			case "lastName":
				criterion = Restrictions.ilike("lastName", filter.getValue(), MatchMode.ANYWHERE);
				break;
			case "phoneNo":
				criterion = Restrictions.ilike("phoneNo", filter.getValue(), MatchMode.ANYWHERE);
				break;
			case "dateofBirth":
				criterion = Restrictions.eq("dateofBirth", filter.getValue());
				break;
			default:
				criterion = Restrictions.ne("deleteFlag", "Y");
				break;
			}
			conjunction.add(criterion);
		}

		criteria.add(conjunction);

		member = criteria.list();

		/*
		 * ScrollableResults iterator = criteria.setFirstResult(maxRowsPerFetch
		 * * rowIndex) .setMaxResults(maxRowsPerFetch)
		 * .scroll(ScrollMode.FORWARD_ONLY);
		 */

		if (member != null) {
			for (Member member2 : member) {
				member2.getBookIssued();
				System.out.println(member2.getBookIssued());
			}
		}

		return member;
	}

	public List<Member> searchMember(MemberSearchDTO searchDTO) {
		Session session = getSession();
		List<Member> members = new ArrayList<>();
		
		Criteria criteria = session.createCriteria(Member.class);
		Conjunction conjunction = Restrictions.conjunction();
		Criterion criterion = null;

		if (searchDTO != null) {
			if (searchDTO.getRegistrationNo() != null) {
				criterion = Restrictions.eq("registrationNo", searchDTO.getRegistrationNo());
				conjunction.add(criterion);
			}
			if (searchDTO.getFirstName() != null && !searchDTO.getFirstName().isEmpty()) {
				criterion = Restrictions.ilike("firstName", searchDTO.getFirstName(), MatchMode.ANYWHERE);
				conjunction.add(criterion);
			}
			if (searchDTO.getLastName() != null && !searchDTO.getLastName().isEmpty()) {
				criterion = Restrictions.ilike("lastName", searchDTO.getLastName(), MatchMode.ANYWHERE);
				conjunction.add(criterion);
			}
			if (searchDTO.getPhoneNo() != null) {
				criterion = Restrictions.eq("phoneNo", searchDTO.getPhoneNo());
				conjunction.add(criterion);
			}
			if (searchDTO.getDateofBirth() != null) {
				criterion = Restrictions.eq("dateofBirth", searchDTO.getDateofBirth());
				conjunction.add(criterion);
			}
			if (searchDTO.getIdentificationNo() != null && !searchDTO.getIdentificationNo().isEmpty()) {
				criterion = Restrictions.eq("identificationNo", searchDTO.getIdentificationNo());
				conjunction.add(criterion);
			}
			
		}
		/*
		 * setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) removes duplicate records
		 */
		criteria.add(conjunction).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		members = criteria.list();
		return members;
	}

}
