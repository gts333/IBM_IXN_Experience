var contextPath = $("#contextPath").val();
var contentt = $("#content").val();
var searchResultContainer = $("#searchResultContainer");
var loadingDiv = $('#loadingDiv');
var defaultDisplay = $("#defaultDisplay");
var successNotification = $("#resultSuccessNotification");
var failureNotification = $("#resultFailureNotification");

//initializing
defaultDisplay.addClass("d-none");
loadingDiv.removeClass("d-none");
successNotification.addClass("d-none");
failureNotification.addClass("d-none");
searchResultContainer.empty();
if(contentt === ""){
    alert("please enter the content to search!");
    loadingDiv.addClass("d-none");
    defaultDisplay.removeClass("d-none");
    failureNotification.removeClass("d-none");
} else if (contentt.length > 500 ){
    alert("content too long!");
    loadingDiv.addClass("d-none");
    defaultDisplay.removeClass("d-none");
    failureNotification.removeClass("d-none");
} else {
    $.ajax({
        url: contextPath + "/search",
        type: "POST",
        data: {
            content: contentt
        },
        success: function (resp) {
            loadingDiv.addClass("d-none");
            defaultDisplay.removeClass("d-none");
            for (const [key, value] of Object.entries(resp)) {
                if(key === "NOMATCHINGRESULT"){
                    failureNotification.removeClass("d-none");
                    return;
                }
                successNotification.removeClass("d-none");
                var href = $("<a target='_blank' href=" + value + "></a>").addClass("ms-4 display-3 resultEntity link-secondary rounded p-3 text-decoration-none");
                var div = $("<div></div>").addClass("ms-4 display-3 resultEntity").text(key);
                href.append(div);
                href.append($("<hr>"));
                searchResultContainer.append(href);
            }
        }
    });

}




