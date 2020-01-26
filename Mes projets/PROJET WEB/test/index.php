<?php 
	session_start();

	if(isset($_GET['controle']) & isset($_GET['action'])) {
		$controle = $_GET['controle'];
		$action = $_GET['action'];
		require('./controleur/' . $controle . '.php') ;
		$action() ;
	}
	else {
		$_SESSION = array() ;
		require('./vue/connexion.tpl' );
	}

?>