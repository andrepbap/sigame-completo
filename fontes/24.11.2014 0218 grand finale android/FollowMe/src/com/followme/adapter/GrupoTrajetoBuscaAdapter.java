package com.followme.adapter;

import java.util.List;

import com.android.volley.toolbox.NetworkImageView;

import com.followme.R;
import com.followme.R.id;
import com.followme.R.layout;
import com.followme.library.VolleySingleton;
import com.followme.model.MotoristaModel;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class GrupoTrajetoBuscaAdapter extends ArrayAdapter<MotoristaModel> {
	
	static final int LAYOUT = R.layout.grupo_trajeto_list_juntarse_activity;
	
	public GrupoTrajetoBuscaAdapter(Context context, 
		    List<MotoristaModel> objects) {

		    super(context, LAYOUT, objects);
		  }
	
	@Override
	  public View getView(int position, 
	    View convertView, ViewGroup parent) {

	    Context ctx = parent.getContext();
	    if (convertView == null){
	      convertView = LayoutInflater.from(ctx)
	        .inflate(R.layout.grupo_trajeto_list_juntarse_activity, null);
	    }
	    NetworkImageView img = (NetworkImageView)
	      convertView.findViewById(R.id.ivActActJuntarSeGrupoTrajeto);
	    TextView txtEmail = (TextView)
	      convertView.findViewById(R.id.lblNomeLiderGrupoActJuntarSeGrupoTrajeto);
	    
	   // TextView txtStatusBloqueio = (TextView)
	  	      //convertView.findViewById(R.id.txtStatusBloqueioActMotoristaAutorizacao);
	    
	  
	    MotoristaModel motoristaModel = getItem(position);
	    txtEmail.setText("L�der: "+motoristaModel.getEmail().toString());
	    //txtStatusBloqueio.setText(motoristaModel.getAutorizado().toString());
	   /* if(motoristaModel.getAutorizado().equals("bloqueado"))
	    {
	    	convertView.setBackgroundColor(Color.RED);
	    }else
	    {
	    	convertView.setBackgroundColor(Color.GREEN);
	    }*/
	    
	    String url = motoristaModel.getUrl();
	    img.setImageUrl(
	      motoristaModel.getUrl(), 
	      VolleySingleton.getInstance(
	        getContext()).getImageLoader());
	  
	    return convertView;
	  }

}
