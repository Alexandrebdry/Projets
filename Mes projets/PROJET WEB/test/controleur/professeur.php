<?php 

function choisirUnTest(){
	require('./modele/projet.php');
	$test = recupererTest($_POST['test']);
	if(isset($_SESSION['etus']))
		unset($_SESSION['etus']);

	if(isset($_SESSION['id_test']))
		unset($_SESSION['id_test']);

	if(isset($_SESSION['grp']))
		unset($_SESSION['grp']);

	if(isset($_SESSION['titre']))
		unset($_SESSION['titre']);

	if(isset($_SESSION['theme']))
		unset($_SESSION['theme']);

	
	require("./vue/test.tpl");
}

function revenirMenu(){
	if(isset($_SESSION['etus']))
		unset($_SESSION['etus']);

	if(isset($_SESSION['id_test']))
		unset($_SESSION['id_test']);

	if(isset($_SESSION['grp']))
		unset($_SESSION['grp']);

	if(isset($_SESSION['titre']))
		unset($_SESSION['titre']);

	if(isset($_SESSION['theme']))
		unset($_SESSION['theme']);

	
	require("./vue/choisirTest.php");
}

function validerTest(){
	require('./modele/projet.php');
	if(isset($_POST['valide'])) {

		$valide = valTest($_POST['valide']);
	if ($valide == "valide") {
		$idQ = recuprerIdQuest($_SESSION["id_test"]); 
		$Question = recuprerQuestion($idQ);
		unset($_SESSION["idQ"]); unset($_SESSION["Questions"]);
		if(!isset($_SESSION["idQ"]) && !isset($_SESSION["Questions"])){
			$_SESSION["idQ"] = $idQ ; $_SESSION["Questions"] = $Question ;
		}
		require('./vue/questions.tpl');
	}
	if ($valide == "retour")
		require('./vue/choisirTest.php');
	}
	else 
		require('./vue/test.tpl'); 
}

function lancerTest(){
	require('./modele/projet.php');
	lancerUnTest($_SESSION["idQ"]);
	require('./vue/testLancer.tpl');
}

function seConnecter(){
	require("./modele/connect.php");
	if(isset($_SESSION['login_prof'])) {
		require("./modele/projet.php");
		connectionProf($_SESSION['login_prof']);
		require("./vue/choisirTest.php");

	}
}



 ?>