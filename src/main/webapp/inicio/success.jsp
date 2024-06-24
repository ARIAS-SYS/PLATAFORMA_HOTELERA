
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ReservaYa</title>

    <!-- tailwind -->
    <script src="https://cdn.tailwindcss.com"></script>

    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- estilos locales -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />

</head>
<body class="bg-[#0F1522]">

    <header>

        <jsp:include page="../layout/navbar.jsp">
            <jsp:param name="posicion" value="absolute"/>
        </jsp:include>
    </header>

    <main>
        
        <!-- contenido -->
        <section class="p-5 lg:px-20 w-full h-[100vh] flex justify-center items-center">
            <div>
                <div class="flex justify-center">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" 
                        class="size-[4rem] text-gray-300">
                        <path fill-rule="evenodd" d="M2.25 12c0-5.385 4.365-9.75 9.75-9.75s9.75 4.365 9.75 9.75-4.365 9.75-9.75 9.75S2.25 17.385 2.25 12Zm13.36-1.814a.75.75 0 1 0-1.22-.872l-3.236 4.53L9.53 12.22a.75.75 0 0 0-1.06 1.06l2.25 2.25a.75.75 0 0 0 1.14-.094l3.75-5.25Z" clip-rule="evenodd" />
                    </svg>
                </div>
                <h3 class="text-slate-300 text-center text-xl lg:text-4xl">
                    Reserva Exitosa
                </h3>
                <a href="MainController?action=index" class="block w-fit mx-auto mt-5 text-white px-5 py-2 rounded-md bg-gray-600">
                    Volver al inicio
                </a>
            </div>
        </section>

    </main>


</body>
</html>