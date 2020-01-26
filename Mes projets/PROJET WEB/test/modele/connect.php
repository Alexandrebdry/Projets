<?php
if(isset($_SESSION['login_prof'])) {
	try {
		$bdd = new PDO('mysql:host=localhost;dbname=projetphp;charset=utf8','root');
	}
	catch(Exception $e) {
		die ("Erreur : ' " . $e->getMessage());
	}
}
else {
	
if(isset($_POST['login_prof']) && isset($_POST['pass_prof']))
{
    // connexion à la base de données
    $db_username = 'root';
    $db_password = '';
    $db_name     = 'projetphp';
    $db_host     = 'localhost';
    $db = mysqli_connect($db_host, $db_username, $db_password,$db_name)
           or die('could not connect to database');
    
    // 2 fonctions mysqli_real_escape_string et htmlspecialchars
    // éliminer toute attaque de type injection SQL et XSS
    $login_prof = mysqli_real_escape_string($db,htmlspecialchars($_POST['login_prof'])); 
    $pass_prof = mysqli_real_escape_string($db,htmlspecialchars($_POST['pass_prof']));
    
    if($login_prof !== "" && $pass_prof !== "")
    {
        $requete = "SELECT count(*) FROM professeur where 
              login_prof = '".$login_prof."' and pass_prof = '".$pass_prof."' ";
        $exec_requete = mysqli_query($db,$requete);
        $reponse = mysqli_fetch_array($exec_requete);
        $count = $reponse['count(*)'];
        if($count!=0) // nom d'professeur et mot de passe correctes
        {
           $_SESSION['login_prof'] = $login_prof;
           header("./vue/choisirTest.php");
        }
        else
        {
           header('Location: index.php?erreur=1'); // professeur ou mot de passe incorrect
        }
    }
    else
    {
       header('Location: index.php?erreur=2'); // professeur ou mot de passe vide
    }
}
else
{
   header('Location: index.php');
}


mysqli_close($db); // fermer la connexion
}
?>