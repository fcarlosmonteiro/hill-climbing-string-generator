/*     */ package br.unesp.stringsearch.databases;
/*     */ 
/*     */ import br.unesp.stringsearch.utils.Utilitario;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Ieee
/*     */   implements Utilitario
/*     */ {
/*     */   public static String generate(List<String> wa)
/*     */   {
/*  20 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  22 */     int n = wa.size();
/*     */ 
/*  25 */     sb.append("(");
/*     */ 
/*  27 */     for (int i = 0; i < n - 1; i++) {
/*  28 */       sb.append("\"Abstract\":\"");
/*  29 */       sb.append(((String)wa.get(i)).trim());
/*  30 */       sb.append("\"");
/*  31 */       sb.append(" ");
/*  32 */       sb.append("OR");
/*  33 */       sb.append(" ");
/*     */     }
/*     */ 
/*  36 */     sb.append("\"Abstract\":\"");
/*  37 */     sb.append(((String)wa.get(n - 1)).trim());
/*  38 */     sb.append("\"");
/*     */ 
/*  40 */     sb.append(")");
/*     */ 
/*  43 */     sb.append("\n\n");
/*     */ 
/*  45 */     sb.append("(");
/*     */ 
/*  47 */     for (int i = 0; i < n - 1; i++) {
/*  48 */       sb.append("\"Document Title\":\"");
/*  49 */       sb.append(((String)wa.get(i)).trim());
/*  50 */       sb.append("\"");
/*  51 */       sb.append(" ");
/*  52 */       sb.append("OR");
/*  53 */       sb.append(" ");
/*     */     }
/*     */ 
/*  56 */     sb.append("\"Document Title\":\""); 
/*  57 */     sb.append(((String)wa.get(n - 1)).trim());
/*  58 */     sb.append("\"");
/*     */ 
/*  60 */     sb.append(")");
/*     */ 
/*  63 */     sb.append("\n\n");
/*     */ 
/*  65 */     sb.append("(");
/*     */ 
/*  67 */     for (int i = 0; i < n - 1; i++) {
/*  68 */       sb.append("\"Author Keywords\":\"");
/*  69 */       sb.append(((String)wa.get(i)).trim());
/*  70 */       sb.append("\"");
/*  71 */       sb.append(" ");
/*  72 */       sb.append("OR");
/*  73 */       sb.append(" ");
/*     */     }
/*     */ 
/*  76 */     sb.append("\"Author Keywords\":\"");
/*  77 */     sb.append(((String)wa.get(n - 1)).trim());
/*  78 */     sb.append("\"");
/*     */ 
/*  80 */     sb.append(")");
/*     */ 
/*  82 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String generate(List<String> wa, List<String> wb) {
/*  86 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  88 */     int n = wa.size();
/*     */ 
/*  91 */     sb.append("(");
/*     */ 
/*  93 */     for (int i = 0; i < n - 1; i++) {
/*  94 */     //  sb.append("\"Abstract\":\"");
                sb.append("\"");
/*  95 */       sb.append(((String)wa.get(i)).trim());
/*  96 */       sb.append("\"");
/*  97 */       sb.append(" ");
/*  98 */       sb.append("OR");
/*  99 */       sb.append(" ");
/*     */     }
/*     */ 
/* 102 */    // sb.append("\"Abstract\":\"");
                sb.append("\"");
/* 103 */     sb.append(((String)wa.get(n - 1)).trim());
/* 104 */     sb.append("\"");
/*     */ 
/* 106 */     sb.append(")");
/*     */ 
/* 108 */     sb.append(" ");
/* 109 */     sb.append("AND");
/* 110 */     sb.append(" ");
/*     */ 
/* 112 */     int m = wb.size();
/*     */ 
/* 114 */     sb.append("(");
/*     */ 
/* 116 */     for (int i = 0; i < m - 1; i++) {
/* 117 */   //    sb.append("\"Abstract\":\"");
                 sb.append("\"");
/* 118 */       sb.append(((String)wb.get(i)).trim());
/* 119 */       sb.append("\"");
/* 120 */       sb.append(" ");
/* 121 */       sb.append("OR");
/* 122 */       sb.append(" ");
/*     */     }
/*     */ 
/* 125 */   //  sb.append("\"Abstract\":\"");
                sb.append("\"");
/* 126 */     sb.append(((String)wb.get(m - 1)).trim());
/* 127 */     sb.append("\"");
/*     */ 
/* 129 */     sb.append(")");
/*     */ 
/* 133 */  
/* 215 */     return sb.toString();
/*     */   }



public static String generate(List<String> wa, List<String> wb, List<String> wc) {
/*  86 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  88 */     int n = wa.size();
/*     */ 
/*  91 */     sb.append("(");
/*     */ 
/*  93 */     for (int i = 0; i < n - 1; i++) {
/*  94 */     //  sb.append("\"Abstract\":\"");
				sb.append("\"");
/*  95 */       sb.append(((String)wa.get(i)).trim());
/*  96 */       sb.append("\"");
/*  97 */       sb.append(" ");
/*  98 */       sb.append("OR");
/*  99 */       sb.append(" ");
/*     */     }
/*     */ 
/* 102 */     //sb.append("\"Abstract\":\"");
				sb.append("\"");
/* 103 */    	sb.append(((String)wa.get(n - 1)).trim());
/* 104 */     	sb.append("\"");
/*     */ 
/* 106 */ 	    sb.append(")");
/*     */ 
/* 108 */     sb.append(" ");
/* 109 */     sb.append("AND");
/* 110 */     sb.append(" ");
/*     */ 
/* 112 */     int m = wb.size();
/*     */ 
/* 114 */     sb.append("(");
/*     */ 
/* 116 */     for (int i = 0; i < m - 1; i++) {
/* 117 */    //   sb.append("\"Abstract\":\"");
				sb.append("\"");
/* 118 */       sb.append(((String)wb.get(i)).trim());
/* 119 */       sb.append("\"");
/* 120 */       sb.append(" ");
/* 121 */       sb.append("OR");
/* 122 */       sb.append(" ");
/*     */     }
/*     */ 
/* 125 */    // sb.append("\"Abstract\":\"");
				sb.append("\"");
/* 126 */     	sb.append(((String)wb.get(m - 1)).trim());
/* 127 */     	sb.append("\"");
/*     */ 
/* 129 */   	sb.append(")");
/*     */ 
/* 133 */ 
/* 108 */     sb.append(" ");
/* 109 */     sb.append("AND");
/* 110 */     sb.append(" ");

			  
			 int o = wc.size();
			
			 
			  
			 sb.append("(");
			  
			 for (int i = 0; i < o - 1; i++) {
		//	 sb.append("\"Abstract\":\"");
			 sb.append("\"");
			 sb.append(((String)wc.get(i)).trim());
			 sb.append("\"");
			 sb.append(" ");
			 sb.append("OR");
			 sb.append(" ");
			 				}
			 
		//	 sb.append("\"Abstract\":\"");
			 sb.append(((String)wc.get(o - 1)).trim());
			 sb.append("\"");
			 
			 sb.append(")");
			 
					 


/*

			 for (int i = 0; i < n - 1; i++) {
 //      	sb.append("\"Document Title\":\"");
      		sb.append(((String)wa.get(i)).trim());
      		sb.append("\"");
      		sb.append(" ");
      		sb.append("OR");
      		sb.append(" ");
			}
 
		//	 sb.append("\"Document Title\":\"");
			 sb.append(((String)wa.get(n - 1)).trim());
			 sb.append("\"");

			 sb.append(")");

			 sb.append(" ");
			 sb.append("AND");
			 sb.append(" ");
			 
			 sb.append("(");

			 for (int i = 0; i < m - 1; i++) {
		//	 sb.append("\"Document Title\":\"");
			 sb.append(((String)wb.get(i)).trim());
			 sb.append("\"");
			 sb.append(" ");
			 sb.append("OR");
			 sb.append(" ");
			 }

		//	 sb.append("\"Document Title\":\"");
			 sb.append(((String)wb.get(m - 1)).trim());
			 sb.append("\"");

			 sb.append(")");

			 sb.append("\n\n\n");
			 sb.append("(");

			 for (int i = 0; i < n - 1; i++) {
	//			sb.append("\"Author Keywords\":\"");
				sb.append(((String)wa.get(i)).trim());
				sb.append("\"");
				sb.append(" ");
				sb.append("OR");
				sb.append(" ");
			 }

		//	 sb.append("\"Author Keywords\":\"");
			 sb.append(((String)wa.get(n - 1)).trim());
			 sb.append("\"");

			 sb.append(")");
			 
			 sb.append(" ");
			 sb.append("AND");
			 sb.append(" ");

			 sb.append("(");

			 for (int i = 0; i < m - 1; i++) {
	//		sb.append("\"Author Keywords\":\"");
			sb.append(((String)wb.get(i)).trim());
			sb.append("\"");
			sb.append(" ");
			sb.append("OR");
			sb.append(" ");
			 }

		//	 sb.append("\"Author Keywords\":\"");
			 sb.append(((String)wb.get(m - 1)).trim());
			 sb.append("\"");

			 sb.append(")");
			 */

			 return sb.toString();
	}





/*     */ }

/* Location:           /home/frota/Dropbox/Papers2015/ESEM2015/SearchString/
 * Qualified Name:     br.unesp.stringsearch.databases.Ieee
 * JD-Core Version:    0.6.2
 */