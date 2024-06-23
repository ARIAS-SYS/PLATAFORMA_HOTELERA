
<%@page import="com.emergentes.entities.Usuario"%>      
    <nav class="${param.posicion} top-0 left-0 right-0 px-5 py-[0.8rem] border-b-2 border-slate-700 lg:px-20 flex justify-between">
        <div class="">
            <a class="text-gray-300 text-2xl font-semibold" href="MainController?action=index">ReservaYa</a>
        </div>
        <div class="flex gap-5 lg:gap-7  items-center">
            <div>
                <a href="MainController?action=buscador" >
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" 
                        class="size-[1.5rem] text-[#8F9EB3] hover:text-[#CBD5E1]">
                        <path fill-rule="evenodd" d="M10.5 3.75a6.75 6.75 0 1 0 0 13.5 6.75 6.75 0 0 0 0-13.5ZM2.25 10.5a8.25 8.25 0 1 1 14.59 5.28l4.69 4.69a.75.75 0 1 1-1.06 1.06l-4.69-4.69A8.25 8.25 0 0 1 2.25 10.5Z" clip-rule="evenodd" />
                    </svg>
                </a>
            </div>
            <button id="openModalSesion" class="text-[#8F9EB3] hover:text-[#CBD5E1] flex gap-1">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" 
                    class="size-[1.5rem]">
                    <path fill-rule="evenodd" d="M7.5 6a4.5 4.5 0 1 1 9 0 4.5 4.5 0 0 1-9 0ZM3.751 20.105a8.25 8.25 0 0 1 16.498 0 .75.75 0 0 1-.437.695A18.683 18.683 0 0 1 12 22.5c-2.786 0-5.433-.608-7.812-1.7a.75.75 0 0 1-.437-.695Z" clip-rule="evenodd" />
                </svg>
                <c:if test="${not empty sessionScope.usuario}">
                    <span>${usuario.nombre}</span>
                </c:if>
            </button>
        </div>
    </nav>
                
    <!-- modal sesion -->
    <div id="modalSesion" class="fixed inset-0 bg-[#1F1F1F40] flex items-center justify-center hidden">
        <div class="bg-[#0F1522] w-[15rem] lg:w-[22rem] p-6 lg:px-16">
            <h2 class="text-white text-xl lg:text-2xl font-bold mb-4 text-center">
                Iniciar Sesión
            </h2>
            <form method="post" action="LoginController?action=sesion">
                <div class="mb-4">
                    <input type="email" name="email" placeholder="Email" class="block w-full px-3 py-2 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                </div>
                <div class="mb-4">
                    <input type="password" name="password" placeholder="Password" class="block w-full px-3 py-2 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                </div>
                <button type="submit" class="text-white w-full bg-blue-700 py-2 rounded">
                    Login
                </button>
                <div class="mt-2">
                    <p class="text-[#8F9EB3] text-center">
                        ¿No tienes una cuenta?
                    </p>
                    <button type="button" id="openModalRegister" class="text-[#FF7D7D] block w-full">
                        REGISTRARSE
                    </button>
                </div>
            </form>
        </div>
    </div>

    <!-- modal register -->
    <div id="modalRegister" class="fixed inset-0 bg-[#1F1F1F40] flex items-center justify-center hidden">
        <div class="bg-[#0F1522] w-[15rem] lg:w-[22rem] p-6 lg:px-16">
            <h2 class="text-white text-xl lg:text-2xl font-bold mb-4 text-center">
                Registrarse
            </h2>
            <form method="post" action="LoginController?action=register">
                <div class="mb-4">
                    <input type="text" name="nombre" placeholder="Nombre" class="block w-full px-3 py-2 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                </div>
                <div class="mb-4">
                    <input type="email" name="email" placeholder="Email" class="block w-full px-3 py-2 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                </div>
                <div class="mb-4">
                    <input type="password" placeholder="Password" class="block w-full px-3 py-2 bg-transparent border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                </div>
                <div class="mb-4">
                    <select name="rol" class="block w-full px-3 py-2 bg-[#0F1522] border border-slate-500 focus:outline-none focus:right-0 text-[#CBD5E1]">
                        <option value="1">Cliente</option>
                        <option value="2">Propietario</option>
                    </select>
                </div>
                <button type="submit" class="text-white w-full bg-blue-700 py-2 rounded">
                    Registrarse
                </button>
                <div class="mt-2">
                    <p class="text-[#8F9EB3] text-center">
                        ¿Ya tienes una cuenta?
                    </p>
                    <button type="button" id="openModalSesion2" class="text-[#FF7D7D] block w-full">
                        INICIAR SESIÓN
                    </button>
                </div>
            </form>
        </div>
    </div>

      <script src="js/loginModal.js"></script>