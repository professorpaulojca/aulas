using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace aula03.modelo
{
    public class Sexo
    {
        public int id { get; set; }
        public string descricao { get; set; }

        public Sexo()
        {

        }
        public Sexo(int id, string descricao)
        {
            this.id = id;
            this.descricao = descricao;
        }
        public List<Sexo> listar()
        {
            List<Sexo> lstsexo = new List<Sexo>();

            lstsexo.Add(new Sexo(1, "Feminino"));
            lstsexo.Add(new Sexo(2, "Masculino"));

            return lstsexo;
        }

    }
}
