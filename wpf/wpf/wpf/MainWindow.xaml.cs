using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Text.RegularExpressions;
namespace wpf
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            Console.WriteLine("1111");
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            
            MessageBox.Show("hello");
        }

       

       
        private void onclick(object sender,RoutedEventArgs e)
        {
        new network().ShowDialog();
           
        }

        private void DatePicker_CalendarClosed(object sender, RoutedEventArgs e)
        {
            DatePicker d =(DatePicker)sender;
            string s=d.ToString().Split(' ')[0];
            Regex regex = new Regex(@"(/)");
            if(regex.IsMatch(s))
            {
                s=regex.Replace(s, "-");
            }
            MessageBox.Show(DateTime.Now.ToString());
        }
    }
}
