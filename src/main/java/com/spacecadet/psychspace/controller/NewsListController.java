package com.spacecadet.psychspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by aliao on 3/20/2017.
 */
@Controller
public class NewsListController {
    @RequestMapping(value = "/newsfeed", method = RequestMethod.GET)
    public ModelAndView newList(){
        ModelAndView model = new ModelAndView();

        return model;
    }
}
