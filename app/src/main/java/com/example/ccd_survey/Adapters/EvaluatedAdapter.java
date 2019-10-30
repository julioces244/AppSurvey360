package com.example.ccd_survey.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ccd_survey.Activities.Question1Activity;
import com.example.ccd_survey.Models.Evaluated;
import com.example.ccd_survey.R;
import com.example.ccd_survey.Service.ApiService;
import com.github.florent37.shapeofview.shapes.CircleView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class EvaluatedAdapter extends RecyclerView.Adapter<EvaluatedAdapter.ViewHolder> {



    private List<Evaluated> evaluateds;

    //final ArrayList<String> correcta = new ArrayList<String>();

    public List<Evaluated> getEvaluateds() {
        return evaluateds;
    }

    public EvaluatedAdapter(){
        this.evaluateds = new ArrayList<>();
    }

    public void setEvaluateds(List<Evaluated> evaluateds){
        this.evaluateds = evaluateds;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        public CircularImageView fotoImage;
        public TextView nombreText;
        public Spinner spinner;



        public ViewHolder(View itemView) {
            super(itemView);
            fotoImage = itemView.findViewById(R.id.imageEvaluated);
            nombreText = itemView.findViewById(R.id.txt_evaluated);

            spinner = itemView.findViewById(R.id.spn_item);
            ArrayAdapter adapter = ArrayAdapter.createFromResource(itemView.getContext(),
                    R.array.answers, R.layout.spinner_item);

            adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
            spinner.setAdapter(adapter);

        }
    }

    @Override
    public EvaluatedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evaluated, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EvaluatedAdapter.ViewHolder viewHolder, final int position) {

        final Evaluated evaluated = this.evaluateds.get(position);

        viewHolder.nombreText.setText(evaluated.getName());


        String url = ApiService.API_BASE_URL + "/images/" + evaluated.getImage();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);



            viewHolder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String a = adapterView.getSelectedItem().toString();



                    evaluated.setCorrecta(viewHolder.spinner.getSelectedItem().toString());

                    //correcta.add(viewHolder.spinner.getSelectedItem().toString());

                    //Toast.makeText(viewHolder.itemView.getContext(), position+" : "+ correcta, Toast.LENGTH_SHORT).show();




                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });


      //  }

    }

    @Override
    public int getItemCount() {
        return this.evaluateds.size();
    }


}
