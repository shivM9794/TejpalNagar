package app.tejpalnagar.SideNavSection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import app.tejpalnagar.R;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Element adsElement = new Element();
        adsElement.setTitle("Join Us");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                //.setImage(R.drawable.tejpalwallpaper)
                .setDescription("Tejpal Singh Nagar popularly known as Tejpal Master is a known politician and a member of the 18th Uttar Pradesh Assembly and also 17th Legislative Assembly of India. He represents Dadri constituency of Uttar Pradesh and is a member of the BJP political party.")
                .addItem(new Element().setTitle("Version 1.0"))
                .addItem(adsElement)
                .addGroup("Connect with us")
                .addEmail("tejpalnagar@gmail.com")
                .addWebsite("https://en.wikipedia.org/wiki/Tejpal_Singh_Nagar")
                .addFacebook("https://www.facebook.com/tejpalnagarMLA")
                .addTwitter("https://twitter.com/tejpalmla")
//                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
//                .addPlayStore("com.ideashower.readitlater.pro")
                .addInstagram("https://www.instagram.com/tejpaldadri4bjp/?hl=en")
                .addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
    }


    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.about_icon_copy_right);
        copyRightsElement.setAutoApplyIconTint(true);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(v -> Toast.makeText(getApplicationContext(), copyrights, Toast.LENGTH_SHORT).show());
        return copyRightsElement;
    }
}