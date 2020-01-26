Imports System.IO
Public Class Form_jeu


    Dim tps_s As Integer = 0
    Dim tps_m As Integer = 0
    Dim coups As Integer = 0
    Dim temps As Integer = 0
    Dim pers As Personne
    Dim gagnée As Boolean = False
    Dim rejoue As Boolean = False

    Function returnTemps() As Integer
        temps = tps_m * 60 + tps_s
        Return temps
    End Function

    Private Sub Form2_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        If resolution = True Then
            Button_résoudre.Visible = True
        Else
            Button_résoudre.Visible = False
        End If
        pers.nom = Form_debut.ComboBox1.Text

        Me.Label1.Text = "Joueur : " & Form_debut.ComboBox1.Text
        Me.Label3.Text = "Vous avez 5 minutes pour résoudre ce casse-tête"
        generateButtonNames()

        Button_back.Visible = False

        Timer1_Tick(sender, e)
        Timer1.Interval = 1000
        Timer1.Start()

        Timer2_Tick(sender, e)
        Timer2.Interval = 1
        Timer2.Start()
    End Sub

    Private Sub Button_abandonner_Click(sender As Object, e As EventArgs) Handles Button_abandonner.Click, Button_back.Click
        Timer1.Stop()
        Dim reponse = MsgBox("Voulez-vous vraiment revenir au menu principal " & Form_debut.ComboBox1.Text & " ?", vbYesNo, "Revenir au menu principal")
        If reponse = vbYes Then
            pers.tempsTotalJoue += returnTemps()
            Me.Close()
            Form_debut.Show()
        Else
            Timer1.Start()
        End If
    End Sub

    Private Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick

        If tps_m = 0 Then
            tps_s += 1
            Me.Label2.Text = "Temps : " & tps_s & " secondes"
            If tps_s = 60 Then
                tps_m += 1
                tps_s = 0
            End If
        ElseIf tps_m > 0 Then
            tps_s += 1
            If tps_m = 1 Then
                Me.Label2.Text = "Temps : " & tps_m & " minute " & tps_s & " secondes"
            Else
                Me.Label2.Text = "Temps : " & tps_m & " minutes " & tps_s & " secondes"
            End If
            If tps_s >= 60 Then
                tps_m += 1
                tps_s = 0
            End If
        ElseIf tps_m > 1 AndAlso tps_s >= 60 Then
            tps_s = 0
            tps_m += 1
        End If

        If tps_m = 5 Then

            Timer1.Stop()
            Panel1.Enabled = False
            gagnée = True
            masqueButton16(Button1)
            masqueButton16(Button2)
            masqueButton16(Button3)
            masqueButton16(Button4)
            masqueButton16(Button5)
            masqueButton16(Button6)
            masqueButton16(Button7)
            masqueButton16(Button8)
            masqueButton16(Button9)
            masqueButton16(Button10)
            masqueButton16(Button11)
            masqueButton16(Button12)
            masqueButton16(Button13)
            masqueButton16(Button14)
            masqueButton16(Button15)
            masqueButton16(Button16)

            Button_back.Visible = True
            Button_abandonner.Visible = False
            Button_résoudre.Visible = False
            Label3.Visible = True

            Label3.Text = "Dommage ! Vous avez pris trop de temps"

        End If
    End Sub
    Private Sub Timer2_Tick(sender As Object, e As EventArgs) Handles Timer2.Tick

        partiegagnée()
        bloquée()

        getcolor(Button1)
        masqueButton16(Button1)

        getcolor(Button2)
        masqueButton16(Button2)

        getcolor(Button3)
        masqueButton16(Button3)

        getcolor(Button4)
        masqueButton16(Button4)

        getcolor(Button5)
        masqueButton16(Button5)

        getcolor(Button6)
        masqueButton16(Button6)

        getcolor(Button7)
        masqueButton16(Button7)

        getcolor(Button8)
        masqueButton16(Button8)

        getcolor(Button9)
        masqueButton16(Button9)

        getcolor(Button10)
        masqueButton16(Button10)

        getcolor(Button11)
        masqueButton16(Button11)

        getcolor(Button12)
        masqueButton16(Button12)

        getcolor(Button13)
        masqueButton16(Button13)

        getcolor(Button14)
        masqueButton16(Button14)

        getcolor(Button15)
        masqueButton16(Button15)

        getcolor(Button16)
        masqueButton16(Button16)

    End Sub
    Sub bloquée()
        If Button1.Text = 1 And Button2.Text = 2 AndAlso Button3.Text = 3 And Button4.Text = 4 AndAlso Button5.Text = 5 AndAlso Button6.Text = 6 AndAlso Button7.Text = 7 AndAlso Button8.Text = 8 AndAlso Button9.Text = 9 AndAlso Button10.Text = 10 AndAlso Button11.Text = 12 AndAlso Button12.Text = 11 AndAlso Button13.Text = 13 AndAlso Button14.Text = 14 AndAlso Button15.Text = 15 And Button16.Text = 16 Then
            Button17.Visible = True
        Else
            Button17.Visible = False
        End If
    End Sub
    Sub generateButtonNames()

        Dim numéro As Integer
        Dim random As New Random()
        Dim compt As Integer = 1
        Dim test As Boolean
        Dim Ok As Integer = 16



        Dim tab2(16) As String

        Dim inc As Integer = 1

        While Not Ok < 1

            For indices As Integer = 1 To 16

                indices = inc
                numéro = random.Next(1, 17)

                If indices = 1 Then

                    test = True
                    Button1.Text = numéro
                    compt += 1
                    Exit For

                End If

                For j As Integer = 1 To indices - 1

                    If Not numéro = tab2(j) Then
                        test = True
                    Else
                        test = False
                        Exit For
                    End If

                Next
                If test = True Then
                    If compt = 2 Then
                        Button2.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 3 Then
                        Button3.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 4 Then
                        Button4.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 5 Then
                        Button5.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 6 Then
                        Button6.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 7 Then
                        Button7.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 8 Then
                        Button8.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 9 Then
                        Button9.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 10 Then
                        Button10.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 11 Then
                        Button11.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 12 Then
                        Button12.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 13 Then
                        Button13.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 14 Then
                        Button14.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 15 Then
                        Button15.Text = numéro
                        compt += 1
                        Exit For
                    End If
                    If compt = 16 Then
                        Button16.Text = numéro
                        Exit For
                    End If
                Else
                    If Not test Then
                        indices -= 1
                    End If

                End If
            Next indices
            If (test) Then
                inc += 1
                tab2(compt - 1) = numéro
                Ok -= 1
            End If

        End While

    End Sub

    Sub masqueButton16(ByRef button)
        If button.Text = 16 Then
            button.Visible = False
        End If

    End Sub

    Sub deplacer(ByRef button1 As Button, ByRef button2 As Button)
        If button2.Text = 16 Then
            button2.Text = button1.Text
            button1.Text = 16
            button2.Visible = True
            coups += 1
        End If
    End Sub

    Sub partiegagnée()

        If Button1.Text = 1 And Button2.Text = 2 AndAlso Button3.Text = 3 And Button4.Text = 4 AndAlso Button5.Text = 5 AndAlso Button6.Text = 6 AndAlso Button7.Text = 7 AndAlso Button8.Text = 8 AndAlso Button9.Text = 9 AndAlso Button10.Text = 10 AndAlso Button11.Text = 11 AndAlso Button12.Text = 12 AndAlso Button13.Text = 13 AndAlso Button14.Text = 14 AndAlso Button15.Text = 15 And Button16.Text = 16 Then
            Timer1.Stop()
            Panel1.Enabled = False
            gagnée = True
            masqueButton16(Button1)
            masqueButton16(Button2)
            masqueButton16(Button3)
            masqueButton16(Button4)
            masqueButton16(Button5)
            masqueButton16(Button6)
            masqueButton16(Button7)
            masqueButton16(Button8)
            masqueButton16(Button9)
            masqueButton16(Button10)
            masqueButton16(Button11)
            masqueButton16(Button12)
            masqueButton16(Button13)
            masqueButton16(Button14)
            masqueButton16(Button15)
            masqueButton16(Button16)

            Button_back.Visible = True
            Button_abandonner.Visible = False
            Button_résoudre.Visible = False

            If tps_m > 1 Then
                Label3.Visible = True
                Label3.Text = "Félicitation " & Form_debut.ComboBox1.Text & " ! Vous avez gagné en " & coups & " coups  et " & tps_m & " minutes " & tps_s & " secondes"
            Else
                Label3.Visible = True
                Label3.Text = "Félicitation " & Form_debut.ComboBox1.Text & " ! Vous avez gagné en " & coups & " coups et " & tps_m & " minute " & tps_s & " secondes"
            End If



        End If
    End Sub
    Sub getcolor(but As Button)
        If but.Text = 1 Then
            but.BackColor = Color.OrangeRed
        End If

        If but.Text = 2 Then
            but.BackColor = Color.Beige
        End If

        If but.Text = 3 Then
            but.BackColor = Color.BlueViolet
        End If

        If but.Text = 4 Then
            but.BackColor = Color.Olive
        End If

        If but.Text = 5 Then
            but.BackColor = Color.Navy
        End If

        If but.Text = 5 Then
            but.BackColor = Color.MintCream
        End If

        If but.Text = 6 Then
            but.BackColor = Color.MediumTurquoise
        End If

        If but.Text = 7 Then
            but.BackColor = Color.MediumSpringGreen
        End If

        If but.Text = 8 Then
            but.BackColor = Color.Linen
        End If

        If but.Text = 9 Then
            but.BackColor = Color.LightPink
        End If

        If but.Text = 10 Then
            but.BackColor = Color.Purple
        End If

        If but.Text = 11 Then
            but.BackColor = Color.ForestGreen
        End If

        If but.Text = 12 Then
            but.BackColor = Color.DarkSeaGreen
        End If

        If but.Text = 13 Then
            but.BackColor = Color.DarkRed
        End If

        If but.Text = 14 Then
            but.BackColor = Color.DarkGoldenrod
        End If

        If but.Text = 15 Then
            but.BackColor = Color.Crimson
        End If
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        If Button2.Text = 16 Then
            deplacer(Button1, Button2)
        End If
        If Button4.Text = 16 Then
            deplacer(Button1, Button4)
        End If
        If Button5.Text = 16 Then
            deplacer(Button1, Button5)
        End If
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        If Button1.Text = 16 Then
            deplacer(Button2, Button1)
        End If
        If Button3.Text = 16 Then
            deplacer(Button2, Button3)
        End If
        If Button6.Text = 16 Then
            deplacer(Button2, Button6)
        End If
    End Sub

    Private Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click
        If Button2.Text = 16 Then
            deplacer(Button3, Button2)
        End If
        If Button4.Text = 16 Then
            deplacer(Button3, Button4)
        End If
        If Button7.Text = 16 Then
            deplacer(Button3, Button7)
        End If
    End Sub

    Private Sub Button4_Click(sender As Object, e As EventArgs) Handles Button4.Click
        If Button1.Text = 16 Then
            deplacer(Button4, Button1)
        End If
        If Button8.Text = 16 Then
            deplacer(Button4, Button8)
        End If
        If Button3.Text = 16 Then
            deplacer(Button4, Button3)
        End If
    End Sub

    Private Sub Button5_Click(sender As Object, e As EventArgs) Handles Button5.Click
        If Button1.Text = 16 Then
            deplacer(Button5, Button1)
        End If
        If Button6.Text = 16 Then
            deplacer(Button5, Button6)
        End If
        If Button8.Text = 16 Then
            deplacer(Button5, Button8)
        End If
        If Button9.Text = 16 Then
            deplacer(Button5, Button9)
        End If
    End Sub

    Private Sub Button6_Click(sender As Object, e As EventArgs) Handles Button6.Click
        If Button2.Text = 16 Then
            deplacer(Button6, Button2)
        End If
        If Button7.Text = 16 Then
            deplacer(Button6, Button7)
        End If
        If Button5.Text = 16 Then
            deplacer(Button6, Button5)
        End If
        If Button10.Text = 16 Then
            deplacer(Button6, Button10)
        End If
    End Sub

    Private Sub Button7_Click(sender As Object, e As EventArgs) Handles Button7.Click
        If Button3.Text = 16 Then
            deplacer(Button7, Button3)
        End If
        If Button8.Text = 16 Then
            deplacer(Button7, Button8)
        End If
        If Button6.Text = 16 Then
            deplacer(Button7, Button6)
        End If
        If Button11.Text = 16 Then
            deplacer(Button7, Button11)
        End If
    End Sub

    Private Sub Button8_Click(sender As Object, e As EventArgs) Handles Button8.Click
        If Button4.Text = 16 Then
            deplacer(Button8, Button4)
        End If
        If Button7.Text = 16 Then
            deplacer(Button8, Button7)
        End If
        If Button5.Text = 16 Then
            deplacer(Button8, Button5)
        End If
        If Button12.Text = 16 Then
            deplacer(Button8, Button12)
        End If
    End Sub

    Private Sub Button9_Click(sender As Object, e As EventArgs) Handles Button9.Click
        If Button10.Text = 16 Then
            deplacer(Button9, Button10)
        End If
        If Button13.Text = 16 Then
            deplacer(Button9, Button13)
        End If
        If Button5.Text = 16 Then
            deplacer(Button9, Button5)
        End If
        If Button12.Text = 16 Then
            deplacer(Button9, Button12)
        End If
    End Sub

    Private Sub Button10_Click(sender As Object, e As EventArgs) Handles Button10.Click
        If Button6.Text = 16 Then
            deplacer(Button10, Button6)
        End If
        If Button14.Text = 16 Then
            deplacer(Button10, Button14)
        End If
        If Button9.Text = 16 Then
            deplacer(Button10, Button9)
        End If
        If Button11.Text = 16 Then
            deplacer(Button10, Button11)
        End If
    End Sub

    Private Sub Button11_Click(sender As Object, e As EventArgs) Handles Button11.Click
        If Button7.Text = 16 Then
            deplacer(Button11, Button7)
        End If
        If Button15.Text = 16 Then
            deplacer(Button11, Button15)
        End If
        If Button10.Text = 16 Then
            deplacer(Button11, Button10)
        End If
        If Button12.Text = 16 Then
            deplacer(Button11, Button12)
        End If
    End Sub

    Private Sub Button12_Click(sender As Object, e As EventArgs) Handles Button12.Click
        If Button8.Text = 16 Then
            deplacer(Button12, Button8)
        End If
        If Button16.Text = 16 Then
            deplacer(Button12, Button16)
        End If
        If Button11.Text = 16 Then
            deplacer(Button12, Button11)
        End If
        If Button9.Text = 16 Then
            deplacer(Button12, Button9)
        End If
    End Sub

    Private Sub Button13_Click(sender As Object, e As EventArgs) Handles Button13.Click
        If Button16.Text = 16 Then
            deplacer(Button13, Button16)
        End If
        If Button14.Text = 16 Then
            deplacer(Button13, Button14)
        End If
        If Button9.Text = 16 Then
            deplacer(Button13, Button9)
        End If
    End Sub

    Private Sub Button14_Click(sender As Object, e As EventArgs) Handles Button14.Click
        If Button15.Text = 16 Then
            deplacer(Button14, Button15)
        End If
        If Button10.Text = 16 Then
            deplacer(Button14, Button10)
        End If
        If Button13.Text = 16 Then
            deplacer(Button14, Button13)
        End If
    End Sub

    Private Sub Button15_Click(sender As Object, e As EventArgs) Handles Button15.Click
        If Button16.Text = 16 Then
            deplacer(Button15, Button16)
        End If
        If Button14.Text = 16 Then
            deplacer(Button15, Button14)
        End If
        If Button11.Text = 16 Then
            deplacer(Button15, Button11)
        End If
    End Sub

    Private Sub Button16_Click(sender As Object, e As EventArgs) Handles Button16.Click
        If Button15.Text = 16 Then
            deplacer(Button16, Button15)
        End If
        If Button13.Text = 16 Then
            deplacer(Button16, Button13)
        End If
        If Button12.Text = 16 Then
            deplacer(Button16, Button12)
        End If
    End Sub

    Private Sub Form_jeu_Closed(sender As Object, e As EventArgs) Handles Me.Closed

        If gagnée Then
            pers = ModuleFicherText.initPersStatsParFichier(Form_debut.ComboBox1.Text)
            pers.nbPartiesJouees += 1
            pers = ModuleFicherText.MeilleurTemps(pers.nom, returnTemps())
            pers.tempsTotalJoue += returnTemps()


        Else
            pers = ModuleFicherText.initPersStatsParFichier(Form_debut.ComboBox1.Text)
            pers.nbPartiesJouees += 1
            pers.tempsTotalJoue += returnTemps()
        End If

        ModuleFicherText.StatJoueur(pers)
        Form_debut.Show()

    End Sub
    Private Sub Button_résoudre_Click(sender As Object, e As EventArgs) Handles Button_résoudre.Click
        ' Ecrit les dimensions du taquin et l'enregiste dans un ficher.txt
        EnregistrerTaquin()
        ' créer un .bat qui va servir a lancer le programme de résoluttion du taquin
        File.Create(Form_debut.path & "resoudre\executeCMD.bat").Dispose()

        'Créer un flux d'entrée pour écrire dans le ficher bat créer au dessus
        ' puis on va écrire la ligne de commande pour lancer le .exe de résolution & obtenir un fichier de sortie
        ' et apres on ferme le flux d'entrée
        Dim writter As New StreamWriter(Form_debut.path & "resoudre\executeCMD.bat")
        writter.WriteLine(Application.StartupPath & "resoudre\Taquin.exe < " & Application.StartupPath & "resoudre\aResoudre.txt >" & Application.StartupPath & "resoudre\out.txt
exit")
        writter.Close()

        Dim proc As New System.Diagnostics.Process()
        'On va lancer le CMD en executant la commande dans le .bat
        proc.StartInfo.FileName = "cmd.exe"
        proc.StartInfo.Arguments = Shell(Form_debut.path & "resoudre\executeCMD.bat")
        proc.Start()
        proc.WaitForExit()
        proc.Close()

        'On va lire le fichier générer et si on lit NORD SUD EST OUEST on stock le text dans une liste
        'puis on effectue le mouvement par rapport au text
        Dim solution As New List(Of String)
        Dim lines() As String = File.ReadAllLines(Application.StartupPath & "resoudre\out.txt")

        For Each line In lines
            Select Case line
                Case "EST"
                    solution.Add("EST")
                Case "NORD"
                    solution.Add("NORD")
                Case "SUD"
                    solution.Add("SUD")
                Case "OUEST"
                    solution.Add("OUEST")
            End Select
        Next
        While solution.Count <> 0
            Select Case solution.First
                Case "EST"
                    buttonEST().PerformClick()
                    solution.Remove(solution.First)
                Case "NORD"
                    ButtonNord().PerformClick()
                    solution.Remove(solution.First)
                Case "SUD"
                    ButtonSUD().PerformClick()
                    solution.Remove(solution.First)
                Case "OUEST"
                    buttonOUEST().PerformClick()
                    solution.Remove(solution.First)
            End Select
        End While

        'supprime les fichiers une fois que le taquin a été résolu
        File.Delete(Form_debut.path & "resoudre\" & "executeCMD.bat")
        File.Delete(Form_debut.path & "resoudre\" & "aResoudre.txt")
        File.Delete(Form_debut.path & "resoudre\out.txt")
    End Sub
    Private Function trouverCaseVide() As Button
        Dim but As Button
        For Each but In Panel1.Controls
            If but.Text = 16 Then
                Return but
            End If
        Next
    End Function
    Private Function buttonEST() As Button
        Dim butVide As Button
        butVide = trouverCaseVide()
        If Button1.Text = butVide.Text Then
            Return Button2
        End If
        If Button2.Text = butVide.Text Then
            Return Button3
        End If
        If Button3.Text = butVide.Text Then
            Return Button4
        End If
        If Button4.Text = butVide.Text Then
            Return Button1
        End If
        If Button5.Text = butVide.Text Then
            Return Button6
        End If
        If Button6.Text = butVide.Text Then
            Return Button7
        End If
        If Button7.Text = butVide.Text Then
            Return Button8
        End If
        If Button8.Text = butVide.Text Then
            Return Button5
        End If
        If Button9.Text = butVide.Text Then
            Return Button10
        End If
        If Button10.Text = butVide.Text Then
            Return Button11
        End If
        If Button11.Text = butVide.Text Then
            Return Button12
        End If
        If Button12.Text = butVide.Text Then
            Return Button9
        End If
        If Button13.Text = butVide.Text Then
            Return Button14
        End If
        If Button14.Text = butVide.Text Then
            Return Button15
        End If
        If Button15.Text = butVide.Text Then
            Return Button16
        End If
        If Button16.Text = butVide.Text Then
            Return Button13
        Else
            Return trouverCaseVide()
        End If
    End Function
    Private Function buttonOUEST() As Button
        Dim butVide As Button
        butVide = trouverCaseVide()
        If Button1.Text = butVide.Text Then
            Return Button4
        End If
        If Button2.Text = butVide.Text Then
            Return Button1
        End If
        If Button3.Text = butVide.Text Then
            Return Button2
        End If
        If Button4.Text = butVide.Text Then
            Return Button3
        End If
        If Button5.Text = butVide.Text Then
            Return Button8
        End If
        If Button6.Text = butVide.Text Then
            Return Button5
        End If
        If Button7.Text = butVide.Text Then
            Return Button6
        End If
        If Button8.Text = butVide.Text Then
            Return Button7
        End If
        If Button9.Text = butVide.Text Then
            Return Button12
        End If
        If Button10.Text = butVide.Text Then
            Return Button9
        End If
        If Button11.Text = butVide.Text Then
            Return Button10
        End If
        If Button12.Text = butVide.Text Then
            Return Button11
        End If
        If Button13.Text = butVide.Text Then
            Return Button16
        End If
        If Button14.Text = butVide.Text Then
            Return Button13
        End If
        If Button15.Text = butVide.Text Then
            Return Button14
        End If
        If Button16.Text = butVide.Text Then
            Return Button15
        Else
            Return trouverCaseVide()
        End If
    End Function
    Private Function ButtonNord() As Button
        Dim butVide As Button
        butVide = trouverCaseVide()
        If butVide.Text = Button5.Text Then
            Return Button1
        End If
        If butVide.Text = Button6.Text Then
            Return Button2
        End If
        If butVide.Text = Button7.Text Then
            Return Button3
        End If
        If butVide.Text = Button8.Text Then
            Return Button4
        End If
        If butVide.Text = Button9.Text Then
            Return Button5
        End If
        If butVide.Text = Button10.Text Then
            Return Button6
        End If
        If butVide.Text = Button11.Text Then
            Return Button7
        End If
        If butVide.Text = Button12.Text Then
            Return Button8
        End If
        If butVide.Text = Button13.Text Then
            Return Button9
        End If
        If butVide.Text = Button14.Text Then
            Return Button10
        End If
        If butVide.Text = Button15.Text Then
            Return Button11
        End If
        If butVide.Text = Button16.Text Then
            Return Button12
        Else
            Return butVide
        End If

    End Function
    Private Function ButtonSUD() As Button
        Dim butVide As Button
        butVide = trouverCaseVide()
        If butVide.Text = Button1.Text Then
            Return Button5
        End If
        If butVide.Text = Button2.Text Then
            Return Button6
        End If
        If butVide.Text = Button3.Text Then
            Return Button7
        End If
        If butVide.Text = Button4.Text Then
            Return Button8
        End If
        If butVide.Text = Button5.Text Then
            Return Button9
        End If
        If butVide.Text = Button6.Text Then
            Return Button10
        End If
        If butVide.Text = Button7.Text Then
            Return Button11
        End If
        If butVide.Text = Button8.Text Then
            Return Button12
        End If
        If butVide.Text = Button9.Text Then
            Return Button13
        End If
        If butVide.Text = Button10.Text Then
            Return Button14
        End If
        If butVide.Text = Button11.Text Then
            Return Button15
        End If
        If butVide.Text = Button12.Text Then
            Return Button16
        Else
            Return butVide
        End If

    End Function
    Private Sub EnregistrerTaquin()
        Dim Taquin() As String = {Button1.Text, Button2.Text, Button3.Text, Button4.Text, Button5.Text,
            Button6.Text, Button7.Text, Button8.Text, Button9.Text, Button10.Text, Button11.Text,
            Button12.Text, Button13.Text, Button14.Text, Button15.Text, Button16.Text}

        If Not Directory.Exists(Form_debut.path & "resoudre\") Then
            Directory.CreateDirectory(Form_debut.path & "resoudre\")
        End If
        If Not File.Exists(Form_debut.path & "resoudre\" & "aResoudre.txt") Then
            File.CreateText(Form_debut.path & "resoudre\" & "aResoudre.txt").Dispose()
        End If

        Dim writter As New StreamWriter(Form_debut.path & "resoudre\" & "aResoudre.txt")
        writter.WriteLine("4 4")

        Dim retourALaLigne As Integer = 0
        For i As Integer = 0 To Taquin.Length - 1
            retourALaLigne += 1
            If Taquin(i) = 16 Then
                writter.Write("# ")
            Else
                writter.Write(Taquin(i) + " ")
            End If

            If retourALaLigne Mod 4 = 0 Then
                writter.WriteLine()
            End If

        Next
        writter.Close()


    End Sub
    Private Sub Button17_Click(sender As Object, e As EventArgs) Handles Button17.Click

        Dim butTmp As New Button()

        butTmp.Text = Button11.Text
        Button11.Text = Button12.Text
        Button12.Text = butTmp.Text


    End Sub
End Class