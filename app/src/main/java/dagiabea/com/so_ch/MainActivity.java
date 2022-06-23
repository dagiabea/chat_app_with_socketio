package dagiabea.com.so_ch;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class MainActivity extends AppCompatActivity {


    private Socket mSocket;
    {
        try {
            //mSocket = IO.socket("http://192.168.137.1:3000");
            mSocket = IO.socket("http://10.240.72.36:5000/userOperator");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSocket.connect();
        mSocket.emit("info","B23456","CAR");
        //mSocket.emit("Participant: ","CAR");

        if(mSocket.connected()){
            //mSocket.emit("messages","selam");
            Toast.makeText(this, "connected", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "not connected", Toast.LENGTH_LONG).show();
        }

        
    }
}