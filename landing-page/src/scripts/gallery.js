// Galería interactiva para mostrar imágenes en grande
document.addEventListener('DOMContentLoaded', () => {
    const galleryImages = document.querySelectorAll('.diagrams-gallery img');
    const modal = document.createElement('div');
    modal.className = 'modal';
    modal.innerHTML = `
        <span class="close">&times;</span>
        <img class="modal-content" id="modal-img">
        <div id="caption"></div>
    `;
    document.body.appendChild(modal);

    galleryImages.forEach(img => {
        img.addEventListener('click', () => {
            modal.style.display = 'block';
            modal.querySelector('#modal-img').src = img.src;
            modal.querySelector('#caption').innerText = img.alt;
        });
    });

    modal.querySelector('.close').onclick = function() {
        modal.style.display = 'none';
    };
    modal.onclick = function(e) {
        if (e.target === modal) modal.style.display = 'none';
    };
});