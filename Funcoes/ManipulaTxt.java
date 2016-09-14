package Funcoes;
import javax.swing.*;
import java.util.Formatter; //formatar arquivo
import java.io.*;
public class ManipulaTxt{
   private Formatter saida;
   private File arq;
   private FileReader reader;
   private BufferedReader leitor;
   private String nomeArquivo;

   public ManipulaTxt(String nomeArquivo ){
      this.nomeArquivo = nomeArquivo;
   }
   
   public String getNomeArquivo(){
      return this.nomeArquivo;
   }
   
   public void setText(String texto){
      if (saida == null){ // Verifica se o TXT está aberto.
         try{
            saida = new Formatter(getNomeArquivo());
         }
         catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro["+ ex.getMessage() +"]");
         }
      }
      
      saida.format(texto);
      
   }
   
   public String getLine(){
      if (reader == null){
         try{
            reader = new FileReader(getNomeArquivo());
            leitor = new BufferedReader(reader);
            return leitor.readLine();
         }
         catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro["+ ex.getMessage() +"]");
         }
      }
      return null;
   }
   
   public StringBuilder toStringBuilder(){
      StringBuilder txtArquivo = new StringBuilder();
      String linha = null;
      reader = null;
      linha = getLine();
      while(linha != null){
         txtArquivo.append(linha);
         linha = getLine();      
      }
      
      return txtArquivo;
      
      
   }
   
   public void fecharArquivo(){ 
      saida.close();
      saida = null;
   }
   
}