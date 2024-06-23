
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ReservaYa</title>

    <!-- tailwind -->
    <script src="https://cdn.tailwindcss.com"></script>

    <!-- estilos locales -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">


</head>
<body class="bg-[#0F1522]">

    <div class="flex h-screen">
        
        <jsp:include page="../layout/sidebar_propietario.jsp" />
        
        <div class="flex flex-col flex-1 h-full overflow-hidden">

            <!-- main -->
            <main class="flex-1 max-h-full p-5 overflow-hidden overflow-y-scroll">

                <!-- perfil -->
                <section class="p-5 lg:px-20 pt-5 h-[65vh] flex justify-center items-center">
                    <div class="">
                        <div class="flex justify-center">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" 
                                class="size-[4rem] lg:size-[6rem] text-green-700">
                                <path fill-rule="evenodd" d="M18.685 19.097A9.723 9.723 0 0 0 21.75 12c0-5.385-4.365-9.75-9.75-9.75S2.25 6.615 2.25 12a9.723 9.723 0 0 0 3.065 7.097A9.716 9.716 0 0 0 12 21.75a9.716 9.716 0 0 0 6.685-2.653Zm-12.54-1.285A7.486 7.486 0 0 1 12 15a7.486 7.486 0 0 1 5.855 2.812A8.224 8.224 0 0 1 12 20.25a8.224 8.224 0 0 1-5.855-2.438ZM15.75 9a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0Z" clip-rule="evenodd" />
                            </svg>                              
                        </div>
                        <h3 class="text-slate-300 text-center mt-3 text-xl sm:text-4xl">${usuario.nombre}</h3>
                        <span class="block text-slate-300 mt-3 text-center text-sm sm:text-base">${usuario.email}</span>
                        <a class="block w-fit mx-auto mt-3 text-center text-white px-5 py-2 rounded-md bg-gray-600" href="LoginController">
                            Cerrar sesión
                        </a>
                    </div>
                </section>

            </main>

        </div>

    </div>
    

</body>
</html>