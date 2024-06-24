<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ReservaYa</title>

    <!-- tailwind -->
    <script src="https://cdn.tailwindcss.com"></script>

    
    <!-- estilos locales -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
    
</head>
<body class="bg-[#0F1522]">
    <!-- component -->
    <div>
        <div class="flex h-screen overflow-y-hidden bg-[#0F1522]" x-data="setup()" x-init="$refs.loading.classList.add('hidden')">
            
            <jsp:include page="../layout/sidebar_cliente.jsp">
                <jsp:param name="opcion" value="productos"/>
            </jsp:include>

            <div class="flex flex-col flex-1 h-full overflow-hidden">
                
                <jsp:include page="../layout/navbar_cliente.jsp">
                    <jsp:param name="opcion" value="productos"/>
                </jsp:include>
                
                <!-- Main content -->
                <main class="flex-1 max-h-full p-5 overflow-hidden overflow-y-scroll">
                    
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
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.7.3/dist/alpine.min.js" defer></script>
        <script>
            let valor=false;
            if (window.innerWidth >= 1024) { 
                    valor = true;
            } else {
                valor = false;
            }
           
            const setup = () => {
                return {
                loading: true,
                isSidebarOpen: valor,
                toggleSidbarMenu() {
                    this.isSidebarOpen = !this.isSidebarOpen
                },
                isSettingsPanelOpen: false,
                isSearchBoxOpen: false,
                }
            }
        </script>
    </div>
</body>
</html>