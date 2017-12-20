package mum.waa.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.coffee.domain.Person;
import mum.waa.coffee.domain.UserCredentials;
import mum.waa.coffee.exception.EmailTakenException;
import mum.waa.coffee.exception.UsernameTakenException;
import mum.waa.coffee.service.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {
	private final PersonService memberService;
	private final AuthenticationManager authenticationManager;

	@Autowired
	public RegisterController(PersonService memberService, AuthenticationManager authenticationManager) {
		this.memberService = memberService;
		this.authenticationManager = authenticationManager;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm(@ModelAttribute("member") Person member, Model model) {
		model.addAttribute("member", member);
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("member") Person member, BindingResult result, Model model,
			HttpServletRequest request) {
		UserCredentials credentials = member.getUserCredentials();
		 if (!credentials.getPassword().equals(credentials.getVerifyPassword())) {
			 result.rejectValue("userCredentials.verifyPassword", "PasswordConfirmNotMatch", "Password Confirm does not match");
		 }

		boolean hasError = result.hasErrors();

		if (!hasError) {
			try {
				member.getUserCredentials().setEnabled(true);
				memberService.registerNewPerson(member);
				loginAfterRegistering(member, request);
			} catch (EmailTakenException e) {
				hasError = true;
				result.rejectValue("email", "EmailAlreadyTaken", "Email is already taken");
			} catch (UsernameTakenException e) {
				hasError = true;
				result.rejectValue("userCredentials.username", "UsernameAlreadyTaken", "User Name is already taken");
			}
		}

		if (hasError) {
			model.addAttribute("member", member);
			return "register";
		}

		return "redirect:/";
	}

	private void loginAfterRegistering(Person person, HttpServletRequest request) {
		// UsernamePasswordAuthenticationToken token = new
		// UsernamePasswordAuthenticationToken(person.getUsername(),
		// person.getPassword());
		//
		// // create session if not exist
		// request.getSession();
		//
		// token.setDetails(new WebAuthenticationDetails(request));
		//
		// Authentication authentication = authenticationManager.authenticate(token);
		// SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
