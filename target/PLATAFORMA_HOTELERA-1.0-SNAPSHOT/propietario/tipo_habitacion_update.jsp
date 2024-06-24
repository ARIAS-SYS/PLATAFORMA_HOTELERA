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
                <section class="w-full pt-10 flex items-center justify-center">
                    <div class="w-[50%]">
                        <h3 class="text-slate-300 text-center mt-3 text-4xl mb-10 flex items-center justify-center">
                            Tipo de Habitación
                            <c:if test="${tipoHabitacion.id==0}">
                                <span class="inline-block text-sm px-2 rounded-full bg-sky-400 ml-5">Nuevo</span>
                                <c:set var="ope" value="none" />

                            </c:if>
                            <c:if test="${tipoHabitacion.id!=0}">
                                <span class="inline-block text-sm px-2 rounded-full bg-green-500 ml-5">Editar</span>
                                <c:set var="ope" value="block" />

                            </c:if>
                        </h3>
                        <form method="post" action="TipoHabitacionController">
                            <input type="hidden" value="${tipoHabitacion.id}" name="id">
                            <input type="text" name="nombre" value="${tipoHabitacion.tipo}" placeholder="Nombre" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                            <input type="text" id="imagen" value="${tipoHabitacion.foto}" name="imagen" placeholder="URL Foto" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                            <div id="preview-container" class="mt-3 w-[10rem] h-[10rem] mx-auto ">
                                <img id="image-preview" class="w-full h-full object-cover object-center" src="${tipoHabitacion.foto}" alt="Previsualización de la imagen" style="display: ${ope};">
                            </div>
                            <input type="submit" value="Guardar" class="px-5 py-2 rounded-md mt-3 cursor-pointer text-white bg-slate-600">

                        </form>

                        
                    </div>
                </section>

                <script>
                    document.getElementById('imagen').addEventListener('input', function() {
                        const url = this.value;
                        const imagePreview = document.getElementById('image-preview');
                        
                        if (url) {
                            imagePreview.src = url;
                            imagePreview.style.display = 'block';
                        } else {
                            imagePreview.style.display = 'none';
                        }
                    });
                </script>

            </main>

        </div>

    </div>
    
</body>
</html>