<!-- sidebar -->
        <aside class="border-r w-64 border-slate-600">

            <nav class="flex-1 overflow-hidden hover:overflow-y-auto pt-2">
                <ul class="overflow-hidden">
                    <li>
                        <div class="px-5 py-4 flex items-center justify-end">
                            <a href="MainController?action=index">
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" 
                                     class="size-[2rem] text-gray-500">
                                    <path fill-rule="evenodd" d="M12 2.25c-5.385 0-9.75 4.365-9.75 9.75s4.365 9.75 9.75 9.75 9.75-4.365 9.75-9.75S17.385 2.25 12 2.25ZM8.547 4.505a8.25 8.25 0 1 0 11.672 8.214l-.46-.46a2.252 2.252 0 0 1-.422-.586l-1.08-2.16a.414.414 0 0 0-.663-.107.827.827 0 0 1-.812.21l-1.273-.363a.89.89 0 0 0-.738 1.595l.587.39c.59.395.674 1.23.172 1.732l-.2.2c-.211.212-.33.498-.33.796v.41c0 .409-.11.809-.32 1.158l-1.315 2.191a2.11 2.11 0 0 1-1.81 1.025 1.055 1.055 0 0 1-1.055-1.055v-1.172c0-.92-.56-1.747-1.414-2.089l-.654-.261a2.25 2.25 0 0 1-1.384-2.46l.007-.042a2.25 2.25 0 0 1 .29-.787l.09-.15a2.25 2.25 0 0 1 2.37-1.048l1.178.236a1.125 1.125 0 0 0 1.302-.795l.208-.73a1.125 1.125 0 0 0-.578-1.315l-.665-.332-.091.091a2.25 2.25 0 0 1-1.591.659h-.18c-.249 0-.487.1-.662.274a.931.931 0 0 1-1.458-1.137l1.279-2.132Z" clip-rule="evenodd" />
                                  </svg>
                            </a>
                        </div>
                    </li>
                    <li>
                        <a href="PropietarioController?action=home">
                            <div class="px-5 py-4 flex items-center space-x-5 hover:bg-[#1F2634] cursor-pointer border-b border-t border-slate-600">
                                <img src="${pageContext.request.contextPath}/icons/principal.png" class="w-[1.3rem] h-[1.3rem]" alt="">
                                <span class="w-full size-[1.5rem] text-white">
                                    Principal
                                </span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="PropietarioController?action=reservas">
                            <div class="px-5 py-4 flex items-center space-x-5 hover:bg-[#1F2634] cursor-pointer border-b border-t border-slate-600">
                                <img src="${pageContext.request.contextPath}/icons/reservas.png" class="w-[1.3rem] h-[1.3rem]" alt="">
                                <span class="w-full size-[1.5rem] text-white">
                                    Reservas
                                </span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="PropietarioController?action=habitaciones">
                            <div class="px-5 py-4 flex items-center space-x-5 hover:bg-[#1F2634] cursor-pointer border-b border-t border-slate-600">                                
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                    class="bi bi-building-fill size-[1.3rem] text-[#CBD5E1]" viewBox="0 0 16 16">
                                    <path d="M3 0a1 1 0 0 0-1 1v14a1 1 0 0 0 1 1h3v-3.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5V16h3a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1zm1 2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm3.5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5M4 5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zM7.5 5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5m2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zM4.5 8h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5m2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm3.5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5"/>
                                  </svg>
                                <span class="w-full size-[1.5rem] text-white">
                                    Habitaciones
                                </span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="PropietarioController?action=tipo_habitaciones">
                            <div class="px-5 py-4 flex items-center space-x-5 hover:bg-[#1F2634] cursor-pointer border-b border-t border-slate-600">
                                <img src="${pageContext.request.contextPath}/icons/cama_matrimonial.png" class="w-[1.3rem] h-[1.3rem]" alt="">
                                <span class="w-full size-[1.5rem] text-white">
                                    Tipo de Habitación
                                </span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="PropietarioController?action=ofertas">
                            <div class="px-5 py-4 flex items-center space-x-5 hover:bg-[#1F2634] cursor-pointer border-b border-t border-slate-600">
                                <img src="${pageContext.request.contextPath}/icons/ofertas.png" class="w-[1.3rem] h-[1.3rem]" alt="">
                                <span class="w-full size-[1.5rem] text-white">
                                    Ofertas
                                </span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="PropietarioController?action=detalle">
                            <div class="px-5 py-4 flex items-center space-x-5 hover:bg-[#1F2634] cursor-pointer border-b border-t border-slate-600">
                                <img src="${pageContext.request.contextPath}/icons/detalles.png" class="w-[1.3rem] h-[1.3rem]" alt="">
                                <span class="w-full size-[1.5rem] text-white">
                                    Detalle
                                </span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="LoginController">
                            <div class="px-5 py-4 flex items-center space-x-5 hover:bg-[#1F2634] cursor-pointer border-b border-t border-slate-600">
                                <img src="${pageContext.request.contextPath}/icons/cerrar_sesion.png" class="w-[1.3rem] h-[1.3rem]" alt="">
                                <span class="w-full size-[1.5rem] text-white">
                                    Cerrar Sesión
                                </span>
                            </div>
                        </a>
                    </li>
                </ul>
            </nav>


        </aside>
