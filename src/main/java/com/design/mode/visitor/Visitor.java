package com.design.mode.visitor;

/**
 * The type Visitor.
 */
public abstract class Visitor
{
  /**
   * Visit.
   *
   * @param emp the emp
   */
  public abstract void visit(Employee emp);

  /**
   * Visit.
   *
   * @param emp the emp
   */
  public abstract void visit(Boss emp);
}
