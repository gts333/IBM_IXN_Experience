var contextPath = $("#contextPath").val();
var projectToggleButton = $("#addProject");
var addProjectButton = $("#sub-1");
var newProjectTopic = $("#newProjectTopic");
var newProjectContent = $("#newProjectContent");
var newProjectRepo = $("#newProjectRepo");
var newProjectImage = $("#formFile-1");
var allProjectsContainer = $("#allProjectsContainer");
var imageURL1;
projectToggleButton.on("click", function () {
    $("#newProjectContainer").slideToggle("slow");
    if(projectToggleButton.text() !== "cancel"){
        projectToggleButton.text("cancel");
    } else {
        projectToggleButton.text("add new project");
    }

});
function projectsPortalInitialize(){
    newProjectTopic.val("");
    newProjectContent.val("");
    newProjectRepo.val("");
    newProjectImage.val("");
    allProjectsContainer.empty();
    $.ajax({
        url: contextPath + "/projects",
        type: "GET",
        success: function (response) {
            for(var i = 0; i < response.length; i++){
                var index = i + 1;
                var currentNews = response[i];
                var curTopic = currentNews.title;
                if(currentNews.title.length > 40){
                    curTopic = currentNews.title.substring(0, 40) + "...";
                }
                var curContent = currentNews.content;
                if(currentNews.content.length > 40){
                    curContent = currentNews.content.substring(0,40) + "...";
                }
                var container = $("<div></div>").addClass("container-fluid row");
                var text1 = $("<h4></h4>").text(curTopic);
                text1.addClass("col-5");
                var text2 = $("<h4></h4>").text(curContent);
                text2.addClass("col-6");
                var hr = $("<hr>");
                var br = $("<p><br></p>");
                var button = $("<button></button>").text("remove").addClass("btn btn-outline-danger btn-sm col-auto");
                button.attr("title", currentNews.title );
                button.on("click", function (){
                    if (confirm('Are you sure you want to delete this project?')) {
                        var title = $(this).attr("title");
                        $.ajax({
                            url:contextPath + "/projects",
                            type: "DELETE",
                            data:{
                                title: title
                            },
                            success:function (resp) {
                                alert(resp);
                            }
                        });
                        //refresh the search results after deleting
                        projectsPortalInitialize();
                    }
                });
                text2.addClass("col-5");
                container.append(text1);
                container.append(text2);
                container.append(button);
                container.append(br);
                container.append(hr);
                allProjectsContainer.append(container);
            }
        }
    });
}


addProjectButton.click(function () {

    if(newProjectTopic.val() === ""){
        alert("please enter a title");
        return;
    }
    if(newProjectTopic.val().length > 500){
        alert("title too long, should be less than 500 characters");
        return;
    }
    if(newProjectRepo.val() === ""){
        alert("please enter repository link");
        return;
    }
    if(!newProjectRepo.val().length > 200){
        alert("link too long, should be less than 200 characters");
        return;
    }
    if(newProjectContent.val() === ""){
        alert("please enter description");
        return;
    }
    if(newProjectContent.val().length > 5000){
        alert("description too long, should be less than 5000 characters");
        return;
    }
    if(newProjectImage.val() === ""){
        alert("please upload an image");
        return;
    }
    $("#frm-reg-1").ajaxSubmit(function (data) {
        imageURL1 = data.data.url + "";
        $.ajax({
            url:  contextPath + "/projects",
            type: "POST",
            data: {
                topic: newProjectTopic.val(),
                content: newProjectContent.val(),
                repo: newProjectRepo.val(),
                image: imageURL1
            },
            success: function (response) {
                alert(response);
                projectsPortalInitialize();
            }
        })
    });

});















var file = document.getElementById('formFile-1');

file.onchange = function(e) {
    var ext = this.value.match(/\.([^\.]+)$/)[1];
    switch (ext) {
        case 'jpg':
        case 'bmp':
        case 'png':
        case 'jpeg':
        case 'webp':
            break;
        default:
            alert('The file format is not allowed');
            this.value = '';
    }
};
