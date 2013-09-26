/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufhci.kishore;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kishore
 */
public class taskSuper {
    private static taskSuper myInst = null;
    public String resLocal;
    private int currentTaskID =0;
    private boolean practice = true;
    
    private taskSuper(){
        
    }
    
    public static taskSuper getInstance(){
        if(myInst == null) {
            myInst = new taskSuper();
        }
        return myInst;
    }
    
    protected void reportAction(String source){
        if(source.equalsIgnoreCase("call")){
            if((currentTaskID == 0 && practice == true) || (currentTaskID == 7 && practice == false)){
                resLocal = resLocal + " Action Report : " + source + "\t"+ new Date().toString() + "\n";
                resLocal = resLocal + "\nCompleted Task : "+currentTaskID+"\t"+ new Date().toString() + "\n";
                currentTaskID++;
                IMinterface.updateDisplay(practice, currentTaskID);
                resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString()+"\n";
            }else{
                resLocal = resLocal + " ERROR Action Report : " + source + "\t"+ new Date().toString() + "\n";
            }            
        }else if(source.equalsIgnoreCase("endcall")){
            if((currentTaskID == 1 && practice == true) || (currentTaskID == 8 && practice == false)){
                resLocal = resLocal + " Action Report : " + source + "\t"+ new Date().toString() + "\n";
                resLocal = resLocal + "\nCompleted Task : "+currentTaskID+"\t"+ new Date().toString() + "\n";
                currentTaskID++;
                IMinterface.updateDisplay(practice, currentTaskID);
                resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString()+"\n";
            }else{
                resLocal = resLocal + " ERROR Action Report : " + source + "\t"+ new Date().toString() + "\n";
            }
        }else if(source.equalsIgnoreCase("combobox")){
            if((currentTaskID == 2 && practice == true) || (currentTaskID == 9 && practice == false)){
                resLocal = resLocal + " Action Report : " + source + "\t"+ new Date().toString() + "\n";
                resLocal = resLocal + "\nCompleted Task : "+currentTaskID+"\t"+ new Date().toString() + "\n";
                currentTaskID++;
                if(currentTaskID != 10){
                    IMinterface.updateDisplay(practice, currentTaskID);
                    resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString()+"\n";
                }
            }else{
                resLocal = resLocal + " ERROR Action Report : " + source + "\t"+ new Date().toString() + "\n";
            }
        }else if(source.equalsIgnoreCase("searchcon")){
            if((currentTaskID == 3 && practice == true) || (currentTaskID == 6 && practice == false)){
                resLocal = resLocal + " Action Report : " + source + "\t"+ new Date().toString() + "\n";
                resLocal = resLocal + "\nCompleted Task : "+currentTaskID+"\t"+ new Date().toString() + "\n";
                currentTaskID++;
                IMinterface.updateDisplay(practice, currentTaskID);
                resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString()+"\n";
            }else{
                resLocal = resLocal + " ERROR Action Report : " + source + "\t"+ new Date().toString() + "\n";
            }
        }else if(source.equalsIgnoreCase("send")){
            if((currentTaskID == 4 && practice == true) || (currentTaskID == 1 && practice == false)){
                resLocal = resLocal + " Action Report : " + source + "\t"+ new Date().toString() + "\n";
                resLocal = resLocal + "\nCompleted Task : "+currentTaskID+"\t"+ new Date().toString() + "\n";
                currentTaskID++;
                IMinterface.updateDisplay(practice, currentTaskID);
                resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString()+"\n";
            }else{
                resLocal = resLocal + " ERROR Action Report : " + source + "\t"+ new Date().toString() + "\n";
            }
        }else if(source.equalsIgnoreCase("save")){
            if((currentTaskID == 5 && practice == true) || (currentTaskID == 2 && practice == false)){
                resLocal = resLocal + " Action Report : " + source + "\t"+ new Date().toString() + "\n";
                resLocal = resLocal + "\nCompleted Task : "+currentTaskID+"\t"+ new Date().toString() + "\n";
                currentTaskID++;
                IMinterface.updateDisplay(practice, currentTaskID);
                resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString()+"\n";
            }else{
                resLocal = resLocal + " ERROR Action Report : " + source + "\t"+ new Date().toString() + "\n";
            }
        }else if(source.equalsIgnoreCase("add")){
            if((currentTaskID == 6 && practice == true) || (currentTaskID == 0 && practice == false)){
                resLocal = resLocal + " Action Report : " + source + "\t"+ new Date().toString() + "\n";
                resLocal = resLocal + "\nCompleted Task : "+currentTaskID+"\t"+ new Date().toString() + "\n";
                currentTaskID++;
                IMinterface.updateDisplay(practice, currentTaskID);
                resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString()+"\n";
            }else{
                resLocal = resLocal + " ERROR Action Report : " + source + "\t"+ new Date().toString() + "\n";
            }
        }else if(source.equalsIgnoreCase("view")){
            if((currentTaskID == 7 && practice == true) || (currentTaskID == 3 && practice == false)){
                resLocal = resLocal + " Action Report : " + source + "\t"+ new Date().toString() + "\n";
                resLocal = resLocal + "\nCompleted Task : "+currentTaskID+"\t"+ new Date().toString() + "\n";
                currentTaskID++;
                IMinterface.updateDisplay(practice, currentTaskID);
                resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString()+"\n";
            }else{
                resLocal = resLocal + " ERROR Action Report : " + source + "\t"+ new Date().toString() + "\n";
            }
        }else if(source.equalsIgnoreCase("searchchat")){
            if((currentTaskID == 8 && practice == true) || (currentTaskID == 4 && practice == false)){
                resLocal = resLocal + " Action Report : " + source + "\t"+ new Date().toString() + "\n";
                resLocal = resLocal + "\nCompleted Task : "+currentTaskID+"\t"+ new Date().toString() + "\n";
                currentTaskID++;
                IMinterface.updateDisplay(practice, currentTaskID);
                resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString()+"\n";
            }else{
                resLocal = resLocal + " ERROR Action Report : " + source + "\t"+ new Date().toString() + "\n";
            }
        }else if(source.equalsIgnoreCase("delete")){
            if((currentTaskID == 9 && practice == true) || (currentTaskID == 5 && practice == false)){
                resLocal = resLocal + " Action Report : " + source + "\t"+ new Date().toString() + "\n";
                resLocal = resLocal + "\nCompleted Task : "+currentTaskID+"\t"+ new Date().toString() + "\n";
                currentTaskID++;
                if(currentTaskID != 10){
                    IMinterface.updateDisplay(practice, currentTaskID);
                    resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString()+"\n";
                }
            }else{
                resLocal = resLocal + " ERROR Action Report : " + source + "\t"+ new Date().toString() + "\n";
            }
        }else{
            resLocal = resLocal + " ERROR Action Report : " + source + "\t"+ new Date().toString() + "\n";
        }
        if(currentTaskID == 10){
            if(practice == true){
                resLocal = resLocal + "\n\n\t\t COMPLETED PRATICE ROUND \n\n";
                IMinterface.updateCommand(1);
                IMinterface.updateDisplay(practice, 77);
            }else{
                resLocal = resLocal + "\n\n\t\t COMPLETED RECORDED ROUND \n\n";
                IMinterface.Result = IMinterface.Result + resLocal;
                IMinterface.updateCommand(2);
                IMinterface.updateDisplay(practice, 77);
            }
        }
    }
    
    protected void startPracticeTaskList(){
        IMinterface.updateCommand(99);
        resLocal = resLocal + "\n\n\t\t STARTING PRATICE ROUND \n\n";
        resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString();
        IMinterface.updateDisplay(practice, currentTaskID);
    }
    
    protected void startTaskList(){
        IMinterface.updateCommand(99);
        practice = false;
        currentTaskID =0;
        resLocal = resLocal + "\n\n\t\t STARTING RECORDED ROUND \n\n";
        resLocal = resLocal + "\nStarting new Task : "+currentTaskID+"\t"+ new Date().toString();
        IMinterface.updateDisplay(practice, currentTaskID);
    }
    
    protected void skipTask(){
        resLocal = resLocal + "\n ERROR Skipping the current task : "+currentTaskID+"\t"+ new Date().toString();
        currentTaskID++;
    }
}
