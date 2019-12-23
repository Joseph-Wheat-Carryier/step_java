package day18.WeChatOnConsole;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Users implements Runnable {

    private UsersData usersData = null;

    InputStream inputStream;

    OutputStream outputStream;

    DataInputStream dataIn;

    DataOutputStream dataout;

    /**
     * To confirm if the account to be registered has been used;
     *
     * @param account:the account to be confirmed
     */

    public static boolean accountRepeat(String account) {
        try (InputStream inputStream = new FileInputStream("target/generated-sources/WeChatOnConsole/UserDabaBase");
             ObjectInputStream objInput = new ObjectInputStream(inputStream)
        ) {
            while (true) {
                try {
                    UsersData usersData = (UsersData) objInput.readObject();
                    if(usersData==null)
                        return true;
                    if (usersData.getAccount().equals(account)) {
                        return false;
                    }
                } catch (EOFException e) {
                    System.out.println("空了");
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    Users(Socket socket) throws IOException {

        inputStream = socket.getInputStream();

        outputStream = socket.getOutputStream();

        dataIn = new DataInputStream(inputStream);

        dataout = new DataOutputStream(outputStream);
    }

    public UsersData getUsersData() {
        return usersData;
    }

    public UsersData select(String name) {
        try (InputStream inputStream =
                     new FileInputStream(new File("target/generated-sources/WeChatOnConsole/UserDabaBase"));
             ObjectInputStream objectStream = new ObjectInputStream(inputStream)) {

            UsersData usersData;
            while (true) {
                try {
                    usersData = (UsersData) objectStream.readObject();
                    if (usersData.getAccount().equals(name)) {
                        return usersData;
                    }
                } catch (EOFException a) {
                    return null;
                }
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public UsersData regist() throws IOException {
        String account;
        String passWord;
        String nickName;
        UsersData usersData = new UsersData();

        do {
            while (true) {
                dataout.writeUTF("输入用户名:");
                account = dataIn.readUTF();
                if (accountRepeat(account)) {
                    dataout.writeUTF("用户名已经被注册,请重新输入");
                } else {
                    break;
                }
            }

            do {
                dataout.writeUTF("请输入密码:");
                passWord = dataIn.readUTF();
                dataout.writeUTF("请确认");
            } while (!passWord.equals(dataIn.readUTF()));

            dataout.writeUTF("输入昵称");
            nickName = dataIn.readUTF();


            assert usersData != null;
            usersData = usersData.regist(account, passWord, nickName);

        } while (usersData == null);

        try (
                ObjectOutputStream objStream =
                        new ObjectOutputStream(new FileOutputStream(new File("target/generated-sources/WeChatOnConsole/UserDabaBase"),true))) {
            objStream.writeObject(usersData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersData;
    }

    boolean login() throws IOException {
        String passWord;

        dataout.writeUTF("欢迎来到Console聊天室,请输入任意键登陆,输入regist注册");

        if (dataIn.readUTF().equals("regist")) {
            usersData = regist();
            dataout.writeUTF(String.format("注册成功,欢迎%s", usersData.getNickName()));
            return true;
        } else {
            while (usersData == null) {
                dataout.writeUTF("账号:");
                String accout = dataIn.readUTF();
                dataout.writeUTF("密码:");
                passWord = dataIn.readUTF();
                usersData = select(accout);
                if (usersData == null)
                    dataout.writeUTF("没有此账号!");
                if (!usersData.getPassWord().equals(passWord)) {
                    dataout.writeUTF("账号/密码错误!");
                    usersData = null;
                }
            }

            dataout.writeUTF(String.format("登陆成功,欢迎%s", usersData.getNickName()));
            return true;
        }
    }

    @Override
    public void run() {
        try {
            login();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
