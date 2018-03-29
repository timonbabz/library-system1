/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarySystemcodes;

import java.io.IOException;

/**
 *
 * @author user
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class SplashLibrary {
    public static void main (String[]args) throws IOException{
        LibSplash homesplash = new LibSplash();
        homesplash.setVisible(true);
        LibrarySignIn home = new LibrarySignIn();
        
        try{
        for(int i = 0;i<=100;i++){
        Thread.sleep(40);
        homesplash.lblLoad.setText(Integer.toString(i)+"%");
        homesplash.progressBar.setValue(i);
        
        if (i == 100){
        homesplash.setVisible(false);
        home.setVisible(true);
        }
        //end of if clause
        }
        //end of try
        }catch(Exception e){}
    }
}