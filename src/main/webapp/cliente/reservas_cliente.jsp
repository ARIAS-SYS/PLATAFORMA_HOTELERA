
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

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
                    <!-- respuesta -->
                    <section class="p-5 lg:px-20 pt-5">
                        
                        <h2 class="text-gray-400 py-3 pb-10 text-center text-xl lg:text-2xl font-semibold">Historial de Reservas</h2>

                        <div class="flex flex-wrap items-center justify-around gap-5">
                            
                            
                            
                            <c:forEach var="item" items="${usuario.reservaList}">
                                
                                            
                                <!-- card normal -->
                                <div class="w-[18rem] sm:w-full bg-[#8f9eb31c] rounded-md mb-5 sm:mx-0 sm:flex sm:p-5">          

                                    <div class="sm:w-[80%] sm:flex">
                                        <img class="w-full sm:rounded-none sm:w-[12rem] h-[12rem] rounded-t-md object-cover" src="${pageContext.request.contextPath}/images/${item.idHabit.idHotelHab.foto}" alt="">
                                        <div class="p-4 sm:px-4 sm:py-0 textPart lg:flex w-full justify-between ">
                                            <div class="space-y-1">
                                                <a href="MainController?action=hotel&id=${item.id}" class="font-semibold text-lg text-white">
                                                    ${item.idHabit.idHotelHab.nombre}
                                                </a>
                                                <div class="flex gap-5 py-1">
                                                    <a href="${item.idHabit.idHotelHab.facebook}">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                                            class="bi bi-facebook size-[1.3rem] text-[#8F9EB3] hover:text-[#CBD5E1] cursor-pointer" viewBox="0 0 16 16">
                                                            <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951"/>
                                                        </svg>
                                                    </a>
                                                    <a href="${item.idHabit.idHotelHab.instagram}">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                                            class="bi bi-instagram size-[1.3rem] text-[#8F9EB3] hover:text-[#CBD5E1] cursor-pointer" viewBox="0 0 16 16">
                                                            <path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.9 3.9 0 0 0-1.417.923A3.9 3.9 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.9 3.9 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.9 3.9 0 0 0-.923-1.417A3.9 3.9 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599s.453.546.598.92c.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.5 2.5 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.5 2.5 0 0 1-.92-.598 2.5 2.5 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233s.008-2.388.046-3.231c.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92s.546-.453.92-.598c.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92m-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217m0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334"/>
                                                        </svg>
                                                    </a>
                                                    <a href="${item.idHabit.idHotelHab.linkUbicacion}">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                                            class="bi bi-geo-alt size-[1.3rem] text-[#8F9EB3] hover:text-[#CBD5E1] cursor-pointer" viewBox="0 0 16 16">
                                                            <path d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A32 32 0 0 1 8 14.58a32 32 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10"/>
                                                            <path d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4m0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
                                                        </svg>
                                                    </a>
                                                </div>
                                                <p class="text-gray-500 text-sm">
                                                    ${item.idHabit.idHotelHab.pais},
                                                    ${item.idHabit.idHotelHab.departamento},
                                                    ${item.idHabit.idHotelHab.ciudad},
                                                    ${item.idHabit.idHotelHab.descripcionUbi}                                                    
                                                </p>
                                                <h4 class="font-semibold text-base text-[#CBD5E1]">
                                                    ${item.idHabit.idTipoHab.tipo} 
                                                </h4>
                                                <p class="text-[#f4b848] text-sm font-bold">
                                                    Bs. ${item.totalPrecio}
                                                </p>
                                                <div class="sm:flex sm:gap-3 sm:flex-wrap text-sm">
                                                    <c:forEach var="comodidad" items="${item.idHabit.comodidadHabitacionList}">
                                                        <div class="flex gap-2">
                                                            <img src="${pageContext.request.contextPath}/icons/${comodidad.idComodidad.icono}" class="w-[1.3rem] h-[1.3rem]" alt="">
                                                            <span class="text-[#8F9EB3]">${comodidad.idComodidad.comodidad}</span>
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                                <p class="text-gray-300 text-sm tracking-widest">
                                                    Del <fmt:formatDate value="${item.fechaInicio}" pattern="dd" /> de
                                                    <fmt:formatDate value="${item.fechaInicio}" pattern="MMMM" /> al
                                                    <fmt:formatDate value="${item.fechaFin}" pattern="dd" /> de
                                                    <fmt:formatDate value="${item.fechaFin}" pattern="MMMM" />
                                                </p>
                                            </div>  
                                        </div>
                                    </div>
                                    <div class="sm:w-[20%] sm:flex sm:flex-col sm:justify-between mx-auto">
                                        <div>
                                            <p class="text-gray-500 text-sm text-center">
                                                <fmt:formatDate value="${item.fechaReserva}" pattern="dd-MM-yyyy" />
                                            </p>
                                        </div>
                                        <div>
                                            <c:if test="${item.estado == 'Reservado'}">
                                                <span class="block w-fit mx-auto text-center rounded-full my-2 sm:my-0 py-1 sm:py-0 px-3 text-white bg-sky-400">
                                                    ${item.estado}
                                                </span>
                                            </c:if>
                                            <c:if test="${item.estado == 'Completado'}">
                                                <span class="block w-fit mx-auto text-center rounded-full my-2 sm:my-0 py-1 sm:py-0 px-3 text-white bg-purple-700">
                                                    ${item.estado}
                                                </span>
                                            </c:if>
                                            <c:if test="${item.estado == 'En Estancia'}">
                                                <span class="block w-fit mx-auto text-center rounded-full my-2 sm:my-0 py-1 sm:py-0 px-3 text-white bg-green-400">
                                                    ${item.estado}
                                                </span>
                                            </c:if>
                                            
                                        </div>
                                    </div>         
                                </div>
                                                    
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