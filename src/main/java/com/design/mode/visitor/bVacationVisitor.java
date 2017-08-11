package com.design.mode.visitor;

/**
 * The type B vacation visitor.
 */
public class bVacationVisitor extends Visitor
{
    /**
     * The Total days.
     */
    int total_days;

    /**
     * Instantiates a new B vacation visitor.
     */
    public bVacationVisitor()
  {
  total_days = 0;
  }

    /**
     * Gets total days.
     *
     * @return the total days
     */
//-----------------------------
  public int getTotalDays()
  {
     return total_days;
  }
//--------------------------------
 public void visit(Boss boss)
 {
    total_days += boss.getVacDays();
    total_days += boss.getBonusDays();
    }                             
  //-----------------------------
 public void visit(Employee emp)
 {
    total_days += emp.getVacDays();
 }
}
