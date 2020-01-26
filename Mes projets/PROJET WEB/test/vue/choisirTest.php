<!DOCTYPE html>
<html>
<head>
	<title>Choisir un test</title>
	<link rel="stylesheet" type="text/css" href="./vue/CSS.css">
</head>
<header> <h1>Bienvenue dans QCM Live</h1></header>
<body>
	<section>
		<article>

			<img src="./vue/images/prof.png">
			<h2>Voici la liste de toutes les questions disponible. Veuillez en choisir une.</h2>

	<?php 

include('./modele/connect.php');

$reponse = $bdd->query("select * from test") ;

?>
<form method="post" action="index.php?controle=professeur&action=choisirUnTest">
	<select name="test">

		<?php 

		while( $données = $reponse->fetch() ) 
		{
			?>

			<option ><?php echo $données['titre_test']; ?></option>
			<?php echo $données['titre_test'] . "<p>  = id du test </p>" ; 
		}

		$reponse->closeCursor();
		?>

	</select> 
	<input type="submit" name="submit" value="Choisir la valeur séléctionné" />


</form>
	<h3>Toutes les informations liées au test choisi seront affichés par la suite.</h3>
		</article>
		<br>
	</section>
	
</body>
<footer></footer>
</html>

