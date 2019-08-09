/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gui.GUI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vank4
 */
public class ThreadTime extends Thread {

    GUI form;
    private boolean flag;

    public ThreadTime(GUI form) {
        this.form = form;
        flag = true;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            form.getTxtElapsed().setText(count+ " sec");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadTime.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (flag) count++;
        }
    }
    
    public void pause(){
        flag = false;
    }
    
    public void timeResume(){
        flag = true;
    }

}
