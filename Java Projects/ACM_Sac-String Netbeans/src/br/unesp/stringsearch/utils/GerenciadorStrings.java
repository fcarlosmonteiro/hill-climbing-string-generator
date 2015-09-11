/*    */ package br.unesp.stringsearch.utils;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ 
/*    */ public class GerenciadorStrings
/*    */ {
/*    */   public static List<String> dividePalavras(String stringSearch)
/*    */   {
/* 22 */     String[] words = stringSearch.split("OR");
/* 23 */     List lwords = new ArrayList();
/*    */ 
/* 25 */     if (words.length > 0) {
/* 26 */       lwords = Arrays.asList(words);
/*    */     }
/*    */ 
/* 31 */     return lwords;
/*    */   }
/*    */ }

/* Location:           /home/frota/Dropbox/Papers2015/ESEM2015/SearchString/
 * Qualified Name:     br.unesp.stringsearch.utils.GerenciadorStrings
 * JD-Core Version:    0.6.2
 */