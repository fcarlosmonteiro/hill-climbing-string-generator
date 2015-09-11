/*     */ package br.unesp.stringsearch.databases;
/*     */ 
/*     */ import br.unesp.stringsearch.utils.Utilitario;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Acm
/*     */   implements Utilitario
/*     */ {
/*     */   public static String generate(List<String> wa)
/*     */   {
/*  20 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  22 */     int n = wa.size();
/*     */ 
/*  24 */     sb.append("Title:");
/*     */ 
/*  26 */     sb.append("(");
/*     */ 
/*  28 */     for (int i = 0; i < n - 1; i++) {
/*  29 */       sb.append("\"");
/*  30 */       sb.append(((String)wa.get(i)).trim());
/*  31 */       sb.append("\"");
/*  32 */       sb.append(" ");
/*  33 */       sb.append("OR");
/*  34 */       sb.append(" ");
/*     */     }
/*     */ 
/*  37 */     sb.append("\"");
/*  38 */     sb.append(((String)wa.get(n - 1)).trim());
/*  39 */     sb.append("\"");
/*     */ 
/*  42 */     sb.append(")");
/*     */ 
/*  44 */     sb.append("\n\n");
/*     */ 
/*  46 */     sb.append("Abstract:");
/*     */ 
/*  48 */     sb.append("(");
/*     */ 
/*  50 */     for (int i = 0; i < n - 1; i++) {
/*  51 */       sb.append("\"");
/*  52 */       sb.append(((String)wa.get(i)).trim());
/*  53 */       sb.append("\"");
/*  54 */       sb.append(" ");
/*  55 */       sb.append("OR");
/*  56 */       sb.append(" ");
/*     */     }
/*     */ 
/*  59 */     sb.append("\"");
/*  60 */     sb.append(((String)wa.get(n - 1)).trim());
/*  61 */     sb.append("\"");
/*     */ 
/*  64 */     sb.append(")");
/*     */ 
/*  66 */     sb.append("Keywords:");
/*     */ 
/*  68 */     sb.append("(");
/*     */ 
/*  70 */     for (int i = 0; i < n - 1; i++) {
/*  71 */       sb.append("\"");
/*  72 */       sb.append(((String)wa.get(i)).trim());
/*  73 */       sb.append("\"");
/*  74 */       sb.append(" ");
/*  75 */       sb.append("OR");
/*  76 */       sb.append(" ");
/*     */     }
/*     */ 
/*  79 */     sb.append("\"");
/*  80 */     sb.append(((String)wa.get(n - 1)).trim());
/*  81 */     sb.append("\"");
/*     */ 
/*  84 */     sb.append(")");
/*     */ 
/*  86 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String generate(List<String> wa, List<String> wb) {
/*  90 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  92 */     int n = wa.size();
/*     */ 
/*  94 */     sb.append("Title:");
/*  95 */     sb.append("(");
/*  96 */     sb.append("(");
/*     */ 
/*  98 */     for (int i = 0; i < n - 1; i++) {
/*  99 */       sb.append("\"");
/* 100 */       sb.append(((String)wa.get(i)).trim());
/* 101 */       sb.append("\"");
/* 102 */       sb.append(" ");
/* 103 */       sb.append("OR");
/* 104 */       sb.append(" ");
/*     */     }
/*     */ 
/* 107 */     sb.append("\"");
/* 108 */     sb.append(((String)wa.get(n - 1)).trim());
/* 109 */     sb.append("\"");
/*     */ 
/* 111 */     sb.append(")");
/*     */ 
/* 113 */     sb.append(" ");
/* 114 */     sb.append("AND");
/* 115 */     sb.append(" ");
/*     */ 
/* 117 */     int m = wb.size();
/*     */ 
/* 119 */     sb.append("(");
/*     */ 
/* 121 */     for (int i = 0; i < m - 1; i++) {
/* 122 */       sb.append("\"");
/* 123 */       sb.append(((String)wb.get(i)).trim());
/* 124 */       sb.append("\"");
/* 125 */       sb.append(" ");
/* 126 */       sb.append("OR");
/* 127 */       sb.append(" ");
/*     */     }
/*     */ 
/* 130 */     sb.append("\"");
/* 131 */     sb.append(((String)wb.get(m - 1)).trim());
/* 132 */     sb.append("\"");
/*     */ 
/* 134 */     sb.append(")");
/* 135 */     sb.append(")");
/*     */ 
/* 137 */     sb.append("\n\n");
/*     */ 
/* 139 */     sb.append("Abstract:");
/* 140 */     sb.append("(");
/* 141 */     sb.append("(");
/*     */ 
/* 143 */     for (int i = 0; i < n - 1; i++) {
/* 144 */       sb.append("\"");
/* 145 */       sb.append(((String)wa.get(i)).trim());
/* 146 */       sb.append("\"");
/* 147 */       sb.append(" ");
/* 148 */       sb.append("OR");
/* 149 */       sb.append(" ");
/*     */     }
/*     */ 
/* 152 */     sb.append("\"");
/* 153 */     sb.append(((String)wa.get(n - 1)).trim());
/* 154 */     sb.append("\"");
/*     */ 
/* 156 */     sb.append(")");
/*     */ 
/* 158 */     sb.append(" ");
/* 159 */     sb.append("AND");
/* 160 */     sb.append(" ");
/*     */ 
/* 162 */     sb.append("(");
/*     */ 
/* 164 */     for (int i = 0; i < m - 1; i++) {
/* 165 */       sb.append("\"");
/* 166 */       sb.append(((String)wb.get(i)).trim());
/* 167 */       sb.append("\"");
/* 168 */       sb.append(" ");
/* 169 */       sb.append("OR");
/* 170 */       sb.append(" ");
/*     */     }
/*     */ 
/* 173 */     sb.append("\"");
/* 174 */     sb.append(((String)wb.get(m - 1)).trim());
/* 175 */     sb.append("\"");
/*     */ 
/* 177 */     sb.append(")");
/* 178 */     sb.append(")");
/*     */ 
/* 181 */     sb.append("\n\n");
/*     */ 
/* 183 */     sb.append("Keywords:");
/* 184 */     sb.append("(");
/* 185 */     sb.append("(");
/*     */ 
/* 187 */     for (int i = 0; i < n - 1; i++) {
/* 188 */       sb.append("\"");
/* 189 */       sb.append(((String)wa.get(i)).trim());
/* 190 */       sb.append("\"");
/* 191 */       sb.append(" ");
/* 192 */       sb.append("OR");
/* 193 */       sb.append(" ");
/*     */     }
/*     */ 
/* 196 */     sb.append("\"");
/* 197 */     sb.append(((String)wa.get(n - 1)).trim());
/* 198 */     sb.append("\"");
/*     */ 
/* 200 */     sb.append(")");
/*     */ 
/* 202 */     sb.append(" ");
/* 203 */     sb.append("AND");
/* 204 */     sb.append(" ");
/*     */ 
/* 206 */     sb.append("(");
/*     */ 
/* 208 */     for (int i = 0; i < m - 1; i++) {
/* 209 */       sb.append("\"");
/* 210 */       sb.append(((String)wb.get(i)).trim());
/* 211 */       sb.append("\"");
/* 212 */       sb.append(" ");
/* 213 */       sb.append("OR");
/* 214 */       sb.append(" ");
/*     */     }
/*     */ 
/* 217 */     sb.append("\"");
/* 218 */     sb.append(((String)wb.get(m - 1)).trim());
/* 219 */     sb.append("\"");
/*     */ 
/* 221 */     sb.append(")");
/* 222 */     sb.append(")");
/*     */ 
/* 224 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           /home/frota/Dropbox/Papers2015/ESEM2015/SearchString/
 * Qualified Name:     br.unesp.stringsearch.databases.Acm
 * JD-Core Version:    0.6.2
 */