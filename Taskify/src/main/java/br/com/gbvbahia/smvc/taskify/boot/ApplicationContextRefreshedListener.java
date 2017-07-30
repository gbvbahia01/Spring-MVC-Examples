    package br.com.gbvbahia.smvc.taskify.boot;

import br.com.gbvbahia.smvc.taskify.domain.File;
import br.com.gbvbahia.smvc.taskify.domain.Task;
import br.com.gbvbahia.smvc.taskify.domain.User;
import br.com.gbvbahia.smvc.taskify.service.TaskService;
import br.com.gbvbahia.smvc.taskify.service.UserService;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//@Component
public class ApplicationContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextRefreshedListener.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    private static final String PROFILE_IMAGE_SAVE_LOCATION = "/tmp/taskify/profileImages";

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info(">>>>>>>>>>>>>>>>>>> Inside " + this + ".onApplicationEvent--- <<<<<<<<<<");

        User shameer = new User(null, "Shameer Kunjumohamed", "sameerean", "password", new Date());
        userService.createNewUser(shameer);
        discoverProfileImageIfExists(shameer);

        User tarun = new User(null, "Tarun Bhati", "tbhati", "password", new Date());
        userService.createNewUser(tarun);
        discoverProfileImageIfExists(tarun);

        taskService.createTask(new Task("Order Food", 10, "Open", shameer, new Date(), tarun, "This is for breakfast"));
        taskService.createTask(new Task("Commit code changes", 5, "Open", shameer, new Date(), tarun, "Let's test and deploy on Staging Server"));
        taskService.createTask(new Task("Review code changes", 6, "Open", tarun, new Date(), shameer, "Please send your feedback"));
        taskService.createTask(new Task("Release project version", 3, "Open", tarun, new Date(), shameer, "All tested, verified, accepted"));
        taskService.createTask(new Task("Order Snacks", 9, "Closed", tarun, new Date(), shameer, "Order some samosas and juices from Haji Ali"));
    }

    private void discoverProfileImageIfExists(User user) {
        String fileSaveDirectory = PROFILE_IMAGE_SAVE_LOCATION + "/" + user.getId();
        java.io.File physicalDir = new java.io.File(fileSaveDirectory);

        if (physicalDir.exists()) {
            java.io.File[] files = physicalDir.listFiles();
            if (files != null && files.length > 0) {
                java.io.File firstFile = files[0];
                user.setProfileImage(new File(1000 + user.getId() + 1, firstFile.getName()));
            }
        }

    }

}
