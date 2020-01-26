<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="./vue/CSS.css">
</head>
<header> <h1>Bienvenue dans QCM Live</h1></header>
<body>
	<section>
		<article>
			
	<?php 
	include_once ('./modele/projet.php');

	if(!empty($test)) {
	$idtest = $test['id_test'];
	$grp = $test['num_grpe'];
	$titre = $test['titre_test'];
	$thème = afficherTheme($idtest);
	$etus = afficherNbPersDsGrp("$grp");
	}
	
	if(!isset($_SESSION['etus']))
		$_SESSION['etus'] = $etus;

	if(!isset($_SESSION['id_test']))
		$_SESSION['id_test'] = $idtest;

	if(!isset($_SESSION['grp']))
		$_SESSION['grp'] = $grp;

	if(!isset($_SESSION['titre']))
		$_SESSION['titre'] = $titre;

	if(!isset($_SESSION['theme']))
		$_SESSION['theme'] = $thème;
	
	echo '<h2>test : ' . $_SESSION['titre'] . '</h2>';
	if(empty($_SESSION['theme']))
	echo '<h2>' . ' il n\'y a pas de theme pour ce test </h2>' ; 
	else
	echo '<h2>' ." Theme : " .$_SESSION['theme'] . '</h2>' ; 
	echo '<h2>' . ' groupe : ' . $_SESSION['grp'] . "(" . $_SESSION['etus']  . ")</h2>" ;  
	?>


	<form method="post" action="index.php?controle=professeur&action=validerTest">
		<div>
			valide : <input type="radio" name="valide" value="valide">
		</div>
		<div>
			retour : <input type="radio" name="valide" value="retour">	
		</div>	
		<input type="submit" name="submit" value="Valider">
	</form>

	
		</article>
	</section>
</body>
</html>

