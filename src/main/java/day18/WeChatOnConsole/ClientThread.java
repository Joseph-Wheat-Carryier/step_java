package day18.WeChatOnConsole;

import java.util.HashMap;

public class ClientThread {
    HashMap<String,Thread> threadMap= new HashMap<>();

    void addTread(String account,Thread t){
        threadMap.put(account,t);
    }

    void startTread(String account){
        threadMap.get(account).start();
    }
}
