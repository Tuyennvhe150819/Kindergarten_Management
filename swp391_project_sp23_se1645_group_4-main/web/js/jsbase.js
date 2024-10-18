
const navMenu = document.querySelector(".bottom-navbar");
window.onscroll = () => {
    navMenu.classList.toggle('close', window.scrollY > 0);
}

function show(anything) {
    document.querySelector('.textBox').value = anything.textContent;
}

let dropdown = document.querySelector('.dropdown_selectBox');
if (dropdown) {
    console.log(dropdown);
    dropdown.onclick = function () {
        dropdown.classList.toggle('active');
    }
}

  