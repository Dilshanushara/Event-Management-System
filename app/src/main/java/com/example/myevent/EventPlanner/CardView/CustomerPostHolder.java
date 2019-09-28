package com.example.myevent.EventPlanner.CardView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myevent.Interface.ItemClickListener;
import com.example.myevent.R;
import com.squareup.picasso.Picasso;

public class CustomerPostHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    View mview;
    private com.example.myevent.Interface.ItemClickListener ItemClickListener;



    public CustomerPostHolder(@NonNull View itemView) {
        super(itemView);
        mview=itemView;
        itemView.setOnClickListener(this);
    }







    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.ItemClickListener = itemClickListener;
    }




    public void setTitle(String title){

        TextView post_title = (TextView)mview.findViewById(R.id.post_title);
        post_title.setText(title);

    }






    public void setDesc(String desc){

        TextView post_desc = (TextView)mview.findViewById(R.id.post_description);
        post_desc.setText(desc);

    }





    public void setImage(Context ctx, String image){

        ImageView post_Image=(ImageView)mview.findViewById(R.id.post_image);
        Picasso.with(ctx).load(image).into(post_Image);




    }





    @Override
    public void onClick(View view) {

        ItemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
