using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Npgsql;

namespace produtos
{
    public class Tipo
    {

        public int id { get; set; }
        public string nometipo { get; set; }

        public Tipo()
        {
                
        }

        public Tipo(int id, string nometipo)
        {
            this.id = id;
            this.nometipo = nometipo;
        }


        public List<Tipo> listar()
        {
            List<Tipo> arrtipos = new List<Tipo>();

            //os dados dos objetos virão da base de dados

            NpgsqlConnection conex = null;
            try
            {

                Conexao conexao = new Conexao();

                conex = conexao.getConexao();

                conex.Open();

                string sql;

                sql = "select * from tipo;";

                NpgsqlCommand cmd = new NpgsqlCommand(sql, conex);

                NpgsqlDataReader dr = cmd.ExecuteReader();

                while (dr.Read())
                {
                    Tipo objtipo = new Tipo();
                    objtipo.id = Convert.ToInt16(dr["id"].ToString());
                    objtipo.nometipo = dr["nometipo"].ToString();

                    arrtipos.Add(objtipo);
                }


            } catch(Exception ex)
            {
               
            }
            finally
            {
                conex.Close();
            }


            return arrtipos;
        }

    }
}
