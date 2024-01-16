package nhc.erp.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 이승준
 */
@Controller
public class IndexController {
	@GetMapping(value = "/")
    public String index(HttpServletRequest request, Model model) {
    	// model.addAttribute("movePage", loginService.getLoginPage(request.getParameter("w2xPath")));
    	// model.addAttribute("movePage", "/cm/main/login.xml");
		model.addAttribute("movePage", "/cm/main/index.xml");
    	return "websquare/websquare";
    }
    
    public String ex() {
        throw new RuntimeException("xxxxx");
    }
}