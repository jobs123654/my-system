using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace wpf
{
    class dbhelper
    {
        private string dbname;

        public dbhelper()
        {
            dbname = "root";
            dbpwd = "root";
        }
        public string Dbname
        {
            get { return dbname; }
            set { dbname = value; }
        }
        private string dbpwd;

        public string Dbpwd
        {
            get { return dbpwd; }
            set { dbpwd = value; }
        }
        public override string ToString()
        {
            return dbname+"   "+dbpwd;
        }
    }
}
