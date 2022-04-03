//the max floor counter, default zero
var maxFloor = 0;
//the post id
var postId = $("#postId").val();
//the context path
var contextPath = $("#contextPath").val();
$.ajax({
    url: contextPath + "/getComments/" + postId  + ".do",
    dataType:"json",
    success: function(resp){
        if(resp.length !== 0){
            loadAllComments(resp);
        }
    }
});

function loadAllComments(resp){
    maxFloor = resp[resp.length - 1].floor;
    var commentsContainer = $("#commentsContainer");
    for(var i = 0; i < resp.length; i++) {
        var currentComment = resp[i];

        var div = $("<div></div>");
        div.css("min-height", "250px");
        var h3 = $("<h3></h3>").text(currentComment.content);
        div.append(h3);

        var div2= $("<div></div>");
        div2.addClass("row");
        var p = $("<p></p>");
        p.addClass("col-8");
        var timeString = new Date(currentComment.postTime).toString();
        timeString = timeString.substr(0, timeString.length - 31);
        var p2 = $("<p></p>").text("posted by "+ currentComment.name + " on " + timeString);
        p2.addClass("fst-italic");
        p2.addClass("col-4");
        div2.append(p);
        div2.append(p2);

        var lineSeparator = $("<hr>");

        commentsContainer.append(div);
        commentsContainer.append(div2);
        commentsContainer.append(lineSeparator);

    }
}






$(".toggleButton").on("click", function () {
    var toggleButton = $(".toggleButton")[0];
    $("#newCommentContainer").slideToggle("slow");
    if (toggleButton.innerText === "cancel") {
        toggleButton.innerText = "add comment";
    } else {
        toggleButton.innerText = "cancel";
    }
});


$(".postButton").on("click", function () {
    var newName = $("#newName");
    var newContent = $("#newContent");
    var newNameValue = newName.val();
    var newContentValue = newContent.val();
    if (newNameValue === "") {
        alert("please enter a name");
        return;
    }
    if (newNameValue.length > 20) {
        alert("name too long");
        return;
    }
    if (newContentValue === "") {
        alert("please enter the content");
        return;
    }
    if (newContentValue.length > 500) {
        alert("content too long");
        return;
    }
    $.ajax({
        type: "POST",
        url:contextPath + "/addComment.do",
        data: {
            id : postId,
            floor : maxFloor + 1,
            name: newNameValue,
            content: newContentValue
        },
        dataType: "text",
        success: function (resp) {
            alert(resp);
            location.reload();
        }
    });
});

