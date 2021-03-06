package ca.vickypatel.materialdesigndialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import vickypatel.ca.materialdesigndialog.MaterialDesignDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                /** sample use of custom dialog */
                String title = "Hello I am title";
                String content = "I am sample content";
                String positiveActionText = "YES";
                String negativeActionText = "NO";

                /** simple custom dialog */
                new MaterialDesignDialog.Builder(MainActivity.this)
                        .title(title)
                        .content(content)
                        .positiveActionText(positiveActionText)
                        .negativeActionText(negativeActionText)
                        .onPositiveAction(new MaterialDesignDialog.OnActionListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(MainActivity.this, "OK clicked", Toast.LENGTH_LONG).show();
                            }
                        })
                        .onNegativeAction(new MaterialDesignDialog.OnActionListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(MainActivity.this, "CANCEL clicked", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
