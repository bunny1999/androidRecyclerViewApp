package in.irotech.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<ExampleSet> list;

    private Button insert,delete;
    private EditText edit1,edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=new ArrayList<>();

        list.add(new ExampleSet(R.drawable.node,"Short By Hitesh"));
        list.add(new ExampleSet(R.drawable.oner,"Short By Hitesh"));
        list.add(new ExampleSet(R.drawable.twor,"Short By Hitesh"));
        list.add(new ExampleSet(R.drawable.threer,"Short By Hitesh"));
        list.add(new ExampleSet(R.drawable.fourr,"Short By Hitesh"));
        list.add(new ExampleSet(R.drawable.fiver,"Short By Hitesh"));
        list.add(new ExampleSet(R.drawable.sixr,"Short By Hitesh"));

        recyclerView=findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(this);
        adapter=new Adapter(list);

        //for Large data set(perfomance)
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        //Insert & delete
        insert=findViewById(R.id.buttonadd);
        delete=findViewById(R.id.buttondelete);
        edit1=findViewById(R.id.edittextadd);
        edit2=findViewById(R.id.edittextdelete);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val=edit1.getText().toString();
                if(val.length()==0){
                    edit1.setError("Error");
                }else{
                    int postion= Integer.parseInt(val);
                    if(postion>list.size()){
                        edit1.setError("Add in Series");
                    }else{
                        addCard(postion);
                    }
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val=edit2.getText().toString();
                if(val.length()==0){
                    edit2.setError("Error");
                }else{
                    int postion= Integer.parseInt(val);
                    if(list.isEmpty()){
                        edit2.setError("Empty");
                    }else if(postion>list.size()-1){
                        edit2.setError("Item Not Present");
                    }else{
                        deleteCard(postion);
                    }
                }
            }
        });
    }

    public void addCard(int postion){
        list.add(postion,new ExampleSet(R.drawable.node,"New Added"));
        adapter.notifyItemInserted(postion);
    }
    public void deleteCard(int postion){
        list.remove(postion);
        adapter.notifyItemRemoved(postion);
    }
}
