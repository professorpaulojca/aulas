using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Npgsql;

namespace produtos
{
    public class Departamento
    {

        public int id { get; set; }
        public string nomedepartamento { get; set; }


        public Departamento()
        {

        }

        public Departamento(int id, string nomedepartamento)
        {
            this.id = id;
            this.nomedepartamento = nomedepartamento;
        }


        public List<Departamento> listar(int id_tipo)
        {
            List<Departamento> arrdepartamentos = new List<Departamento>();

            //os dados dos objetos virão da base de dados

            NpgsqlConnection conex = null;
            try
            {

                Conexao conexao = new Conexao();

                conex = conexao.getConexao();

                conex.Open();

                string sql;

                sql = "select * from departamento where id_tipo=" + id_tipo + ";";

                NpgsqlCommand cmd = new NpgsqlCommand(sql, conex);

                NpgsqlDataReader dr = cmd.ExecuteReader();

                while (dr.Read())
                {
                    Departamento objDepartamento = new Departamento();
                    objDepartamento.id = Convert.ToInt16(dr["id"].ToString());
                    objDepartamento.nomedepartamento = dr["nomedepartamento"].ToString();

                    arrdepartamentos.Add(objDepartamento);
                }


            }
            catch (Exception ex)
            {

            }
            finally
            {
                conex.Close();
            }


            return arrdepartamentos;
        }

    }
}
