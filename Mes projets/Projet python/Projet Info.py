# Espace des importations
import os
import sys
import math

# Espace de définition des variables globales.
choix_utilisateur = ""  # variable globale qui prendra la valeur d'une saisie de l'utilisateur
validation = ["oui", "non"]


# Espace de définition des fonctions utiles.

def lancement_application():  # Fonction du début qui sert à tout. Seule fonction appeller dans l'application.
    choix = ['rechercher', 'editer']  # les deux choix possibles

    print("Vous êtes sur le menu principal. Voulez continuer ?")
    réponse = input(validation[0] + " ou " + validation[1] + " ? ")
    if réponse == validation[1]:
        sys.exit(0)
    else:
        while 1:  # Boucle infinie
            print(choix[0] + " ou " + choix[1] + " ? ")  # Affiche les choix possibles
            choix_utilisateur = input("Rentrez votre choix : ")  # Demande de saisie de la par de l'utilisateur
            if choix_utilisateur == choix[0] or choix_utilisateur == choix[1]:  # Si la saisie est correcte
                break  # on sort de la boucle infinie
            else:  # Sinon
                print("Vous n'avez rien choisi de valide")  # On affiche un message d'erreur
                continue  # et on recommance jusqu'a une saisie correcte

        if choix_utilisateur == choix[0]:  # Si l'utilisateur veut rechercher qqch
            rechercher_quelque_chose()  # On appelle la fonction qui permet de rechercher
        else:  # Si il veut éditer
            editer_quelque_chose()  # alors on appelle la fonction pour éditer


# Fonctions de recherche
def rechercher_par_compositeur():  # fonction de recherche par compositeur
    with open(sys.path[0] + "/types/compositeur.txt",'r') as fichier :
        tmp = fichier.read()
        données = tmp.split()
        for elt in données:
            print(elt)
        while 1:
            choix = input("Quel compositeur voulez-vous choisir ? ")
            for elt in données:
                if choix == elt:
                    validation = input("En êtes-vous sur ? oui ou non : ")
                    if validation == "oui":
                        with open(sys.path[0] + "/types/partition.txt",'r') as partition :
                            tmp = partition.read()
                            partition_str = tmp.split()
                            i = int(0)
                            auteurs = []
                            for element in partition_str:
                                if i % 2 != 2:
                                    if element == choix:
                                        auteurs.append(partition_str[i-1])
                                i += 1
                                i = int(i)
                            if len(auteurs) == 0:
                                print("Ce compositeur n'a rien écrit")
                            else:
                                print("Voici toutes les partitions de "+ choix)
                                for element in auteurs:
                                    print(element)
                                while 1:
                                    test = input("Voulez-vous lire une partition ? oui ou non: ")
                                    if test == "oui":
                                        for element in auteurs:
                                            print(element)
                                        part_a_lire = input("Laquelle voulez-vous lire ? ")
                                        for element in auteurs:
                                            if part_a_lire == element:
                                                if os.path.exists(sys.path[0] + "/types/partition " +part_a_lire + ".txt"):
                                                    with open(sys.path[0] + "/types/partition " +part_a_lire + ".txt", 'r') as part:
                                                        print(part.read())
                                                else:
                                                    print("Impossible d'acceder à la partition. " + choix + " ne veut peut-être pas vous la montrer.")
                                                    rechercher_par_compositeur()
                                            else:
                                                print("La partition n'existe pas pour ce compositeur.")
                                    elif test == "non":
                                        lancement_application()
                                    else:
                                        print("Saisie incorrect")

def rechercher_par_titre_de_partition():  # fonction de recherche par titre de partition
    with open(sys.path[0] + "/types/partition.txt", 'r') as partition:
        i = int(0)
        tmp = partition.read()
        partition_str = tmp.split()
        for elt in partition_str:
            if i % 2 == 0:
                print(elt)
            i+=1
            i = int(i)
            while 1:
                choix = input("Laquelle de ces partitions vous interesse ? ")
                for elt in partition_str:
                    if choix == elt:
                        validation = input("En êtes-vous sur ? oui ou non : ")
                        if validation == "oui":
                            if os.path.exists(sys.path[0] + "/types/partition "+choix+".txt"):
                                with open(sys.path[0] + "/types/partition "+choix+".txt", 'r') as part:
                                    print(part.read())
                                    lancement_application()
                            else:
                                print("Impossible d'acceder à la partition. " + choix +".")
                                rechercher_par_titre_de_partition()
                        elif validation == "non":
                            lancement_application()
                        else:
                            print("Saisie incorrect.")



