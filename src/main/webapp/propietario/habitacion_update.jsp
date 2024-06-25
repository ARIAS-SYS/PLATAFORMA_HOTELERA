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

               <!-- nuevo hotel -->
                <section class="w-full pt-10">
                    <div class="w-[50%] mx-auto">
                        <h3 class="text-slate-300 text-center mt-3 text-4xl mb-10">
                            Habitaciones
                            
                             <c:if test="${habitacion.id==0}">
                                <span class="inline-block text-sm px-2 rounded-full bg-sky-400 ml-5">Nuevo</span>
                                <c:set var="capa" value="" />
                                <c:set var="pre" value="" />

                            </c:if>
                            <c:if test="${habitacion.id!=0}">
                                <span class="inline-block text-sm px-2 rounded-full bg-green-500 ml-5">Editar</span>
                                <c:set var="capa" value="${habitacion.capacidad}" />
                                <c:set var="pre" value="${habitacion.precio}" />
                            </c:if>
                        </h3>
                        <form method="post" action="HabitacionController">
                            
                            <input type="hidden" value="${habitacion.id}" name="id">

                            <div class="flex gap-1">
                                <input type="text" value="${habitacion.codigo}" name="codigo" placeholder="Código" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                                <select name="tipo" class="block w-full px-3 mt-3 py-1 bg-[#0F1522] border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                                    <c:forEach var="tipo" items="${usuario.tipoHabitacionList}">
                                        <option value="${tipo.id}" <c:if test="${tipo.id == habitacion.idTipoHab.id}">selected</c:if>>${tipo.tipo}</option>
                                    </c:forEach>
                                    
                                </select>                            
                            </div>
                            
                            <div class="flex gap-1">
                                <input type="text" value="${capa}" name="capacidad" placeholder="Capacidad" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                                <input type="text" value="${pre}" name="precio" placeholder="Precio por noche" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                            </div>
                            <div class="flex gap-1">
                                <div id="selectedAmenities" class="w-[50%] h-[10rem] mt-3 py-1 bg-transparent border border-slate-500 text-white">
                                    <!-- Comodidades seleccionadas se mostrarán aquí -->
                                                                    
                                    <c:if test="${habitacion.id!=0}">
                                        <c:forEach var="comi" items="${habitacion.comodidadHabitacionList}">
                                            <div id="selected-${comi.idComodidad.id}" class="inline-block px-2 rounded-full bg-gray-500 ml-1 mb-1">
                                                <span>${comi.idComodidad.comodidad}</span>
                                                <button type="button" class="text-black ml-2" onclick="removeAmenity('${comi.idComodidad.id}')">X</button>
                                                <input type="hidden" name="selectedAmenities[]" value="${comi.idComodidad.id}">
                                            </div>
                                        </c:forEach>
                                    </c:if>
                                </div>
                                <div class="w-[50%]">                                    
                                    <select id="amenities" class="block w-full px-3 mt-3 py-1 bg-[#0F1522] border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                                        <c:forEach var="comodidad" items="${comodidades}">
                                            <option value="${comodidad.id}">${comodidad.comodidad}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <input type="submit" value="Guardar" class="px-5 py-2 rounded-md mt-3 cursor-pointer text-white bg-slate-600">

                        </form>
                    </div>
                </section>


            </main>

        </div>

    </div>
        
        <script src="${pageContext.request.contextPath}/js/comodidad.js"></script>
    
</body>
</html>