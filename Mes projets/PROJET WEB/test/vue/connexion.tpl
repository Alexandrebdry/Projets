<!DOCTYPE html>
<html lang="fr">
<head>
	<title>Connexion</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="./vue/CSS.css">

</head>
	<header><h1>Bienvenue sur QCM Live</h1></header>
<body>
	<section>
	<article>
		
				<form class="login100-form validate-form" action="index.php?controle=professeur&action=seConnecter" method="POST">
					<span class="login100-form-title">
						Identification 
					</span>
						<input class="input100" type="text" name="login_prof" placeholder="Entrer le nom d'utilisateur">
						<input class="input100" type="password" name="pass_prof" placeholder="Mot de passe">			
						<button class="login100-form-btn" type="submit" value="LOGIN">
							Connexion
						</button>
					
  				<?php
                if(isset($_GET['erreur'])){
                    $err = $_GET['erreur'];
                    if($err==1 || $err==2)
                        echo "<p style='color:red'>Utilisateur ou mot de passe incorrect</p>";
                }
                ?> 

				</form>
			</div>
		</div>
	</div>
	

		
	</article>
	</section>

</body>
</html>


	