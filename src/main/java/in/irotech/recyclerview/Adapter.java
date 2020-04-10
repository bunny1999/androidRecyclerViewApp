package in.irotech.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViweHolder> {

    private ArrayList<ExampleSet> arrayList;

    public Adapter(ArrayList<ExampleSet> list){
        this.arrayList=list;
    }

    public class AdapterViweHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public AdapterViweHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView=itemView.findViewById(R.id.imageView);
            this.textView=itemView.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public AdapterViweHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout,parent,false);
        AdapterViweHolder adapterViweHolder=new AdapterViweHolder(view);
        return adapterViweHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViweHolder adapterViweHolder, int position) {
        ExampleSet currentSet = arrayList.get(position);
        adapterViweHolder.imageView.setImageResource(currentSet.getImage());
        adapterViweHolder.textView.setText(currentSet.getText());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
