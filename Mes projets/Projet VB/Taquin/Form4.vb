Public Class Form4
    Dim bool As Boolean
    Private Sub Form4_Load(sender As Object, e As EventArgs) Handles Me.Closed
        Form_debut.Show()
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles BT_parcourir.Click
        ' On affiche le formulaire et on teste si l'utilisateur a bien sélectionné un dossier.
        ' L'utilisateur aura donc cliqué sur le bouton OK.
        If FolderBrowserDialog1.ShowDialog() = Windows.Forms.DialogResult.OK Then
            ' Récupère le chemin complet du dossier sélectionné par l'utilisateur
            Dim dossier_selectionner As String = FolderBrowserDialog1.SelectedPath
            Form_debut.path = dossier_selectionner
            ' Affiche le nom du dossier (seulement) sélectionné, à l'utilisateur
            ' Petite subtilité, il faut utiliser la fonction "IO.Path.GetFileName" sur le chemin d'un dossier
            ' pour en récupérer le nom du dossier ciblé.
            ' Alors que "IO.Path.GetDirectoryName" vous aurait affiché le chemin du dossier CONTENANT le dossier
            ' ciblé par le chemin indiqué en paramètre
            MsgBox("Vous avez sélectionné le dossier : " & IO.Path.GetFileName(dossier_selectionner))

        Else
            ' Si l'utilisateur n'a pas sélectionné de dossier, on lui affiche un avertissement
            MsgBox("Aucun dossier n'a été sélectionné", MsgBoxStyle.Exclamation, "Aucun dossier sélectionné")
        End If
    End Sub

    Private Sub Form4_Load_1(sender As Object, e As EventArgs) Handles MyBase.Load
        If resolution = True Then
            CheckBox1.Checked = True
        Else
            CheckBox1.Checked = False
        End If

        FolderBrowserDialog1.SelectedPath = Application.StartupPath
        FolderBrowserDialog1.Description = "Veuillez sélectionner le dossier où vous souhaitez enregistrer les scores."
        FolderBrowserDialog1.ShowNewFolderButton = True
    End Sub

    Private Sub Button1_Click_1(sender As Object, e As EventArgs) Handles Button1.Click
        Me.Hide()
        Form_debut.Show()
    End Sub

    Private Sub CheckBox1_CheckedChanged(sender As Object, e As EventArgs) Handles CheckBox1.CheckedChanged
        If CheckBox1.Checked = True Then
            resolution = True
        Else
            resolution = False
        End If
    End Sub
End Class