/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.awt.Component;
import java.awt.Container;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JTextField;


/**
 *
 * @author eyubonsai
 */

public class Functions {
     
public String _getPathReport()
{
    String p=new String();
    File f = new File(System.getProperty("user.dir") + "/src/Laporan/");
    if (f.exists())
       {
            p=System.getProperty("user.dir") + "/src/Laporan/";   
       }else{
        p=System.getProperty("user.dir") + "/Laporan/";
        }
    return p;
}
    public static String implode(String separator, String... data) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < data.length - 1; i++) {
    //data.length - 1 => to not add separator at the end
        if (!data[i].matches(" *")) {//empty string are ""; " "; "  "; and so on
            sb.append(data[i]);
            sb.append(separator);
        }
    }
    sb.append(data[data.length - 1]);
    return sb.toString();
    }
    
  
    
   public static String implode3(String delimiter, Map<String, String> map){
boolean first = true;
 StringBuilder sb = new StringBuilder();

   for(Entry<String, String> e : map.entrySet()){
      if (!first) sb.append(" ").append(delimiter).append(" ");
      sb.append(" ").append(e.getKey()).append(" = '").append(e.getValue()).append("' ");
      first = false;
   }

   return sb.toString();
    }
   
  public static String _RpToStr(Integer nilaiRp) {
        return Rupiah.convert(nilaiRp);
  }
  
  public static String _getXML()
  {
      
      return null;
  }
  
  public void clearTextFields (Container container){

  for(Component c : container.getComponents()){
   if(c instanceof JTextField){
     JTextField f = (JTextField) c;
     f.setText("");
 } 
  else if (c instanceof Container)
     clearTextFields((Container)c);
}
}

    public String _getValue(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
