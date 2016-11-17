package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.User;
import domain.UserRepository;
import domain.UserRole;
import domain.UserRolesRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserRolesRepository userRolesRepo;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		saveUser(userForm);

		return "redirect:/welcome";
	}

	private void saveUser(User user) {
		System.out.println("Register user, user name: " + user.getUserName());
		System.out.println("Register user, user password: " + user.getPassword());

		Iterable<UserRole> findAll = userRolesRepo.findAll();
		System.out.println(findAll);

		// encrypt password
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		String roleUserName = "ROLE_USER";
		user.setEmail("default@mail");
		User savedUser = userRepo.save(user);
		UserRole userRole = new UserRole();
		userRole.setRole(roleUserName);
		userRole.setUserid(savedUser.getUserid());
		userRolesRepo.save(userRole);

	}

}
