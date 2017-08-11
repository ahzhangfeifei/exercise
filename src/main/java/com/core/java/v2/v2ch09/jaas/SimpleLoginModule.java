package com.core.java.v2.v2ch09. jaas;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * The type Simple login module.
 */
public class SimpleLoginModule implements LoginModule
{
   private Subject subject;
   private CallbackHandler callbackHandler;
   private Map<String, ?> options;

   public void initialize(Subject subject, CallbackHandler callbackHandler,
         Map<String, ?> sharedState, Map<String, ?> options)
   {
      this.subject = subject;
      this.callbackHandler = callbackHandler;
      this.options = options;
   }

   public boolean login() throws LoginException
   {
      if (callbackHandler == null) throw new LoginException("no handler");

      NameCallback nameCall = new NameCallback("username: ");
      PasswordCallback passCall = new PasswordCallback("password: ", false);
      try
      {
         callbackHandler.handle(new Callback[] { nameCall, passCall });
      }
      catch (UnsupportedCallbackException e)
      {
         LoginException e2 = new LoginException("Unsupported callback");
         e2.initCause(e);
         throw e2;
      }
      catch (IOException e)
      {
         LoginException e2 = new LoginException("I/O exception in callback");
         e2.initCause(e);
         throw e2;
      }

      try
      {
         return checkLogin(nameCall.getName(), passCall.getPassword());
      }
      catch (IOException ex)
      {
         LoginException ex2 = new LoginException();
         ex2.initCause(ex);
         throw ex2;
      }
   }

   private boolean checkLogin(String username, char[] password) throws LoginException, IOException
   {
      try (Scanner in = new Scanner(Paths.get("" + options.get("pwfile"))))
      {
         while (in.hasNextLine())
         {
            String[] inputs = in.nextLine().split("\\|");
            if (inputs[0].equals(username) && Arrays.equals(inputs[1].toCharArray(), password))
            {
               String role = inputs[2];
               Set<Principal> principals = subject.getPrincipals();
               principals.add(new SimplePrincipal("username", username));
               principals.add(new SimplePrincipal("role", role));
               return true;
            }
         }
         return false;
      }
   }

   public boolean logout()
   {
      return true;
   }

   public boolean abort()
   {
      return true;
   }

   public boolean commit()
   {
      return true;
   }
}
