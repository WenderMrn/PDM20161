package br.edu.ifpb.si.pdm.analitico.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.edu.ifpb.si.pdm.analitico.util.BitmapByteHelper;
import br.edu.ifpb.si.pdm.analitico.R;

/**
 * Created by thor on 17/07/16.
 */
public class PersonAdapter extends BaseAdapter {

    private List<Person> persons;
    private Context context;

    public PersonAdapter(List<Person> persons, Context context) {
        this.persons = persons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.persons.size();
    }

    @Override
    public Object getItem(int position) {
        return this.persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Person p = this.persons.get(position);

        if (convertView == null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.person_layout, null);
        }else view = convertView;

        TextView tv = (TextView) view.findViewById(R.id.personTvTextInfo);
        if(p.getTextInfo() != null && p.getTextInfo()!=""){
            if(p.getTextInfo().length() > 60){
                tv.setText(p.getTextInfo().substring(0,60)+"...");
            }else{
                tv.setText(p.getTextInfo());
            }
        }

        ImageView iv = (ImageView) view.findViewById(R.id.personIvPhoto);

        if(p.getImg()!=null){
            iv.setImageBitmap(BitmapByteHelper.getImage(p.getImg()));
        }

        return view;
    }
}
