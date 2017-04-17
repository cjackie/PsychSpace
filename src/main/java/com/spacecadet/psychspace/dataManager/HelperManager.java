package com.spacecadet.psychspace.dataManager;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.JsonObject;
import com.spacecadet.psychspace.utilities.Comment;
import com.spacecadet.psychspace.utilities.News;
import com.spacecadet.psychspace.utilities.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by marleneshankar on 4/8/17.
 */
public class HelperManager {

    public Object stringToJson(String str, String objectType) {
        Gson g = new Gson();
        if (objectType.compareTo("User") == 0) {
            return g.fromJson(str, User.class);
        } else if (objectType.compareTo("News") == 0) {
            return g.fromJson(str, News.class);
        } else if (objectType.compareTo("Comment") == 0) {
            return g.fromJson(str, Comment.class);
        }
        return null;
    }

    public String[] stringToJsonNewsKeyList(String str) {
        Gson g = new Gson();

        return g.fromJson(str, String[].class);

    }

    public Date stringToDate(String dateString) {
        DateFormat df2 = new SimpleDateFormat("mm-dd-yyyy");
        Date date = new Date();
        try {
            date = df2.parse(dateString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return date;
    }
}
