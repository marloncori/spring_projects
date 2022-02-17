package pl.millenium.mvctutorial.controller;

import pl.millenium.mvctutorial.repository.RobotRepository;
import pl.millenium.mvctutorial.model.Robot;

import com.springframework.ui.Model;
import com.springframework.beans.factory.annotation.Autowired;

import com.springframework.stereotype.Controller;
import com.springframework.web.bind.annotation.GetMapping;
import com.springframework.web.bind.annotation.ModelAttribute;
import com.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    RobotRepository robotRepository;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("robot", new Robot());
        return "home";
    }

    @PostMapping("/robot")
    public String robot(@ModelAttribute Robot robot){
        robotRepository.save(robot);
        return "robot";
    }

    @GetMapping("/allRobots")
    public String getAllRobots(Model model){
        List<Robot> allRobots = (List<Robot>)robotRepository.findAll();
        model.addAttribute("allRobots", allRobots);
        return "robots";
    }
    
}
