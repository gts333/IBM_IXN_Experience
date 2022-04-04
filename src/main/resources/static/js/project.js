var contextPath = $("#contextPath").val();
var projectsContainer = $("#projectsDisplayingContainer");
projectsInitialize();
function projectsInitialize() {
    projectsContainer.empty();
    $.ajax({
        url: contextPath + "/projects",
        type: "GET",
        success: function (resp) {
            for(var i = 0; i < resp.length; i++){
                var currentContainer = $("<div></div>")
                var index = i + 1;
                var currentNews = resp[i];
                var title = currentNews.title;
                var content = currentNews.content;
                var imageURL = currentNews.image;
                var repo = currentNews.repo;
                var newsTitle = $("<h3></h3>").text(title).addClass("fw-bold d-flex justify-content-center");
                var newsDate = $("<a target=\"_blank\" href=" + repo  + ">Youtube Link</a>").addClass("d-flex justify-content-center");
                var newsImage = $("<img class=\"img-fluid\" alt=newsImage" + index + " src=" + imageURL  +">");
                var newsContent = $("<h5></h5>").text(content);
                currentContainer.append(newsTitle);
                currentContainer.append(newsImage);
                currentContainer.append(newsContent);
                currentContainer.append(newsDate);
                currentContainer.addClass("rounded border border-1 m-1 p-1");
                var externalContainer = $("<div></div>").addClass("col-4");
                externalContainer.append(currentContainer);
                projectsContainer.append(externalContainer);
            }
        }

    })
}