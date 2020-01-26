var slideIndex = 1; //on déclare une variable index on arrive directement sur la 1ere image qd c 1 et la derniere qd c 0

function slideSuivante(n) { //fonction appelée sur index.html sur les radio boutons
  slideVisu(slideIndex += n);
}

function slideActuelle(n) { //fonction précisant la slide actuelle appelée sur index.html
  slideVisu(slideIndex = n);
}

function slideVisu() { //
  var i;
  var slides = document.getElementsByClassName("image"); //récupération des variables par leur classe
  var bouton = document.getElementsByClassName("bouton");
  
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none"; //on affiche pas si c'est pas la bonne slide
  }
  if (slideIndex > slides.length) {slideIndex = 1} 
  if (slideIndex < 1) {slideIndex = slides.length}
  for (i = 0; i < bouton.length; i++) {
      bouton[i].className = bouton[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block"; 
  bouton[slideIndex-1].className += " active";
  //var t = setTimeout(slideVisu, 4000); // on passe automatiquemet à la slide ttes les 3s
  //slideIndex++; //on passe à la slide suivante
  //bouton.addEventListener('click',clearTimeOut(t));
 
}

slideVisu(slideIndex); //appel de la fonction


