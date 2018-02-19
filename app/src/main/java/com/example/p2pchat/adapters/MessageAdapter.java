package com.example.p2pchat.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.p2pchat.R;
import com.example.p2pchat.models.Message;

public class MessageAdapter extends ArrayAdapter<Message> {

    public MessageAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message, parent, false);
        }
        Message current = getItem(position);

        TextView username = convertView.findViewById(R.id.username);
        username.setText(current.getUsername());

        TextView text = convertView.findViewById(R.id.text);
        text.setText(current.getText());

        return convertView;
    }
}
