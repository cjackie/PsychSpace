$(document).ready(function(){
    setActiveLearnNav();
});

function setActiveLearnNav() {
    var url = window.location.href;
    url = url.substring(url.lastIndexOf("/") + 1, url.length);
    console.log(url);
    if (url == "") {
        $("#nav-learn-progress").addClass("active");
        $("#nav-learn-habit").removeClass("active");
        $("#nav-learn-cues").removeClass("active");
        $("#nav-learn-evaluations").removeClass("active");
        $("#nav-learn-videos").removeClass("active");
        $("#nav-learn-forum").removeClass("active");
    }
    else if (url == "habit") {
        $("#nav-learn-progress").removeClass("active");
        $("#nav-learn-habit").addClass("active");
        $("#nav-learn-cues").removeClass("active");
        $("#nav-learn-evaluations").removeClass("active");
        $("#nav-learn-videos").removeClass("active");
        $("#nav-learn-forum").removeClass("active");
    }
    else if (url == "cues") {
        $("#nav-learn-progress").removeClass("active");
        $("#nav-learn-habit").removeClass("active");
        $("#nav-learn-cues").addClass("active");
        $("#nav-learn-evaluations").removeClass("active");
        $("#nav-learn-videos").removeClass("active");
        $("#nav-learn-forum").removeClass("active");
    }
    else if (url == "evaluation") {
        $("#nav-learn-progress").removeClass("active");
        $("#nav-learn-habit").removeClass("active");
        $("#nav-learn-cues").removeClass("active");
        $("#nav-learn-evaluations").addClass("active");
        $("#nav-learn-videos").removeClass("active");
        $("#nav-learn-forum").removeClass("active");
    }
    else if (url == "videos") {
        $("#nav-learn-progress").removeClass("active");
        $("#nav-learn-habit").removeClass("active");
        $("#nav-learn-cues").removeClass("active");
        $("#nav-learn-evaluations").removeClass("active");
        $("#nav-learn-videos").addClass("active");
        $("#nav-learn-forum").removeClass("active");
    }
    else if (url == "forum") {
        $("#nav-learn-progress").removeClass("active");
        $("#nav-learn-habit").removeClass("active");
        $("#nav-learn-cues").removeClass("active");
        $("#nav-learn-evaluations").removeClass("active");
        $("#nav-learn-videos").removeClass("active");
        $("#nav-learn-forum").addClass("active");
    }
    else{
        $("#nav-learn-progress").removeClass("active");
        $("#nav-learn-habit").removeClass("active");
        $("#nav-learn-cues").removeClass("active");
        $("#nav-learn-evaluations").removeClass("active");
        $("#nav-learn-videos").removeClass("active");
        $("#nav-learn-forum").removeClass("active");
    }

}