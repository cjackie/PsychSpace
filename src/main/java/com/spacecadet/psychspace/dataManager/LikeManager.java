package com.spacecadet.psychspace.dataManager;

import com.google.appengine.api.datastore.*;
import com.spacecadet.psychspace.utilities.Like;

import java.util.*;

/**
 * Created by marleneshankar on 4/14/17.
 * Modified by aliao on 4/19/17
 */
public class LikeManager {

    private DatastoreService datastore;

    /**
     * constructor
     */
    public LikeManager() {
        datastore = DatastoreServiceFactory.getDatastoreService();
    }

    /**
     * load all like records in datastore
     * @return list of existing like records
     */
    public ArrayList<Like> loadLikes(String newsKey) {
        Query.Filter newsFilter = new Query.FilterPredicate("newsKey", Query.FilterOperator.EQUAL, newsKey);
        Query likeQuery = new Query("Like").setFilter(newsFilter);
        List<Entity> likeList =
                datastore.prepare(likeQuery).asList(FetchOptions.Builder.withDefaults());
        ArrayList<Like> loadedLikes = new ArrayList<Like>();
        for (Entity entity : likeList) {
            Like like = new Like();
            like.setUserKey(entity.getProperty("userKey").toString());
            like.setArticleKey(entity.getProperty("newsKey").toString());
            like.setStatus(entity.getProperty("status").toString());
            like.setLikeKey(KeyFactory.keyToString(entity.getKey()));
            loadedLikes.add(like);
        }
        return loadedLikes;
    }


    /**
     * check whether is liked
     * @param newsKey single news key
     * @param userKey user key
     * @return is/not liked
     */
    public boolean isLiked(String newsKey, String userKey){
        datastore = DatastoreServiceFactory.getDatastoreService();
        Query.Filter userFilter =
                new Query.FilterPredicate("userKey", Query.FilterOperator.EQUAL, userKey);
        Query.Filter newsFilter =
                new Query.FilterPredicate("newsKey", Query.FilterOperator.EQUAL, newsKey);
        Query.CompositeFilter newsUserFilter = Query.CompositeFilterOperator.and(userFilter, newsFilter);
        Query likeQuery = new Query("Like").setFilter(newsUserFilter);
        Entity like = datastore.prepare(likeQuery).asSingleEntity();
        if (like == null) {
            return false;
        } else {
            if (like.getProperty("status").toString().equals("unlike"))
                return false;
        }
        return true;
    }

    /**
     * adds new Like entity to datastore when user likes an article
     * @param newsManager newsManager
     * @param newsKey news key
     * @param title news title
     * @param author news author
     * @param content news content
     * @param likesCount news like count
     * @param date news date
     * @param like like utility
     */
    public void like (NewsManager newsManager, String newsKey, String title, String author, String content,
                      String likesCount, String date, Like like) {
        int count = Integer.parseInt(likesCount);
        count++;
        newsManager.editNews(newsKey, title, author, content, Integer.toString(count), date);
        Transaction txn = datastore.beginTransaction();
        try {
            Entity newLike = new Entity("Like");
            newLike.setProperty("userKey", like.getUserKey());
            newLike.setProperty("newsKey", like.getArticleKey());
            newLike.setProperty("status", like.getStatus());
            datastore.put(txn, newLike);
            txn.commit();
        } finally {
            if (txn.isActive()) {
                txn.rollback();
            }
        }
    }

    /**
     * modifies the like entity to unlike when user choose to unlike
     * @param newsManager news Manager
     * @param newsKey news key
     * @param title news title
     * @param author news author
     * @param content news content
     * @param likesCount news like count
     * @param date news date
     * @param like like utility
     */
    public void editlike (NewsManager newsManager, String newsKey, String title, String author, String content,
                      String likesCount, String date, Like like) {
        int count = Integer.parseInt(likesCount);
        if(like.getStatus().equals("like")){
            count++;
        } else {
            count--;
        }
        newsManager.editNews(newsKey, title, author, content, Integer.toString(count), date);
        Transaction txn = datastore.beginTransaction();
        try {
            try {
                Entity updatedLike = datastore.get(KeyFactory.stringToKey(like.getLikeKey()));
                updatedLike.setProperty("userKey", like.getUserKey());
                updatedLike.setProperty("newsKey", like.getArticleKey());
                updatedLike.setProperty("status", like.getStatus());

                datastore.delete(KeyFactory.stringToKey(like.getLikeKey()));
                datastore.put(updatedLike);
                txn.commit();

            } catch (EntityNotFoundException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (txn.isActive()) {
                txn.rollback();
            }
        }
    }
}
