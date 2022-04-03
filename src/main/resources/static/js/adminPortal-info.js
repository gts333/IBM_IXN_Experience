var contextPath = $("#contextPath").val();
var adminPortalForInfoContainer = $("#adminPortalForInfoContainer");
var toggleButton = $("#addInfo");
var addButton = $("#confirmAddInfo");

function infoPortalInitialize(){
    adminPortalForInfoContainer.empty();
    var newTopic = $("#newTopic");
    var newContent = $("#newContent");
    newTopic.val("");
    newContent.val("");
    $.ajax({
        type: "GET",
        url: contextPath + "/infos",
        success: function (resp) {
            for(var i = 0; i < resp.length; i++){
                var index = i + 1;
                var currentInfo = resp[i];
                var curTopic = currentInfo.topic;
                if(currentInfo.topic.length > 40){
                    curTopic = currentInfo.topic.substring(0, 40) + "...";
                }
                var curContent = currentInfo.content;
                if(currentInfo.content.length > 40){
                    curContent = currentInfo.content.substring(0,40) + "...";
                }
                var container = $("<div></div>").addClass("container-fluid row");
                var text1 = $("<h4></h4>").text(curTopic);
                text1.addClass("col-5");
                var text2 = $("<h4></h4>").text(curContent);
                text2.addClass("col-6");
                var hr = $("<hr>");
                var br = $("<p><br></p>")
                var button = $("<button></button>").text("remove").addClass("btn btn-outline-danger btn-sm col-auto");
                button.attr("topic", currentInfo.topic );
                button.on("click", function (){
                    if (confirm('Are you sure you want to delete this entity?')) {
                        var topic = $(this).attr("topic");
                        $.ajax({
                            url:contextPath + "/infos",
                            type: "DELETE",
                            data:{
                                topic: topic
                            },
                            success:function (resp) {
                                alert(resp);
                            }
                        });
                        //refresh the search results after deleting
                        infoPortalInitialize();
                    }
                });
                text2.addClass("col-5");
                container.append(text1);
                container.append(text2);
                container.append(button);
                container.append(br);
                container.append(hr);
                adminPortalForInfoContainer.append(container);

            }
        }

    })

}
toggleButton.on("click", function () {
    $("#addContainer").slideToggle("slow");
    if(toggleButton.text() !== "cancel"){
        toggleButton.text("cancel");
    } else {
        toggleButton.text("add new entity");
    }

});
addButton.click(function () {
    var newTopic = $("#newTopic");
    var newContent = $("#newContent");
    var newTopicValue = newTopic.val();
    var newContentValue = newContent.val();
    if (newTopicValue === "") {
        alert("please enter a topic");
        return;
    }
    if (newTopicValue.length > 500) {
        alert("topic length too long! should be shorter than 500 characters");
        return;
    }
    if (newContentValue === "") {
        alert("please enter the content");
        return;
    }
    if (newContentValue.length > 5000) {
        alert("content length too long! should be shorter than 5000 characters");
        return;
    }
    $.ajax({
        type: "POST",
        url: contextPath + "/infos",
        data: {
            topic: newTopicValue,
            content: newContentValue
        },
        dataType: "text",
        success: function (resp) {
            alert(resp);
            infoPortalInitialize();
        }
    });
});