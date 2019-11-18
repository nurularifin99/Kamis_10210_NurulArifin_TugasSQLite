package com.udinus.kamis_10210_nurularifin_tugassqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MyViewHolder> {

    private static final String TAG = MahasiswaAdapter.class.getSimpleName();
    private Context context;
    private List<MahasiswaModel> mahasiswaModelList;
    private MahasiswaAdapterCallback mahasiswaAdapterCallback;

    public MahasiswaAdapter(Context context, List<MahasiswaModel> mahasiswaModelList, MahasiswaAdapterCallback mahasiswaAdapterCallback) {
        this.context = context;
        this.mahasiswaModelList = mahasiswaModelList;
        this.mahasiswaAdapterCallback = mahasiswaAdapterCallback;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mahasiswa_card, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.snim.setText(mahasiswaModelList.get(position).getNim());
        holder.snama.setText(mahasiswaModelList.get(position).getNama());

    }

    @Override
    public int getItemCount() {
        return mahasiswaModelList.size();
    }

    public void clear() {
        int size = this.mahasiswaModelList.size();
        this.mahasiswaModelList.clear();
        notifyItemRangeRemoved(0, size);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView snim, snama;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            snim = itemView.findViewById(R.id.tnim);
            snama = itemView.findViewById(R.id.tnama);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mahasiswaAdapterCallback.onRowMahasiswaAdapterClicked(getAdapterPosition());
                }
            });
        }
    }

    public interface MahasiswaAdapterCallback{

        void onRowMahasiswaAdapterClicked(int position);
    }

}
