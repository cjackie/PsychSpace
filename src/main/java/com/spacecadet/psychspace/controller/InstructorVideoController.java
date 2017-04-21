package com.spacecadet.psychspace.controller;

import com.spacecadet.psychspace.dataManager.CourseManager;
import com.spacecadet.psychspace.dataManager.UserManager;
import com.spacecadet.psychspace.utilities.Course;
import com.spacecadet.psychspace.utilities.User;
import com.spacecadet.psychspace.utilities.Video;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by aliao on 4/21/2017.
 */
@Controller
public class InstructorVideoController {

    private CourseManager courseManager = new CourseManager();
    private UserManager userManager = new UserManager();

    /**
     * instructor page - add new video to course
     * @return
     */
    @RequestMapping(value = "/addVideo", method = RequestMethod.GET)
    public ModelAndView addVideo() {
        ArrayList<Course> courses = courseManager.loadAllOpenCourses();
        ModelAndView model = new ModelAndView();
        model.setViewName("instructorAddVideo");
        model.addObject("video", new Video());
        model.addObject("courses", courses);

        return model;
    }

    /**
     * instructor page - edit video to course
     * @return
     */
    @RequestMapping(value = "/editVideo", method = RequestMethod.GET)
    public ModelAndView editVideo() {
        ArrayList<Course> courses = courseManager.loadAllOpenCourses();
        ModelAndView model = new ModelAndView();
        model.setViewName("instructorEditVideo");
        model.addObject("video", new Video());
        model.addObject("courses", courses);

        return model;
    }

    /**
     * instructor page - delete video to course
     * @return
     */
    @RequestMapping(value = "/deleteVideo", method = RequestMethod.GET)
    public ModelAndView deleteVideo() {
        ArrayList<Course> courses = courseManager.loadAllOpenCourses();
        ModelAndView model = new ModelAndView();
        model.setViewName("instructorDeleteVideo");
        model.addObject("video", new Video());
        model.addObject("courses", courses);

        return model;
    }

    /**
     * logout on instructor course page
     * @return
     */
    @RequestMapping(value = "/addVideo/logout", method = RequestMethod.POST)
    public String logoutAdd(@RequestBody String user) {
        userManager.resetCurrentUser(new User());
        return "redirect:/";
    }

    /**
     * logout on instructor course page
     * @return
     */
    @RequestMapping(value = "/editVideo/logout", method = RequestMethod.POST)
    public String logoutEdit(@RequestBody String user) {
        userManager.resetCurrentUser(new User());
        return "redirect:/";
    }

    /**
     * logout on instructor course page
     * @return
     */
    @RequestMapping(value = "/deleteVideo/logout", method = RequestMethod.POST)
    public String logoutDelete(@RequestBody String user) {
        userManager.resetCurrentUser(new User());
        return "redirect:/";
    }
}