def rechercheer_par_instrument():  # fonction de recherche par instrument
    with open(sys.path[0] + "/types/instrument.txt", 'r') as instrument:
        tmp = instrument.read()
        données = tmp.split()
        for elt in données:
            print(elt)
        while 1:
            nb_instru_a_choisir = input("Combien voulez-vous selectionner d'instrument ? ")
            nb_instru_a_choisir = int(nb_instru_a_choisir)
            test_nb_instru = nb_instru_a_choisir
            instruments = []
            while nb_instru_a_choisir != 0:
                choix= input("Saisissez un instrument : ")
                for elt in données:
                    if choix == elt:
                        instruments.append(elt)
                        nb_instru_a_choisir -= 1
                        nb_instru_a_choisir = str(nb_instru_a_choisir)
                        print("Il vous reste " + nb_instru_a_choisir + " a choisir !")
                        nb_instru_a_choisir = int(nb_instru_a_choisir)
                    else:
                        print("Cet instrument n'existe pas.")
            with open(sys.path[0] + "/types/partition.txt", 'r') as partition:
                i = int(0)
                tmp = partition.read()
                partition_str = tmp.split()
                bonnes_parts = []
                for elt in partition_str:
                    if i % 2 == 0:
                        if os.path.exists(sys.path[0] + "/types/partition " + elt + ".txt"):
                            with open(sys.path[0] + "/types/partition " + elt + ".txt", 'r') as part:
                                tmp = part.read()
                                tests = tmp.split()
                                j= int(0)
                                for test in tests:
                                    for instru in instruments:
                                        if test_nb_instru == j:
                                            bonnes_parts.append(elt)
                                            break
                                        if test == instru:
                                            j+=1
                                            j = int(j)
                    i+= 1
                    i = int(i)
                if len(bonnes_parts) == 0:
                    print("Aucune partition ne contient ces instruments")
                    lancement_application()
                else :
                    print("Voici les partitions contenant les instruments choisi.")
                    for elt in bonnes_parts:
                        print(elt)
                    lancement_application()

def rechercher_quelque_chose():  # fonction de recherche qui demande ce que l'on cherche

    types_de_recherche = ["compositeur", "titre de partition", "instrument"]  # Liste de tous les types de recherche possible

    while 1:

        # On demande a l'utilisateur de choisir un type de recherche
        # tant que la saisie n'est pas bonne
        # et si elle ne l'est pas alors on affiche un message d'erreur
        # et lorsque l'utilisateur a bien tapé un type de recherche on effectue la recherche de ce type

        # Affichage des différents choix possibles
        print("Voulez-vous rechercher par " + types_de_recherche[0] + ", par " + types_de_recherche[1] +
              " ou par " + types_de_recherche[2]  )

        # Demande de saisie de la par de l'utilisateur
        choix_utilisateur = input("Rentrez votre choix : ")

        # Test de la saisie
        if choix_utilisateur == types_de_recherche[0]:
            rechercher_par_compositeur()
            lancement_application()
            break
        elif choix_utilisateur == types_de_recherche[1]:
            rechercher_par_titre_de_partition()
            lancement_application()
            break
        elif choix_utilisateur == types_de_recherche[2]:
            rechercheer_par_instrument()
            lancement_application()
        else:
            print("Vous n'avez rien choisi de valide")  # On affiche un message d'erreur
            continue  # et on recommance jusqu'a une saisie correcte


