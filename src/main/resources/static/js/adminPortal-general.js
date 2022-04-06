//the context path
var contextPath = $("#contextPath").val();
var adminPortalForGeneral = $("#adminPortalForGeneral");
var adminPortalForForum = $("#adminPortalForForum");
var adminPortalForNews = $("#adminPortalForNews");
var adminPortalForProjects = $("#adminPortalForProjects");
var adminPortalForInfo = $("#adminPortalForInfo");

function generalClicked(){
    adminPortalForGeneral.removeClass("d-none");
    adminPortalForForum.addClass("d-none");
    adminPortalForNews.addClass("d-none");
    adminPortalForProjects.addClass("d-none");
    adminPortalForInfo.addClass("d-none");
    window.scrollTo(0,0);
    generalInitialize();
}
function forumClicked(){
    adminPortalForGeneral.addClass("d-none");
    adminPortalForForum.removeClass("d-none");
    adminPortalForNews.addClass("d-none");
    adminPortalForProjects.addClass("d-none");
    adminPortalForInfo.addClass("d-none");
    window.scrollTo(0,0);
    forumPortalInitialize();
}
function newsClicked(){
    adminPortalForGeneral.addClass("d-none");
    adminPortalForForum.addClass("d-none");
    adminPortalForNews.removeClass("d-none");
    adminPortalForProjects.addClass("d-none");
    adminPortalForInfo.addClass("d-none");
    window.scrollTo(0,0);
    newsPortalInitialize();
}
function projectsClicked(){
    adminPortalForGeneral.addClass("d-none");
    adminPortalForForum.addClass("d-none");
    adminPortalForNews.addClass("d-none");
    adminPortalForProjects.removeClass("d-none");
    adminPortalForInfo.addClass("d-none");
    window.scrollTo(0,0);
    projectsPortalInitialize();
}
function infoClicked(){
    adminPortalForGeneral.addClass("d-none");
    adminPortalForForum.addClass("d-none");
    adminPortalForNews.addClass("d-none");
    adminPortalForProjects.addClass("d-none");
    adminPortalForInfo.removeClass("d-none");
    window.scrollTo(0,0);
    infoPortalInitialize();
}

var generateReportButton = $("#generateReportButton");
var reportContainer = $("#reportContainer");
function generalInitialize(){
    reportContainer.empty();
}

generateReportButton.click(function () {
    reportContainer.empty();
    alert("Please wait, it takes sometime to load");
    $.ajax({
        url: "/userInputs",
        type: "GET",
        success:function (resp) {
            var words = [];
            var counts = [];
            for (const [key, value] of Object.entries(resp)) {
                words.push(key);
                counts.push(value);
            }
            console.log(words);
            console.log(counts);

            //creating the chart
            var canvas = $("<canvas></canvas>").attr("id", "myChart");
            var div = $("<div></div>").attr("id", "chartContainer");
            div.append(canvas);
            reportContainer.append(div);
            const data = {
                labels: words,
                datasets: [{
                    axis: 'y',
                    label: 'Keywords appearance frequency',
                    data: counts,
                    fill: false,
                    backgroundColor: 'rgba(54, 162, 235, 0.2)',
                    borderColor: 'rgb(54, 162, 235)',
                    borderWidth: 1
                }]
            };
            const config = {
                type: 'bar',
                data,
                options: {
                    indexAxis: 'y',
                }
            };
            const myChart = new Chart(
                document.getElementById('myChart'),
                config
            );
        }
    })
});