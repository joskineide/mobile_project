package br.usjt.ciclodevidagpsemapas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListaChamadoActivity extends MainActivity{

    private ListView posicoesListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);
        Intent origemIntent = getIntent();
        final List<String> posicoes = origemIntent.getStringArrayListExtra("historicoPosicao");
        posicoes.add("posicao 2");
        posicoes.add("precisaria mockar");
        posicoesListView=findViewById(R.id.posicoesListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, posicoes);
        posicoesListView.setAdapter(adapter);

        posicoesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String listText = posicoesListView.getItemAtPosition(i).toString();

                String lat = listText.split(",")[0].split(":")[1];

                String lon = listText.split(",")[1].split(":")[1];


                Uri gmmIntentUri = Uri.parse(String.format("geo:%s,%s", lat, lon));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

//                Toast.makeText(ListaChamadoActivity.this, posicoesListView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

            }
        });

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(MainActivity.this, ListaChamadoActivity.class);
//                Intent.putStringArrayListExtra("historicoPosicao", historicoPosicao);
//
//
//
//                EditText edit = (EditText)findViewById(R.id.search_box);
//                String searchQuery = edit.getText().toString();
//                Uri gmmIntentUri = Uri.parse(String.format("geo:%f,%f?q=%s", latitudeAtual, longitudeAtual, searchQuery));
//                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                mapIntent.setPackage("com.google.android.apps.maps");
//                startActivity(mapIntent);
//            }
//        });


        Toast.makeText(this, "Got in boys", Toast.LENGTH_LONG).show();

//        final List<String> chamados = ;
    }
}
