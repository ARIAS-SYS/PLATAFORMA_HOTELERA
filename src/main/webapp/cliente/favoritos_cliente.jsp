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
    
    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    
    <!-- funciones locales -->
    <script src="js/quitarFavorito.js" type="text/javascript"></script>


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
                    <!-- hoteles -->
                    <section class="p-5 lg:px-20 pt-5">

                        <h2 class="text-2xl text-center font-semibold text-gray-400 mb-10">Favoritos</h2>
                        
                        <div class="flex flex-wrap items-center justify-around gap-5">
                            
                            <c:forEach var="item" items="${hoteles}">
                                
                                <c:set var="esFavorito" value="false" />

                                <c:forEach var="favorito" items="${item.favoritoList}">
                                    <c:if test="${favorito.idUsuario.id == usuario.id}">
                                        <c:set var="esFavorito" value="true" />
                                    </c:if>
                                </c:forEach>
                                
                                <c:if test="${esFavorito == true}">
                                
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
                                                    <div class="esfavorito">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" 
                                                            class="size-[1.5rem] text-[#D91C58] cursor-pointer">
                                                            <path d="m11.645 20.91-.007-.003-.022-.012a15.247 15.247 0 0 1-.383-.218 25.18 25.18 0 0 1-4.244-3.17C4.688 15.36 2.25 12.174 2.25 8.25 2.25 5.322 4.714 3 7.688 3A5.5 5.5 0 0 1 12 5.052 5.5 5.5 0 0 1 16.313 3c2.973 0 5.437 2.322 5.437 5.25 0 3.925-2.438 7.111-4.739 9.256a25.175 25.175 0 0 1-4.244 3.17 15.247 15.247 0 0 1-.383.219l-.022.012-.007.004-.003.001a.752.752 0 0 1-.704 0l-.003-.001Z" />
                                                        </svg>
                                                    </div>
                                                </button>
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