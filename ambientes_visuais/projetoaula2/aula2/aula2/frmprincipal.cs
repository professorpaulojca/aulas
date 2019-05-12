using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace aula2
{
    public partial class frmprincipal : Form
    {
        public frmprincipal()
        {
            InitializeComponent();
        }

        private void rbsim_Click(object sender, EventArgs e)
        {
            pnlcnpj.Visible = true;
        }

        private void rbnao_Click(object sender, EventArgs e)
        {
            pnlcnpj.Visible = false;
        }

        private void btngravar_Click(object sender, EventArgs e)
        {
            //lista de checkbox
            var listcheckbox = new List<CheckBox>();

            //se estiver fora do groupbox
            //listcheckbox = this.Controls.OfType<CheckBox>()
            //              .Where(c => String.Equals(c.Tag, "tagpossui"))
            //              .ToList();

            //se estiver dentro         
            listcheckbox = grpbpossui.Controls.OfType<CheckBox>().ToList();
            StringBuilder strbuilder = new StringBuilder();

            foreach (var obj in listcheckbox)
            {              
                if (obj.Checked)
                {
                    strbuilder.Append(obj.Text);
                }
            }

            MessageBox.Show(strbuilder.ToString());

        }

        private void txtdatanasc_TextChanged(object sender, EventArgs e)
        {
            Regex regex = new Regex(@"^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$");
            Match match = regex.Match(txtdatanasc.Text);
            if (match.Success)
            {
                
                pctdatanasc.Visible = true;

            } else
            {
                pctdatanasc.Visible = false;
            }
        }
    }
}
