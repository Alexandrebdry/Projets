Imports System.IO
Public Class Form_debut

    Public path As String = Application.StartupPath
    Private Sub Button_quitter_Click(sender As Object, e As EventArgs) Handles Button_quitter.Click
        Dim reponse = MsgBox("Voulez-vous vraiment arrêter ?", MsgBoxStyle.YesNo + MsgBoxStyle.DefaultButton2, "fenetre d'arret")
        If reponse = vbYes Then
            Me.Close()
        End If
    End Sub

    Private Sub Bouton_ajout_Click(sender As Object, e As EventArgs) Handles bouton_ajout.Click

        Dim pers As Personne
        pers.nom = Me.TextBox1.Text
        pers.meilleurTemps = 0

        compare(pers)

        TextBox1.Text = ""

    End Sub

    Sub nom_keypress(sender As Object, e As System.Windows.Forms.KeyPressEventArgs) Handles TextBox1.KeyPress
        If e.KeyChar = vbBack Then Exit Sub
        If Char.IsPunctuation(e.KeyChar) Or Char.IsSymbol(e.KeyChar) Then
            e.Handled = True ' emp^eche l'evenement de se propager
        End If
    End Sub

    Private Sub Button_jouer_Click(sender As Object, e As EventArgs) Handles Button_jouer.Click

        If ComboBox1.Text = "" Then
            MsgBox("Vous n'avez pas choisi de joueur")
        Else

            Me.Hide()
            Form_jeu.Show()
        End If

    End Sub

    Private Sub Button_Score_Click(sender As Object, e As EventArgs) Handles Button_Score.Click
        Me.Hide()
        Form3.Show()
    End Sub


    Private Sub Form_debut_Closed(sender As Object, e As EventArgs) Handles Me.Closed
        End
    End Sub

    Private Sub Button_option_Click(sender As Object, e As EventArgs) Handles Button_option.Click
        Me.Hide()
        Form4.Show()
    End Sub
End Class
