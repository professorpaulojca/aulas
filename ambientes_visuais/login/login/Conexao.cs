using Npgsql;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace login
{
    class Conexao
    {

        public NpgsqlConnection getConexao()
        {

            // configuração da conexao com o banco de dados.
            string serverName = "127.0.0.1";  //localhost
            string port = "5432";             //porta default
            string userName = "postgres";     //nome do administrador
            string password = "postgres";     //senha do administrador
            string databaseName = "sistema"; //nome do banco de dados

            NpgsqlConnection pgsqlConnection = null;
            string connString = String.Format("Server={0};Port={1};User Id={2};Password={3};Database={4};", serverName, port, userName, password, databaseName);

            pgsqlConnection = new NpgsqlConnection(connString);


            return pgsqlConnection;

        }

    }
}
