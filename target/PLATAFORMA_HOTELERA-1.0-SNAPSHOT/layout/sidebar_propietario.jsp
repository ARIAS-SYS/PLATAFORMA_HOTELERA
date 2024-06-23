<!-- sidebar -->
        <aside class="border-r w-64 border-slate-600">

            <nav class="flex-1 overflow-hidden hover:overflow-y-auto pt-8">
                <ul class="p-2 overflow-hidden">
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
