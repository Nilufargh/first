package first_proj.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Templatecontroller {

    @RequestMapping("/index")
    public String index(Model model){
        //List<User> users=new ArrayList<>();
        //User user = new User("Arki","123kh");
        //User user1=new User("Nil","456f");
        //users.add(user);
        //users.add(user1);
        model.addAttribute("userdata",new User());
        return "Index";

    }
    @RequestMapping("/login")
    public String login(@ModelAttribute("userdata") User user){
        System.out.println(user.getUsername()+','+ user.getPassword());
        return "redirect:index";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "view/contact";
    }
}
