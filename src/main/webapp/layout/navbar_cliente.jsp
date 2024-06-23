<!-- Navbar -->
<header class="flex-shrink-0 border-b border-slate-700">
    <div class="pr-5 py-[.8rem] border-b border-slate-700 lg:pr-20 flex justify-between">
        <!-- Navbar left -->
        <div class="flex items-center justify-between space-x-3">
            <a href="MainController?action=index" class="p-2 text-gray-300 text-xl font-semibold tracking-wider uppercase lg:hidden">RY</a>
            <!-- Toggle sidebar button -->
            <button @click="toggleSidbarMenu()" class="p-2 rounded-md focus:outline-none focus:ring">
                <svg
                    class="w-4 h-4 text-gray-600"
                    :class="{'transform transition-transform -rotate-180': isSidebarOpen}"
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    >
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 5l7 7-7 7M5 5l7 7-7 7" />
                </svg>
            </button>                            
        </div>
        <div class="flex  items-center space-x-2 lg:space-x-10 gap-3">
            <div>
                <a href="MainController?action=buscador">
                <svg 
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke-width="1.5"
                    stroke="currentColor"
                    class="size-[1.5rem] text-[#8F9EB3] hover:text-[#CBD5E1] cursor-pointer"
                >
                    <path stroke-linecap="round" stroke-linejoin="round" d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" />
                </svg>
                </a>
            </div>
            <a href="MainController?action=cliente" class="flex gap-1 text-[#8F9EB3] hover:text-[#CBD5E1] cursor-pointer">
                <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 24 24"
                fill="currentColor"
                class="size-[1.5rem]"
                >
                <path fill-rule="evenodd" d="M7.5 6a4.5 4.5 0 1 1 9 0 4.5 4.5 0 0 1-9 0ZM3.751 20.105a8.25 8.25 0 0 1 16.498 0 .75.75 0 0 1-.437.695A18.683 18.683 0 0 1 12 22.5c-2.786 0-5.433-.608-7.812-1.7a.75.75 0 0 1-.437-.695Z" clip-rule="evenodd"/>
                </svg>
                <span>${usuario.nombre}</span>
            </a>
        </div>
    </div>
</header>