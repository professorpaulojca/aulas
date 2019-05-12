using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace login
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnentrar_Click(object sender, EventArgs e)
        {
            Usuario objusuario = new Usuario();




            objusuario.Email = txtusuario.Text.Replace("'","");
            objusuario.Senha = txtsenha.Text;




            if (objusuario.logar())
            {

                MessageBox.Show("Bem vindo!");

            } else
            {

                MessageBox.Show("HAHAH! Sei....vai tentando.");

            }

        }
    }
}
