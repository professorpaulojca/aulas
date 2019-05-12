using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace produtos
{
    public partial class frmcadprodutos : Form
    {
        public frmcadprodutos()
        {
            InitializeComponent();
        }

        private void frmcadprodutos_Load(object sender, EventArgs e)
        {
            Tipo objtipo = new Tipo();
            cmbtipo.DataSource = objtipo.listar();
            cmbtipo.DisplayMember = "nometipo";
            cmbtipo.ValueMember = "id";

            Departamento objdepartamento = new Departamento();
            cmbdepartamento.DataSource = objdepartamento.listar(Convert.ToInt16(cmbtipo.SelectedValue.ToString()));
            cmbdepartamento.DisplayMember = "nomedepartamento";
            cmbdepartamento.ValueMember = "id";

        }

        private void cmbtipo_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                Departamento objdepartamento = new Departamento();
                cmbdepartamento.DataSource = objdepartamento.listar(Convert.ToInt16(cmbtipo.SelectedValue.ToString()));
                cmbdepartamento.DisplayMember = "nomedepartamento";
                cmbdepartamento.ValueMember = "id";

            } catch (Exception ex)
            {
                //
            }
         

        }
    }
}
