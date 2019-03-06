//package com.citizenzet.myapplication.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.citizenzet.myapplication.R;
//import com.citizenzet.restclient.model.Sample;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleViewHolder> {
//
//    private List<Sample> items = new ArrayList<>();
//
//    private Context context;
//
//    public static final String IMAGE_URL_BASE_PATH="http://concepture.club";
//
//    public SampleAdapter(Context context) {
//
//        this.context = context;
//
//    }
//
//    public void setItems(Collection<Sample> tweets) {
//        items.addAll(tweets);
//        notifyDataSetChanged();
//    }
//
//    public void clearItems() {
//        items.clear();
//        notifyDataSetChanged();
//    }
//
////A view holder inner class where we get reference to the views in the layout using their ID
//
//    public static class SampleViewHolder extends RecyclerView.ViewHolder {
//
//
//        TextView text;
//
//
//        ImageView image;
//
//        public SampleViewHolder(View v) {
//
//            super(v);
//
//
//            image = (ImageView) v.findViewById(R.id.image);
//
//            text = (TextView) v.findViewById(R.id.text);
//
//
//        }
//
//    }
//
//    @Override
//
//    public SampleAdapter.SampleViewHolder onCreateViewHolder(ViewGroup parent,
//
//                                                             int viewType) {
//
//        View view = LayoutInflater.from(
//                parent.getContext()).
//                inflate(
//                        R.layout.recycler_view_item,
//                        parent,
//                        false);
//
//        return new SampleViewHolder(view);
//
//    }
//
//    @Override
//
//    public void onBindViewHolder(SampleViewHolder holder, final int position) {
//
//        //String image_url = IMAGE_URL_BASE_PATH + items.get(position).getPosterPath();
//
//        String image_url = IMAGE_URL_BASE_PATH + "/common/uploads/articles/726/1551060535.jpg";
//
//        Picasso.with(context)
//
//                .load(image_url)
//
//                .placeholder(android.R.drawable.sym_def_app_icon)
//
//                .error(android.R.drawable.sym_def_app_icon)
//
//                .into(holder.image);
//
//        holder.text.setText(items.get(position).getTitle());
//
//
//    }
//
//    @Override
//
//    public int getItemCount() {
//
//        return items.size();
//
//    }
//
//}