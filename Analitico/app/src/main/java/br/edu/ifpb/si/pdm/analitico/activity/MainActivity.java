package br.edu.ifpb.si.pdm.analitico.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.edu.ifpb.si.pdm.analitico.DAO.PersonDAO;
import br.edu.ifpb.si.pdm.analitico.R;
import br.edu.ifpb.si.pdm.analitico.models.Person;
import br.edu.ifpb.si.pdm.analitico.models.PersonAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int TELA_SCANNER = 2,TELA_DETAIL = 1;
    private PersonDAO personDAO;
    private ListView listViewPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.LoadComponents();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.personDAO = new PersonDAO(this);
        PersonAdapter adapter = new PersonAdapter(this.personDAO.readAll(), this);
        this.listViewPerson.setAdapter(adapter);
        this.UpdateAdapter();
        this.addListeners();
    }
    private void addListeners(){
        MainActivity.this.listViewPerson.setOnItemLongClickListener(new OnLongClickList());
        MainActivity.this.listViewPerson.setOnItemClickListener(new OnClickItemList());
    }
    private void UpdateAdapter(){
        this.listViewPerson.setAdapter(new PersonAdapter(this.personDAO.readAll(), this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == TELA_SCANNER){
                    Intent it = new Intent(MainActivity.this,DetailActivity.class);
                    Bundle extras = data.getExtras();
                    it.putExtras(extras);
                    startActivityForResult(it,TELA_DETAIL);
            }else if(requestCode == TELA_DETAIL){

                if(data != null){

                    String text = data.getStringExtra("formated_text");
                    byte[] photo = data.getByteArrayExtra("photo");

                    Person person = null;

                   if(text!= null){
                       person = new Person();

                       if(photo != null)
                            person.setImg(photo);

                        person.setTextInfo(text);
                        new Person();
                        this.personDAO.create(person);
                        this.UpdateAdapter();
                    }

                }
            }
        }
    }
    private class OnClickItemList implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Person p = (Person) parent.getAdapter().getItem(position);
            Intent it = new Intent(MainActivity.this,DetailActivity.class);
            it.putExtra("photo",p.getImg());
            it.putExtra("formated_text",p.getTextInfo());
            startActivity(it);
        }
    }

    private class OnLongClickList implements AdapterView.OnItemLongClickListener{

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Person p = (Person) parent.getAdapter().getItem(position);
            MainActivity.this.personDAO.delete(p);
            MainActivity.this.UpdateAdapter();
            return true;
        }
    }

    private void LoadComponents(){
        this.listViewPerson = (ListView) findViewById(R.id.lvPersons);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_scaneer) {

            Intent it = new Intent(MainActivity.this, ScannerActivity.class);
            startActivityForResult(it,TELA_SCANNER);
        } /*else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } */else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
