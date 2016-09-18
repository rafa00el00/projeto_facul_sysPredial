package Funcoes;
import java.io.*; 

public class Cryptografia{

   //----------Criptografar o arquivo
   public byte[] criptografar(String sMsgClara){
      byte[] bMsgClara = null;
      try{
      // Converte o texto String dado no equivalente byte[]
         bMsgClara = sMsgClara.getBytes("ISO-8859-1");
         
      // Instancia um objeto da classe CryptoAES
         CryptoAES caes = new CryptoAES();
      
         // Gera a Chave criptografica AES simetrica e o nome do arquivo onde será armazenada
         caes.geraChave(new File("chave.simetrica"));
         caes.geraCifra(bMsgClara,new File("chave.simetrica"));
         return   caes.getTextoCifrado();
      }
      catch(Exception e){
         e.printStackTrace();
      }
      return null   ;
   }
   //----------DesCriptografar o arquivo
   public byte[] desCriptografar(byte[] bMsgCifrada){
      CryptoAES caes = new CryptoAES();
      try{
         // Gera a decifra AES da mensagem dada, segundo a chave simetrica gerada
         caes.geraDecifra(bMsgCifrada, new File ("chave.simetrica"));
         
         // recebe o texto decifrado
         return caes.getTextoDecifrado();
      }
      catch(Exception e){
         e.printStackTrace();
      }
      // Converte o texto byte[] no equivalente String
         //sMsgDecifrada = (new String (bMsgDecifrada, "ISO-8859-1"));
      return null;
   }
}

