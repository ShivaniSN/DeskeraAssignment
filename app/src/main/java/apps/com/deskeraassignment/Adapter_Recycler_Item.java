package apps.com.deskeraassignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Adapter_Recycler_Item extends RecyclerView.Adapter<Adapter_Recycler_Item.MyViewHolder>{
    private List<ListItem> moviesList;
    protected Context context;
    private SparseBooleanArray selectedItems;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;

        public MyViewHolder(View view) {
            super(view);
            textViewTitle = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    public Adapter_Recycler_Item(List<ListItem> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public Adapter_Recycler_Item.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = null;
        View itemView = null;

        itemView   = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_itemlist, parent, false);
        viewHolder = new Adapter_Recycler_Item.MyViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter_Recycler_Item.MyViewHolder holder, int position) {
        ListItem table = moviesList.get(position);
        holder.textViewTitle.setText(table.getStringName());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return moviesList.get(position) != null ? 1 : 0;
    }

    public int getSelectedItemCount() {
        return selectedItems.size();
    }

    public List<Integer> getSelectedItems() {
        List<Integer> items =
                new ArrayList<Integer>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); i++) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }
}
