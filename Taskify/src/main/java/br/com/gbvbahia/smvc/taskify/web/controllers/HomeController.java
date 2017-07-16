package br.com.gbvbahia.smvc.taskify.web.controllers;

import br.com.gbvbahia.smvc.taskify.service.TaskService;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 *
 * HomeController is a simple POJO with the @Controller annotation. This annotation registers it as
 * a web controller with a set of annotated handler methods inside it. It can have an
 *
 * @RequestMapping annotation at the class level to indicate the root URL of all handler methods in
 * it. The method home() is the request handler for the root URL, http://<context-root>/.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private TaskService taskService;

    /**
     * Simply selects the home view to render by returning its name.<br/>
     * Any request that hits the root URL of the app is rst received by DispatcherServlet, which
     * delegates it to HomeController.home(), which processes the request and returns the view name
     * (home, in this case).
     */
    @RequestMapping(method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome to Taskify! The client locale is {}.", locale);

        model.addAttribute("totalTasks", taskService.findAllTasksCount());
        model.addAttribute("totalOpenTasks", taskService.findAllOpenTasksCount());

        return "home";
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/m")
    public String hometwo(Locale locale, Model model) {
        logger.info("Welcome to Taskify! The client locale is {}.", locale);

        model.addAttribute("totalTasks", 5);
        model.addAttribute("totalOpenTasks", 10);

        return "home";
    }
}
