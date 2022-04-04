var contextPath = $("#contextPath").val();
var newsToggleButton = $("#addNews");
var addNewsButton = $("#sub");
var newNewsTopic = $("#newNewsTopic");
var newNewsContent = $("#newNewsContent");
var newNewsDate = $("#newNewsDate");
var newNewsImage = $("#formFile");
var allNewsContainer = $("#allNewsContainer");
var imageURL;
newsToggleButton.on("click", function () {
    $("#newNewsContainer").slideToggle("slow");
    if(newsToggleButton.text() !== "cancel"){
        newsToggleButton.text("cancel");
    } else {
        newsToggleButton.text("add new news");
    }

});
function newsPortalInitialize(){
    newNewsTopic.val("");
    newNewsContent.val("");
    newNewsDate.val("");
    newNewsImage.val("");
    allNewsContainer.empty();
    $.ajax({
        url: contextPath + "/news",
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
                    if (confirm('Are you sure you want to delete this news?')) {
                        var title = $(this).attr("title");
                        $.ajax({
                            url:contextPath + "/news",
                            type: "DELETE",
                            data:{
                                title: title
                            },
                            success:function (resp) {
                                alert(resp);
                            }
                        });
                        //refresh the search results after deleting
                        newsPortalInitialize();
                    }
                });
                text2.addClass("col-5");
                container.append(text1);
                container.append(text2);
                container.append(button);
                container.append(br);
                container.append(hr);
                allNewsContainer.append(container);
            }
        }
    });
}

addNewsButton.click(function () {

    if(newNewsTopic.val() === ""){
        alert("please enter a title");
        return;
    }
    if(newNewsTopic.val().length > 500){
        alert("title too long, should be less than 500 characters");
        return;
    }
    if(newNewsDate.val() === ""){
        alert("please enter a title");
        return;
    }
    if(!newNewsDate.val().match(/^\d{4}-\d{2}-\d{2}$/)){
        alert("invalid date format");
        return;
    }
    if(newNewsContent.val() === ""){
        alert("please enter content");
        return;
    }
    if(newNewsContent.val().length > 5000){
        alert("content too long, should be less than 5000 characters");
        return;
    }
    if(newNewsImage.val() === ""){
        alert("please upload an image");
        return;
    }
    $("#frm-reg").ajaxSubmit(function (data) {
        imageURL = data.data.url + "";
        console.log(imageURL);
        $.ajax({
            url:  contextPath + "/news",
            type: "POST",
            data: {
                topic: newNewsTopic.val(),
                content: newNewsContent.val(),
                time: newNewsDate.val(),
                image: imageURL
            },
            success: function (response) {
                alert(response);
                newsPortalInitialize();
            }
        })
    });

});




var file = document.getElementById('formFile');

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