# Fonction d'éditions
def créer_qqch():
    choix = ["compositeur", "instrument", "partition"]

    while 1:
        # On demande a l'utilisateur de choisir un type de recherche
        # tant que la saisie n'est pas bonne
        # et si elle ne l'est pas alors on affiche un message d'erreur
        # et lorsque l'utilisateur a bien tapé un type de recherche on effectue la recherche de ce type

        # Affichage des différents choix possibles
        print("Que voulez-vous créer ? Un " + choix[0] + ", un " + choix[1] + " ou bien une " + choix[2])

        # Demande de saisie de la par de l'utilisateur
        choix_utilisateur = input("Rentrez votre choix : ")
        tmp = choix_utilisateur
        # test de saisie
        if choix_utilisateur == choix[0]:
            nom_fichier = choix[0]
            choix_utilisateur = input("Veuillez saisir le nom du " + choix[0] + " que vous souhaitez ajouter: ")
            break;
        elif choix_utilisateur == choix[1]:
            nom_fichier = choix[1]
            choix_utilisateur = input("Veuillez saisir le nom de l' " + choix[1] + " que vous souhaitez ajouter: ")
            break;
        elif choix_utilisateur == choix[2]:
            nom_fichier = choix[2]
            choix_utilisateur = input("Veuillez saisir le nom de la " + choix[2] + " que vous souhaitez ajouter: ")
            break;
        else:
            print("Vous n'avez rien choisi de valide")  # On affiche un message d'erreur
            continue  # et on recommance jusqu'a une saisie correcte

    while 1:
        # Validation de la création
        print("Etes vous sur de vouloir ajouter " + choix_utilisateur + " en tant que " + tmp + " ?")
        # Demande de saisie de la par de l'utilisateur
        valide = input(validation[0] + " ou " + validation[1] + " ? ")
        if valide == validation[0]:
            # Création d'un répertoire types si il n'existe pas
            if not os.path.exists(sys.path[0] + "/types"):
                os.mkdir(sys.path[0] + "/types")
            # Ajoute l'objet choisi au-dessus dans le fichier texte correspondant

            if choix[0] == nom_fichier or choix[1] == nom_fichier:
                if not os.path.exists(sys.path[0] + "/types/" + nom_fichier + ".txt"):
                    f = open(sys.path[0] + "/types/" + nom_fichier + ".txt", 'w')

                with open(sys.path[0] + "/types/" + nom_fichier + ".txt", 'a') as f:
                    if not ExisteDeja(choix_utilisateur, sys.path[0] + "/types/" + nom_fichier + ".txt"):
                        f.write(choix_utilisateur + '\n')
                        f.close()
                        lancement_application()
                    else:
                        print("Le " + nom_fichier + " existe déjà.")
                        créer_qqch()
            elif nom_fichier == choix[2]:
                if not os.path.exists(sys.path[0] + '/types/' + nom_fichier + " " + choix_utilisateur + ".txt"):
                    with open(sys.path[0] + "/types/" + nom_fichier + " " + choix_utilisateur + ".txt", 'a') as f:
                        instruments = []

                        print("Pour ajouter une partition il faut aussi son auteur. ")

                        # Saisie du nom de l'auteur
                        while 1:

                            auteur = input("Veuillez saisir le nom de l'auteur : ")
                            if not ExisteDeja(auteur, sys.path[0] + "/types/" + choix[0] + ".txt"):
                                print("L'auteur n'existe pas.")
                            else:
                                break

                        # Saisie du nb d'instru et leurs noms
                        print("Il faut aussi des instruments. Combien en faut-il pour cette partition ? ")
                        nb_instru = int(0);
                        while nb_instru < 1:
                            nb_instru = input("Veuillez saisir le nombre d'instruments nécessaire pour la partition : ")
                            nb_instru = int(nb_instru)
                            if nb_instru < 1:
                                print ("Il doit au moins y avoir un instrument par partition.")

                        print("Il faut maintenant les noms de ces instruments. ")

                        while nb_instru >= 1:
                            instru = input("Veuillez saisir un instrument: ")

                            if not ExisteDeja(instru, sys.path[0] + "/types/" + choix[1] + ".txt"):
                                print ("l'instrument n'existe pass.")
                            else:
                                instruments.append(instru)
                                nb_instru -= 1

                        # Saisie de la date de création
                        print("Il nous faut maintenant la date de création de la partition")
                        date = input("Veuillez renseigner la date de création : ")

                        f.write("nom " + nom_fichier + " : " + choix_utilisateur + "\n")
                        f.write("auteur : " + auteur + '\n')
                        for instrument in instruments:
                            f.write("instrument : " + instrument + '\n')
                        f.write("date : " + date + '\n')
                        f.close()
                        if os.path.exists(sys.path[0] + "/types/" + nom_fichier + ".txt"):
                            f = open(sys.path[0] + "/types/" + nom_fichier + ".txt", 'w')
                        with open(sys.path[0] + "/types/" + nom_fichier + ".txt", 'a') as f:
                            if not ExisteDeja(choix_utilisateur, sys.path[0] + "/types/" + nom_fichier + ".txt"):
                                f.write(choix_utilisateur + " " + auteur)
                        # Retour au menu principal
                        lancement_application()
                else:
                    print(choix_utilisateur + " existe déjà dans " + tmp)
                    créer_qqch()

        elif validation[1] == valide:
            créer_qqch()


