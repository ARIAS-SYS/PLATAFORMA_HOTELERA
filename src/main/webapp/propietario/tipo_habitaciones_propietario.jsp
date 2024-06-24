<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

                <!-- tabla -->
                <div class="bg-[#8f9eb31c] pt-1">
                    <div class="flex justify-between">
                        <h2 class="px-5 text-white text-xl font-bold my-4">Tipo de Habitaciones</h2>
                        <div class="p-5">
                            <a href="TipoHabitacionController?action=add">
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" 
                                    class="size-6 text-white">
                                    <path d="M21.731 2.269a2.625 2.625 0 0 0-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 0 0 0-3.712ZM19.513 8.199l-3.712-3.712-12.15 12.15a5.25 5.25 0 0 0-1.32 2.214l-.8 2.685a.75.75 0 0 0 .933.933l2.685-.8a5.25 5.25 0 0 0 2.214-1.32L19.513 8.2Z" />
                                </svg>
                            </a>
                        </div>                        
                    </div>
                    <table class="text-white w-full">
                        <tr class="border-b border-slate-600">
                            <th class="py-3 pl-2 w-[15rem] text-left">Id</th>
                            <th class="text-left">Nombre</th>
                            <th class="text-center">Imagen</th>
                            <th></th>
                        </tr>
                        
                        <c:forEach var="item" items="${tipoHabitaciones}">
                            
                            <c:if test="${item.idUsuario.id==usuario.id}">
                                
                                <tr class="border-b border-slate-600 hover:bg-[#363F4F]">
                                    <td class="pl-2">${item.id}</td>
                                    <td>${item.tipo}</td>
                                    <td class="">
                                        <img class="rounded-full w-20 h-20 object-cover object-center my-1 mx-auto" src="${item.foto}"  alt="">
                                    </td>
                                    <td class="text-center">  
                                        <div class="flex gap-3">
                                            <a href="TipoHabitacionController?action=edit&id=${item.id}">
                                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" 
                                                    class="size-6 text-green-500">
                                                    <path d="M21.731 2.269a2.625 2.625 0 0 0-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 0 0 0-3.712ZM19.513 8.199l-3.712-3.712-8.4 8.4a5.25 5.25 0 0 0-1.32 2.214l-.8 2.685a.75.75 0 0 0 .933.933l2.685-.8a5.25 5.25 0 0 0 2.214-1.32l8.4-8.4Z" />
                                                    <path d="M5.25 5.25a3 3 0 0 0-3 3v10.5a3 3 0 0 0 3 3h10.5a3 3 0 0 0 3-3V13.5a.75.75 0 0 0-1.5 0v5.25a1.5 1.5 0 0 1-1.5 1.5H5.25a1.5 1.5 0 0 1-1.5-1.5V8.25a1.5 1.5 0 0 1 1.5-1.5h5.25a.75.75 0 0 0 0-1.5H5.25Z" />
                                                </svg>
                                            </a>
                                            <a href="TipoHabitacionController?action=delete&id=${item.id}">
                                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" 
                                                    class="size-6 text-red-600">
                                                    <path fill-rule="evenodd" d="M16.5 4.478v.227a48.816 48.816 0 0 1 3.878.512.75.75 0 1 1-.256 1.478l-.209-.035-1.005 13.07a3 3 0 0 1-2.991 2.77H8.084a3 3 0 0 1-2.991-2.77L4.087 6.66l-.209.035a.75.75 0 0 1-.256-1.478A48.567 48.567 0 0 1 7.5 4.705v-.227c0-1.564 1.213-2.9 2.816-2.951a52.662 52.662 0 0 1 3.369 0c1.603.051 2.815 1.387 2.815 2.951Zm-6.136-1.452a51.196 51.196 0 0 1 3.273 0C14.39 3.05 15 3.684 15 4.478v.113a49.488 49.488 0 0 0-6 0v-.113c0-.794.609-1.428 1.364-1.452Zm-.355 5.945a.75.75 0 1 0-1.5.058l.347 9a.75.75 0 1 0 1.499-.058l-.346-9Zm5.48.058a.75.75 0 1 0-1.498-.058l-.347 9a.75.75 0 0 0 1.5.058l.345-9Z" clip-rule="evenodd" />
                                                </svg>
                                            </a>
                                        </div>                                                         
                                    </td>
                                </tr>
                            </c:if>
                            
                            
                        </c:forEach>
                        
                       
                    </table>
                </div>

            </main>

        </div>

    </div>
    
</body>
</html>