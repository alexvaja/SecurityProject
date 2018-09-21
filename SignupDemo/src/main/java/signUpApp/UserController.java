package signUpApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import signUpApp.entity.User;
import signUpApp.model.UserViewModel;
import signUpApp.repository.UserRepository;
@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserRepository userRepo;
	@GetMapping("/insert")
	public String addUserToDatabase(Model model)
	{
		model.addAttribute("userViewModel", new UserViewModel());
		return "insert";
	}
	@PostMapping("/insert")
	public String addUserToDatabase(@ModelAttribute UserViewModel userViewModel)
	{
		User user = new User();
		user.setUsername(userViewModel.getUsername());
		user.setPassword(userViewModel.getPassword());
		user.setPassword(userViewModel.getRepeatPassword());
		user.setFirstQuestion(userViewModel.getFirstQuestion());
		user.setSecondQuestion(userViewModel.getSecondQuestion());
		user.setThirdQuestion(userViewModel.getThirdQuestion());
		userRepo.save(user);
		return "result";
	}
}