def modifier_qqch():
    choix = ['modifier', 'supprimer']  # les deux choix possibles
    while 1:
        # On demande a l'utilisateur de choisir un type de recherche
        # tant que la saisie n'est pas bonne
        # et si elle ne l'est pas alors on affiche un message d'erreur
        # et lorsque l'utilisateur a bien tapé un type de recherche on effectue la recherche de ce type

        # Affichage des différents choix possibles
        print("Souhaitez-vous " + choix[0] + " ou " + choix[1] + " ?")

        # Demande de saisie de la par de l'utilisateur
        choix_utilisateur = input("Rentrez votre choix : ")

        # Test de la saisie
        if choix_utilisateur == choix[0]:
            choix = ["compositeur", "instrument", "partition"]
            while 1:
                # On demande a l'utilisateur de choisir un type de recherche
                # tant que la saisie n'est pas bonne
                # et si elle ne l'est pas alors on affiche un message d'erreur

                # Affichage des différents choix possibles
                print("Souhaitez-vous modifier un " + choix[0] + ", un  " + choix[1] + " ou une " + choix[2] + " ?")

                # Demande de saisie de la par de l'utilisateur
                saisie = input("Rentrez votre choix : ")
                if saisie == choix[0]:
                    nom_fichier = choix[0]
                elif saisie == choix[1]:
                    nom_fichier = choix[0]
                elif saisie == choix[2]:
                    nom_fichier = choix[2]
                else:
                    print("Vous n'avez rien choisi de valide")  # On affiche un message d'erreur
                    continue  # et on recommance jusqu'a une saisie correcte

                if not os.path.exists(sys.path[0] + "/types/" + nom_fichier + ".txt"):
                    print("Aucun " + choix[0] + " n'existe. Il est donc impossible de les modifiers.")
                    editer_quelque_chose()
                else:
                    if saisie == choix[0] or saisie == choix[1]:
                        with open(sys.path[0] + "/types/" + nom_fichier + ".txt", 'r') as f:
                            text = f.read()
                            noms = text.split()
                            print("Parmis tous les " + nom_fichier + " lequel voulez-vous modifier ?  ")
                            for nom in noms:
                                print(nom)
                            while 1:
                                anciens = []
                                i = -1
                                # On demande a l'utilisateur de choisir un type de recherche
                                # tant que la saisie n'est pas bonne
                                # et si elle ne l'est pas alors on affiche un message d'erreur

                                nom_choisie = input("Rentrez votre choix : ")
                                for nom in noms:
                                    if nom_choisie == nom:
                                        del noms[noms.index(nom)]
                                nouveau_nom = input("Veuillez saisir le nouveau nom : ")
                                noms.append(nouveau_nom)
                                with open(sys.path[0] + "/types/" + nom_fichier + ".txt", 'w') as f:
                                    for newnoms in noms:
                                        f.write(newnoms + '\n')
                                with open(sys.path[0] + "/types/" + choix[2] + ".txt", 'r') as file:
                                    for nom in noms:
                                        text = file.read()
                                        données = text.split()
                                        for ancien in données:
                                            try:
                                                i += 1
                                                anciens.append(données[i])

                                                if ancien == nom_choisie:
                                                    tmp = données[i - 1]
                                                    del anciens[i]
                                                    del anciens[i - 1]
                                                    anciens.append(tmp)
                                                    anciens.append(" " + nouveau_nom)
                                            except IndexError:
                                                pass
                                    with open(sys.path[0] + "/types/" + choix[2] + ".txt", 'w') as f:
                                        i = 0
                                        for ancien in anciens:
                                            f.write(ancien + " ")
                                            valeur = i % 2
                                            if valeur == 0 and i > 1:
                                                f.write('\n')
                                                valeur = 0
                                            i += 1
                                        i = 0
                                        for ancien in anciens:
                                            if i % 2 == 0:
                                                if not os.path.exists(sys.path[0] + "/types/" + choix[
                                                    2] + " " + ancien + ".txt"):
                                                    try:
                                                        with open(sys.path[0] + "/types/" + choix[
                                                            2] + " " + ancien + ".txt", 'r+') as f:

                                                                text = f.read()
                                                                j = text.index(nom_choisie)
                                                                f.seek(0)
                                                                f.write(text[:j] + nouveau_nom + text[
                                                                                         j + len(nom_choisie):])
                                                    except ValueError and FileNotFoundError:
                                                        pass
                                        i += 1
                                lancement_application()
                    elif choix[2] == saisie:
                        with open(sys.path[0] + "/types/" + nom_fichier + ".txt", 'r') as f:
                            text = f.read()
                            noms = text.split()
                            print("Parmis tous les " + nom_fichier + " laquelle voulez-vous modifier ?  ")
                            i = 0
                            for nom in noms:
                                if i % 2 == 0:
                                    print(nom)
                                i += 1
                            while 1:
                                nouvelle_part = ""
                                # On demande a l'utilisateur de choisir un type de recherche
                                # tant que la saisie n'est pas bonne
                                # et si elle ne l'est pas alors on affiche un message d'erreur

                                partition_choisie = input("Rentrez votre choix : ")
                                for nom in noms:

                                    if partition_choisie == nom:
                                        nouvelle_part = input("Veuillez saisir le nouveau nom de la partition : ")

                                lines_remplacer = []
                                i = int(0)
                                with open(sys.path[0] + '/types/' + saisie + ".txt", 'r') as g:
                                    try:
                                        text = g.read()
                                        test = text.split()
                                        while len(test) > 0:

                                            if test[i] == partition_choisie:
                                                lines_remplacer.append(nouvelle_part)
                                                lines_remplacer.append(test[i + 1])

                                                del test[test[i]]
                                                del test[test[i + 1]]

                                            else:
                                                lines_remplacer.append(test[i])
                                                lines_remplacer.append(test[i + 1])
                                                del test[test[i]]
                                                del test[test[i + 1]]
                                            i += int(1)

                                    except IndexError and TypeError:
                                        pass


                                with open(sys.path[0] + '/types/' + saisie + ".txt", 'w') as f:
                                    i = 0
                                    for elt in lines_remplacer:
                                        f.write(elt + " ")
                                        if i % 2 == 0 and i > 1:
                                            f.write('\n')
                                        i += 1
                                    i = 0

                                if os.path.exists(sys.path[0] + '/types/' + nom_fichier + " " + nouvelle_part + ".txt"):
                                    with open(sys.path[0] + "/types/" + nom_fichier + " " + nouvelle_part + ".txt",
                                              'r+') as g:
                                        g.read()
                                else:
                                    with open(sys.path[0] + "/types/" + nom_fichier + " " + nouvelle_part + ".txt",
                                              'a') as g:
                                        with open(sys.path[
                                                      0] + "/types/" + nom_fichier + " " + partition_choisie + ".txt",
                                                  'r+') as f:
                                            try:
                                                text = f.read()
                                                j = text.index(partition_choisie)
                                                f.seek(0)
                                                g.write(text[:j] + nouvelle_part + text[j + len(partition_choisie):])
                                            except ValueError:
                                                pass
                                        os.remove(
                                            sys.path[0] + "/types/" + nom_fichier + " " + partition_choisie + ".txt")
                                break
                    lancement_application()

        elif choix_utilisateur == choix[1]:
            choix = ["compositeur", "instrument", "partition"]
            while 1:

                choix_utilisateur = input("Que voulez-vous supprimer ? Un " + choix[0] + ", un " + choix[1] + " ou une " + choix[2] + " : ")
                if choix_utilisateur == choix[0]:
                    nom_fichier = choix[0]
                    with open(sys.path[0] + "/types/" + nom_fichier + ".txt",'r') as f:
                        contenue = f.read()
                        données = contenue.split()
                        for elt in données:
                            print(elt)
                        valeur_a_supprimer = input("Parmis ces " + choix[0] + " lequel voulez-vous supprimer ? ")
                        while 1:
                            for elt in données:
                                if valeur_a_supprimer == elt:
                                    validation = input("voulez-vous vraiment supprimer :" + valeur_a_supprimer + " ? ")
                                    if validation == "oui":
                                        supprimer_qqch(sys.path[0] + "/types/" + nom_fichier + ".txt",valeur_a_supprimer,choix[0])
                                        lancement_application()
                    break
                elif choix_utilisateur == choix[1]:
                    nom_fichier = choix[1]
                    with open(sys.path[0] + "/types/" + nom_fichier + ".txt", 'r') as f:
                        contenue = f.read()
                        données = contenue.split()
                        for elt in données:
                            print(elt)
                        valeur_a_supprimer = input("Parmis ces " + choix[1] + " lequel voulez-vous supprimer ? ")
                        while 1:
                            for elt in données:
                                if valeur_a_supprimer == elt:
                                    validation = input("voulez-vous vraiment supprimer :" + valeur_a_supprimer + " ? ")
                                    if validation == "oui":
                                        supprimer_qqch(sys.path[0] + "/types/" + nom_fichier + ".txt",
                                                       valeur_a_supprimer, choix[1])
                                        lancement_application()
                    break
                elif choix_utilisateur == choix[2]:
                    nom_fichier = choix[2]
                    with open(sys.path[0] + "/types/" + nom_fichier + ".txt", 'r') as f:
                        i = int(0)
                        contenue = f.read()
                        données = contenue.split()
                        for elt in données:
                            if i % 2 == 0:
                                print(elt)
                            i+=1
                            i = int(i)
                        valeur_a_supprimer = input("Parmis ces " + choix[2] + " lequel voulez-vous supprimer ? ")
                        while 1:
                            for elt in données:
                                if valeur_a_supprimer == elt:
                                    validation = input("voulez-vous vraiment supprimer :" + valeur_a_supprimer + " ? ")
                                    if validation == "oui":
                                        supprimer_qqch(sys.path[0] + "/types/" + nom_fichier + ".txt",
                                                       valeur_a_supprimer, choix[2])
                                        lancement_application()

                else:
                    print("Saisie incorrecte. Veuillez ressayer")




        else:
            print("Vous n'avez rien choisi de valide")  # On affiche un message d'erreur
            continue  # et on recommance jusqu'a une saisie correcte


