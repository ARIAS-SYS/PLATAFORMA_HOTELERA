
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
                    <!-- ofertas -->
                    <section class="p-5 lg:px-20 pt-5">

                        <h2 class="text-2xl text-center font-semibold text-gray-400 mb-10">Ofertas</h2>
                        
                        <div class="flex flex-wrap items-center justify-around gap-5">
                
                        <!-- card 1 -->
                        <a href="hotel.html" class="w-[18rem] bg-[#8f9eb31c] hover:bg-[#2A3345] rounded-md mb-5">
                            <div class="cursor-pointer">
                            <img class="w-full h-[12rem] rounded-t-md object-cover" src="https://media.istockphoto.com/id/525408989/es/foto/familia-con-maletas-pasando-por-fuente-en-complejo-tur%C3%ADstico.jpg?s=2048x2048&w=is&k=20&c=Smlsdgse2TgcLYwzq5ueF-fdNj9Ldq_prKF6t7GYNOk=" alt="">
                            <div class="p-4 textPart lg:flex w-full justify-between ">
                                <div class="space-y-1">
                                <h3 class="font-semibold text-lg text-white">
                                    Luminoso Oasis Hotel
                                </h3>
                                <p class="text-gray-400 text-sm">
                                    Las vacaciones que te hacen falta
                                </p>
                                <span class="bg-[#FE0000] text-gray-300 text-[0.7rem] font-bold inline-block p-1 my-2 rounded-2xl">
                                    20% de descuento
                                </span>
                                <p class=" text-base text-gray-300 font-semibold block">
                                    Plan Familia
                                </p>               
                                <span class="block text-gray-400 text-sm ">
                                    Del 10 de junio al 21 de junio
                                </span>
                                </div>
                                
                            </div>
                            </div>
                        </a>
                
                        <!-- card 2 -->
                        <a href="hotel.html" class="w-[18rem] bg-[#8f9eb31c] hover:bg-[#2A3345] rounded-md mb-5">
                            <div class="cursor-pointer">
                            <img class="w-full h-[12rem] rounded-t-md object-cover" src="https://media.istockphoto.com/id/525408989/es/foto/familia-con-maletas-pasando-por-fuente-en-complejo-tur%C3%ADstico.jpg?s=2048x2048&w=is&k=20&c=Smlsdgse2TgcLYwzq5ueF-fdNj9Ldq_prKF6t7GYNOk=" alt="">
                            <div class="p-4 textPart lg:flex w-full justify-between ">
                                <div class="space-y-1">
                                <h3 class="font-semibold text-lg text-white">
                                    Luminoso Oasis Hotel
                                </h3>
                                <p class="text-gray-400 text-sm">
                                    Las vacaciones que te hacen falta
                                </p>
                                <span class="bg-[#FE0000] text-gray-300 text-[0.7rem] font-bold inline-block p-1 my-2 rounded-2xl">
                                    20% de descuento
                                </span>
                                <p class=" text-base text-gray-300 font-semibold block">
                                    Plan Familia
                                </p>               
                                <span class="block text-gray-400 text-sm">
                                    Del 10 de junio al 21 de junio
                                </span>
                                </div>
                                
                            </div>
                            </div>
                        </a>
                
                        <!-- card 3 -->
                        <a href="hotel.html" class="w-[18rem] bg-[#8f9eb31c] hover:bg-[#2A3345] rounded-md mb-5">
                            <div class="cursor-pointer">
                            <img class="w-full h-[12rem] rounded-t-md object-cover" src="https://media.istockphoto.com/id/525408989/es/foto/familia-con-maletas-pasando-por-fuente-en-complejo-tur%C3%ADstico.jpg?s=2048x2048&w=is&k=20&c=Smlsdgse2TgcLYwzq5ueF-fdNj9Ldq_prKF6t7GYNOk=" alt="">
                            <div class="p-4 textPart lg:flex w-full justify-between ">
                                <div class="space-y-1">
                                <h3 class="font-semibold text-lg text-white">
                                    Luminoso Oasis Hotel
                                </h3>
                                <p class="text-gray-400 text-sm">
                                    Las vacaciones que te hacen falta
                                </p>
                                <span class="bg-[#FE0000] text-gray-300 text-[0.7rem] font-bold inline-block p-1 my-2 rounded-2xl">
                                    20% de descuento
                                </span>
                                <p class=" text-base text-gray-300 font-semibold block">
                                    Plan Familia
                                </p>               
                                <span class="block text-gray-400 text-sm">
                                    Del 10 de junio al 21 de junio
                                </span>
                                </div>
                                
                            </div>
                            </div>
                        </a>
                
                        <!-- card 4 -->
                        <a href="hotel.html" class="w-[18rem] bg-[#8f9eb31c] hover:bg-[#2A3345] rounded-md mb-5">
                            <div class="cursor-pointer">
                            <img class="w-full h-[12rem] rounded-t-md object-cover" src="https://media.istockphoto.com/id/525408989/es/foto/familia-con-maletas-pasando-por-fuente-en-complejo-tur%C3%ADstico.jpg?s=2048x2048&w=is&k=20&c=Smlsdgse2TgcLYwzq5ueF-fdNj9Ldq_prKF6t7GYNOk=" alt="">
                            <div class="p-4 textPart lg:flex w-full justify-between ">
                                <div class="space-y-1">
                                <h3 class="font-semibold text-lg text-white">
                                    Luminoso Oasis Hotel
                                </h3>
                                <p class="text-gray-400 text-sm">
                                    Las vacaciones que te hacen falta
                                </p>
                                <span class="bg-[#FE0000] text-gray-300 text-[0.7rem] font-bold inline-block p-1 my-2 rounded-2xl">
                                    20% de descuento
                                </span>
                                <p class=" text-base text-gray-300 font-semibold block">
                                    Plan Familia
                                </p>               
                                <span class="block text-gray-400 text-sm">
                                    Del 10 de junio al 21 de junio
                                </span>
                                </div>
                                
                            </div>
                            </div>
                        </a>
                        
                
                        
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