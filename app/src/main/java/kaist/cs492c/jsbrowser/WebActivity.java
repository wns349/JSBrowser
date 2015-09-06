package kaist.cs492c.jsbrowser;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebActivity extends Activity{
    private static final String TAG = WebActivity.class.getSimpleName();

    private static final String URL_FAV1 = "http://www.google.com";
    private static final String URL_FAV2 = "http://www.yahoo.com";
    private static final String URL_FAV3 = "http://www.espnfc.com";

    private Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web);

        this.mContext = this;

        // add actions to buttons
        initializeButtons();
    }

    private void initializeButtons(){
        // Find all views by their IDs
        final EditText edtUrl = (EditText)findViewById(R.id.edt_url);
        final Button btnGo = (Button)findViewById(R.id.btn_go);
        final WebView webContent = (WebView) findViewById(R.id.web_content);
        final Button btnFav1 = (Button)findViewById(R.id.btn_fav1);
        final Button btnFav2 = (Button)findViewById(R.id.btn_fav2);
        final Button btnFav3 = (Button)findViewById(R.id.btn_fav3);

        // Enable javascript on webContent
        webContent.getSettings().setJavaScriptEnabled(true);

        // Set web view client to webContent
        webContent.setWebViewClient(new WebViewClient());

        // Go button
        btnGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String url = edtUrl.getText().toString().trim();
                if (url == null || url.isEmpty()) {
                    Toast.makeText(mContext, "Invalid URL...", Toast.LENGTH_LONG).show();
                } else {
                    webContent.loadUrl(url);
                    Log.d(TAG, "Loading URL: " + url);
                }
            }
        });

        // Fav 1 button
        btnFav1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                webContent.loadUrl(URL_FAV1);
            }
        });

        // Fav 2 button
        btnFav2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                webContent.loadUrl(URL_FAV2);
            }
        });

        // Fav 3 button
        btnFav3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                webContent.loadUrl(URL_FAV3);
            }
        });
    }
}
