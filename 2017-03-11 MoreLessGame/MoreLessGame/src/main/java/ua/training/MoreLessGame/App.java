package ua.training.MoreLessGame;

import controller.Controller;
import view.View;

public class App 
{
    public static void main( String[] args )
    {
        //Controller.play();
        System.out.format("%d %d", 0, 1);
    	mformat("%d %d", 0, 1);
    }
    
    public static void mformat(String message, int ... args) {
		System.out.format(message, args);
	}
	
}
