package com.example.todo.rest;


import com.example.todo.dao.UserDAO;
//import com.example.todo.dao.UserDAOImpl;
import com.example.todo.entity.User;
import com.example.todo.service.UserService;
import com.example.todo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/api")
public class ToDoRestController {
 static boolean email_reg=false;
    @Autowired
    private UserService userService ;
    @Autowired
    private UserDAO userRepository;
    @PostMapping("/signup")
    String createNewEmployee(@ModelAttribute("user") User theUser,Model model) // the signupform.html
            // sends data to this function. so not possible to modify data inside this function
    {
// the body passed as JSON object will be automatically converted to a Java POJO object

       User theSavedUser = theUser;

        try
        {
            theSavedUser.setId(0);
            userService.saveUser(theSavedUser);
           email_reg = false;
            return "employeesavesuccess";
        }

        catch (Exception e )
        {

            System.out.println("duplicate emails");
            email_reg = true;
            return "duplicate_email";
           // return "signupform";
// without any exception also it's showing the value as true as the default value is set true & does not change

        }



       // }
//return "signupform";
       // System.out.println("name of user  = "+theSavedUser.getFullName()+" email =  "+theSavedUser.getEmail());
//System.out.println("successfully saved user to database");

    }


    @GetMapping("/signup") //to render any page you always need to use getMapping
    // you can only modify the thymeleaf variables in those functions that have an explicit mapping for
    // the corresponding page
            String signupForm(Model model)
    {

        User user = new User();
        model.addAttribute("user",user); // no data stored in this variable
        model.addAttribute("errorMessage",email_reg);// user variable will be used in the signupform
        return "signupform";
    }

    @GetMapping("/usual")
        public String welcomePage()
    {
return "index";
    }


}
