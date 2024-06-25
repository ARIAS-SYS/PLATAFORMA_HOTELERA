document.addEventListener('DOMContentLoaded', function() {
    const amenitiesSelect = document.getElementById('amenities');
    amenitiesSelect.addEventListener('change', function() {
    const selectedAmenitiesContainer = document.getElementById('selectedAmenities');
    const selectedOption = amenitiesSelect.options[amenitiesSelect.selectedIndex];

    // Verifica si la opción ya está seleccionada
    if (!document.getElementById(`selected-${selectedOption.value}`)) {
        const selectedDiv = document.createElement('div');
        selectedDiv.id = `selected-${selectedOption.value}`;
        selectedDiv.className = 'inline-block px-2 rounded-full bg-gray-500 ml-1 mb-1';
        selectedDiv.innerHTML = `
        <span>${selectedOption.textContent}</span>
        <button type="button" class="text-black ml-2" onclick="removeAmenity('${selectedOption.value}')">X</button>
        <input type="hidden" name="selectedAmenities[]" value="${selectedOption.value}">
        `;
        selectedAmenitiesContainer.appendChild(selectedDiv);
    }
    });
});

function removeAmenity(value) {
    const amenityDiv = document.getElementById(`selected-${value}`);
    if (amenityDiv) {
    amenityDiv.remove();
    }
}