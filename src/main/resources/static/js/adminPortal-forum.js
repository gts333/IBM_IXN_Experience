//the context path
var contextPath = $("#contextPath").val();
//the text to display when no matches
var noMatchNotice = $("#noMatchHint");
//the search button
var searchButton = $("#search");
//when the search button is clicked
function forumPortalInitialize(){
    $("#searchPost").val("");
    $("#postsContainer").empty();
}
searchButton.click(function(){
    noMatchNotice.addClass("d-none");
    $("#postsContainer").empty();
    var titleToSearch = $("#searchPost").val();
    if(titleToSearch === ""){
        alert("please enter a title");
        return;
    }
    $.ajax({
        url:contextPath + "/posts/byTitle/" + titleToSearch,
        type: "GET",
        dataType:"json",
        success:function (resp) {
            if(resp.length === 0){
                noMatchNotice.removeClass("d-none");
            }else {
                displayPosts(resp);
            }
        }
    })
});

//the function that displays all posts
function displayPosts(resp){
    var container = $("#postsContainer");
    for(var i = 0; i < resp.length; i++){
        var post = resp[i];
        var title = $("<p></p>").text(post.title);
        title.addClass("col-5");
        var author = $("<p></p>").text(post.name);
        author.addClass("col-2");
        var timeString = new Date(post.postTime).toString();
        timeString = timeString.substr(0, timeString.length - 31);
        var time = $("<p></p>").text(timeString);
        time.addClass("col-2");

        var removeButton = $("<button></button>").text("Remove Post");
        removeButton.addClass("btn btn-danger removePost");
        removeButton.attr("postId", post.id);
        var removeButtonDiv = $("<div></div>");
        removeButtonDiv.addClass("p-2 col-1");
        removeButtonDiv.append(removeButton);

        var viewCommentsButton = $("<button></button>").text("View Comments");
        viewCommentsButton.addClass("btn btn-dark viewComments");
        viewCommentsButton.attr("postId", post.id);
        var viewCommentsButtonDiv = $("<div></div>");
        viewCommentsButtonDiv.addClass("p-2 col-1 ");
        viewCommentsButtonDiv.append(viewCommentsButton);

        var commentsContainer = $("<div></div>");
        commentsContainer.addClass("d-none bg-light col-11 border");
        commentsContainer.attr("id", post.id);

        var div = $("<div></div>");

        div.addClass("row");
        div.append(title);
        div.append(author);
        div.append(time);
        div.append(removeButtonDiv);
        div.append(viewCommentsButtonDiv);
        container.append(div);
        container.append(commentsContainer);

        removeButton.on("click", function () {
            if (confirm('Are you sure to delete this post along with all the comments?')) {
                id = $(this).attr("postId");
                $.ajax({
                    url:contextPath + "/posts/" + id,
                    type: "DELETE",
                    success:function (resp) {
                        alert(resp);
                    }
                });
                //refresh the search results after deleting
                searchButton.trigger("click");
            }
        });

        viewCommentsButton.on("click", function () {
            var button = $(this);
            var id = button.attr("postId");
            var commentsContainer = $("#"+id);
            if(commentsContainer.hasClass("d-none")){
                button.text("Hide Comments");
                commentsContainer.removeClass("d-none");
                $.ajax({
                    url:contextPath + "/comments/" + id,
                    success:function (resp) {
                        if (resp.length === 0){
                            commentsContainer.text("No comments found for this post");
                        }else {
                            var headerContainer= $("<div></div>");
                            headerContainer.addClass("row");
                            var headerContent = $("<p></p>").text("Comment Content");
                            headerContent.addClass("col-6 fw-bold");
                            var headerAuthor = $("<p></p>").text("Comment Author");
                            headerAuthor.addClass("col-2 fw-bold");
                            var headerTime = $("<p></p>").text("Comment Time");
                            headerTime.addClass("col-2 fw-bold");
                            headerContainer.append(headerContent);
                            headerContainer.append(headerAuthor);
                            headerContainer.append(headerTime);
                            commentsContainer.append(headerContainer);
                            for(var i = 0; i < resp.length; i++){
                                var currentComment = resp[i];
                                var content = $("<p></p>").text(currentComment.content);
                                content.addClass("col-6");
                                var author = $("<p></p>").text(currentComment.name);
                                author.addClass("col-2");
                                var timeString = new Date(currentComment.postTime).toString();
                                timeString = timeString.substr(0, timeString.length - 31);
                                var time = $("<p></p>").text(timeString);
                                time.addClass("col-2");

                                var removeButton = $("<button></button>").text("Remove Comment");
                                removeButton.addClass("btn btn-danger removeComment");
                                removeButton.attr("postId", currentComment.id);
                                removeButton.attr("floor", currentComment.floor);
                                var removeButtonDiv = $("<div></div>");
                                removeButtonDiv.addClass("p-4 col-2");
                                removeButtonDiv.append(removeButton);

                                var div = $("<div></div>");
                                div.addClass("row");
                                div.append(content);
                                div.append(author);
                                div.append(time);
                                div.append(removeButtonDiv);
                                commentsContainer.append(div);

                                removeButton.on("click", function (){
                                    if (confirm('Are you sure to delete this comment?')) {
                                        var floor = $(this).attr("floor");
                                        var id = $(this).attr("postId");
                                        $.ajax({
                                            url:contextPath + "/comments",
                                            type: "DELETE",
                                            data:{
                                              id:id,
                                              floor:floor
                                            },
                                            success:function (resp) {
                                                alert(resp);
                                            }
                                        });
                                        //refresh the search results after deleting
                                        searchButton.trigger("click");
                                    }
                                })
                            }
                        }
                    }
                });
            }else {
                button.text("View Comments");
                commentsContainer.addClass("d-none");
                commentsContainer.empty();
            }

        });
    }
}

