
$(document).ready(function(){
    $(".favorito").click(function(e){
        e.preventDefault();
        var button = $(this);
        var hotelId = button.data("hotel");
        var divElement = button.find("div");
        var isFavorite = divElement.hasClass("esfavorito");
        var login = document.getElementById('openModalSesion');

        

        $.ajax({
            url: "MainController",
            method: "POST",
            data: {
                action: 'sessionExist'
            },
            success: function(response) {
                if (response.sessionExists) {
                    $.ajax({
                        url: "MainController",
                        method: "POST",
                        data: {
                            action: 'favorito',
                            hotelId: hotelId,
                            isFavorite: isFavorite
                        },
                        success: function(response) {
                            if (response.success) {
                                if (response.isFavorite) {
                                    window.location.href = 'ClienteController?action=favoritos';                         

                                } else {
                                    window.location.href = 'ClienteController?action=favoritos';                         

                                }
                            }
                        }
                    });
                }else{
                    login.click();
                }
            }
        });
    });
});

