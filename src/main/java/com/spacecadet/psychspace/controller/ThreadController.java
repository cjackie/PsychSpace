package com.spacecadet.psychspace.controller;

import com.spacecadet.psychspace.dataManager.CommentManager;
import com.spacecadet.psychspace.dataManager.CourseManager;
import com.spacecadet.psychspace.dataManager.ThreadManager;
import com.spacecadet.psychspace.utilities.Comment;
import com.spacecadet.psychspace.utilities.Course;
import com.spacecadet.psychspace.utilities.Thread;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Path;
import java.util.ArrayList;

/**
 * Created by aliao on 5/10/2017.
 */
@Controller
public class ThreadController {

    private CommentManager commentManager = new CommentManager();
    private ThreadManager threadManager = new ThreadManager();
    private CourseManager courseManager = new CourseManager();

    /**
     * all visits to thread page
     * @param courseKey course key in datastore
     * @return course forum page
     */
    @RequestMapping(value = "/learn/{courseKey}/forum/{threadKey}", method = RequestMethod.GET)
    public ModelAndView loadForum(@PathVariable("courseKey") String courseKey, @PathVariable("threadKey") String threadKey){
        ArrayList<Comment> comments = commentManager.loadComments(threadKey);
        Thread thread = threadManager.loadSingleThread(threadKey);
        Course course = courseManager.loadSingleCourse(courseKey);
        ModelAndView model = new ModelAndView();
        model.addObject("currUserKey", WelcomeController.currUser.getUserKey());
        model.addObject("thread", thread);
        model.setViewName("learnThread");
        model.addObject("comments", comments);
        model.addObject("comment", new Comment());
        model.addObject("course", course);

        return model;
    }

    /**
     * edit thread on forum page
     * @param courseKey course key in datastore
     * @param thread edited thread
     * @return redirect to course forum page
     */
    @RequestMapping(value = "/learn/{courseKey}/forum/{threadKey}/editThread", method = RequestMethod.POST)
    public String editThread(@PathVariable("courseKey") String courseKey, @PathVariable("threadKey") String threadKey,
                             @ModelAttribute Thread thread){
        threadManager.editThread(thread);
        return "redirect:/learn/"+courseKey+"forum";
    }

    /**
     * delete thread on forum page
     * @param courseKey course key in datastore
     * @param thread deleted thread
     * @return redirect to course forum page
     */
    @RequestMapping(value = "/learn/{courseKey}/forum/{threadKey}/deleteThread", method = RequestMethod.POST)
    public String deleteThread(@PathVariable("courseKey") String courseKey, @PathVariable("threadKey") String threadKey,
                               @ModelAttribute Thread thread){
        threadManager.deleteThread(thread.getThreadKey());
        return "redirect:/learn/"+courseKey+"forum";
    }

    /**
     * add/edit/delete comment on a thread
     * @param courseKey courseKey
     * @param comment add/edit/delete comment
     * @return course forum page
     */
    @RequestMapping(value = "/learn/{courseKey}/forum/{threadKey}/comment", method = RequestMethod.POST)
    public String addComment(@PathVariable("courseKey") String courseKey, @PathVariable("threadKey") String threadKey,
                             @ModelAttribute Comment comment){
        String fullname = WelcomeController.currUser.getFirstName().concat(" ").concat(WelcomeController.currUser.getLastName());
        if (comment.getState().equals("add")){
            commentManager.addComment(threadKey, fullname, WelcomeController.currUser.getUserKey(),comment.getContent());
        } else if(comment.getState().equals("edit")){
            commentManager.editComment(comment.getCommentKey(), fullname, WelcomeController.currUser.getUserKey(), comment.getContent());
        } else if(comment.getState().equals("delete")){
            commentManager.deleteComment(comment.getCommentKey());
        }
        return "redirect:/learn/"+courseKey+"forum";
    }
}
