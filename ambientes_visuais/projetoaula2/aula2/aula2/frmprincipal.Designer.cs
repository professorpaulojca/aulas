namespace aula2
{
    partial class frmprincipal
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
            this.lbltitulo = new System.Windows.Forms.Label();
            this.lblnome = new System.Windows.Forms.Label();
            this.txtnome = new System.Windows.Forms.TextBox();
            this.grpbempresario = new System.Windows.Forms.GroupBox();
            this.rbnao = new System.Windows.Forms.RadioButton();
            this.rbsim = new System.Windows.Forms.RadioButton();
            this.pnlcnpj = new System.Windows.Forms.Panel();
            this.txtcnpj = new System.Windows.Forms.TextBox();
            this.lblcnpj = new System.Windows.Forms.Label();
            this.grpbpossui = new System.Windows.Forms.GroupBox();
            this.btngravar = new System.Windows.Forms.Button();
            this.chk3 = new System.Windows.Forms.CheckBox();
            this.chk2 = new System.Windows.Forms.CheckBox();
            this.chk1 = new System.Windows.Forms.CheckBox();
            this.txtdatanasc = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.pctdatanasc = new System.Windows.Forms.PictureBox();
            this.grpbempresario.SuspendLayout();
            this.pnlcnpj.SuspendLayout();
            this.grpbpossui.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pctdatanasc)).BeginInit();
            this.SuspendLayout();
            // 
            // lbltitulo
            // 
            this.lbltitulo.AutoSize = true;
            this.lbltitulo.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbltitulo.Location = new System.Drawing.Point(223, 38);
            this.lbltitulo.Name = "lbltitulo";
            this.lbltitulo.Size = new System.Drawing.Size(223, 26);
            this.lbltitulo.TabIndex = 0;
            this.lbltitulo.Text = "Cadastro de Cliente";
            // 
            // lblnome
            // 
            this.lblnome.AutoSize = true;
            this.lblnome.Location = new System.Drawing.Point(127, 91);
            this.lblnome.Name = "lblnome";
            this.lblnome.Size = new System.Drawing.Size(35, 13);
            this.lblnome.TabIndex = 1;
            this.lblnome.Text = "Nome";
            // 
            // txtnome
            // 
            this.txtnome.Location = new System.Drawing.Point(167, 88);
            this.txtnome.Name = "txtnome";
            this.txtnome.Size = new System.Drawing.Size(365, 20);
            this.txtnome.TabIndex = 2;
            // 
            // grpbempresario
            // 
            this.grpbempresario.Controls.Add(this.rbnao);
            this.grpbempresario.Controls.Add(this.rbsim);
            this.grpbempresario.Location = new System.Drawing.Point(102, 178);
            this.grpbempresario.Name = "grpbempresario";
            this.grpbempresario.Size = new System.Drawing.Size(428, 73);
            this.grpbempresario.TabIndex = 3;
            this.grpbempresario.TabStop = false;
            this.grpbempresario.Text = "É empresário?";
            // 
            // rbnao
            // 
            this.rbnao.AutoSize = true;
            this.rbnao.Checked = true;
            this.rbnao.Location = new System.Drawing.Point(298, 31);
            this.rbnao.Name = "rbnao";
            this.rbnao.Size = new System.Drawing.Size(45, 17);
            this.rbnao.TabIndex = 1;
            this.rbnao.TabStop = true;
            this.rbnao.Text = "Não";
            this.rbnao.UseVisualStyleBackColor = true;
            this.rbnao.Click += new System.EventHandler(this.rbnao_Click);
            // 
            // rbsim
            // 
            this.rbsim.AutoSize = true;
            this.rbsim.Location = new System.Drawing.Point(64, 31);
            this.rbsim.Name = "rbsim";
            this.rbsim.Size = new System.Drawing.Size(42, 17);
            this.rbsim.TabIndex = 0;
            this.rbsim.Text = "Sim";
            this.rbsim.UseVisualStyleBackColor = true;
            this.rbsim.Click += new System.EventHandler(this.rbsim_Click);
            // 
            // pnlcnpj
            // 
            this.pnlcnpj.Controls.Add(this.txtcnpj);
            this.pnlcnpj.Controls.Add(this.lblcnpj);
            this.pnlcnpj.Location = new System.Drawing.Point(104, 257);
            this.pnlcnpj.Name = "pnlcnpj";
            this.pnlcnpj.Size = new System.Drawing.Size(426, 70);
            this.pnlcnpj.TabIndex = 4;
            this.pnlcnpj.Visible = false;
            // 
            // txtcnpj
            // 
            this.txtcnpj.Location = new System.Drawing.Point(84, 22);
            this.txtcnpj.Name = "txtcnpj";
            this.txtcnpj.Size = new System.Drawing.Size(312, 20);
            this.txtcnpj.TabIndex = 1;
            // 
            // lblcnpj
            // 
            this.lblcnpj.AutoSize = true;
            this.lblcnpj.Location = new System.Drawing.Point(33, 25);
            this.lblcnpj.Name = "lblcnpj";
            this.lblcnpj.Size = new System.Drawing.Size(34, 13);
            this.lblcnpj.TabIndex = 0;
            this.lblcnpj.Text = "CNPJ";
            // 
            // grpbpossui
            // 
            this.grpbpossui.Controls.Add(this.chk3);
            this.grpbpossui.Controls.Add(this.chk1);
            this.grpbpossui.Controls.Add(this.chk2);
            this.grpbpossui.Location = new System.Drawing.Point(104, 333);
            this.grpbpossui.Name = "grpbpossui";
            this.grpbpossui.Size = new System.Drawing.Size(429, 113);
            this.grpbpossui.TabIndex = 5;
            this.grpbpossui.TabStop = false;
            this.grpbpossui.Text = "Possui?";
            // 
            // btngravar
            // 
            this.btngravar.Location = new System.Drawing.Point(488, 467);
            this.btngravar.Name = "btngravar";
            this.btngravar.Size = new System.Drawing.Size(89, 23);
            this.btngravar.TabIndex = 6;
            this.btngravar.Text = "Gravar";
            this.btngravar.UseVisualStyleBackColor = true;
            this.btngravar.Click += new System.EventHandler(this.btngravar_Click);
            // 
            // chk3
            // 
            this.chk3.AutoSize = true;
            this.chk3.Location = new System.Drawing.Point(21, 65);
            this.chk3.Name = "chk3";
            this.chk3.Size = new System.Drawing.Size(58, 17);
            this.chk3.TabIndex = 9;
            this.chk3.Tag = "tagpossui";
            this.chk3.Text = "Celular";
            this.chk3.UseVisualStyleBackColor = true;
            // 
            // chk2
            // 
            this.chk2.AutoSize = true;
            this.chk2.Location = new System.Drawing.Point(21, 42);
            this.chk2.Name = "chk2";
            this.chk2.Size = new System.Drawing.Size(73, 17);
            this.chk2.TabIndex = 8;
            this.chk2.Tag = "tagpossui";
            this.chk2.Text = "Notebook";
            this.chk2.UseVisualStyleBackColor = true;
            // 
            // chk1
            // 
            this.chk1.AutoSize = true;
            this.chk1.Location = new System.Drawing.Point(21, 19);
            this.chk1.Name = "chk1";
            this.chk1.Size = new System.Drawing.Size(71, 17);
            this.chk1.TabIndex = 7;
            this.chk1.Tag = "tagpossui";
            this.chk1.Text = "Geladeira";
            this.chk1.UseVisualStyleBackColor = true;
            // 
            // txtdatanasc
            // 
            this.txtdatanasc.Location = new System.Drawing.Point(168, 133);
            this.txtdatanasc.Name = "txtdatanasc";
            this.txtdatanasc.Size = new System.Drawing.Size(365, 20);
            this.txtdatanasc.TabIndex = 8;
            this.txtdatanasc.TextChanged += new System.EventHandler(this.txtdatanasc_TextChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(73, 136);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(89, 13);
            this.label1.TabIndex = 7;
            this.label1.Text = "Data Nascimento";
            // 
            // pctdatanasc
            // 
            this.pctdatanasc.Image = global::aula2.Properties.Resources.check;
            this.pctdatanasc.Location = new System.Drawing.Point(546, 133);
            this.pctdatanasc.Name = "pctdatanasc";
            this.pctdatanasc.Size = new System.Drawing.Size(18, 19);
            this.pctdatanasc.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pctdatanasc.TabIndex = 9;
            this.pctdatanasc.TabStop = false;
            this.pctdatanasc.Visible = false;
            // 
            // frmprincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.ClientSize = new System.Drawing.Size(637, 502);
            this.Controls.Add(this.pctdatanasc);
            this.Controls.Add(this.txtdatanasc);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btngravar);
            this.Controls.Add(this.grpbpossui);
            this.Controls.Add(this.pnlcnpj);
            this.Controls.Add(this.grpbempresario);
            this.Controls.Add(this.txtnome);
            this.Controls.Add(this.lblnome);
            this.Controls.Add(this.lbltitulo);
            this.Name = "frmprincipal";
            this.Text = "Form1";
            this.grpbempresario.ResumeLayout(false);
            this.grpbempresario.PerformLayout();
            this.pnlcnpj.ResumeLayout(false);
            this.pnlcnpj.PerformLayout();
            this.grpbpossui.ResumeLayout(false);
            this.grpbpossui.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pctdatanasc)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbltitulo;
        private System.Windows.Forms.Label lblnome;
        private System.Windows.Forms.TextBox txtnome;
        private System.Windows.Forms.GroupBox grpbempresario;
        private System.Windows.Forms.RadioButton rbnao;
        private System.Windows.Forms.RadioButton rbsim;
        private System.Windows.Forms.Panel pnlcnpj;
        private System.Windows.Forms.TextBox txtcnpj;
        private System.Windows.Forms.Label lblcnpj;
        private System.Windows.Forms.GroupBox grpbpossui;
        private System.Windows.Forms.Button btngravar;
        private System.Windows.Forms.CheckBox chk3;
        private System.Windows.Forms.CheckBox chk2;
        private System.Windows.Forms.CheckBox chk1;
        private System.Windows.Forms.TextBox txtdatanasc;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.PictureBox pctdatanasc;
    }
}

