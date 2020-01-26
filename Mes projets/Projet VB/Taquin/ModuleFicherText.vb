Imports System.IO
Module ModuleFicherText

    Public Sub insertJoueur(nom As String)

        If Not File.Exists(Form_debut.path & "joueurs.txt") Then
            File.CreateText(Form_debut.path & "joueurs.txt").Dispose()
        End If
        If Not JoueurDansLeFichier(nom) Then

            Dim fil As New StreamWriter(Form_debut.path & "joueurs.txt", True)
            fil.WriteLine(nom)
            fil.Close()

        End If





    End Sub

    Public Sub StatJoueur(pers As Personne)

        If Not Directory.Exists(Form_debut.path & "stat\") Then
            Directory.CreateDirectory(Form_debut.path & "stat\")
        End If

        If Not File.Exists(Form_debut.path & "stat\" & pers.nom & ".txt") Then

            Dim files As New StreamWriter(Form_debut.path & "stat\" & pers.nom & ".txt", True)
            files.WriteLine("Stats du joueur : " & pers.nom)
            files.WriteLine("   Nombre de parties jouées : " & pers.nbPartiesJouees)
            If pers.meilleurTemps = 0 Then
                files.WriteLine("   Meilleur temps : null")
            Else
                files.WriteLine("   Meilleur temps : " & pers.meilleurTemps)
            End If
            files.WriteLine("   Temps total joué : " & pers.tempsTotalJoue)
            files.Close()

        Else
            Dim lines() As String = File.ReadAllLines(Form_debut.path & "stat\" & pers.nom & ".txt")
            Dim write As New StreamWriter(Form_debut.path & "stat\" & pers.nom & ".txt")

            For Each line As String In lines
                If line.Contains("Stats du joueur : " & pers.nom) Then
                    write.WriteLine("Stats du joueur : " & pers.nom)
                End If
                If line.Contains("Nombre de parties jouées :") Then
                    write.WriteLine("  Nombre de parties jouées : " & pers.nbPartiesJouees)
                End If
                If line.Contains("Meilleur temps") Then
                    If pers.meilleurTemps = 0 Then
                        write.WriteLine("   Meilleur temps : null")
                    Else
                        write.WriteLine("  Meilleur temps : " & pers.meilleurTemps)
                    End If

                End If
                If line.Contains("Temps total joué ") Then
                    write.WriteLine("  Temps total joué : " & pers.tempsTotalJoue)
                End If

            Next
            write.Close()

        End If
    End Sub

    Public Sub LireJoueurs()
        If File.Exists(Form_debut.path & "joueurs.txt") Then
            Dim fil As New StreamReader(Form_debut.path & "joueurs.txt")

            While fil.Peek > 0
                Form_debut.ComboBox1.Items.Add(fil.ReadLine.Split(" ")(0))

            End While
            fil.Close()

        End If

    End Sub

    Public Function JoueurDansLeFichier(nom As String) As Boolean
        If File.Exists(Form_debut.path & "joueurs.txt") Then

            Dim file As New StreamReader(Form_debut.path & "joueurs.txt")
            Dim Joueur As String
            While file.Peek >= 0
                Joueur = file.ReadLine.Split(" ")(0)
                If Joueur = nom Then
                    file.Close()
                    Return True
                End If
            End While
            file.Close()
            Return False

        End If

        Return False

    End Function

    Public Function initPersStatsParFichier(nom As String) As Personne

        Dim pers As Personne
        pers.nom = nom

        If Not File.Exists(Form_debut.path & "stat\" & pers.nom & ".txt") Then
            pers.nom = nom
            pers.meilleurTemps = 0
            pers.nbPartiesJouees = 0
            pers.tempsTotalJoue = 0

        Else
            Dim lines() As String = File.ReadAllLines(Form_debut.path & "stat\" & pers.nom & ".txt")
            For Each line As String In lines
                line.Split(":")
                If line.Contains("Stats du joueur : ") Then
                    pers.nom = line.Split.Last
                End If
                If line.Contains("Nombre de parties jouées :") Then
                    pers.nbPartiesJouees = Integer.Parse(line.Split.Last)
                End If
                If line.Contains("Meilleur temps") Then
                    If line.Split.Last = "null" Then
                        pers.meilleurTemps = 0
                    Else
                        pers.meilleurTemps = Integer.Parse(line.Split.Last)
                    End If
                End If
                If line.Contains("Temps total joué ") Then
                    pers.tempsTotalJoue = Integer.Parse(line.Split.Last)
                End If

            Next

        End If

        Return pers

    End Function

    Public Function MeilleurTemps(nom As String, temps As Integer) As Personne
        Dim pers As Personne
        pers = initPersStatsParFichier(nom)

        If pers.meilleurTemps = 0 Then
            pers.meilleurTemps = temps
        Else
            If temps < pers.meilleurTemps Then
                pers.meilleurTemps = temps
            End If

        End If

        Return pers
    End Function
End Module
