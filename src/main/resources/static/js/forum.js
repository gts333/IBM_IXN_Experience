//the number of pages
var maxCount;
//the context path
var contextPath = $("#contextPath").val();

//when loading the forum page, load the pagination and the first page of posts
$.ajax({
    url: contextPath + "/posts/count",
    type: "GET",
    dataType: "text",
    success(resp) {
        loadPagination(resp);
    }
});

//load pagination and the first page
function loadPagination(resp) {
    var count = parseInt(resp);
    count = Math.ceil(count / 10);
    maxCount = count;
    if (count <= 1) {
        $.ajax({
            url: contextPath + "/posts",
            type: "GET",
            dataType: "json",
            success(resp) {
                loadPosts(resp);
            }
        });
    } else {
        var next = $("#next");
        for (var i = 2; i <= count; i++) {
            var li = $("<li></li>");
            li.addClass("page-item");
            li.attr("id", "page" + i);
            var button = $("<button></button>");
            button.addClass("page-link");
            button.text(i);
            li.append(button);
            li.attr("onclick", "loadRequiredPosts(" + i + ")");
            li.insertBefore(next);
        }
        next.removeClass("disabled");
        $.ajax({
            url: contextPath + "/posts/requiredRange",
            type: "GET",
            data: {index: 1},
            dataType: "json",
            success(resp) {
                loadPosts(resp);
            }
        })
    }


}

//whenever a button on the pagination is clicked, load required posts
function loadRequiredPosts(i) {
    if (i === 1) {
        $("#previous").addClass("disabled");
        $("#next").removeClass("disabled");
    } else if (i === maxCount) {
        $("#next").addClass("disabled");
        $("#previous").removeClass("disabled");
    } else {
        $("#previous").removeClass("disabled");
        $("#next").removeClass("disabled");
    }
    $("li.active").removeClass("active");
    $("#page" + i).addClass("active");
    $("#forumPostsContainer").empty();
    $.ajax({
        url: contextPath + "/posts/requiredRange",
        type: "GET",
        data: {index: i},
        dataType: "json",
        success(resp) {
            loadPosts(resp);
        }
    })
}

//the general load posts function
function loadPosts(resp) {
    for (var i = 0; i < resp.length; i++) {
        var currentPost = resp[i];
        var h1 = $("<h1></h1>").text(currentPost.title);
        h1.addClass("display-3");
        var a = $("<a></a>").attr("href", "posts/getPage/" + currentPost.id);
        a.addClass("link-dark");
        a.addClass("text-decoration-none");
        a.append(h1);
        var newline = $("<h3></h3>").html("<br/>");
        var row = $("<div></div>").addClass("row");
        var name = $("<div></div>").addClass("col-8");
        name.text("posted by " + currentPost.name);
        var time = $("<div></div>").addClass("col-4");
        var timeString = new Date(currentPost.postTime).toString();
        timeString = timeString.substr(0, timeString.length - 34);
        time.text("posted on " + timeString);
        row.append(name);
        row.append(time);
        var currentDiv = $("<div class='container'></div>");
        currentDiv.append(a);
        currentDiv.append(newline);
        currentDiv.append(row);
        currentDiv.append("<hr>");
        $("#forumPostsContainer").append(currentDiv);

    }
}

//previous page
function previous() {
    var currentActiveIndex = parseInt($("li.active").attr("id").slice(-1));
    loadRequiredPosts(currentActiveIndex - 1);
}

//next page
function next() {
    var currentActiveIndex = parseInt($("li.active").attr("id").slice(-1));
    loadRequiredPosts(currentActiveIndex + 1);
}


$(".toggleButton").on("click", function () {
    var toggleButton = $(".toggleButton")[0];
    $("#newPostContainer").slideToggle("slow");
    if (toggleButton.innerText === "cancel") {
        toggleButton.innerText = "add new topic";
    } else {
        toggleButton.innerText = "cancel";
    }
});

$(".postButton").on("click", function () {
    var newTitle = $("#newTitle");
    var newName = $("#newName");
    var newContent = $("#newContent");
    var newTitleValue = newTitle.val();
    var newNameValue = newName.val();
    var newContentValue = newContent.val();
    if (newTitleValue === "") {
        alert("please enter a topic");
        return;
    }
    if (newTitleValue.length > 60) {
        alert("topic too long");
        return;
    }
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
    if (newContentValue.length > 1000) {
        alert("content too long");
        return;
    }
    //log the userInput, this time post topic
    $.ajax({
        url: contextPath + "/userInputs",
        type: "POST",
        data: {
            content: newTitleValue
        },
        success: function (resp) {}
    });
    //log the userInput, this time post content
    $.ajax({
        url: contextPath + "/userInputs",
        type: "POST",
        data: {
            content: newContentValue
        },
        success: function (resp) {}
    });
    $.ajax({
        type: "POST",
        url: contextPath + "/posts",
        data: {
            title: newTitleValue,
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

$("#searchButton").on("click", function () {
    var title = $("#searchBar").val();
    if (title === "") {
        alert("please enter the topic");
        return;
    }
    //log the userInput
    $.ajax({
        url: contextPath + "/userInputs",
        type: "POST",
        data: {
            content: title
        },
        success: function (resp) {}
    });
    $.ajax({
        url: contextPath + "/posts/byTitle/" + title,
        type: "GET",
        dataType: "json",
        success: function(resp) {
            var forumPostsContainer = $("#forumPostsContainer");
            forumPostsContainer.empty();
            $("#forumPaginationContainer").empty();
            if (resp.length === 0){
                var h1 = $("<h1></h1>");
                h1.text("Sorry, no post matches your search.");
                h1.addClass("display-3");
                forumPostsContainer.append(h1);
            }else {
                loadPosts(resp);
            }
        }
    });
});