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
import mum.waa.coffee.exception.EmailTakenException;
import mum.waa.coffee.exception.UsernameTakenException;
import mum.waa.coffee.service.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final PersonService personService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public RegisterController(PersonService personService, AuthenticationManager authenticationManager) {
        this.personService = personService;
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showRegisterForm(@ModelAttribute("member") Person person, Model model) {
        model.addAttribute("member", person);
        return "register";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String register(@Valid Person person, BindingResult result, Model model, HttpServletRequest request) {
//        String password = person.getPassword();
//        String passwordConfirm = person.getPasswordConfirm();

//        if (password.isEmpty()) {
//            result.rejectValue("password", null, "Password cannot be empty");
//        }
//
//        if (passwordConfirm.isEmpty()) {
//            result.rejectValue("passwordConfirm", null, "Password confirm cannot be empty");
//        }
//
//        if (!password.equals(passwordConfirm)) {
//            result.rejectValue("passwordConfirm", null, "Password does not match");
//        }

        boolean hasError = result.hasErrors();

        if (!hasError) {
            try {
                personService.registerNewPerson(person);
                loginAfterRegistering(person, request);
            } catch (EmailTakenException e) {
                hasError = true;
                result.rejectValue("email", "", "Email is already taken");
            } catch (UsernameTakenException e) {
                hasError = true;
                result.rejectValue("username", "", "Username is already taken");
            }
        }

        if (hasError) {
            model.addAttribute("person", person);
            return "register";
        }

        return "redirect:/";
    }

    private void loginAfterRegistering(Person person, HttpServletRequest request) {
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(person.getUsername(), person.getPassword());
//
//        // create session if not exist
//        request.getSession();
//
//        token.setDetails(new WebAuthenticationDetails(request));
//
//        Authentication authentication = authenticationManager.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
