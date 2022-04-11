var contextPath = $("#contextPath").val();
var newsContainer = $("#newsDisplayingContainer");
newsInitialize();
function newsInitialize() {
    newsContainer.empty();
    $.ajax({
        url: contextPath + "/news",
        type: "GET",
        async: false,
        success: function (resp) {
            for(var i = 0; i < resp.length; i++){
                var currentContainer = $("<div></div>");
                var index = i + 1;
                var currentNews = resp[i];
                var title = currentNews.title;
                var content = currentNews.content;
                var imageURL = currentNews.image;
                var date = currentNews.time;
                var newsTitle = $("<h1></h1>").text(title).addClass("fw-bold");
                var newsDate = $("<h3></h3>").text(date);
                var newsImage = $("<img class=\"img-fluid\" alt=newsImage" + index + " src=" + imageURL  +">");
                var newsContent = $("<h5></h5>").text(content).addClass("myDisplayText");
                var hr = $("<hr>");
                currentContainer.append(newsTitle);
                currentContainer.append(newsDate);
                currentContainer.append(newsImage);
                currentContainer.append(newsContent);
                currentContainer.append(hr);
                currentContainer.attr("id", title.replace(/\s/g, "").split('.').join(""));
                newsContainer.append(currentContainer);
            }
        }
    });
}