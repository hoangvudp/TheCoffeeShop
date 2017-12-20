package mum.waa.coffee.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.coffee.domain.Member;
import mum.waa.coffee.exception.EmailTakenException;
import mum.waa.coffee.exception.MemberNotFoundException;
import mum.waa.coffee.exception.UsernameTakenException;
import mum.waa.coffee.service.MemberService;

@Controller
@RequestMapping(value = "/members")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	ServletContext servletContext;

	@RequestMapping()
	public String listMembers(Model model) {
		List<Member> members = memberService.getAllMembers();
		model.addAttribute("members", members);
		return "members";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getMemberById(@PathVariable("id") Long id, Model model) {
		Member member = memberService.findById(id);
		if (member == null) {
			throw new MemberNotFoundException(id, null);
		}

		model.addAttribute("member", member);
		return "member";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addMember(Model model, Member member) {
		return "editMember";
	}

	@RequestMapping(value = { "/add", "/edit/{id}" }, method = RequestMethod.POST)
	public String saveMember(@Valid @ModelAttribute("member") Member member, BindingResult result, Model model) {
		boolean hasError = result.hasErrors();
		
		if (hasError) {
			return "editMember";
		}

		try {
			memberService.saveMember(member);
		} catch (EmailTakenException e) {
			hasError = true;
			result.rejectValue("email", "EmailAlreadyTaken", "Email is already taken");
		} catch (UsernameTakenException e) {
			hasError = true;
			result.rejectValue("userCredentials.username", "UsernameAlreadyTaken", "User Name is already taken");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if (hasError) {
			model.addAttribute("member", member);
			return "editMember";
		}
		
		return "redirect:/members";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editMember(@PathVariable("id") Long id, Model model) {
		Member member = memberService.findById(id);
		if (member == null) {
			throw new MemberNotFoundException(id, null);
		}
		model.addAttribute("member", member);
		return "editMember";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteMember(@PathVariable("id") Long id, Model model) {
		memberService.removeMember(id);
		return "redirect:/members";
	}
}
