package org.vvvxd.Hibernate_CRUD_Java;


import org.vvvxd.Hibernate_CRUD_Java.view.MainView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MainView mainView = new MainView();
        mainView.startApp();
    }

}
