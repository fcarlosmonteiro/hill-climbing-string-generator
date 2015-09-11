/*    */ package br.unesp.stringsearch.databases;
/*    */ 
/*    */ import br.unesp.stringsearch.utils.Utilitario;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ScienceDirect
/*    */   implements Utilitario
/*    */ {
/*    */   public static String generate(List<String> wa)
/*    */   {
/* 20 */     StringBuilder sb = new StringBuilder();
/*    */ 
/* 22 */     int n = wa.size();
/*    */ 
/* 24 */     sb.append("TITLE-ABSTR-KEY");
/*    */ 
/* 26 */     sb.append("(");
/*    */ 
/* 28 */     for (int i = 0; i < n - 1; i++) {
/* 29 */       sb.append("\"");
/* 30 */       sb.append(((String)wa.get(i)).trim());
/* 31 */       sb.append("\"");
/* 32 */       sb.append(" ");
/* 33 */       sb.append("OR");
/* 34 */       sb.append(" ");
/*    */     }
/*    */ 
/* 37 */     sb.append("\"");
/* 38 */     sb.append(((String)wa.get(n - 1)).trim());
/* 39 */     sb.append("\"");
/*    */ 
/* 42 */     sb.append(")");
/* 43 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   public static String generate(List<String> wa, List<String> wb) {
/* 47 */     StringBuilder sb = new StringBuilder();
/*    */ 
/* 49 */     int n = wa.size();
/*    */ 
/* 51 */     sb.append("TITLE-ABSTR-KEY");
/* 52 */     sb.append("(");
/* 53 */     sb.append("(");
/*    */ 
/* 55 */     for (int i = 0; i < n - 1; i++) {
/* 56 */       sb.append("\"");
/* 57 */       sb.append(((String)wa.get(i)).trim());
/* 58 */       sb.append("\"");
/* 59 */       sb.append(" ");
/* 60 */       sb.append("OR");
/* 61 */       sb.append(" ");
/*    */     }
/*    */ 
/* 64 */     sb.append("\"");
/* 65 */     sb.append(((String)wa.get(n - 1)).trim());
/* 66 */     sb.append("\"");
/*    */ 
/* 68 */     sb.append(")");
/*    */ 
/* 70 */     sb.append(" ");
/* 71 */     sb.append("AND");
/* 72 */     sb.append(" ");
/*    */ 
/* 74 */     int m = wb.size();
/*    */ 
/* 76 */     sb.append("(");
/*    */ 
/* 78 */     for (int i = 0; i < m - 1; i++) {
/* 79 */       sb.append("\"");
/* 80 */       sb.append(((String)wb.get(i)).trim());
/* 81 */       sb.append("\"");
/* 82 */       sb.append(" ");
/* 83 */       sb.append("OR");
/* 84 */       sb.append(" ");
/*    */     }
/*    */ 
/* 87 */     sb.append("\"");
/* 88 */     sb.append(((String)wb.get(m - 1)).trim());
/* 89 */     sb.append("\"");
/*    */ 
/* 91 */     sb.append(")");
/* 92 */     sb.append(")");
/*    */ 
/* 94 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           /home/frota/Dropbox/Papers2015/ESEM2015/SearchString/
 * Qualified Name:     br.unesp.stringsearch.databases.ScienceDirect
 * JD-Core Version:    0.6.2
 */