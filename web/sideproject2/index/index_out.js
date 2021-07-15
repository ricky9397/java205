window.onload = function(){
    var swiper = new Swiper(".mySwiper1", {
        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
    });

    var swiper2 = new Swiper(".mySwiper2", {
        slidesPerView: 3,
        spaceBetween: 30,
        pagination: {
        el: ".swiper-pagination",
        clickable: true,
        },
    });
};