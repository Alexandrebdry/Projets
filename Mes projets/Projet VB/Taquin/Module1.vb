Imports System.IO
Module Module1

    Structure Personne

        Dim nom As String
        Dim meilleurTemps As Double
        Dim nbPartiesJouees As Integer
        Dim tempsTotalJoue As Double

    End Structure

    Public resolution As Boolean = True

    Public indice As Integer = 0
    Sub ajout(ByRef personne As Personne)

        If ModuleFicherText.JoueurDansLeFichier(personne.nom) = False Then
            Form_debut.ComboBox1.Items.Add(Form_debut.TextBox1.Text)
            ModuleFicherText.insertJoueur(personne.nom)
        End If

    End Sub

    Public Sub compare(ByRef pers As Personne)

        If Form_debut.TextBox1.Text = String.Empty Then
            MsgBox("Vous n'avez rien saisi")
        Else
            If indice = 0 AndAlso JoueurDansLeFichier(pers.nom) = False Then
                MsgBox("Le joueur " & pers.nom & " a été ajouté")
                ajout(pers)

            ElseIf indice > 0 Then

                For i As Integer = 0 To indice
                    If JoueurDansLeFichier(pers.nom) = True Then
                        MsgBox("Le joueur " & pers.nom & " existe déjà.")
                        Exit For
                    Else
                        ajout(pers)
                        MsgBox("Le joueur " & pers.nom & " a été ajouté")


                        Exit For
                    End If
                Next

            End If
        End If

    End Sub

    Sub Main()

        ModuleFicherText.LireJoueurs()

        For i = 0 To Form_debut.ComboBox1.Items.Count - 1
            Dim pers As Personne
            pers = initPersStatsParFichier(Form_debut.ComboBox1.Items.Item(i))
            ajout(pers)
        Next

        Application.Run(Form_debut)

    End Sub

End Module
