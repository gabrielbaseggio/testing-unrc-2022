package testing.graph.ejercicio4;

import java.io.FileNotFoundException;
import java.io.PrintStream;

// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 7, page 141; chapter 9, page 256
// Can be run from command line
// See PatternIndexTest.java, DataDrivenPatternIndexTest.java  for JUnit tests

public class PatternIndex
{

   public static void main (String[] argv)
   {
      if (argv.length != 2)
      {
         System.out.println
            ("java PatternIndex Subject Pattern");
         return;
      }
      String subject = argv[0];
      String pattern = argv[1];
      int n = 0;
      if ((n = patternIndex (subject, pattern)) == -1)
         System.out.println
         ("Pattern string is not a substring of the subject string");
      else
         System.out.println
         ("Pattern string begins at character " + n);
   }
   
  /**
    * Find index of pattern in subject string
    * 
    * @param subject String to search
    * @param pattern String to find
    * @return index (zero-based) of first occurrence of pattern in subject; -1 if not found
    * @throws NullPointerException if subject or pattern is null
    */
   public static int patternIndex (String subject, String pattern)
   {
	  System.out.print("1,");
	  
      final int NOTFOUND = -1;
      int  iSub = 0, rtnIndex = NOTFOUND;
      boolean isPat  = false;
      int subjectLen = subject.length();
      int patternLen = pattern.length();
   
      System.out.print("2,");
      
      while (isPat == false && iSub + patternLen - 1 < subjectLen)
      {
    	  
    	 System.out.print("3,");
         if (subject.charAt(iSub) == pattern.charAt(0))
         {
            rtnIndex = iSub; // Starting at zero
            isPat = true;
            System.out.print("4,");
            for (int iPat = 1; iPat < patternLen; iPat ++)
            {
               System.out.print("5,");
               if (subject.charAt(iSub + iPat) != pattern.charAt(iPat))
               {
                  rtnIndex = NOTFOUND;
                  isPat = false;
                  /* MB: isPat = true; */
                  System.out.print("6,");
                  break;  // out of for loop
               }
               
               System.out.print("7,4,");
            }
         }
         
         iSub ++;
         System.out.print("8,2,");
      }
      
      System.out.println("9");
      return (rtnIndex);
   }
}
