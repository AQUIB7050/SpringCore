package springmvcsearch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class searchController {
	
	@RequestMapping("/home")
	public String searchController() {
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("searchContent") String query) {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("https://www.google.com/search?q="+query);
		return redirectView;
	}

}
