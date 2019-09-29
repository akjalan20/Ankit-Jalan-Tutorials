package com.apjschool.librarymgmt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apjschool.librarymgmt.dao.entity.Book;
import com.apjschool.librarymgmt.dao.entity.Member;
import com.apjschool.librarymgmt.service.MemberService;
import com.apjschool.librarymgmt.util.CustomEditorExample;

@Controller
public class LibraryController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/ngRoute")
	public ModelAndView angularRoute() {
		ModelAndView modelAndView = new ModelAndView("AngularRoute");
		return modelAndView;
	}

	@RequestMapping("/welcome")
	public ModelAndView welcome() {

		ModelAndView modelAndView = new ModelAndView("HomePage");
		// ModelAndView modelAndView = new ModelAndView("AddBook");
		return modelAndView;
	}

	@RequestMapping("/library/add/{action}")
	public ModelAndView add(@PathVariable("action") String action) throws Exception {
		ModelAndView modelAndView = null;
		if (action.equals("addbook")) {
			modelAndView = new ModelAndView("AddBook");
		} else if (action.equals("addmember")) {
			modelAndView = new ModelAndView("AddMember");
			String expn = "NullPointer";
			if(expn.equals("NullPointer")) {
				throw  new NullPointerException();
			}
			
		} else {
			modelAndView = new ModelAndView("HomePage");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/library/addBooks", method = RequestMethod.POST)
	public ModelAndView addBooks(@ModelAttribute("book") Book book, BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("AddBook");
		} else {
			modelAndView = new ModelAndView("BookAddSuccess");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/library/addMember", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") @Valid Member member, BindingResult result) {
		/* @Valid triggers JSR annotation validation placed in Member class */
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("AddMember");
			// modelAndView.addObject(member);
		} else {
			memberService.addMember(member);
			modelAndView = new ModelAndView("MemberAddSuccess");
		}
		return modelAndView;
	}

	@ModelAttribute
	public void addCommonObjects(Model model) {
		model.addAttribute("headerMessage", "Library Management System");

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(String.class, "identificationNo", new CustomEditorExample());
	}
	/* Advantages of InitBinder */
	/*
	 * 1) Before, you had to resort to manually parsing the date:
	 * 
	 * public void webmethod(@RequestParam("date") String strDate) { Date date = ...
	 * // manually parse the date }
	 * 
	 * Now you can get the parsed date directly:
	 * 
	 * public void webmethod(@RequestParam("date") Date date) { }
	 * 
	 * 2) If your jsp page supplies a date on the form yyyy-MM-dd you can retrieve
	 * it as a Date object directly in your controller.
	 * 
	 * 3) Spring tries against all registered editors to see if values can be
	 * converted into objects. You don't have to do anything in the object itself,
	 * that's the beauty of it.
	 */

}
