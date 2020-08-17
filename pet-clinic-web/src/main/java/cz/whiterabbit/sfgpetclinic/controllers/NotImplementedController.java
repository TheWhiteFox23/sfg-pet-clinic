package cz.whiterabbit.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotImplementedController {

    @RequestMapping({"/owners/find", "/vets.html", "/oups"})
    public String getNotImplemented(){
        return "notImlemented";
    }
}
