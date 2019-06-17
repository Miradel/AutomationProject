package com.ethoca.utilities;

import com.ethoca.pages.FramePage;
import com.ethoca.pages.HomePage;
import com.ethoca.pages.SummaryPage;
import com.ethoca.pages.SummerDressPage;

public class Pages {

  private HomePage homePage;
  private SummaryPage summaryPage ;
  private SummerDressPage summerDressPage;
  private FramePage framePage;


   public HomePage homePage(){
       if(homePage == null){
           homePage = new HomePage();
       }
       return homePage;
   }

   public SummaryPage summaryPage(){
       if(summaryPage==null){
           summaryPage = new SummaryPage();
       }
       return summaryPage;
   }

   public SummerDressPage summerDressPage(){
       if(summerDressPage==null){
           summerDressPage = new SummerDressPage();
       }
       return summerDressPage;
   }

   public FramePage framePage(){
       if(framePage==null){
           framePage = new FramePage();
       }
       return framePage;
   }

}
