package first_proj.demo.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    //***best approach***
    //object to jason
    @RequestMapping("/jason")
    public String jason(){
        List<User> users=new ArrayList<>();
        User user =new User("Nil","123");
        User user1=new User("Ark","f**");
        users.add(user);
        users.add(user1);
        return new Gson().toJson(users);

    }

    //pathvariable method
    //namevalues should be the same.but the name in value but the variable and the valuename doesn't need to be the same
    @RequestMapping(value={"/path/{username}/{password}","/path/{password}"},method=RequestMethod.POST)
    public String path(@PathVariable(value="username",required = false)String username,@PathVariable(value="password")String password){
        return "HELLO " + username +","+ password;
    }

    //requestparam method
    @RequestMapping(value="/param")
    public String param(@RequestParam(value="name")String username,@RequestParam("password") String password){
        return "HELLO " + username +","+ password;
    }

    //Requestbody or using jason format
    @RequestMapping(value="/body")
    public String body(@RequestBody User body){
        return body.getUsername()+", "+body.getPassword();
    }
    @RequestMapping(value="/first",method=RequestMethod.POST)
    public String firstRest() {
        return "First Rest";
    }

    //same url and different method
    @RequestMapping(value="/first",method=RequestMethod.GET)
    public String secondRest(){
        return "Second Rest";
    }

    //only post mapping
    @PostMapping(value="/post")
    public String postRest(){
        return "POST only";
    }
    //only GET mapping
    //@GetMapping
    

}
