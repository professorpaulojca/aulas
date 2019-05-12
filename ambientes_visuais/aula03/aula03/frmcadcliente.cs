using aula03.modelo;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace aula03
{
    public partial class frmcadcliente : Form
    {
        public frmcadcliente()
        {
            InitializeComponent();
        }

        private void frmcadcliente_Load(object sender, EventArgs e)
        {
            Sexo objsexo = new Sexo();
            cmbsexo.DataSource = objsexo.listar();
            cmbsexo.ValueMember = "id";
            cmbsexo.DisplayMember = "descricao";
        }
    }
}
