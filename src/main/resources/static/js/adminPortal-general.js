//the context path
var contextPath = $("#contextPath").val();
var adminPortalForGeneral = $("#adminPortalForGeneral");
var adminPortalForForum = $("#adminPortalForForum");
var adminPortalForNews = $("#adminPortalForNews");
var adminPortalForProjects = $("#adminPortalForProjects");
var adminPortalForInfo = $("#adminPortalForInfo");

function generalClicked(){
    adminPortalForGeneral.removeClass("d-none");
    adminPortalForForum.addClass("d-none");
    adminPortalForNews.addClass("d-none");
    adminPortalForProjects.addClass("d-none");
    adminPortalForInfo.addClass("d-none");
    window.scrollTo(0,0)
}
function forumClicked(){
    adminPortalForGeneral.addClass("d-none");
    adminPortalForForum.removeClass("d-none");
    adminPortalForNews.addClass("d-none");
    adminPortalForProjects.addClass("d-none");
    adminPortalForInfo.addClass("d-none");
    window.scrollTo(0,0)
}
function newsClicked(){
    adminPortalForGeneral.addClass("d-none");
    adminPortalForForum.addClass("d-none");
    adminPortalForNews.removeClass("d-none");
    adminPortalForProjects.addClass("d-none");
    adminPortalForInfo.addClass("d-none");
    window.scrollTo(0,0)
}
function projectsClicked(){
    adminPortalForGeneral.addClass("d-none");
    adminPortalForForum.addClass("d-none");
    adminPortalForNews.addClass("d-none");
    adminPortalForProjects.removeClass("d-none");
    adminPortalForInfo.addClass("d-none");
    window.scrollTo(0,0)
}
function infoClicked(){
    adminPortalForGeneral.addClass("d-none");
    adminPortalForForum.addClass("d-none");
    adminPortalForNews.addClass("d-none");
    adminPortalForProjects.addClass("d-none");
    adminPortalForInfo.removeClass("d-none");
    window.scrollTo(0,0)
}