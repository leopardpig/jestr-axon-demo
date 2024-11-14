package com.mangomagma.jestr.axondemo.Exception;

public class JokeNotFoundException extends RuntimeException {

   private static final String JOKE_NOT_FOUND = " joke not found";

   public JokeNotFoundException() {
       super(JOKE_NOT_FOUND);
   }

}
