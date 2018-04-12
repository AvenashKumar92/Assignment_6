package com.example.avenash_2.personalizedwebapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    private static final LoginManager ourInstance = new LoginManager();
    private static List<User> users;
    private static User loginUser;
    void addUser(User user){
        users.add(user);
    }

    public static LoginManager getInstance() {
        return ourInstance;
    }

    private LoginManager() {
        users=new ArrayList<>();
        initList();
    }

    private void openActivity(Context context, Class<?> activityClass, String loginUserEmail){
        Intent intent = new Intent(context,activityClass);
        intent.putExtra(String.valueOf(R.id.wvLogin), loginUserEmail);
        context.startActivity(intent);
    }

    private boolean loginUsingSP(Context context, User expectedUser){
        String preferenceName= context.getResources().getString(R.string.preferenceName);
        SharedPreferences pref=context.getSharedPreferences(preferenceName, context.MODE_PRIVATE);

        String username=context.getResources().getString(R.string.useremail);
        String dusername=context.getResources().getString(R.string.dusername);
        String userEmail=pref.getString(username, dusername);

        if(expectedUser!=null)
            if(!expectedUser.getEmail().equalsIgnoreCase(userEmail))
                return false;

        String password=context.getResources().getString(R.string.password);
        String dpassword=context.getResources().getString(R.string.dpassword);
        String loginUserPassword=pref.getString(password, dpassword);

        loginUser=new User(userEmail, loginUserPassword);
        if(validateUser(loginUser))
            return true;

        return false;
    }

    private void initList()
    {
        addUser(new User("Avenash@yahoo.com", "123"));
        addUser(new User("Rahul@yahoo.com", "321"));
        addUser(new User("Rajesh@yahoo.com", "123"));
        addUser(new User("Malik@yahoo.com", "321"));
        addUser(new User("Osman@yahoo.com", "123"));
    }
    private void updateSharedFile(Context context, User loginUser){
        String preferenceName= context.getResources().getString(R.string.preferenceName);
        SharedPreferences pref=context.getSharedPreferences(preferenceName, context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();

        String username=context.getResources().getString(R.string.useremail);
        editor.putString(username, loginUser.getEmail());

        String password=context.getResources().getString(R.string.password);
        editor.putString(password, loginUser.getPassword());

        editor.commit();
    }

    public void signIn(Context context, Class<?> activityClass, User user) throws LoginException{
        if(loginUsingSP(context, user)) {
            openActivity(context,activityClass, loginUser.getEmail());
            return;
        }


        else if(validateUser(user)){
            updateSharedFile(context,user);
            openActivity(context, activityClass, user.getEmail());
        }
        else
            throw new LoginException("Invalid email or password");
    }

    public void logout(Context context){
        String preferencesName=context.getResources().getString(R.string.preferenceName);
        SharedPreferences sharedPreferences=context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.remove(context.getResources().getString(R.string.useremail));
        editor.remove(context.getResources().getString(R.string.password));
        editor.commit();
    }
    private boolean validateUser(User loginUser){
        for(User user:users){
            if(user.equals(loginUser)){
                return true;
            }
        }
        return false;
    }
}
