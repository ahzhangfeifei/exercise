package com.core.java.v2.v2ch09. permissions;

import java.security.Permission;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Word check permission.
 */
public class WordCheckPermission extends Permission
{
   private String action;

   /**
    * Instantiates a new Word check permission.
    *
    * @param target   the target
    * @param anAction the an action
    */
   public WordCheckPermission(String target, String anAction)
   {
      super(target);
      action = anAction;
   }

   public String getActions()
   {
      return action;
   }

   public boolean equals(Object other)
   {
      if (other == null) return false;
      if (!getClass().equals(other.getClass())) return false;
      WordCheckPermission b = (WordCheckPermission) other;
      if (!Objects.equals(action, b.action)) return false;
      if ("insert".equals(action)) return Objects.equals(getName(), b.getName());
      else if ("avoid".equals(action)) return badWordSet().equals(b.badWordSet());
      else return false;
   }

   public int hashCode()
   {
      return Objects.hash(getName(), action);
   }

   public boolean implies(Permission other)
   {
      if (!(other instanceof WordCheckPermission)) return false;
      WordCheckPermission b = (WordCheckPermission) other;
      if (action.equals("insert"))
      {
         return b.action.equals("insert") && getName().indexOf(b.getName()) >= 0;
      }
      else if (action.equals("avoid"))
      {
         if (b.action.equals("avoid")) return b.badWordSet().containsAll(badWordSet());
         else if (b.action.equals("insert"))
         {
            for (String badWord : badWordSet())
               if (b.getName().indexOf(badWord) >= 0) return false;
            return true;
         }
         else return false;
      }
      else return false;
   }

   /**
    * Bad word set set.
    *
    * @return the set
    */
   public Set<String> badWordSet()
   {
      Set<String> set = new HashSet<>();
      set.addAll(Arrays.asList(getName().split(",")));
      return set;
   }
}
