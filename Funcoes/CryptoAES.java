package Funcoes;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.cert.*;
public class CryptoAES
{ private byte[] textoCifrado;
   private byte[] textoDecifrado;

   public CryptoAES()
   { textoCifrado = null;
      textoDecifrado = null;
   }

   //Gera o arquivo da chave(isso é para sistemas que vao enviar o arquivo criptografado e poder descriptografar no outro lado)
   public void geraChave(File fSim)
   throws IOException, NoSuchAlgorithmException,
   InvalidAlgorithmParameterException,
   CertificateException, KeyStoreException
   { // Gera uma chave simetrica de 128 bits:
      KeyGenerator kg = KeyGenerator.getInstance("AES");
      kg.init(128);
      SecretKey sk = kg.generateKey();
   
   // Grava a chave simetrica em formato serializado
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fSim));//Cria um arquivo fisico na maquina
      oos.writeObject(sk);//passa o texto da chave
      oos.close();//finaliza e salva o arquivo;
   }

   //Criptografa
   public void geraCifra(byte[] texto, File fSim)
   throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
   IllegalBlockSizeException, BadPaddingException,
   InvalidAlgorithmParameterException,
   IOException, ClassNotFoundException
   {
      //Transforma o arquivo em um objeto para inserção de dados
      ObjectInputStream ois = new ObjectInputStream (new FileInputStream (fSim)); //Abre o arquivo
      SecretKey iSim = (SecretKey) ois.readObject();//Pega o arquivo da Chave e transforma em objeto
      byte[] chave = iSim.getEncoded(); // transforma em bytes
      ois.close();//Fecha o arquivo
      Cipher aescf = Cipher.getInstance ("AES/CBC/PKCS5Padding");//Cria uma instancia da Cryptografia
      IvParameterSpec ivspec = new IvParameterSpec (new byte[16]);// esse é uma parametro da função abaixo
      aescf.init (Cipher.ENCRYPT_MODE, new SecretKeySpec (chave, "AES"), ivspec);//inicia(Abre) a cripitografia, passa o modo (Criptografia ou descriptografia),chave
      textoCifrado = aescf.doFinal (texto);//Faz a Cripitografia;
   }


   public byte[] getTextoCifrado() throws Exception
   { 
      return textoCifrado; //Retorna o arquivo depois de criptografado
   }

   //DesCriptografa
   public void geraDecifra(byte[] texto, File fSim)
   throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
   IllegalBlockSizeException, BadPaddingException,
   InvalidAlgorithmParameterException,
   IOException, ClassNotFoundException
   {
      ObjectInputStream ois = new ObjectInputStream (new FileInputStream (fSim));//abre o arquivo da chave
      SecretKeySpec iSim = (SecretKeySpec) ois.readObject();//transforma a chave em objeto
      ois.close();
      Cipher aescf = Cipher.getInstance ("AES/CBC/PKCS5Padding");//instancia(cria) o objeto de cryptografia
      IvParameterSpec ivspec = new IvParameterSpec (new byte[16]);//variavel parametro
      aescf.init (Cipher.DECRYPT_MODE, iSim, ivspec);//Inicia a Classe de criptografia(Parametros, modo:(Criptografia/Descriptografia),chave)
      textoDecifrado = aescf.doFinal (texto);//Passa o arquivo que vai ser descriptografado
   }
   public byte[] getTextoDecifrado() throws Exception
   { 
      return textoDecifrado;//Retorna o arquivo depois de descriptografado

   }
}