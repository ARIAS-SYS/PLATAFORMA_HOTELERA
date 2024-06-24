
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

    <header>

        <jsp:include page="../layout/navbar.jsp">
            <jsp:param name="posicion" value="relative"/>
        </jsp:include>
    </header>


    <main>
        
        <!-- nuevo hotel -->
        <section class="w-full pt-10">
            <div class="w-[50%] mx-auto">
                <h3 class="text-slate-300 text-center mt-3 text-4xl mb-10">
                    Añadir Nuevo Hotel
                </h3>

                <form method="post" action="PropietarioController" enctype="multipart/form-data">
                    <input type="file" name="foto" class="hidden" id="foto">
                    <div class="flex gap-2">
                        <label for="foto" class="cursor-pointer inline-flex items-center p-6 border border-gray-600 hover:bg-[#2A3345]">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                class="bi bi-images size-10 text-gray-400" viewBox="0 0 16 16">
                                <path d="M4.502 9a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3"/>
                                <path d="M14.002 13a2 2 0 0 1-2 2h-10a2 2 0 0 1-2-2V5A2 2 0 0 1 2 3a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v8a2 2 0 0 1-1.998 2M14 2H4a1 1 0 0 0-1 1h9.002a2 2 0 0 1 2 2v7A1 1 0 0 0 15 11V3a1 1 0 0 0-1-1M2.002 4a1 1 0 0 0-1 1v8l2.646-2.354a.5.5 0 0 1 .63-.062l2.66 1.773 3.71-3.71a.5.5 0 0 1 .577-.094l1.777 1.947V5a1 1 0 0 0-1-1z"/>
                            </svg>
                        </label>
                        <div class="h-24 w-24">
                            <output id="list" class="w-full h-full"></output>
                        </div>
                    </div>
                    <input type="text" name="nombre" placeholder="Nombre" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                    <input type="text" name="descripcion" placeholder="Descripción" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                    <div class="flex gap-1">
                        <input type="text" name="ciudad" placeholder="Ciudad" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                        <input type="text" name="departamento" placeholder="Departamento" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                        <input type="text" name="pais" placeholder="Pais" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                    </div>
                    <input type="text" name="descripcionUbicacion" placeholder="Descripción de la Ubicación" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                    <div class="flex gap-1">
                        <input type="text" name="urlUbicacion" placeholder="URL Ubicación" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                        <input type="text" name="urlInstagram" placeholder="URL Instagram" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                    </div>
                    <div class="flex gap-1">
                        <input type="text" name="celular" placeholder="Whatsapp" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                        <input type="text" name="urlFacebook" placeholder="URL Facebook" class="block w-full px-3 mt-3 py-1 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                    </div>
                    <input type="submit" value="Crear Hotel" class="px-5 py-2 rounded-md mt-3 cursor-pointer text-white bg-slate-600">

                </form>
            </div>
        </section>

    </main>

    <script>

        function archivo(evt) {
            var files = evt.target.files; // FileList object
            // Obtenemos la imagen del campo "file".
            for (var i = 0, f; f = files[i]; i++) {
                //Solo admitimos imágenes.
                if (!f.type.match('image.*')) {
                    continue;
                }
                var reader = new FileReader();
                reader.onload = (function (theFile) {
                    return function (e) {
                        // Insertamos la imagen
                        document.getElementById("list").innerHTML = ['<img style="height: 100px; widt: 100%; object-fit: cover; margin: 0 auto;" class="thumb thumbnail " src="',e.target.result, '"  title="', escape(theFile.name), '"/>'].join('');
                    };
                })(f);
                reader.readAsDataURL(f);
            }
        }
        document.getElementById('foto').addEventListener('change', archivo, false);

    </script>


</body>
</html>