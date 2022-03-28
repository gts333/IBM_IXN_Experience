var cooperation =  $("#cooperation");
var cooperationHeight = cooperation.offset().top;
var city = $("#city");
var cityHeight = city.offset().top;
var caption4 = $("#caption4");
var caption5 = $("#caption5");
var caption7 = $("#caption7");
var caption8 = $("#caption8");



$("#downButton1").on("click", function () {
    location.href='#cooperation';
    caption4.fadeIn(2000);
    caption5.fadeIn(3000);
});
$("#downButton2").on("click", function () {
    location.href='#city';
    caption7.fadeIn(2000);
    caption8.fadeIn(3000);
});
$("#downButton3").on("click", function () {
    location.href="#selectRowTitle";
});



$(window).scroll(function () {
    var scroll = $(window).scrollTop();
    if(scroll + 300 > cooperationHeight){
        caption4.fadeIn(2000);
        caption5.fadeIn(3000);
    }
    if(scroll + 300 > cityHeight){
        caption7.fadeIn(2000);
        caption8.fadeIn(3000);
    }
});


//the below is the js for the back to top button
//Get the button
let mybutton = document.getElementById("btn-back-to-top");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function () {
    scrollFunction();
};

function scrollFunction() {
    if (
        document.body.scrollTop > 20 ||
        document.documentElement.scrollTop > 20
    ) {
        mybutton.style.display = "block";
    } else {
        mybutton.style.display = "none";
    }
}
// When the user clicks on the button, scroll to the top of the document
mybutton.addEventListener("click", backToTop);

function backToTop() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}