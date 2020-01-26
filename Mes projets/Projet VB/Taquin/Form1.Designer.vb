<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class Form_debut
    Inherits System.Windows.Forms.Form

    'Form remplace la méthode Dispose pour nettoyer la liste des composants.
    <System.Diagnostics.DebuggerNonUserCode()>
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Requise par le Concepteur Windows Form
    Private components As System.ComponentModel.IContainer

    'REMARQUE : la procédure suivante est requise par le Concepteur Windows Form
    'Elle peut être modifiée à l'aide du Concepteur Windows Form.  
    'Ne la modifiez pas à l'aide de l'éditeur de code.
    <System.Diagnostics.DebuggerStepThrough()>
    Private Sub InitializeComponent()
        Me.ComboBox1 = New System.Windows.Forms.ComboBox()
        Me.TextBox1 = New System.Windows.Forms.TextBox()
        Me.bouton_ajout = New System.Windows.Forms.Button()
        Me.Button_jouer = New System.Windows.Forms.Button()
        Me.Button_quitter = New System.Windows.Forms.Button()
        Me.Button_Score = New System.Windows.Forms.Button()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Panel1 = New System.Windows.Forms.Panel()
        Me.Button_option = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'ComboBox1
        '
        Me.ComboBox1.BackColor = System.Drawing.Color.Purple
        Me.ComboBox1.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.ComboBox1.ForeColor = System.Drawing.Color.White
        Me.ComboBox1.FormattingEnabled = True
        Me.ComboBox1.Location = New System.Drawing.Point(396, 281)
        Me.ComboBox1.Name = "ComboBox1"
        Me.ComboBox1.Size = New System.Drawing.Size(377, 21)
        Me.ComboBox1.Sorted = True
        Me.ComboBox1.TabIndex = 0
        '
        'TextBox1
        '
        Me.TextBox1.Location = New System.Drawing.Point(542, 252)
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.Size = New System.Drawing.Size(155, 20)
        Me.TextBox1.TabIndex = 1
        '
        'bouton_ajout
        '
        Me.bouton_ajout.Location = New System.Drawing.Point(703, 252)
        Me.bouton_ajout.Name = "bouton_ajout"
        Me.bouton_ajout.Size = New System.Drawing.Size(70, 23)
        Me.bouton_ajout.TabIndex = 2
        Me.bouton_ajout.Text = "ajouter"
        Me.bouton_ajout.UseVisualStyleBackColor = True
        '
        'Button_jouer
        '
        Me.Button_jouer.Location = New System.Drawing.Point(34, 367)
        Me.Button_jouer.Name = "Button_jouer"
        Me.Button_jouer.Size = New System.Drawing.Size(211, 56)
        Me.Button_jouer.TabIndex = 3
        Me.Button_jouer.Text = "jouer"
        Me.Button_jouer.TextImageRelation = System.Windows.Forms.TextImageRelation.TextAboveImage
        Me.Button_jouer.UseVisualStyleBackColor = True
        '
        'Button_quitter
        '
        Me.Button_quitter.Location = New System.Drawing.Point(949, 400)
        Me.Button_quitter.Name = "Button_quitter"
        Me.Button_quitter.Size = New System.Drawing.Size(176, 23)
        Me.Button_quitter.TabIndex = 4
        Me.Button_quitter.Text = "quitter"
        Me.Button_quitter.UseVisualStyleBackColor = True
        '
        'Button_Score
        '
        Me.Button_Score.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None
        Me.Button_Score.Location = New System.Drawing.Point(949, 367)
        Me.Button_Score.Name = "Button_Score"
        Me.Button_Score.Size = New System.Drawing.Size(176, 23)
        Me.Button_Score.TabIndex = 5
        Me.Button_Score.Text = "Score"
        Me.Button_Score.UseVisualStyleBackColor = True
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.BackColor = System.Drawing.Color.Transparent
        Me.Label1.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Label1.ForeColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(224, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.Label1.ImageAlign = System.Drawing.ContentAlignment.MiddleRight
        Me.Label1.Location = New System.Drawing.Point(412, 255)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(115, 13)
        Me.Label1.TabIndex = 6
        Me.Label1.Text = "Saisissez votre pseudo"
        '
        'Panel1
        '
        Me.Panel1.BackColor = System.Drawing.Color.Transparent
        Me.Panel1.BackgroundImage = Global.Taquin.My.Resources.Resources._8107cskBQ3L__AC_US218_
        Me.Panel1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom
        Me.Panel1.Location = New System.Drawing.Point(34, 12)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(211, 209)
        Me.Panel1.TabIndex = 7
        '
        'Button_option
        '
        Me.Button_option.Location = New System.Drawing.Point(949, 316)
        Me.Button_option.Name = "Button_option"
        Me.Button_option.Size = New System.Drawing.Size(175, 41)
        Me.Button_option.TabIndex = 8
        Me.Button_option.Text = "Options"
        Me.Button_option.UseVisualStyleBackColor = True
        '
        'Form_debut
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackgroundImage = Global.Taquin.My.Resources.Resources._129752
        Me.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.ClientSize = New System.Drawing.Size(1155, 457)
        Me.Controls.Add(Me.Button_option)
        Me.Controls.Add(Me.Panel1)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.Button_Score)
        Me.Controls.Add(Me.Button_quitter)
        Me.Controls.Add(Me.Button_jouer)
        Me.Controls.Add(Me.bouton_ajout)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.ComboBox1)
        Me.Name = "Form_debut"
        Me.Text = "Form_debut"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents ComboBox1 As ComboBox
    Friend WithEvents TextBox1 As TextBox
    Friend WithEvents bouton_ajout As Button
    Friend WithEvents Button_jouer As Button
    Friend WithEvents Button_quitter As Button
    Friend WithEvents Button_Score As Button
    Friend WithEvents Label1 As Label
    Friend WithEvents Panel1 As Panel
    Friend WithEvents Button_option As Button
End Class
