package Bai2;

import java.util.Timer;
import java.util.TimerTask;

public class timer 
{
  Timer timer;

  public timer (int seconds)   
  {
    timer = new Timer() ;
    timer.schedule(new ToDoTask() , seconds*1000) ;
  }

  class ToDoTask extends TimerTask {
    public void run ()   
    {
      timer.cancel () ; //Terminate the thread
    }
  }

}