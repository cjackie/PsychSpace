package com.spacecadet.psychspace.controller;

import com.spacecadet.psychspace.dataManager.*;
import com.spacecadet.psychspace.utilities.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for all visits to student/user progress pages.
 * use cases: load user progress for selected course
 * Created by aliao on 4/28/2017.
 */
@Controller
public class ProgressController {

    private CourseManager courseManager = new CourseManager();
    private EvaluationManager evaluationManager = new EvaluationManager();
    private HabitManager habitManager = new HabitManager();
    private GoalManager goalManager = new GoalManager();
    private SurveyManager surveyManager = new SurveyManager();

    /**
     * all visit to course learn page
     * @return learn page
     */
    @RequestMapping(value = "/learn/{courseKey}", method = RequestMethod.GET)
    public ModelAndView learnCourse(@PathVariable("courseKey") String courseKey) {
        String hasHabit = "false";
        String hasGoal = "false";
        String hasEvaluation = "false";
        String hasSurvey = "false";
        ModelAndView model = new ModelAndView();
        model.setViewName("learnProgress");
        Course course = courseManager.loadSingleCourse(courseKey);
        model.addObject("courseTitle", course.getTitle());
        model.addObject("courseStartDate", course.getStartDate());
        if(evaluationManager.hasTodaysEvaluation(WelcomeController.currUser.getUserKey(), courseKey)){
            hasEvaluation = "true";
        }
        if(habitManager.loadUserHabit(WelcomeController.currUser.getUserKey(), courseKey) != null){
            hasHabit = "true";
        }
        if(goalManager.loadUserGoal(courseKey, WelcomeController.currUser.getUserKey()) != null){
            hasGoal = "true";
        }
        if(surveyManager.loadUserSurvey(courseKey, WelcomeController.currUser.getUserKey()) != null){
            hasSurvey = "true";
        }
        model.addObject("hasSurvey", hasSurvey);
        model.addObject("hasEvaluation", hasEvaluation);
        model.addObject("hasHabit", hasHabit);
        model.addObject("hasGoal", hasGoal);

        return model;
    }
}
