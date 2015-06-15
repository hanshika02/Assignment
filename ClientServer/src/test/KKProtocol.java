package test;

public class KKProtocol {
	
	    private static final int START = 0;
	    private static final int INITIATE = 1;
	    private static final int SENTACK = 2;
	    private static final int TERMINATE = 3;
	    private int state = START;
	 
	    public String processInput(String theInput) {
	        String theOutput = null;
	 
	        if (state == START) {
	            theOutput = "Welcome!!!";
	            state = INITIATE;
	        } 
	        else if (state == INITIATE) {
	            if (theInput.contains("Hello")||theInput.contains("hello")) {
	                theOutput = "ACK";
	                state = SENTACK;
	            } 
	            else
	            {
	            	theOutput="TERMINATED";
	            	state=TERMINATE;
	            }
	        } 
	        else if(state==SENTACK){
	        	theOutput="Done.";
	        	state=TERMINATE;
	        }
	        else if(state==TERMINATE){
	        	theOutput="TERMINATED";
	        }
	        
	        return theOutput;
	    }
	    
	    public String getName(String theInput){
	    	return (theInput.substring(14, theInput.length()));
	    }
	}
