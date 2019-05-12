using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace aula1
{
    public partial class frmprincipal : Form
    {
        public frmprincipal()
        {
            InitializeComponent();
        }

      
        private void validar()
        {
            if (pctchnome.Visible == true && pctchdata.Visible== true)
            {
                btngravar.Visible = true;
            } else
            {
                btngravar.Visible = false;
            }
        }

        private void txtnome_TextChanged(object sender, EventArgs e)
        {
            if (txtnome.Text.Length >= 5)
            {
                pctchnome.Visible = true;
            }
            else
            {
                pctchnome.Visible = false;
            }
            validar();
        }

        private void btngravar_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Registro gravado com sucesso!");
        }

        private void txtdata_TextChanged(object sender, EventArgs e)
        {
            if (txtdata.Text.Length == 10)
            {
                pctchdata.Visible = true;
            }
            else
            {
                pctchdata.Visible = false;
            }
            validar();
        }
    }
}
