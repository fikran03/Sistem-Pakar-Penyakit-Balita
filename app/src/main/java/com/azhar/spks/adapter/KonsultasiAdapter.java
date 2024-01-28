package com.azhar.spks.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.azhar.spks.R;
import com.azhar.spks.model.ModelKonsultasi;

import java.util.ArrayList;


public class KonsultasiAdapter extends RecyclerView.Adapter<KonsultasiAdapter.KonsultasiHolder> {

    int varGlobal = 0;
    private Context ctx;
    private static ArrayList<ModelKonsultasi> modelKonsultasiArrayList;

    public KonsultasiAdapter(Context context, ArrayList<ModelKonsultasi> items) {
        this.ctx = context;
        this.modelKonsultasiArrayList = new ArrayList<>();
        this.modelKonsultasiArrayList.addAll(items);
    }

    @Override
    public KonsultasiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gejala, parent, false);
        return new KonsultasiHolder(view);
    }

    @Override
    public void onBindViewHolder(KonsultasiHolder holder, @SuppressLint("RecyclerView") final int position) {
        final ModelKonsultasi data = modelKonsultasiArrayList.get(position);

        holder.bind(data, position);
    }

    @Override
    public int getItemCount() {
        return modelKonsultasiArrayList.size();
    }

    class KonsultasiHolder extends RecyclerView.ViewHolder {
        CheckBox cbGejala;

        public KonsultasiHolder(View itemView) {
            super(itemView);
            cbGejala = itemView.findViewById(R.id.cbGejala);
        }

        void bind(ModelKonsultasi data, int position) {
            cbGejala.setOnCheckedChangeListener(null); // Remove previous listener to avoid conflicts

            cbGejala.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton checkboxView, boolean isChecked) {
                    ModelKonsultasi modelKonsultasi = (ModelKonsultasi) checkboxView.getTag();

                    // Logic for checkboxes 1-6 and 4,7,8,9,10,11,12 exclusion
//                    if (position < 6) {
//                        // If checkboxes 1-6 are checked, disable checkboxes 7-20
//                        for (int i = 6; i < modelKonsultasiArrayList.size(); i++) {
//                            modelKonsultasiArrayList.get(i).setEnabled(!isChecked);
//                            modelKonsultasiArrayList.get(i).setSelected(false);
//                            notifyItemChanged(i);
//                        }
//                    }
//                    // Logic for checkboxes 4,12,13,14,15,16 exclusion
//                    if ((position == 3 || position == 11 || (position >= 12 && position <= 16)) && isChecked) {
//                        // If checkboxes 4,12,13,14,15,16 are checked, disable checkboxes 1-3,5,6,17-20
//                        for (int i = 0; i < 7; i++) {
//                            modelKonsultasiArrayList.get(i).setEnabled(false);
//                            modelKonsultasiArrayList.get(i).setSelected(false);
//                            notifyItemChanged(i);
//                        }
//                        for (int i = 4; i <= 6; i++) {
//                            modelKonsultasiArrayList.get(i).setEnabled(false);
//                            modelKonsultasiArrayList.get(i).setSelected(false);
//                            notifyItemChanged(i);
//                        }
//                        for (int i = 16; i < modelKonsultasiArrayList.size(); i++) {
//                            modelKonsultasiArrayList.get(i).setEnabled(false);
//                            modelKonsultasiArrayList.get(i).setSelected(false);
//                            notifyItemChanged(i);
//                        }
//                    }
//
//
//                    // Logic for checkboxes 8,9,17,18,19,20 exclusion
//                    if ((position == 7 || position == 8 || (position >= 16 && position <= 19)) && isChecked) {
//                        // If checkboxes 8,9,17,18,19,20 are checked, disable checkboxes 1-7,10-16
//                        for (int i = 0; i <= 6; i++) {
//                            modelKonsultasiArrayList.get(i).setEnabled(false);
//                            modelKonsultasiArrayList.get(i).setSelected(false);
//                            notifyItemChanged(i);
//                        }
//                        for (int i = 9; i <= 15; i++) {
//                            modelKonsultasiArrayList.get(i).setEnabled(false);
//                            modelKonsultasiArrayList.get(i).setSelected(false);
//                            notifyItemChanged(i);
//                        }
//                    }

                    // Rest of your existing code...
                    // ...

                    if (varGlobal >= 20) {
                        Toast.makeText(ctx, "Maaf Maksimal 2 Pilihan Saja", Toast.LENGTH_LONG).show();
                        checkboxView.setChecked(false);
                        varGlobal--;
                    } else {
                        modelKonsultasi.setSelected(isChecked);
                    }
                }
            });

            cbGejala.setText(data.getStrGejala());
            cbGejala.setChecked(data.isSelected());
            cbGejala.setTag(data);

            // Disable checkboxes 7-20 if checkboxes 1-6 are checked
            if (position >= 6 &&
                    modelKonsultasiArrayList.get(0).isSelected() ||
                    modelKonsultasiArrayList.get(1).isSelected() ||
                    modelKonsultasiArrayList.get(2).isSelected() ||
                    modelKonsultasiArrayList.get(3).isSelected() ||
                    modelKonsultasiArrayList.get(4).isSelected() ||
                    modelKonsultasiArrayList.get(5).isSelected()) {
                for (int i = 6; i < modelKonsultasiArrayList.size(); i++) {
                    modelKonsultasiArrayList.get(i).setEnabled(false);
                    modelKonsultasiArrayList.get(i).setSelected(false);
                    notifyItemChanged(i);
                }
                cbGejala.setEnabled(false);
                cbGejala.setSelected(false);
            }else {
                cbGejala.setEnabled(true);
            }
        }
    }
}
