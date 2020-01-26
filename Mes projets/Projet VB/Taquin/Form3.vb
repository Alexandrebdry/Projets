Public Class Form3
    Dim triée As Boolean
    Private Sub Form3_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        triée = False
        For i = 0 To Form_debut.ComboBox1.Items.Count - 1

            Dim pers As Personne
            ListBox1.Items.Add(Form_debut.ComboBox1.Items(i))
            pers.nom = ListBox1.Items.Item(i)

            pers = ModuleFicherText.initPersStatsParFichier(pers.nom)
            ModuleFicherText.StatJoueur(pers)
            If pers.meilleurTemps = 0 Then
                ListBox2.Items.Add("null")
            Else
                ListBox2.Items.Add(pers.meilleurTemps)
            End If
            ComboBox1.Items.Add(pers.nom)
        Next
    End Sub

    Private Sub ListBox1_SelectedIndexChanged(sender As Object, e As EventArgs) Handles ListBox1.SelectedIndexChanged, ListBox2.SelectedIndexChanged

        Dim position = sender.selectedindex

        ListBox1.SelectedIndex = position
        ListBox2.SelectedIndex = position


        Dim top = sender.topindex

        ListBox1.TopIndex = top
        ListBox2.TopIndex = top


        ComboBox1.Text = ListBox1.SelectedItem
    End Sub

    Private Sub Form3_Closed(sender As Object, e As EventArgs) Handles Me.Closed
        Form_debut.Show()
    End Sub

    Private Sub Bouton_stats_Click(sender As Object, e As EventArgs) Handles Bouton_stats.Click
        Dim pers As Personne
        pers = ModuleFicherText.initPersStatsParFichier(ComboBox1.Text)
        If pers.meilleurTemps = 0 Then
            MsgBox(" joueur : " & pers.nom & "
            Nomdre de parties jouées : " & pers.nbPartiesJouees & "
            Meilleur temps :  null " & "
            Temps total : " & pers.tempsTotalJoue)
        Else
            MsgBox(" joueur : " & pers.nom & "
            Nomdre de parties jouées : " & pers.nbPartiesJouees & "
            Meilleur temps : " & pers.meilleurTemps & " secondes" & "
            Temps total : " & pers.tempsTotalJoue)
        End If

    End Sub

    Private Sub Bouton_trie_tps_Click(sender As Object, e As EventArgs) Handles Bouton_trie_tps.Click

        If triée Then
            MsgBox("Les joueurs sont déjà triés par temps.")
        Else
            ListBox1.Sorted = False
            Dim tabTps As List(Of Integer)
            Dim perso As Personne

            tabTps = remplirTabTps()

            For i = 0 To tabTps.Count - 1

                If tabTps.ElementAt(i) = 0 Then
                    ListBox2.Items.Add("null")
                Else
                    ListBox2.Items.Add(tabTps.ElementAt(i))
                 End If
        Next
            ListBox1.Items.Clear()

            While ListBox1.Items.Count <> ListBox2.Items.Count

                Dim i As Integer

                For i = 0 To ListBox2.Items.Count - 1

                    perso = ModuleFicherText.initPersStatsParFichier(ComboBox1.Items(i))

                    For j = 0 To ListBox2.Items.Count - 1

                        If perso.meilleurTemps = tabTps.ElementAt(0) Then

                            ListBox1.Items.Add(perso.nom)
                            tabTps.Remove(tabTps.ElementAt(0))
                            If tabTps.Count = 0 Then
                                Exit While
                            End If
                            Exit For
                        End If

                    Next
                Next
                i = 0

            End While
            triée = True
        End If


    End Sub
    Private Function Tri(ByRef tab As List(Of Integer)) As List(Of Integer)

        Dim trié As New List(Of Integer)
        Dim zero As New List(Of Integer)
        While tab.Count - 1 <> 0

            For i = 0 To tab.Count - 1
                For j = 0 To tab.Count - 2
                    If tab.ElementAt(i) < tab.ElementAt(j) Then

                        If tab.ElementAt(i) = 0 Then
                            zero.Add(tab.ElementAt(i))
                            tab.Remove(tab.ElementAt(i))
                        Else
                            trié.Add(tab.ElementAt(i))
                            tab.Remove(tab.ElementAt(i))
                        End If

                        i = 0
                        If tab.Count = 1 Then
                            trié.Add(tab.ElementAt(i))
                            tab.Remove(tab.ElementAt(i))
                            Exit While
                        End If
                    End If
                Next
            Next
        End While
        For zeros As Integer = 0 To zero.Count - 1
            trié.Add(zero.ElementAt(zeros))
        Next
        Return trié
    End Function

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        If triée Then
            ListBox1.Sorted() = True
            triée = False

            Dim tabTps As List(Of Integer)
            Dim perso As Personne

            tabTps = remplirTabTps()

            While ListBox1.Items.Count <> ListBox2.Items.Count

                Dim i As Integer

                For i = 0 To ListBox1.Items.Count - 1

                    perso = ModuleFicherText.initPersStatsParFichier(ComboBox1.Items(i))

                    For j = 0 To ListBox1.Items.Count - 1

                        If perso.nom = ListBox1.Items.Item(i) Then
                            If tabTps.Count = 0 Then
                                Exit While
                            End If
                            If perso.meilleurTemps = 0 Then
                                ListBox2.Items.Add("null")
                            Else

                                ListBox2.Items.Add(perso.meilleurTemps)
                                tabTps.Remove(tabTps.ElementAt(0))
                            End If
                            Exit For

                        End If

                    Next
                Next
                i = 0

            End While

        Else
            MsgBox("Les joueurs sont déjà triés par noms.")
        End If


    End Sub

    Private Function remplirTabTps() As List(Of Integer)

        Dim tabTps As New List(Of Integer)
        ListBox2.Items.Clear()
        Dim perso As Personne

        For i = 0 To ComboBox1.Items.Count - 1
            perso = ModuleFicherText.initPersStatsParFichier(ListBox1.Items.Item(i))
            tabTps.Add(perso.meilleurTemps)
        Next

        tabTps = Tri(tabTps)

        Return tabTps
    End Function

End Class