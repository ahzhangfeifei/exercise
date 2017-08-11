package com.design.mode.composite;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.Enumeration;
//swing classes

/**
 * 组合模式
 *
 * Created by zhangfeifei on 2016/12/08.
 */

public class empTree extends JxFrame
   implements TreeSelectionListener
{
    /**
     * The Boss.
     */
    Employee boss, /**
 * The Market vp.
 */
marketVP, /**
 * The Prod vp.
 */
prodVP;
    /**
     * The Sales mgr.
     */
    Employee salesMgr, /**
 * The Adv mgr.
 */
advMgr;
    /**
     * The Prod mgr.
     */
    Employee prodMgr, /**
 * The Ship mgr.
 */
shipMgr;

    /**
     * The Sp.
     */
    JScrollPane sp;
    /**
     * The Tree panel.
     */
    JPanel treePanel;
    /**
     * The Tree.
     */
    JTree tree;
    /**
     * The Troot.
     */
    DefaultMutableTreeNode troot;
    /**
     * The Cost.
     */
    JLabel cost;

    /**
     * Instantiates a new Emp tree.
     */
    public empTree()
      {
         super("Employee tree");
         makeEmployees();
         setGUI();
      }
   //--------------------------------------
      private void setGUI()
      {
         treePanel = new JPanel();
         getContentPane().add(treePanel);
         treePanel.setLayout(new BorderLayout());
         
         sp = new JScrollPane();
         treePanel.add("Center", sp);
         treePanel.add("South", cost = new JLabel("          "));
         
         treePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
         troot = new DefaultMutableTreeNode(boss.getName());
         tree= new JTree(troot);
         tree.setBackground(Color.lightGray);
         loadTree(boss);
         /* Put the Tree in a scroller. */
         
         sp.getViewport().add(tree);
         setSize(new Dimension(200, 300));
         setVisible(true);

      }

    /**
     * Load tree.
     *
     * @param topDog the top dog
     */
//------------------------------------
      public void loadTree(Employee topDog)
       {
         DefaultMutableTreeNode troot;
         troot = new DefaultMutableTreeNode(topDog.getName());
         treePanel.remove(tree);
         tree= new JTree(troot);
         tree.addTreeSelectionListener(this);
         sp.getViewport().add(tree);
         
         addNodes(troot, topDog);
         tree.expandRow(0);
         repaint();
      }
      //--------------------------------------
      private void addNodes(DefaultMutableTreeNode pnode, Employee emp)
      {
      DefaultMutableTreeNode node;

      Enumeration e = emp.elements();
        while(e.hasMoreElements())
            {
            Employee newEmp = (Employee)e.nextElement();
            node = new DefaultMutableTreeNode(newEmp.getName());
            pnode.add(node);
            addNodes(node, newEmp);
            }
      }
      //--------------------------------------
      private void makeEmployees()
      {
      boss = new Employee("CEO", 200000);
      boss.add(marketVP = new Employee("Marketing VP", 100000));
      boss.add(prodVP = new Employee("Production VP", 100000));

      marketVP.add(salesMgr = new Employee("Sales Mgr", 50000));
      marketVP.add(advMgr = new Employee("Advt Mgr", 50000));

      for (int i=0; i<5; i++) 
         salesMgr .add(new Employee("Sales "+new Integer(i).toString(), 30000.0F +(float)(Math.random()-0.5)*10000));
      advMgr.add(new Employee("Secy", 20000));

      prodVP.add(prodMgr = new Employee("Prod Mgr", 40000));
      prodVP.add(shipMgr = new Employee("Ship Mgr", 35000));
      for (int i = 0; i < 4; i++)
        prodMgr.add( new Employee("Manuf "+new Integer(i).toString(), 25000.0F +(float)(Math.random()-0.5)*5000));
      for (int i = 0; i < 3; i++)
        shipMgr.add( new Employee("ShipClrk "+new Integer(i).toString(), 20000.0F +(float)(Math.random()-0.5)*5000));
        
      }                            
      //--------------------------------------
      public void valueChanged(TreeSelectionEvent evt)
      {
       TreePath path = evt.getPath();
       String selectedTerm = path.getLastPathComponent().toString();

       Employee emp = boss.getChild(selectedTerm);
       if(emp != null)
          cost.setText(new Float(emp.getSalaries()).toString());
      }

    /**
     * Main.
     *
     * @param argv the argv
     */
//--------------------------------------
      static public void main(String argv[])
      {
         new empTree();
      }
}