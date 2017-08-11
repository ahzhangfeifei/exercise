package com.core.java.v1.v1ch09. dataExchange;

/**
 * The type User.
 */
public class User
{
   private String name;
   private char[] password;

   /**
    * Instantiates a new User.
    *
    * @param aName     the a name
    * @param aPassword the a password
    */
   public User(String aName, char[] aPassword)
   {
      name = aName;
      password = aPassword;
   }

   /**
    * Gets name.
    *
    * @return the name
    */
   public String getName()
   {
      return name;
   }

   /**
    * Get password char [ ].
    *
    * @return the char [ ]
    */
   public char[] getPassword()
   {
      return password;
   }

   /**
    * Sets name.
    *
    * @param aName the a name
    */
   public void setName(String aName)
   {
      name = aName;
   }

   /**
    * Sets password.
    *
    * @param aPassword the a password
    */
   public void setPassword(char[] aPassword)
   {
      password = aPassword;
   }
}
