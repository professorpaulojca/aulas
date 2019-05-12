namespace aula1
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmprincipal));
            this.lblnome = new System.Windows.Forms.Label();
            this.txtnome = new System.Windows.Forms.TextBox();
            this.pctchnome = new System.Windows.Forms.PictureBox();
            this.pctchdata = new System.Windows.Forms.PictureBox();
            this.txtdata = new System.Windows.Forms.TextBox();
            this.lbldata = new System.Windows.Forms.Label();
            this.btngravar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pctchnome)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pctchdata)).BeginInit();
            this.SuspendLayout();
            // 
            // lblnome
            // 
            this.lblnome.AutoSize = true;
            this.lblnome.Location = new System.Drawing.Point(28, 27);
            this.lblnome.Name = "lblnome";
            this.lblnome.Size = new System.Drawing.Size(122, 13);
            this.lblnome.TabIndex = 1;
            this.lblnome.Text = "Digite o nome do Cliente";
            // 
            // txtnome
            // 
            this.txtnome.Location = new System.Drawing.Point(31, 43);
            this.txtnome.Name = "txtnome";
            this.txtnome.Size = new System.Drawing.Size(265, 20);
            this.txtnome.TabIndex = 2;
            this.txtnome.TextChanged += new System.EventHandler(this.txtnome_TextChanged);
            // 
            // pctchnome
            // 
            this.pctchnome.Image = ((System.Drawing.Image)(resources.GetObject("pctchnome.Image")));
            this.pctchnome.Location = new System.Drawing.Point(301, 43);
            this.pctchnome.Name = "pctchnome";
            this.pctchnome.Size = new System.Drawing.Size(20, 19);
            this.pctchnome.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pctchnome.TabIndex = 3;
            this.pctchnome.TabStop = false;
            this.pctchnome.Visible = false;
            // 
            // pctchdata
            // 
            this.pctchdata.Image = ((System.Drawing.Image)(resources.GetObject("pctchdata.Image")));
            this.pctchdata.Location = new System.Drawing.Point(165, 103);
            this.pctchdata.Name = "pctchdata";
            this.pctchdata.Size = new System.Drawing.Size(20, 19);
            this.pctchdata.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pctchdata.TabIndex = 6;
            this.pctchdata.TabStop = false;
            this.pctchdata.Visible = false;
            // 
            // txtdata
            // 
            this.txtdata.Location = new System.Drawing.Point(31, 103);
            this.txtdata.Name = "txtdata";
            this.txtdata.Size = new System.Drawing.Size(128, 20);
            this.txtdata.TabIndex = 5;
            this.txtdata.TextChanged += new System.EventHandler(this.txtdata_TextChanged);
            // 
            // lbldata
            // 
            this.lbldata.AutoSize = true;
            this.lbldata.Location = new System.Drawing.Point(28, 87);
            this.lbldata.Name = "lbldata";
            this.lbldata.Size = new System.Drawing.Size(189, 13);
            this.lbldata.TabIndex = 4;
            this.lbldata.Text = "Digite a data de nascimento do Cliente";
            // 
            // btngravar
            // 
            this.btngravar.Location = new System.Drawing.Point(267, 233);
            this.btngravar.Name = "btngravar";
            this.btngravar.Size = new System.Drawing.Size(93, 26);
            this.btngravar.TabIndex = 7;
            this.btngravar.Text = "Gravar";
            this.btngravar.UseVisualStyleBackColor = true;
            this.btngravar.Visible = false;
            this.btngravar.Click += new System.EventHandler(this.btngravar_Click);
            // 
            // frmprincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(392, 281);
            this.Controls.Add(this.btngravar);
            this.Controls.Add(this.pctchdata);
            this.Controls.Add(this.txtdata);
            this.Controls.Add(this.lbldata);
            this.Controls.Add(this.pctchnome);
            this.Controls.Add(this.txtnome);
            this.Controls.Add(this.lblnome);
            this.Name = "frmprincipal";
            this.Text = "Sistema Super +";
            ((System.ComponentModel.ISupportInitialize)(this.pctchnome)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pctchdata)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label lblnome;
        private System.Windows.Forms.TextBox txtnome;
        private System.Windows.Forms.PictureBox pctchnome;
        private System.Windows.Forms.PictureBox pctchdata;
        private System.Windows.Forms.TextBox txtdata;
        private System.Windows.Forms.Label lbldata;
        private System.Windows.Forms.Button btngravar;
    }
}

