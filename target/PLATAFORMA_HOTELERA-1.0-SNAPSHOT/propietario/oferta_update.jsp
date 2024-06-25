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

    <!-- estilos locales -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">


</head>
<body class="bg-[#0F1522]">

    <div class="flex h-screen">
        
        <jsp:include page="../layout/sidebar_propietario.jsp" />


        <div class="flex flex-col flex-1 h-full overflow-hidden">

            <!-- main -->
            <main class="flex-1 max-h-full p-5 overflow-hidden overflow-y-scroll">

                <section class="w-full pt-10">
                    <div class="w-[50%] mx-auto">
                        <h3 class="text-slate-300 text-center mt-3 text-4xl mb-10">
                            Oferta
                            <c:if test="${oferta.id==0}">
                                <span class="inline-block text-sm px-2 rounded-full bg-sky-400 ml-5">Nuevo</span>
                                <c:set var="capa" value="" />

                            </c:if>
                            <c:if test="${oferta.id!=0}">
                                <span class="inline-block text-sm px-2 rounded-full bg-green-500 ml-5">Editar</span>
                                <c:set var="capa" value="${oferta.descuento}" />
                            </c:if>
                        </h3>
                        <form method="post" action="OfertaController">
                                                        
                            <input type="hidden" value="${oferta.id}" name="id">

                            <input type="text" name="titulo" value="${oferta.titulo}" placeholder="Titulo" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                            <input type="text" name="descripcion" value="${oferta.descripcion}" placeholder="Descripción" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                            <div class="flex gap-1">
                                <input type="date" name="fecha_inicio" value="<fmt:formatDate value="${oferta.fechaInicio}" pattern="yyyy-MM-dd" />" placeholder="Fecha Inicio" class="block w-full px-3 mt-3 py-1 bg-[#0F1522] border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                                <input type="date" name="fecha_fin" value="<fmt:formatDate value="${oferta.fechaFin}" pattern="yyyy-MM-dd" />" placeholder="Fecha Final" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                                <input type="text" name="descuento" value="${capa}" placeholder="Descuento en (%)" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                            </div>
                            <div class="flex gap-1">
                                <input type="text" name="foto" value="${oferta.foto}"  placeholder="URL de la Imagen" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                                <select name="tipo" class="block w-full px-3 mt-3 py-1 bg-[#0F1522] border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                                    <c:forEach var="tipo" items="${usuario.tipoHabitacionList}">
                                        <option value="${tipo.id}" <c:if test="${tipo.id == oferta.idTipoHabitacion.id}">selected</c:if>>${tipo.tipo}</option>
                                    </c:forEach>
                                </select>                             
                            </div>
                            <input type="submit" value="Guardar" class="px-5 py-2 rounded-md mt-3 cursor-pointer text-white bg-slate-600">

                        </form>
                    </div>
                </section>

            </main>

        </div>

    </div>
    
</body>
</html>