package com.core.java.v2.v2ch01. match;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * The type Href match.
 */
public class HrefMatch
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      try
      {
         // get URL string from command line or use default
         String urlString;
         if (args.length > 0) urlString = args[0];
         else urlString = "http://java.sun.com";

         // open reader for URL
         InputStreamReader in = new InputStreamReader(new URL(urlString).openStream());

         // read contents into string builder
         StringBuilder input = new StringBuilder();
         int ch;
         while ((ch = in.read()) != -1)
            input.append((char) ch);

         // search for all occurrences of pattern
         String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
         Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
         Matcher matcher = pattern.matcher(input);

         while (matcher.find())
         {
            int start = matcher.start();
            int end = matcher.end();
            String match = input.substring(start, end);
            System.out.println(match);
         }
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      catch (PatternSyntaxException e)
      {
         e.printStackTrace();
      }
   }
}
