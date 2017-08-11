package com.core.java.v2.v2ch09. jaas;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;

/**
 * The type Simple callback handler.
 */
public class SimpleCallbackHandler implements CallbackHandler
{
   private String username;
   private char[] password;

   /**
    * Instantiates a new Simple callback handler.
    *
    * @param username the username
    * @param password the password
    */
   public SimpleCallbackHandler(String username, char[] password)
   {
      this.username = username;
      this.password = password;
   }

   public void handle(Callback[] callbacks)
   {
      for (Callback callback : callbacks)
      {
         if (callback instanceof NameCallback)
         {
            ((NameCallback) callback).setName(username);
         }
         else if (callback instanceof PasswordCallback)
         {
            ((PasswordCallback) callback).setPassword(password);
         }
      }
   }
}
