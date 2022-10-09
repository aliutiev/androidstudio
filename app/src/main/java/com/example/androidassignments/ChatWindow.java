package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    //initialize variables
    ListView listView;
    EditText editText;
    Button sendButton;

    ChatAdapter messageHandler;

    // private class
    ArrayList<String> messageList = new ArrayList<String>();

    protected static final String ACTIVITY_NAME = "ChatWindow";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        messageHandler = new ChatAdapter(this);
        listView = findViewById(R.id.chatView);
        editText = findViewById(R.id.editTextChatWindow);
        sendButton = findViewById(R.id.sendButton);


        final ChatAdapter messageAdapter = new ChatAdapter(this);
        listView.setAdapter(messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chat = editText.getText().toString();
                messageList.add(chat);
                messageAdapter.notifyDataSetChanged();
                editText.setText(""); // Set text to empty strings after message sent
            }
        });

    }

    private class ChatAdapter extends ArrayAdapter<String> {
        public ChatAdapter(Context ctx){
            super(ctx,0);
        }

        public String getItem(int position){
            return messageList.get(position);
        }

        public int getCount(){
            return messageList.size();
        }

        public View getView(int position, View convertView, ViewGroup parent){
            View result; // Initialize view
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

            // Decide if the message will appear on incoming or outgoing side
            result = inflater.inflate(position % 2 == 0? R.layout.chat_row_incoming: R.layout.chat_row_outgoing, null );

            TextView message = (TextView) result.findViewById(R.id.message_text);
            message.setText(getItem(position));

            return result;
        }

//        @Override
//        public long getItemId(int position) {
//            messageCursor.moveToPosition(position);
//
//            int messageID = messageCursor.getInt(messageCursor.getColumnIndex(ChatDatabaseHelper.KEY_ID));
//            Log.i(ACTIVITY_NAME, "Position: " + position +  " Message ID: " + messageID );
//
//            return messageID;
//        }
    }

    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume() CW");

    }

    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart() CW");

    }

    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause() CW");

    }
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop() CW");

    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy() CW");

    }
}