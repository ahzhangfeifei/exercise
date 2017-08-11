package com.core.java.v2.v2ch10. bytecodeAnnotations;

import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.generic.*;

import java.io.IOException;

/**
 * The type Entry logger.
 */
public class EntryLogger
{
   private ClassGen cg;
   private ConstantPoolGen cpg;

   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      try
      {
         if (args.length == 0) 
            System.out.println("USAGE: java bytecodeAnnotations.EntryLogger classname");
         else
         {
            JavaClass jc = Repository.lookupClass(args[0]);
            ClassGen cg = new ClassGen(jc);
            EntryLogger el = new EntryLogger(cg);
            el.convert();
            String f = Repository.lookupClassFile(cg.getClassName()).getPath();
            System.out.println("Dumping " + f);
            cg.getJavaClass().dump(f);
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   /**
    * Instantiates a new Entry logger.
    *
    * @param cg the cg
    */
   public EntryLogger(ClassGen cg)
   {
      this.cg = cg;
      cpg = cg.getConstantPool();
   }

   /**
    * Convert.
    *
    * @throws IOException the io exception
    */
   public void convert() throws IOException
   {
//      for (Method m : cg.getMethods())
//      {
//         AnnotationEntry[] annotations = m.getAnnotationEntries();
//         for (AnnotationEntry a : annotations)
//         {
//            if (a.getAnnotationType().equals("LbytecodeAnnotations/LogEntry;"))
//            {
//               for (ElementValuePair p : a.getElementValuePairs())
//               {
//                  if (p.getNameString().equals("logger"))
//                  {
//                     String loggerName = p.getValue().stringifyValue();
//                     cg.replaceMethod(m, insertLogEntry(m, loggerName));
//                  }
//               }
//            }
//         }
//      }
   }

   /**
    * Adds an "entering" call to the beginning of a method.
    * @param m the method
    * @param loggerName the name of the logger to call
    */
//   private Method insertLogEntry(Method m, String loggerName)
//   {
//      MethodGen mg = new MethodGen(m, cg.getClassName(), cpg);
//      String className = cg.getClassName();
//      String methodName = mg.getMethod().getName();
//      System.out.printf("Adding logging instructions to %s.%s%n", className, methodName);
//
//      int getLoggerIndex = cpg.addMethodref("java.util.logging.Logger", "getLogger",
//            "(Ljava/lang/String;)Ljava/util/logging/Logger;");
//      int enteringIndex = cpg.addMethodref("java.util.logging.Logger", "entering",
//            "(Ljava/lang/String;Ljava/lang/String;)V");
//
//      InstructionList il = mg.getInstructionList();
//      InstructionList patch = new InstructionList();
//      patch.append(new PUSH(cpg, loggerName));
//      patch.append(new INVOKESTATIC(getLoggerIndex));
//      patch.append(new PUSH(cpg, className));
//      patch.append(new PUSH(cpg, methodName));
//      patch.append(new INVOKEVIRTUAL(enteringIndex));
//      InstructionHandle[] ihs = il.getInstructionHandles();
//      il.insert(ihs[0], patch);
//
//      mg.setMaxStack();
//      return mg.getMethod();
//   }
}
