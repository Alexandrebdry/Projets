<?php

function recupererTest($titre_test) {

	require("connect.php") ;
	/*On prepare le sql et le ? correspond à la valeur d'entrée de la fonction*/
	$CommandeSQL = $bdd->prepare("select * from test t where titre_test = ?");

	/*On lance la requete sql avec la valeur d'entrée de la fonction*/
	$CommandeSQL->execute(Array($titre_test));

	/*On récupère les valeurs de la requete et on les stocks dans $id_test*/
	$id_test = $CommandeSQL->fetch();
	return $id_test ; 

}

function afficherTheme($id_test) {

	require("connect.php") ;
	/*On prepare le sql et le ? correspond à la valeur d'entrée de la fonction*/
	$reponse = $bdd->prepare("select th.titre_theme
		from test  t inner join ( 
		qcm inner join ( 
		question q inner join theme th on q.id_theme = th.id_theme ) 
		on qcm.id_quest = q.id_quest ) 
		on qcm.id_test  = ? ;") ;

	/*On lance la requete sql avec la valeur d'entrée de la fonction*/
	$reponse->execute(Array($id_test)) ; 

	/*On récupère les valeurs de la requete et on les stocks dans $id_test*/
	$titre_theme = $reponse->fetch() ;
	/*echo $titre_theme[0] ;*/ 

	return $titre_theme[0] ; 
}

function afficherNbPersDsGrp($id_grp) {

	require('connect.php');

	$reponse = $bdd->prepare('select id_grpe 
		from groupe where num_grpe = ?
		');
	$reponse->execute(Array($id_grp));
	$nbpersgrp = $reponse->fetch();

	$sql = $bdd->prepare('select count(id_etu)
		from grpetudiants 
		where id_grpe = ?');
	$sql->execute(Array($nbpersgrp[0]));

	$nbPersGrpe = $sql->fetch();

	return $nbPersGrpe[0];

}

function valTest($test) {
	return $test == "valide"? "valide" : "retour" ; 
}

function recuprerIdQuest($id_test){

	require("connect.php");

	$sql = $bdd->prepare("select id_quest from qcm where id_test = ?");
	$sql->execute(Array($id_test));

	$idQ = $sql->fetch();
	return $idQ[0];

}
function recuprerQuestion($id_question) {

	require("connect.php");

	$sql = $bdd->prepare("select texte
							from question
							where id_quest = ?");
	$sql->execute(Array($id_question));

	$questions = $sql->fetch(); 
	return $questions; 
}

function recuprerThemeQ($idQ) {

	require("connect.php");

	$sql = $bdd->prepare("select titre from question where id_quest = ?");
	$sql->execute(Array($idQ));

	$titreQ = $sql->fetch();
	return $titreQ[0];

}

function recuprerRep($idQ) {

	require("connect.php");

	$sql = $bdd->prepare("select id_rep from reponse 
	where id_quest = ? group by id_rep");
	$sql->execute(Array($idQ));

	$reponses = $sql->fetchAll();
	return $reponses ; 

}

function repValide($idRep) {

	require("connect.php");

	$sql = $bdd->prepare("select bvalide from reponse where id_rep = ?");
	$sql->execute(Array($idRep)) ;

	$val = $sql->fetch();
	return $val[0] ;
}

function recupererNomRep($idRep) {

	require("connect.php");

	$sql = $bdd->prepare("select texte_rep from reponse where id_rep = ?");
	$sql->execute(Array($idRep)) ;

	$val = $sql->fetch();
	return $val[0];
}

function lancerUnTest($idq) {

	require("connect.php");

	$sql= $bdd->prepare("update qcm set bAutorise = 1, bBloque = 0 where id_quest = ?");
	$sql->execute(Array($idq));
}

function connectionProf($login){
	require("connect.php");

	$sql= $bdd->prepare("update professeur set bConnect = 1 where login_prof = ?");
	$sql->execute(Array($login));
}
