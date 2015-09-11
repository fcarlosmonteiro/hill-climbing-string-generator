/*    */ package br.unesp.stringsearch.databases;
/*    */ 
/*    */ import br.unesp.stringsearch.utils.Utilitario;
/*    */ import java.util.List;
/*    */ 
/*    */ public class SpringerLink
/*    */   implements Utilitario
/*    */ {
/*    */   public static String generate(List<String> wa)
/*    */   {
/* 20 */     StringBuilder sb = new StringBuilder();
/*    */ 
/* 22 */     int n = wa.size();
/*    */ 
/* 24 */     sb.append("(");
/*    */ 
/* 27 */     for (int i = 0; i < n - 1; i++) {
/* 28 */       sb.append("\"");
/* 29 */       sb.append(((String)wa.get(i)).trim());
/* 30 */       sb.append("\"");
/* 31 */       sb.append(" ");
/* 32 */       sb.append("OR");
/* 33 */       sb.append(" ");
/*    */     }
/*    */ 
/* 36 */     sb.append("\"");
/* 37 */     sb.append(((String)wa.get(n - 1)).trim());
/* 38 */     sb.append("\"");
/*    */ 
/* 40 */     sb.append(")");
/*    */ 
/* 42 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   public static String generate(List<String> wa, List<String> wb) {
/* 46 */     StringBuilder sb = new StringBuilder();
/*    */ 
/* 48 */     int n = wa.size();
/*    */ 
/* 50 */     sb.append("(");
/*    */ 
/* 53 */     for (int i = 0; i < n - 1; i++) {
/* 54 */       sb.append("\"");
/* 55 */       sb.append(((String)wa.get(i)).trim());
/* 56 */       sb.append("\"");
/* 57 */       sb.append(" ");
/* 58 */       sb.append("OR");
/* 59 */       sb.append(" ");
/*    */     }
/*    */ 
/* 62 */     sb.append("\"");
/* 63 */     sb.append(((String)wa.get(n - 1)).trim());
/* 64 */     sb.append("\"");
/*    */ 
/* 66 */     sb.append(")");
/*    */ 
/* 68 */     sb.append(" ");
/* 69 */     sb.append("AND");
/* 70 */     sb.append(" ");
/*    */ 
/* 72 */     int m = wb.size();
/*    */ 
/* 74 */     sb.append("(");
/*    */ 
/* 76 */     for (int i = 0; i < m - 1; i++) {
/* 77 */       sb.append("\"");
/* 78 */       sb.append(((String)wb.get(i)).trim());
/* 79 */       sb.append("\"");
/* 80 */       sb.append(" ");
/* 81 */       sb.append("OR");
/* 82 */       sb.append(" ");
/*    */     }
/*    */ 
/* 85 */     sb.append("\"");
/* 86 */     sb.append(((String)wb.get(m - 1)).trim());
/* 87 */     sb.append("\"");
/*    */ 
/* 89 */     sb.append(")");
/*    */ 
/* 92 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           /home/frota/Dropbox/Papers2015/ESEM2015/SearchString/
 * Qualified Name:     br.unesp.stringsearch.databases.SpringerLink
 * JD-Core Version:    0.6.2
 */