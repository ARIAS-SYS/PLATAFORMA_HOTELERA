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
    
    
    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


    <!-- flowbite -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css" rel="stylesheet" />

    <!-- estilos locales -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">


</head>
<body class="bg-[#0F1522]">

    <div class="flex h-screen">
                
        <jsp:include page="../layout/sidebar_propietario.jsp" />

        <div class="flex flex-col flex-1 h-full overflow-hidden">

            <!-- main -->
            <main class="flex-1 max-h-full p-5 overflow-hidden overflow-y-scroll">

                <!-- encabezado -->
                <div class="bg-[#8f9eb31c] p-5">
                    <h2 class="text-gray-300 text-2xl font-bold mb-4">
                        Reservas
                    </h2>
                    <div class="flex gap-5 pb-2">
                        <label for="item1" class="text-gray-300 cursor-pointer">
                            <input type="radio" name="filtro" id="item1" checked> 
                            <a href="PropietarioController?action=reservas">                            
                                Pendientes
                            </a>
                        </label>
                        <label for="item2" class="text-gray-300 cursor-pointer">
                            <input type="radio" name="filtro" id="item2"> 
                            <a href="PropietarioController?action=reservasEstadia"> 
                                En Estadia
                            </a>
                        </label>
                        <label for="item3" class="text-gray-300 cursor-pointer">
                            <input type="radio" name="filtro" id="item3"> 
                            <a href="PropietarioController?action=reservasCompleto">
                                Completados
                            </a>
                        </label>

                        <label for="item4" class="text-gray-300 cursor-pointer">
                            <input type="radio" name="filtro" id="item4"> 
                            <a href="PropietarioController?action=reservasTodos">Todos</a>
                        </label>
                        
                    </div>
                </div>

                <!-- tabla -->
                <div class="bg-[#8f9eb31c] mt-2 pt-1">
                    <h3 class="px-5 text-white text-xl font-bold my-4">
                        Reservados
                    </h3>
                    <table class="text-white w-full">
                        <tr class="border-b border-slate-600">
                            <th class="py-3 pl-2 text-left">Id</th>
                            <th class="text-center">Imagen</th>
                            <th class="text-left">Cliente</th>
                            <th class="text-left">Fecha</th>
                            <th class="text-left">Precio</th>
                            <th class="text-left">Habitación</th>
                            <th class="text-left">Estado</th>
                            <th class="text-left">Dias</th>
                            <th class="text-center">Actualizar</th>
                        </tr>
                        <c:forEach var="reserva" items="${reservas}">
                            <c:if test="${hotel.id==reserva.idHabit.idHotelHab.id  && reserva.estado=='Reservado'}">
                                <tr class="border-b border-slate-600 hover:bg-[#363F4F]">
                                    <td class="pl-2">${reserva.id}</td>
                                    <td class="">
                                        <img class="rounded-full w-20 h-20 object-cover object-center my-1 mx-auto" src="${reserva.idHabit.idTipoHab.foto}"  alt="">
                                    </td>
                                    <td>${reserva.idUsuario.nombre}</td>
                                    <td>
                                        <fmt:formatDate value="${reserva.fechaReserva}" pattern="dd-MM-yyyy" />
                                    </td>
                                    <td>${reserva.totalPrecio} Bs.</td>
                                    <td>${reserva.idHabit.idTipoHab.tipo}</td>
                                    <td>
                                        
                                        <c:if test="${reserva.estado=='Completado'}">
                                            <span class="inline-block px-2 rounded-full bg-purple-700">Completado</span>
                                        </c:if>
                                        <c:if test="${reserva.estado=='Reservado'}">
                                            <span class="inline-block px-2 rounded-full bg-sky-400">Reservado</span>
                                        </c:if>
                                        <c:if test="${reserva.estado=='En Estancia'}">
                                            <span class="inline-block px-2 rounded-full bg-green-400">En Estancia</span>
                                        </c:if>
                                    </td>
                                    <td>
                                        <fmt:formatDate value="${reserva.fechaInicio}" pattern="dd-MM-yyyy" /> al
                                        <fmt:formatDate value="${reserva.fechaFin}" pattern="dd-MM-yyyy" />
                                    </td>
                                    <td class="text-center">                           
                                        <button data-id="${reserva.id}" class="estado text-blue-400 font-bold" type="button">
                                            Estado
                                        </button>  
                                    </td>
                                </tr>
                            </c:if>

                        </c:forEach>

                    </table>
                </div>

            </main>

        </div>

    </div>
        
    <div id="estadoModal" class="fixed top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 hidden bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700">
        <ul id="modalOptions" class="py-2 text-sm text-gray-700 dark:text-gray-200">
            <!-- Opciones se llenarán dinámicamente con JavaScript -->
        </ul>
    </div>

    
    <script src="${pageContext.request.contextPath}/js/estadoModal.js" type="text/javascript"></script>

    <!-- flowbite -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>
    
        

</body>
</html>