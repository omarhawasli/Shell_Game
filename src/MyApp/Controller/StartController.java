package MyApp.Controller;

import MyApp.MyApp;
import javafx.scene.control.MenuItem;


public class StartController {
    public MenuItem menuClose;
    public MenuItem menuAbout;

    public void onMenuCloseClick() {
        MyApp.instance.shutdown();
    }

    public void onMenuAboutClick(){
        MyApp.instance.showAboutBox();
    }
}
