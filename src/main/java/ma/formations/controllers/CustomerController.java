package ma.formations.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import ma.formations.service.IService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
/**
 * @Controller : les applications web.
 * @RestController hérite de @Controller : Rest
 */
public class CustomerController {

    private IService service;

    public CustomerController(IService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String welcome() {
        return "external";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }

    @GetMapping("/customers")
    /**
     * C'est le MVC II :
     * - Le C crée le M.
     * - le C choisit la V.
     * - Le C passe M à V.
     *
     * M= customers + username
     * C= DispatsherServlet + customers()
     * V=customers.html
     */
    public String customers(Principal principal,Model model) {
        model.addAttribute("customers",service.getAllCustomers());
        model.addAttribute("username",principal.getName());
        return "customers";
    }
}
