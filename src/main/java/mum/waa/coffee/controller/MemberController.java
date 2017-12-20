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
import mum.waa.coffee.exception.MemberNotFoundException;
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

	@RequestMapping(value = "{id}")
	public String getMemberById(@PathVariable("id") Long id, Model model) {
		Member member = memberService.findById(id);
		if (member == null) {
			throw new MemberNotFoundException(id, null);
		}

		model.addAttribute("member", member);
		return "member";
	}

	@RequestMapping(value = "/add")
	public String addMember(Model model, Member member) {
		return "member";
	}

	@RequestMapping(value = { "/add", "/edit/{id}" }, method = RequestMethod.POST)
	public String saveMember(@Valid @ModelAttribute("member") Member member, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "member";
		}

		Member savedMember = memberService.saveMember(member);
		boolean isAdd = member.getId() == null;

		String[] suppressedFields = result.getSuppressedFields();

		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		// MultipartFile productImage = member.getProductImage();
		// String rootDirectory = servletContext.getRealPath("/");
		//
		// // isEmpty means file exists BUT NO Content
		// if (productImage != null && !productImage.isEmpty()) {
		// try {
		// productImage.transferTo(new File(rootDirectory + "\\images\\" +
		// savedProduct.getId() + ".jpeg"));
		// } catch (Exception e) {
		// throw new RuntimeException("Product Image saving failed", e);
		// }
		// }
		//
		// if (isAdd) {
		// }
		return "redirect:/members";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editMember(@PathVariable("id") Long id, Model model) {
		Member member = memberService.findById(id);
		if (member == null) {
			throw new MemberNotFoundException(id, null);
		}
		model.addAttribute("member", member);
		return "member";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteMember(@PathVariable("id") Long id, Model model) {
		memberService.removeMember(id);
		return "redirect:/members";
	}
}
