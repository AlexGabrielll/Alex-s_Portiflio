document.addEventListener("DOMContentLoaded", () => {

  const toggle = document.getElementById("theme-toggle");

  function applyTheme(theme) {
    if (theme === "dark") {
      document.body.classList.add("dark");
      toggle.textContent = "☀️ Tema";
    } else {
      document.body.classList.remove("dark");
      toggle.textContent = "🌙 Tema";
    }
  }

  const saved = localStorage.getItem("theme");

  if (saved) {
    applyTheme(saved);
  } else {
    const prefersDark = window.matchMedia("(prefers-color-scheme: dark)").matches;
    applyTheme(prefersDark ? "dark" : "light");
  }

  toggle.addEventListener("click", () => {
    const isDark = document.body.classList.toggle("dark");
    const newTheme = isDark ? "dark" : "light";
    applyTheme(newTheme);
    localStorage.setItem("theme", newTheme);
  });

  // Scroll suave
  document.querySelectorAll('a[href^="#"]').forEach(link => {
    link.addEventListener("click", e => {
      e.preventDefault();
      document.querySelector(link.getAttribute("href"))
        .scrollIntoView({ behavior: "smooth" });
    });
  });

});
