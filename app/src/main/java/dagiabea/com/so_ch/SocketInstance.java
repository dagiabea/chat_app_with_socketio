package dagiabea.com.so_ch;

import android.app.Application;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class SocketInstance extends Application {
    private Socket iSocket;
    private static final String URL ="http://localhost:3000";
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            IO.Options opts = new IO.Options();
            opts.query = "auth_token=";
            iSocket = IO.socket(URL, opts);

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public Socket getSocketInstance(){
        return iSocket;
    }
}
