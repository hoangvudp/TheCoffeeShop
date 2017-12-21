package mum.waa.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.coffee.domain.Member;
import mum.waa.coffee.domain.UserCredentials;
import mum.waa.coffee.exception.EmailTakenException;
import mum.waa.coffee.exception.UsernameTakenException;
import mum.waa.coffee.service.MemberService;
import mum.waa.coffee.service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm(@ModelAttribute("member") Member member, Model model) {
		model.addAttribute("member", member);
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("member") Member member, BindingResult result, Model model,
			HttpServletRequest request) {
		UserCredentials credentials = member.getUserCredentials();
		 if (!credentials.getInputPassword().equals(credentials.getVerifyPassword())) {
			 result.rejectValue("userCredentials.verifyPassword", "PasswordConfirmNotMatch", "Password Confirm does not match");
		 }

		boolean hasError = result.hasErrors();

		if (!hasError) {
			try {
				member.getUserCredentials().setEnabled(true);
				memberService.registerNewMember(member);
				System.out.println(credentials.getPassword());
		        securityService.autologin(credentials.getUsername(), credentials.getVerifyPassword());

			} catch (EmailTakenException e) {
				hasError = true;
				result.rejectValue("email", "EmailAlreadyTaken", "Email is already taken");
			} catch (UsernameTakenException e) {
				hasError = true;
				result.rejectValue("userCredentials.username", "UsernameAlreadyTaken", "User Name is already taken");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (hasError) {
			model.addAttribute("member", member);
			return "register";
		}

		return "redirect:/";
	}
}
