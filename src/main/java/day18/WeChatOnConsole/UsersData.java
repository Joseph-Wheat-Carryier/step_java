package day18.WeChatOnConsole;

import java.io.*;

public class UsersData implements Serializable {
    private String account;
    private  String passWord;
    private  String nickName;

    public  UsersData regist(String account,String passWord,String nickName){
        if(account==null||passWord==null||nickName==null){
            System.out.println("账号密码和昵称不能为空!");
            return null;
        }
        this.account = account;
        this.passWord= passWord;
        this.nickName = nickName;
        return this;
    }


    public String getAccount() {
        return account;
    }


    public String getPassWord() {
        return passWord;
    }


    public String getNickName() {
        return nickName;
    }

}