def supprimer_qqch(fichier,valeur_a_supprimer,type):
    choix = ["compositeur", "instrument", "partition"]
    if type == choix[0]:
        with open(fichier,'r') as f:

            lines = []
            valeurs_indésirables = []

            contenue = f.read()
            contenue_f = contenue.split()

            for elt in contenue_f:
                if elt != valeur_a_supprimer:
                    lines.append(elt)
                elif elt == valeur_a_supprimer:
                    valeurs_indésirables.append(elt)


            with open(fichier, 'w') as f:
                for elt in lines:
                    f.write(elt + '\n')
        test = []
        i = int(0)
        j = int(0)
        agarder = []

        with open(sys.path[0] + "/types/" + choix[2] + ".txt",'r+') as f:
             contenue = f.read()
             contenue_f = contenue.split()

             for elt in contenue_f:
                for elts in valeurs_indésirables:

                    if elts == elt:
                        test.append(contenue_f[i-1])
                        del agarder[j-1]
                    else:
                        agarder.append(contenue_f[i])
                        j+= 1
                        j = int(j)
                i += 1
                i = int(i)

        with open(sys.path[0] + "/types/" + choix[2] + ".txt",'w') as f:
            i = 0
            for elt in agarder:
                f.write(elt + " ")
                if i % 2 == 0 and i > 1:
                    f.write('\n')
                i+= 1
                i = int(i)

            for elt in test:
                if os.path.exists(sys.path[0] + "/types/" + choix[2] + " "+ elt+".txt"):
                    os.remove(sys.path[0] + "/types/" + choix[2] + " "+ elt+".txt")

    elif type == choix[1]:

        with open(fichier, 'r') as f:

            lines = []
            valeurs_indésirables = []

            contenue = f.read()
            contenue_f = contenue.split()

            for elt in contenue_f:
                if elt != valeur_a_supprimer:
                    lines.append(elt)
                elif elt == valeur_a_supprimer:
                    valeurs_indésirables.append(elt)

            with open(fichier, 'w') as f:
                for elt in lines:
                    f.write(elt + '\n')
        test = []
        i = int(0)
        asuppr = []

        with open(sys.path[0] + "/types/" + choix[2] + ".txt", 'r') as f:

            contenue = f.read()
            contenue_f = contenue.split()



            for elt in contenue_f:
                if i % 2 == 0:
                    test.append(elt)
            i += 1
            i = int(i)


        for elt in test:
            if os.path.exists(sys.path[0] + "/types/" + choix[2] + " " + elt + ".txt"):
                with open(sys.path[0] + "/types/" + choix[2] + " "+ elt+".txt",'r') as f:

                    f_str = f.read()
                    données = f_str.split()

                    for element in données:
                        if valeur_a_supprimer == element:

                            asuppr.append(elt)

        for elt in asuppr:
            if os.path.exists(sys.path[0] + "/types/" + choix[2] + " " + elt + ".txt"):
                os.remove(sys.path[0] + "/types/" + choix[2] + " " + elt + ".txt")
        with open(sys.path[0] + "/types/" + choix[2] + ".txt", 'r+') as f:
            contenue = f.read()
            contenue_f = contenue.split()

            for elt in contenue_f:
                if valeur_a_supprimer == elt:
                    if j != 0:
                        del agarder[j - 1]
                    break
                else:
                    agarder.append(contenue_f[i])
                    j += 1
                    j = int(j)
                i += 1
                i = int(i)

            for elt in contenue_f:
                agarder.append(elt)
            del agarder[j]
            del agarder[j + 1]

        with open(sys.path[0] + "/types/" + choix[2] + ".txt", 'w') as f:
            i = 0
            for elt in agarder:
                f.write(elt + " ")
                if i % 2 == 0 and i > 1:
                    f.write('\n')
                i += 1
                i = int(i)

    elif type == choix[2]:
        os.remove(sys.path[0] + "/types/" + choix[2] + " " + valeur_a_supprimer + ".txt")
        i = int(0)
        j = int(0)
        agarder = []

        with open(sys.path[0] + "/types/" + choix[2] + ".txt", 'r+') as f:
            contenue = f.read()
            contenue_f = contenue.split()

            for elt in contenue_f:
                if valeur_a_supprimer == elt:
                    if j != 0:
                        del agarder[j - 1]
                    break
                else:
                    agarder.append(contenue_f[i])
                    j += 1
                    j = int(j)
                i += 1
                i = int(i)

            for elt in contenue_f:
                agarder.append(elt)
            del agarder[j]
            del agarder[j+1]

        with open(sys.path[0] + "/types/" + choix[2] + ".txt", 'w') as f:
            i = 0
            for elt in agarder:
                f.write(elt + " ")
                if i % 2 == 0 and i > 1:
                    f.write('\n')
                i += 1
                i = int(i)


