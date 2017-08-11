package com.core.java.v2.v2ch09. auth;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.security.PrivilegedAction;

/**
 * The type Auth test.
 */
public class AuthTest
{
   /**
    * Main.
    *
    * @param args the args
    */
   public static void main(final String[] args)
   {
      System.setSecurityManager(new SecurityManager());
      try
      {
         LoginContext context = new LoginContext("Login1");
         context.login();
         System.out.println("Authentication successful.");
         Subject subject = context.getSubject();
         System.out.println("subject=" + subject);
         PrivilegedAction<String> action = new SysPropAction("user.home");
         String result = Subject.doAsPrivileged(subject, action, null);
         System.out.println(result);
         context.logout();
      }
      catch (LoginException e)
      {
         e.printStackTrace();
      }
   }
}
