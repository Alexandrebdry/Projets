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
		$titreQ = recuprerThemeQ($_SESSION["idQ"]);
		$reponses = recuprerRep($_SESSION["idQ"]);
					
		echo " groupe : " . $_SESSION['grp'] .'('. $_SESSION['etus'] .')' . "<br>";
		echo  "test : " . $_SESSION['titre'] . '<br>';
		echo "theme : " . $titreQ  . '<br>';
		if(is_array($_SESSION["Questions"])) {
			for($i = 1 ; $i < count($_SESSION["Questions"]) ; $i++ ) {
			echo $i . " - " . $_SESSION["Questions"][$i-1] . " " ;
			for( $j = 0 ; $j < count($reponses) ; $j++) {
				$repvals = repValide($reponses[$j]["id_rep"]) ;
				$rep = recupererNomRep($reponses[$j]["id_rep"]);
	?> 
				<form method="post" action="index.php?controle=professeur&action=lancerTest">
				<?php 
				if($repvals == 1 ) { ?>
					<input type="radio" name="rep" id="<?php $rep ?>" value="<?php $rep ?>" checked="true" > 
					<label for="<?php $rep ?>"><?php echo $rep ?></label> <?php echo "test" ;
				}
				 else { ?> 
					<input type="radio" name="rep" id="<?php $rep ?>" value="<?php $rep ?>"  >
					<label for="<?php $rep ?>"><?php echo $rep ?></label> <?php
				}
				
			}
		}
	}

	else   {
		
		echo "1 -  " . $_SESSION["Questions"] . " " ;
		for( $j = 0 ; $j < count($reponses) ; $j++) {
				$repvals = repValide($reponses[$j]["id_rep"]) ;
				$rep = recupererNomRep($reponses[$j]["id_rep"]);

				?> 
				<form method="post" action="index.php?controle=professeur&action=lancerTest">
				<?php 
				if($repvals == 1 ) { ?>
					<input type="radio" name="rep" id="<?php $rep ?>" value="<?php $rep ?>" checked="true" > 
					<label for="<?php $rep ?>"><?php echo $rep ?></label> <?php echo "test" ;
				}
				 else { ?> 
					<input type="radio" name="rep" id="<?php $rep ?>" value="<?php $rep ?>"  >
					<label for="<?php $rep ?>"><?php echo $rep ?></label> <?php
				}
				
			}
		

	}
		
?>
<br><br>
<input type="submit" name="submit" value="LancerTest">
</form>

<form method="post" action="index.php?controle=professeur&action=revenirMenu">

		<input type="submit" name="submit" value="Revenir au choix">
	</form>
	
	
		</article>
	</section>
</body>
<footer></footer>
</html>