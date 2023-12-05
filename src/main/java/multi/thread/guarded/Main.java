package multi.thread.guarded;

import multi.thread.guarded.thread.ClientThread;
import multi.thread.guarded.thread.RequestQueue;
import multi.thread.guarded.thread.ServerThread;

public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Alice", 3141592L).start();
        new ServerThread(requestQueue, "Bobby", 6535897L).start();
    }
}
