<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>ReservaYa</title>

    <!-- tailwind -->
    <script src="https://cdn.tailwindcss.com"></script>

    <!-- slider -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css" integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css" integrity="sha512-17EgCFERpgZKcm0j0fEq1YCJuyAWdz9KUtv1EjVuaOz8pDnh/0nZxmU6BBXwaaxqoi9PQXnRWqlcDB027hgv9A==" crossorigin="anonymous" referrerpolicy="no-referrer" />  

    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- funciones locales -->
    <script src="js/funciones.js" type="text/javascript"></script>


    <!-- estilos locales -->
    <link rel="stylesheet" href="css/styles.css">


</head>
<body class="bg-[#0F1522]">

    <header>
        
        <jsp:include page="layout/navbar.jsp">
            <jsp:param name="posicion" value="absolute"/>
        </jsp:include>
        
        <div class="banner flex justify-center items-center">
            <div class="w-[50%] text-center">
                <h1 class="text-3xl text-white font-bold py-5 lg:text-6xl">ReservaYa</h1>
                <p class="text-gray-300 text-xl lg:text-4xl">
                    Prueba la Comodidad: Fácil, Variedad de Hoteles y viaja confiado.
                </p>
            </div>
        </div>

    </header>

    <main>
        <!-- slider -->
        <section class="px-5 pt-10 lg:px-20">

            <h2 class="text-gray-400 py-3 pb-10 text-xl lg:text-2xl font-semibold">Tipos de Habitaciones Ofrecidos</h2>
            
            <div class="slider">

                <!-- circle-1 -->
                <div class="w-[9rem] mx-auto p-2">
                    <img class="mx-auto w-[7rem] h-[7rem] lg:w-[10rem] lg:h-[10rem] rounded-full object-cover object-center" src="https://cdn.pixabay.com/photo/2017/04/12/18/59/log-home-2225414_1280.jpg" alt="">
                    <p class="text-[#8F9EB3] py-5 font-semibold text-base lg:text-xl text-center">Habitación Individual</p>
                </div>
                
                <!-- circle-2 -->
                <div class="w-[9rem] mx-auto p-2">
                    <img class="mx-auto w-[7rem] h-[7rem] lg:w-[10rem] lg:h-[10rem] rounded-full object-cover object-center" src="https://cdn.pixabay.com/photo/2020/09/02/05/17/hotel-room-5537364_960_720.jpg" alt="">
                    <p class="text-[#8F9EB3] py-5 font-semibold text-base lg:text-xl text-center">Habitación Doble</p>
                </div>

                <!-- circle-3 -->
                <div class="w-[9rem] mx-auto p-2">
                    <img class="mx-auto w-[7rem] h-[7rem] lg:w-[10rem] lg:h-[10rem] rounded-full object-cover object-center" src="https://cdn.pixabay.com/photo/2016/12/08/03/53/pillow-1890940_1280.jpg" alt="">
                    <p class="text-[#8F9EB3] py-5 font-semibold text-base lg:text-xl text-center">Habitación Matrimonial</p>
                </div>

                <!-- circle-4 -->
                <div class="w-[9rem] mx-auto p-2">
                    <img class="mx-auto w-[7rem] h-[7rem] lg:w-[10rem] lg:h-[10rem] rounded-full object-cover object-center" src="https://www.colchonexpres.com/blog/wp-content/uploads/2018/12/habitaciones-con-tres-camas-2.jpg" alt="">
                    <p class="text-[#8F9EB3] py-5 font-semibold text-base lg:text-xl text-center">Habitación Triple</p>
                </div>

                <!-- circle-5 -->
                <div class="w-[9rem] mx-auto p-2">
                    <img class="mx-auto w-[7rem] h-[7rem] lg:w-[10rem] lg:h-[10rem] rounded-full object-cover object-center" src="https://cdn.pixabay.com/photo/2016/10/18/09/02/hotel-1749602_1280.jpg" alt="">
                    <p class="text-[#8F9EB3] py-5 font-semibold text-base lg:text-xl text-center">Suite Junior</p>
                </div>

                <!-- circle-6 -->
                <div class="w-[9rem] mx-auto p-2">
                    <img class="mx-auto w-[7rem] h-[7rem] lg:w-[10rem] lg:h-[10rem] rounded-full object-cover object-center" src="https://cdn.pixabay.com/photo/2016/06/10/01/05/hotel-room-1447201_960_720.jpg" alt="">
                    <p class="text-[#8F9EB3] py-5 font-semibold text-base lg:text-xl text-center">Suite</p>
                </div>

                <!-- circle-7 -->
                <div class="w-[9rem] mx-auto p-2">
                    <img class="mx-auto w-[7rem] h-[7rem] lg:w-[10rem] lg:h-[10rem] rounded-full object-cover object-center" src="https://cdn.pixabay.com/photo/2016/11/18/13/02/bed-1834327_1280.jpg" alt="">
                    <p class="text-[#8F9EB3] py-5 font-semibold text-base lg:text-xl text-center">Suite Presidencial</p>
                </div>

                <!-- circle-8 -->
                <div class="w-[9rem] mx-auto p-2">
                    <img class="mx-auto w-[7rem] h-[7rem] lg:w-[10rem] lg:h-[10rem] rounded-full object-cover object-center" src="https://cdn.pixabay.com/photo/2018/02/03/03/40/table-3126881_1280.jpg" alt="">
                    <p class="text-[#8F9EB3] py-5 font-semibold text-base lg:text-xl text-center">Habitación Familiar</p>
                </div>

                <!-- circle-9 -->
                <div class="w-[9rem] mx-auto p-2">
                    <img class="mx-auto w-[7rem] h-[7rem] lg:w-[10rem] lg:h-[10rem] rounded-full object-cover object-center" src="https://d1vp8nomjxwyf1.cloudfront.net/wp-content/uploads/sites/44/2016/10/01130913/EXEC-608-2_small1.jpg" alt="">
                    <p class="text-[#8F9EB3] py-5 font-semibold text-base lg:text-xl text-center">Habitación Ejecutiva</p>
                </div>


            </div>

        </section>

        <!-- hoteles -->
        <section class="px-5 lg:px-20 pb-5">

            <h2 class="text-gray-400 py-3 pb-10 text-xl lg:text-2xl font-semibold">Nuestros Hoteles</h2>
            
            <div class="flex flex-wrap justify-around gap-5">
                <c:forEach var="item" items="${hoteles}">
                    
                    <!-- card 1 -->
                    <a href="MainController?action=hotel&id=${item.id}" class="w-[18rem] bg-[#8F9EB31C] hover:bg-[#2A3345] rounded-md mb-5">
                        <img class="w-full h-[10rem] rounded-t-md object-cover object-center" src="images/${item.foto}" alt="">
                        <div class="p-4 flex w-full justify-between">
                            <div class="space-y-1">
                                <h3 class="text-white font-semibold text-lg">
                                    ${item.nombre}
                                </h3>
                                <p class="text-gray-500 text-sm">
                                    ${item.descripcion}
                                </p>
                            </div>
                            <div>
                                <button class="favorito" data-hotel="${item.id}">
                                    
                                    <c:set var="esFavorito" value="false" />
                            
                                    <c:forEach var="favorito" items="${item.favoritoList}">
                                        <c:if test="${favorito.idUsuario.id == usuario.id}">
                                            <c:set var="esFavorito" value="true" />
                                        </c:if>
                                    </c:forEach>
                                    
                                    <c:if test="${esFavorito == true}">
                                        <div class="esfavorito">
                                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" 
                                                class="size-[1.5rem] text-[#D91C58] cursor-pointer">
                                                <path d="m11.645 20.91-.007-.003-.022-.012a15.247 15.247 0 0 1-.383-.218 25.18 25.18 0 0 1-4.244-3.17C4.688 15.36 2.25 12.174 2.25 8.25 2.25 5.322 4.714 3 7.688 3A5.5 5.5 0 0 1 12 5.052 5.5 5.5 0 0 1 16.313 3c2.973 0 5.437 2.322 5.437 5.25 0 3.925-2.438 7.111-4.739 9.256a25.175 25.175 0 0 1-4.244 3.17 15.247 15.247 0 0 1-.383.219l-.022.012-.007.004-.003.001a.752.752 0 0 1-.704 0l-.003-.001Z" />
                                            </svg>
                                        </div>
                                    </c:if>
                                    <c:if test="${esFavorito == false}">
                                        <div class="noFavorito">
                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" 
                                                class="size-[1.5rem] text-[#8F9EB3] hover:text-[#CBD5E1] cursor-pointer">
                                                <path stroke-linecap="round" stroke-linejoin="round" d="M21 8.25c0-2.485-2.099-4.5-4.688-4.5-1.935 0-3.597 1.126-4.312 2.733-.715-1.607-2.377-2.733-4.313-2.733C5.1 3.75 3 5.765 3 8.25c0 7.22 9 12 9 12s9-4.78 9-12Z" />
                                            </svg>
                                        </div>
                                    </c:if>
                                </button>
                            </div>

                        </div>
                    </a>
                    
                    
                </c:forEach>
                
            </div>

        </section>

        <!-- ofertas -->
        <section class="px-5 lg:px-20 pb-5">

            <h2 class="text-gray-400 py-3 pb-10 text-xl lg:text-2xl font-semibold">Ofertas Disponibles</h2>
            
            <div class="flex flex-wrap justify-around gap-5">

                <c:forEach var="item" items="${ofertas}">
                    
                    <c:if test="${item.estado=='En Curso'}">
                    
                        <c:set var="hotelNombre" value="${item.idHotel.nombre}" />
                        <c:set var="hotelId" value="${item.idHotel.id}" />

                        <a href="MainController?action=hotel&id=${hotelId}" class="w-[18rem] bg-[#8f9eb31c] hover:bg-[#2A3345] rounded-md mb-5">
                            <div class="cursor-pointer">
                                <img class="w-full h-[12rem] rounded-t-md object-cover" src="${item.foto}" alt="">
                                <div class="p-4 textPart lg:flex w-full justify-between ">
                                    <div class="space-y-1">
                                        <h3 class="font-semibold text-lg text-white">                               
                                            ${hotelNombre}
                                        </h3>
                                        <p class="text-gray-400 text-sm">
                                            ${item.descripcion}
                                        </p>
                                        <span class="bg-[#FE0000] text-gray-300 text-[0.7rem] font-bold inline-block p-1 my-2 rounded-2xl">
                                            ${item.descuento}% de descuento
                                        </span>
                                        <p class=" text-base text-gray-300 font-semibold block">
                                            ${item.titulo}
                                        </p>               
                                        <span class="block text-gray-400 text-sm text-center ">
                                            Del <fmt:formatDate value="${item.fechaInicio}" pattern="dd" /> de
                                            <fmt:formatDate value="${item.fechaInicio}" pattern="MMMM" /> al
                                            <fmt:formatDate value="${item.fechaFin}" pattern="dd" /> de
                                            <fmt:formatDate value="${item.fechaFin}" pattern="MMMM" />
                                        </span>   
                                    </div>

                                </div>
                            </div>
                        </a>
                    </c:if>
                
                </c:forEach>

            </div>

        </section>
    </main>

    <footer class="p-5 lg:px-20">
        <h2 class="text-white text-2xl lg:text-4xl text-center py-3 font-semibold">
            ReservaYa
        </h2>
        <p class="text-gray-500 text-center">
            Copyright &copy <a class="text-gray-200" href="https://github.com/ARIAS-SYS">Sistemas</a>, Todos los derechos reservados.
        </p>
    </footer>


    <!-- slider -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js" integrity="sha512-h9kKZlwV1xrIcr2LwAPZhjlkx+x62mNwuQK5PAu9d3D+JXMNlGx8akZbqpXvp0vA54rz+DrqYVrzUGDMhwKmwQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/1.2.1/jquery-migrate.min.js" integrity="sha512-fDGBclS3HUysEBIKooKWFDEWWORoA20n60OwY7OSYgxGEew9s7NgDaPkj7gqQcVXnASPvZAiFW8DiytstdlGtQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js" integrity="sha512-HGOnQO9+SP1V92SrtZfjqxxtLmVzqZpjFFekvzZVWoiASSQgSr4cw9Kqd2+l8Llp4Gm0G8GIFJ4ddwZilcdb8A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>


    <script type="text/javascript">
        $(document).ready(function(){
            $('.slider').slick({
                slidesToShow: 5,
                slidesToScroll: 1,
                autoplay: true,
                autoplaySpeed: 2000,
                arrows: false,
                dots: false,
                responsive: [
                    {
                        breakpoint: 1024,
                        settings: {
                            slidesToShow: 4,
                            slidesToScroll: 1,
                            infinite: true
                        }
                    },
                    {
                        breakpoint: 650,
                        settings: {
                            slidesToShow: 3,
                            slidesToScroll: 1,
                        }
                    },
                    {
                        breakpoint: 480,
                        settings: {
                            slidesToShow: 1,
                            slidesToScroll: 1,
                        }
                    }
                    
                ]
            });
        });
    </script>

</body>
</html>