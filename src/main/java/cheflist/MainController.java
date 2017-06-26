package cheflist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cheflist.Chef;
import cheflist.ChefRepository;

@Controller
public class MainController {
	@Autowired 
	private ChefRepository chefRepository;
	
	@GetMapping("/add")
	public String addNewChef(Model chefModel){
		chefModel.addAttribute("add", new Chef());
		return "add";
		
	}
	
	@PostMapping("/add")
	public String chefAdded(@ModelAttribute Chef chef){
		chefRepository.save(chef);
		return "result";
	}
	
	@GetMapping("/display")
	public String displayLists(@ModelAttribute("chef")Chef chef,Model chefListModel){
	 Iterable<Chef> chefList = chefRepository.findAll();
	 chefListModel.addAttribute("chefList", chefList);
	 return "list";
	}
	
	@PostMapping("/delete")
	public String deleteId(Long id){
		chefRepository.delete(id);
		return "delete";
	}

}
