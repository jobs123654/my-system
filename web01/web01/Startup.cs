using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(web01.Startup))]
namespace web01
{
    public partial class Startup {
        public void Configuration(IAppBuilder app) {
            ConfigureAuth(app);
        }
    }
}
