package com.spacecadet.psychspace.testData;

import com.spacecadet.psychspace.dataManager.NewsManager;

/**
 * Dummy data for news
 * Created by aliao on 4/28/2017.
 */
public class NewsTest {

    private NewsManager newsManager = new NewsManager();

    /**
     * Provides dummy data for newsfeed.
     */
    public void news_test() {
        newsManager.addNews("What Makes Self-Directed Learning Effective?",
                "Association for Psychological Science",
                "While the benefits of self-directed learning are widely acknowledged, the reasons why a " +
                        "sense of control leads to better acquisition of material are poorly understood.",
                "5",
                "06/04/1995");

        newsManager.addNews("10 Essential Emotion Regulation Skills for Adults",
                "Alice Boyes",
                "If you can tolerate feeling anxious you’ll be less likely to avoid trying new things, more " +
                        "likely to try things a second time if it didn’t go well the first time, and less likely to " +
                        "abandon projects before they’ve become successful.",
                "2",
                "04/08/2013");

        newsManager.addNews("Self-Regulation",
                "Steven Stosny",
                "Research consistently shows that self-regulation skill is necessary for reliable emotional " +
                        "well being. Behaviorally, self-regulation is the ability to act in your long-term best " +
                        "interest, consistent with your deepest values. (Violation of one's deepest values causes " +
                        "guilt, shame, and anxiety, which undermine well being.) Emotionally, self-regulation is the " +
                        "ability to calm yourself down when you're upset and cheer yourself up when you're down.",
                "12",
                "10/28/2011");
        newsManager.addNews("How Self-Regulation Works",
                "Yalda T. Uhls",
                "Self-regulation is an extremely important skill to develop.  In fact, as I am writing this " +
                        "post, with no outside person or institution forcing me to do, on a vacation day when it is " +
                        "sunny outside, I am demonstrating formidable self-regulation.  I believe that teaching " +
                        "children, and adults, how to self-regulate is one of the best things we can teach them. " +
                        "Too often, we mommy-regulate (i.e helicopter parenting) and children don’t learn the " +
                        "essential skills they need to develop to take care of themselves in the world outside of a " +
                        "safe haven of home.  So, below is a brief review about self-regulation.Effective " +
                        "self-regulators proactively direct their strategies to achieve self-set goals " +
                        "(Zimmerman, 2002). A good self-regulator will pay attention to task, persist when it becomes " +
                        "difficult, demonstrate flexibility and be confident that additional effort will lead to " +
                        "positive outcomes (Schunk, 2005). The literature about self-regulation is immense; the good " +
                        "news is we understand not only that it works but also how it works.  Hundreds of studies in " +
                        "a variety of contexts, not only in the classroom, but also in healthcare and other arenas, " +
                        "found similar positive outcomes for better self-regulated learners (Duckworth, Akerman, " +
                        "MacGregor, Salter, & Vorhaus, 2009).",
                "23",
                "12/28/2001");
        newsManager.addNews("Self-Regulation: The Second Core Strength",
                "Bruce Duncan Perry",
                "While the benefits of self-directed learning are widely acknowledged, the reasons why a sense of control leads to better acquisition of material are poorly understood.",
                "8",
                "03/22/2017");
    }
}
