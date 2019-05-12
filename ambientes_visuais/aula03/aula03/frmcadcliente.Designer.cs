namespace aula03
{
    partial class frmcadcliente
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmcadcliente));
            this.pcticone = new System.Windows.Forms.PictureBox();
            this.lbltitulo = new System.Windows.Forms.Label();
            this.grpdados = new System.Windows.Forms.GroupBox();
            this.cmbsexo = new System.Windows.Forms.ComboBox();
            this.lblsexo = new System.Windows.Forms.Label();
            this.txtnome = new System.Windows.Forms.TextBox();
            this.lblnome = new System.Windows.Forms.Label();
            this.btngravar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pcticone)).BeginInit();
            this.grpdados.SuspendLayout();
            this.SuspendLayout();
            // 
            // pcticone
            // 
            this.pcticone.Image = ((System.Drawing.Image)(resources.GetObject("pcticone.Image")));
            this.pcticone.Location = new System.Drawing.Point(30, 30);
            this.pcticone.Name = "pcticone";
            this.pcticone.Size = new System.Drawing.Size(96, 106);
            this.pcticone.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pcticone.TabIndex = 0;
            this.pcticone.TabStop = false;
            // 
            // lbltitulo
            // 
            this.lbltitulo.AutoSize = true;
            this.lbltitulo.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbltitulo.Location = new System.Drawing.Point(132, 110);
            this.lbltitulo.Name = "lbltitulo";
            this.lbltitulo.Size = new System.Drawing.Size(137, 26);
            this.lbltitulo.TabIndex = 1;
            this.lbltitulo.Text = "Novo Cliente";
            // 
            // grpdados
            // 
            this.grpdados.Controls.Add(this.cmbsexo);
            this.grpdados.Controls.Add(this.lblsexo);
            this.grpdados.Controls.Add(this.txtnome);
            this.grpdados.Controls.Add(this.lblnome);
            this.grpdados.Location = new System.Drawing.Point(35, 167);
            this.grpdados.Name = "grpdados";
            this.grpdados.Size = new System.Drawing.Size(485, 123);
            this.grpdados.TabIndex = 2;
            this.grpdados.TabStop = false;
            this.grpdados.Text = "Dados Básicos";
            // 
            // cmbsexo
            // 
            this.cmbsexo.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbsexo.FormattingEnabled = true;
            this.cmbsexo.Location = new System.Drawing.Point(79, 73);
            this.cmbsexo.Name = "cmbsexo";
            this.cmbsexo.Size = new System.Drawing.Size(196, 21);
            this.cmbsexo.TabIndex = 3;
            // 
            // lblsexo
            // 
            this.lblsexo.AutoSize = true;
            this.lblsexo.Location = new System.Drawing.Point(38, 76);
            this.lblsexo.Name = "lblsexo";
            this.lblsexo.Size = new System.Drawing.Size(31, 13);
            this.lblsexo.TabIndex = 2;
            this.lblsexo.Text = "Sexo";
            // 
            // txtnome
            // 
            this.txtnome.Location = new System.Drawing.Point(79, 35);
            this.txtnome.Name = "txtnome";
            this.txtnome.Size = new System.Drawing.Size(252, 20);
            this.txtnome.TabIndex = 1;
            // 
            // lblnome
            // 
            this.lblnome.AutoSize = true;
            this.lblnome.Location = new System.Drawing.Point(38, 38);
            this.lblnome.Name = "lblnome";
            this.lblnome.Size = new System.Drawing.Size(35, 13);
            this.lblnome.TabIndex = 0;
            this.lblnome.Text = "Nome";
            // 
            // btngravar
            // 
            this.btngravar.Location = new System.Drawing.Point(399, 331);
            this.btngravar.Name = "btngravar";
            this.btngravar.Size = new System.Drawing.Size(120, 35);
            this.btngravar.TabIndex = 3;
            this.btngravar.Text = "Gravar";
            this.btngravar.UseVisualStyleBackColor = true;
            // 
            // frmcadcliente
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(560, 402);
            this.Controls.Add(this.btngravar);
            this.Controls.Add(this.grpdados);
            this.Controls.Add(this.lbltitulo);
            this.Controls.Add(this.pcticone);
            this.Name = "frmcadcliente";
            this.Text = "Cadastro de Novo Cliente";
            this.Load += new System.EventHandler(this.frmcadcliente_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pcticone)).EndInit();
            this.grpdados.ResumeLayout(false);
            this.grpdados.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pcticone;
        private System.Windows.Forms.Label lbltitulo;
        private System.Windows.Forms.GroupBox grpdados;
        private System.Windows.Forms.TextBox txtnome;
        private System.Windows.Forms.Label lblnome;
        private System.Windows.Forms.ComboBox cmbsexo;
        private System.Windows.Forms.Label lblsexo;
        private System.Windows.Forms.Button btngravar;
    }
}