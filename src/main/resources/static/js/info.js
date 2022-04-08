var entities = $("#entities");
var contextPath = $("#contextPath").val();
infoInitialize();
function infoInitialize() {
    $.ajax({
        type: "GET",
        url: contextPath + "/infos",
        success: function (resp) {
            for(var i = 0; i < resp.length; i++){
                var index = i + 1;
                var currentInfo = resp[i];

                var button =  $("<button></button>").addClass("responsiveText entity");
                button.attr("id",index + "");

                button.on("click", function () {
                    var id = $(this).attr("id");
                    var icon = $("#icon" + id);
                    var content = $("#content" + id);
                    if (content.hasClass("d-none")) {
                        content.removeClass("d-none");
                        icon.removeClass("bi-chevron-right");
                        icon.addClass("bi-chevron-down");
                    } else {
                        content.addClass("d-none");
                        icon.removeClass("bi-chevron-down");
                        icon.addClass("bi-chevron-right");
                    }
                });

                var content = $("<div></div>").addClass("responsiveTextContent d-none");
                content.attr("id", "content"+ index);
                content.text(currentInfo.content);
                var curContainer = $("<div></div>").attr("id", currentInfo.topic.replace(/\s/g, "").split('.').join(""));
                curContainer.append(button);
                curContainer.append(content);
                entities.append(curContainer);
                var ii = $("<i></i>").addClass("bi bi-chevron-right");
                ii.attr("id", "icon" + index);
                var text = $("<p></p>").text("");
                text.append(ii);
                var newText = $("<p></p>").text(currentInfo.topic);
                newText.css('display', 'inline-block');
                text.append(newText);
                button.append(text);
            }
        }

    })
}


//assign trigger events to all entities
$(".entity").on("click", function () {
    var id = $(this).attr("id");
    var icon = $("#icon" + id);
    var content = $("#content" + id);
    if (content.hasClass("d-none")) {
        content.removeClass("d-none");
        icon.removeClass("bi-chevron-right");
        icon.addClass("bi-chevron-down");
    } else {
        content.addClass("d-none");
        icon.removeClass("bi-chevron-down");
        icon.addClass("bi-chevron-right");
    }
});