def editer_quelque_chose():
    choix = ['créer', 'modifier']  # les deux choix possibles

    while 1:
        # On demande a l'utilisateur de choisir un type de recherche
        # tant que la saisie n'est pas bonne
        # et si elle ne l'est pas alors on affiche un message d'erreur
        # et lorsque l'utilisateur a bien tapé un type de recherche on effectue la recherche de ce type

        # Affichage des différents choix possibles
        print("Souhaitez-vous " + choix[0] + " ou " + choix[1] + " ?")

        # Demande de saisie de la par de l'utilisateur
        choix_utilisateur = input("Rentrez votre choix : ")

        # Test de la saisie
        if choix_utilisateur == choix[0]:
            créer_qqch()
        elif choix_utilisateur == choix[1]:
            modifier_qqch()
        else:
            print("Vous n'avez rien choisi de valide")  # On affiche un message d'erreur
            continue  # et on recommance jusqu'a une saisie correcte


def ExisteDeja(nom, nom_fichier):
    if not os.path.exists(nom_fichier):
        print("fichier n'existe pas")
        return False

    else:
        with open(nom_fichier, 'r') as fichier:
            text = fichier.read()
            données = text.split()
            for ligne in données:
                print(ligne)
                if ligne == nom:
                    fichier.close()
                    return True
            fichier.close()
            return False


# Application et appelle des fonctions
print("Bonjour et bienvenue sur l'application !"
      "Que voulez-vous faire ?")  # message de bienvenue

lancement_application()



