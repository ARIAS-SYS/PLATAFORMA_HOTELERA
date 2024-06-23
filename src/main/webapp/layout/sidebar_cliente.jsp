<!-- Loading screen -->
            <div
                x-ref="loading"
                class="fixed inset-0 z-50 flex items-center justify-center text-white bg-black bg-opacity-50"
                style="backdrop-filter: blur(14px); -webkit-backdrop-filter: blur(14px)"
            >
                Loading.....
            </div>

            <!-- Sidebar backdrop -->
            <div
                x-show.in.out.opacity="isSidebarOpen"
                class="fixed inset-0 z-10 bg-black bg-opacity-20 lg:hidden"
                style="backdrop-filter: blur(14px); -webkit-backdrop-filter: blur(14px)"
            ></div>

            <!-- Sidebar -->
            <aside
                x-transition:enter="transition transform duration-300"
                x-transition:enter-start="-translate-x-full opacity-30  ease-in"
                x-transition:enter-end="translate-x-0 opacity-100 ease-out"
                x-transition:leave="transition transform duration-300"
                x-transition:leave-start="translate-x-0 opacity-100 ease-out"
                x-transition:leave-end="-translate-x-full opacity-0 ease-in"
                class="fixed inset-y-0 z-10 flex flex-col flex-shrink-0 w-64 max-h-screen overflow-hidden transition-all transform bg-[#0F1522] border-r border-slate-600 shadow-lg lg:z-auto lg:static lg:shadow-none"
                :class="{'-translate-x-full lg:translate-x-0 lg:w-20': !isSidebarOpen}"
            >
                <!-- sidebar header -->
                <div class="flex items-center justify-between flex-shrink-0 p-2" :class="{'lg:justify-center': !isSidebarOpen}">
                    <a href="MainController?action=index" class="py-[.8rem]">
                        <span class="p-2 text-gray-300 text-2xl font-semibold leading-8 tracking-wider whitespace-nowrap">
                            R<span :class="{'lg:hidden': !isSidebarOpen}">eservaYa</span>
                        </span>
                    </a>
                    
                    <button @click="toggleSidbarMenu()" class="p-2 rounded-md lg:hidden">
                        <svg
                            class="w-6 h-6 text-gray-600"
                            xmlns="http://www.w3.org/2000/svg"
                            fill="none"
                            viewBox="0 0 24 24"
                            stroke="currentColor"
                            >
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
                        </svg>
                    </button>              
                </div>

                <!-- Sidebar links -->
                <nav class="flex-1 overflow-hidden hover:overflow-y-auto pt-6">
                    <ul class="p-2 overflow-hidden">                        
                        <li>
                            <a href="ClienteController?action=reservas">
                                <div class="px-5 py-4 flex items-center space-x-5 hover:bg-[#1F2634] cursor-pointer border-b border-t border-slate-600">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                        class="bi bi-calendar-check size-[1.3rem] text-[#CBD5E1]" viewBox="0 0 16 16">
                                        <path d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0"/>
                                        <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4z"/>
                                    </svg>
                                    <span :class="{ 'lg:hidden': !isSidebarOpen }" class="size-[1.5rem] text-[#CBD5E1]">Reservas</span>
                                </div>
                            </a>                            
                        </li>
                        <li>
                            <a href="ClienteController?action=favoritos">
                                <div class="px-5 py-4 flex items-center space-x-5 hover:bg-[#1F2634] cursor-pointer border-b  border-slate-600">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                    class="bi bi-heart-fill size-[1.3rem] text-[#CBD5E1]" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314"/>
                                    </svg>
                                    <span :class="{ 'lg:hidden': !isSidebarOpen }" class="size-[1.5rem] text-[#CBD5E1]">Favoritos</span>
                                </div>
                            </a>                           
                        </li>
                        <li>
                            <a href="ClienteController?action=ofertas">
                                <div class="px-5 py-4 flex items-center space-x-5 hover:bg-[#1F2634] cursor-pointer border-b  border-slate-600">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                        class="bi bi-calendar4-event size-[1.3rem] text-[#CBD5E1]" viewBox="0 0 16 16">
                                        <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z"/>
                                        <path d="M11 7.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5z"/>
                                    </svg>
                                    <span :class="{ 'lg:hidden': !isSidebarOpen }" class="size-[1.5rem] text-[#CBD5E1]">Ofertas</span>
                                </div>
                            </a>                            
                        </li>
                        <li>
                            <a href="LoginController">
                                <div class="px-5 py-4 flex items-center space-x-5 hover:bg-[#1F2634] cursor-pointer border-b  border-slate-600">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                                        class="bi bi-box-arrow-in-right size-[1.3rem] text-[#CBD5E1]" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0z"/>
                                        <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z"/>
                                    </svg>
                                    <span :class="{ 'lg:hidden': !isSidebarOpen }" class="w-full size-[1.5rem] text-[#CBD5E1]">Cerrar sesión</span>
                                </div>
                            </a>               
                        </li>
                        <!-- Sidebar Links... -->
                    </ul>
                </nav>
            </aside>