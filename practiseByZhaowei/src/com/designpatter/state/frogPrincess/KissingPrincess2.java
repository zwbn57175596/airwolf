package com.designpatter.state.frogPrincess;

public class KissingPrincess2 {  
      
    private State state = new Frog();  
      
    public void greet() {  
        state.response();  
    }  
      
    public void change(State state) {  
        this.state = state;  
    }  
      
    public static void main(String[] args) {  
        KissingPrincess2 prince2 = new KissingPrincess2();  
        prince2.greet();  
        prince2.change(new Prince());  
        prince2.greet();  
    }  
} 

