package com.example.healthcareapp_mvvm_architecture;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.textViewName.setText(currentNote.getName());
        holder.textViewGender.setText(currentNote.getGender());
        holder.textViewAppointmentDate.setText((CharSequence) currentNote.getAppointmentDate());
        holder.textViewBirthDate.setText(currentNote.getBirthDate());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position) {
        return notes.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewGender;
        private TextView textViewAppointmentDate;
        private TextView textViewBirthDate;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewGender = itemView.findViewById(R.id.text_view_gender);
            textViewAppointmentDate = itemView.findViewById(R.id.text_view_appointmentdate);
            textViewBirthDate = itemView.findViewById(R.id.text_view_birthdate);
        }
    }
}
