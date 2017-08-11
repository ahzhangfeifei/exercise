package com.design.mode.visitor;

/**
 * The type Boss.
 */
public class Boss extends Employee
{
   private int bonusDays;

   /**
    * Instantiates a new Boss.
    *
    * @param name     the name
    * @param salary   the salary
    * @param vacdays  the vacdays
    * @param sickdays the sickdays
    */
   public Boss(String name, float salary, int vacdays, int sickdays)
   {
      super(name, salary, vacdays, sickdays);
   }

   /**
    * Sets bonus days.
    *
    * @param bonus the bonus
    */
   public void setBonusDays(int bonus)
   {
      bonusDays = bonus;
   }

   /**
    * Gets bonus days.
    *
    * @return the bonus days
    */
   public int getBonusDays()
   {
      return bonusDays;
   }   
   public void accept(Visitor v)
   {
      v.visit(this);
   }
}
