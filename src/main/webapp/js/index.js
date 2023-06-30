const toggleButton = document.getElementsByClassName("toggle-button")[0]
const navbarLinks = document.getElementsByClassName("navbar-links")[0]

toggleButton.addEventListener("click", () => {
	navbarLinks.classList.toggle("active")
})

const nav = document.querySelector("nav")
let navTop = nav.offsetTop

function fixedNav() {
	if (window.scrollY > navTop) {
		nav.classList.add("fixed")
	} else {
		nav.classList.remove("fixed")
	}
}

window.addEventListener("scroll", fixedNav)

tinymce.init({
	selector: "#myTextarea",
})
