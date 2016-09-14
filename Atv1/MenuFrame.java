// Baseado na Fig. 22.5: MenuFrame.java
// Demonstrando menus com internacionalizacao. 

import java.awt.Color; 
import java.awt.Font; 
import java.awt.BorderLayout; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import java.awt.event.ItemListener; 
import java.awt.event.ItemEvent; 
import javax.swing.JFrame; 
import javax.swing.JRadioButtonMenuItem; 
import javax.swing.JCheckBoxMenuItem; 
import javax.swing.JOptionPane; 
import javax.swing.JLabel; 
import javax.swing.SwingConstants; 
import javax.swing.ButtonGroup; 
import javax.swing.JMenu; 
import javax.swing.JMenuItem; 
import javax.swing.JMenuBar; 
import java.util.Locale;
import java.util.ResourceBundle;

public class MenuFrame extends JFrame 
{ 
   private final Color colorValues[]= {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN}; 
   private JRadioButtonMenuItem colorItems[]; // itens do menu Color 
   private JRadioButtonMenuItem fonts[]; // itens do menu Font 
   private JCheckBoxMenuItem styleItems[]; // itens do menu Font Style 
   private JLabel displayJLabel; // exibe texto de exemplo 
   private ButtonGroup fontButtonGroup; // gerencia itens do menu Font 
   private ButtonGroup colorButtonGroup; // gerencia itens do menu Color 
   private int style; // utilizado para criar estilos de fontes 
   private ResourceBundle bn = null;
   private JMenu  fileMenu, formatMenu, idiomMenu, colorMenu, fontMenu;
   private JMenuItem aboutItem, exitItem, portugueseItem, englishItem,francesItem,italianoItem;

   // construtor sem argumento para configurar a GUI 
   public MenuFrame() 
   { 
      super(); 
      ClssListener lstnr = new ClssListener();
   
      bn = ResourceBundle.getBundle("ex1");
      setTitle(bn.getString("titulo"));
      
      // cria menu arquivo
      fileMenu = new JMenu(bn.getString("arquivo")); // cria o menu arquivo internacionalizado
      fileMenu.setMnemonic(bn.getString("arquivo.mnemonico").charAt(0)); // configura o mnemonico 
   
      // cria item de menu Sobre... 
      aboutItem = new JMenuItem(bn.getString("sobre") + "..."); 
      aboutItem.setMnemonic(bn.getString("sobre.mnemonico").charAt(0)); // configura o mnemonico 
   
      fileMenu.add( aboutItem ); // adiciona o item sobre ao menu Arquivo
      aboutItem.addActionListener( 
            new ActionListener() // classe interna anonima
            { 
            // exibe um dialogo de mensagem quando o usuario seleciona Sobre... 
               public void actionPerformed( ActionEvent event ) 
               { 
                  JOptionPane.showMessageDialog( MenuFrame.this, bn.getString("sobre.mensagem"), bn.getString("sobre.titulo"), JOptionPane.PLAIN_MESSAGE);
               } // fim do metodo actionPerformed 
            } // fim da classe interna anonima 
         ); // fim da chamada para addActionListener 
   
      exitItem = new JMenuItem( bn.getString("sair")); // cria o item sair
      exitItem.setMnemonic(bn.getString("sair.mnemonico").charAt(0)); // configura o mnemonico 
      fileMenu.add( exitItem ); // adiciona o item sair ao menu Arquivo
      exitItem.addActionListener( 
            new ActionListener() // classe interna anonima 
            { 
            // termina o aplicativo quando o usuario clica exitItem
               public void actionPerformed( ActionEvent event ) 
               { 
                  System.exit( 0 ); // encerra o aplicativo 
               } // fim do metodo actionPerformed 
            } // fim da classe interna anonima 
         ); // fim da chamada para addActionListener 
   
      JMenuBar bar = new JMenuBar(); // cria a barra de menus 
      setJMenuBar( bar ); // adiciona uma barra de menus ao aplicativo 
      bar.add( fileMenu ); // adiciona o menu arquivo na barra de menus 
   
      // cria menu formato
      formatMenu = new JMenu(bn.getString("formato")); // cria o menu formato
      formatMenu.setMnemonic(bn.getString("formato.mnemonico").charAt(0)); // configura o mnemonico
      
      // array listando cores de string 
   /**/  final String colors[] = { bn.getString("cor.preto"), bn.getString("cor.azul"), bn.getString("cor.vermelho"), bn.getString("cor.verde")};
      
      colorMenu = new JMenu( bn.getString("cor") ); // cria o menu Color 
      colorMenu.setMnemonic( bn.getString("cor").charAt(0)); // configura o mnemonico
      
      // cria itens do menu cor com botoes de opcao 
      colorItems = new JRadioButtonMenuItem[ colors.length ]; 
      colorButtonGroup = new ButtonGroup(); // gerencia cores 
      ItemHandler itemHandler = new ItemHandler(); // handler para cores 
   
      // cria itens do menu Color com botoes de opcao 
      for ( int count = 0; count < colors.length; count++ ) 
      { 
         colorItems[ count ] = new JRadioButtonMenuItem( colors[ count ] ); // cria o item 
         colorMenu.add( colorItems[ count ] ); // adiciona o item ao menu cor
         colorButtonGroup.add( colorItems[ count ] ); // adiciona ao grupo 
         colorItems[ count ].addActionListener( itemHandler ); 
      } // fim do for 
      colorItems[ 0 ].setSelected( true ); // seleciona o primeiro item cor
      formatMenu.add( colorMenu ); // adiciona o menu cor ao menu formato
      formatMenu.addSeparator(); // adiciona um separador no menu 
      
      // array listando nomes de fonte 
      String fontNames[] = { bn.getString("fonte.Serif"), bn.getString("fonte.Monospaced"), bn.getString("fonte.SansSerif")}; 
      fontMenu = new JMenu( bn.getString("fonte")); // cria a fonte do menu
      fontMenu.setMnemonic(  bn.getString("fonte.mnemonico").charAt(0) ); // configura o mnemonico
   
      // cria itens do menu radiobutton para nomes de fonte 
      fonts = new JRadioButtonMenuItem[ fontNames.length ]; 
      fontButtonGroup = new ButtonGroup(); // gerencia os nomes das fontes 
   
      // criar itens do menu fonte com botoes de opcao 
      for ( int count = 0; count < fonts.length; count++ ) 
      { 
         fonts[ count ] = new JRadioButtonMenuItem( fontNames[ count ] ); 
         fontMenu.add( fonts[ count ] ); // adiciona fonte ao menu fonte
         fontButtonGroup.add( fonts[ count ] ); // adiciona ao grupo de botoes
         fonts[ count ].addActionListener( itemHandler ); // adiciona handler 
      } // fim do for 
      
      fonts[ 0 ].setSelected( true ); // seleciona o primeiro item do menu fonte
      fontMenu.addSeparator(); // adiciona uma barra separadora ao menu fonte
      String styleNames[] = { bn.getString("estilo.negrito"),  bn.getString("estilo.italico") }; // nomes dos estilos
      styleItems = new JCheckBoxMenuItem[ styleNames.length ]; 
      StyleHandler styleHandler = new StyleHandler(); // handler de estilo 
      
      // criar itens do menu estilo com caixas de selecao 
      for ( int count = 0; count < styleNames.length; count++ ) 
      { 
         styleItems[ count ] = new JCheckBoxMenuItem( styleNames[ count ] ); // para estilo 
         fontMenu.add( styleItems[ count ] ); // adiciona ao menu fonte 
         styleItems[ count ].addItemListener( styleHandler ); // handler 
      } // fim do for 
   
      formatMenu.add( fontMenu ); // adiciona o menu fonte ao menu formato
      bar.add( formatMenu ); // adiciona o menu formato na barra de menus 
      
      // configura o rotulo para exibir texto 
      displayJLabel = new JLabel( bn.getString("mensagem"), SwingConstants.CENTER ); 
      displayJLabel.setForeground( colorValues[ 0 ] ); 
      displayJLabel.setFont( new Font( "Serif", Font.PLAIN, 72 ) ); 
      getContentPane().setBackground( Color.CYAN ); // configura o fundo 
      add( displayJLabel, BorderLayout.CENTER ); // adiciona displayJLabel
      
      idiomMenu = new JMenu(bn.getString("idioma")); // cria o menu idioma
      idiomMenu.setMnemonic(bn.getString("idioma.mnemonico").charAt(0)); // configura o mnemonico
   
      // cria item de menu portugues 
      portugueseItem = new JMenuItem(bn.getString("portuga")); 
      portugueseItem.setMnemonic(bn.getString("portuga.mnemonico").charAt(0)); // configura o mnemonico
      idiomMenu.add( portugueseItem ); // adiciona o item portuguese ao menu Idiom
      
      // cria item de menu ingles
      englishItem = new JMenuItem(bn.getString("ingles")); // cria o item ingles
      englishItem.setMnemonic(bn.getString("ingles.mnemonico").charAt(0) ); // configura o mnemonico
      idiomMenu.add( englishItem ); // adiciona o item english ao menu Idiom
      
       // cria item de menu Frances
      francesItem = new JMenuItem(bn.getString("frances")); // cria o item ingles
      francesItem.setMnemonic(bn.getString("frances.mnemonico").charAt(0) ); // configura o mnemonico
      idiomMenu.add( francesItem ); // adiciona o item english ao menu Idiom
      
       // cria item de menu Italiano
      italianoItem = new JMenuItem(bn.getString("italiano")); // cria o item ingles
      italianoItem.setMnemonic(bn.getString("italiano.mnemonico").charAt(0) ); // configura o mnemonico
      idiomMenu.add( italianoItem ); // adiciona o item english ao menu Idiom
   
      
      // adiciona acao aos itens de menu 
      portugueseItem.addActionListener(lstnr); // pt_BR  
      englishItem.addActionListener(lstnr); // en_US
      francesItem.addActionListener(lstnr); // fr_FR
      italianoItem.addActionListener(lstnr); // it_IT
      
      
      bar.add( idiomMenu ); // adiciona o menu Idiom na barra de menus 
   } // fim do construtor de MenuFrame
   
   // classe interna para tratar eventos de acao dos itens de menu 
   private class ItemHandler implements ActionListener 
   { 
      // processa selecoes de cor e fonte 
      public void actionPerformed( ActionEvent event ) 
      { 
         // processa a selecao de cor 
         for ( int count = 0; count < colorItems.length; count++ ) 
         { 
            if ( colorItems[ count ].isSelected() ) 
            { 
               displayJLabel.setForeground( colorValues[ count ] ); 
               break; 
            } // fim do if 
         } // fim do for 
      
         // processa a selecao de fonte 
         for ( int count = 0; count < fonts.length; count++ ) 
         { 
            if ( event.getSource() == fonts[ count ] ) 
            { 
               displayJLabel.setFont( new Font( fonts[ count ].getText(), style, 72 ) ); 
            } // fim do if 
         } // fim do for 
         
         repaint(); // redesenha o aplicativo 
      } // fim do metodo actionPerformed 
   } // fim da classe ItemHandler 

   // classe interna para tratar eventos dos itens de menu com caixa de selecao 
   private class StyleHandler implements ItemListener 
   { 
      // processa selecoes de estilo da fonte 
      public void itemStateChanged( ItemEvent e ) 
      { 
         style = 0; // inicializa o estilo 
      
         // verifica se negrito foi selecionado 
         if ( styleItems[ 0 ].isSelected() ) style += Font.BOLD; // adiciona negrito ao estilo 
         
         // verifica se italico foi selecionado 
         if ( styleItems[ 1 ].isSelected() ) style += Font.ITALIC; // adiciona italico ao estilo 
         
         displayJLabel.setFont( new Font( displayJLabel.getFont().getName(), style, 72 ) ); 
         repaint(); // redesenha o aplicativo 
      } // fim do metodo itemStateChanged 
   } // fim da classe StyleHandler 
   
   // Classe Interna
   private class ClssListener implements ActionListener // classe interna
   { 
            // exibe um dialogo de mensagem quando o usuario seleciona o idioma 
      public void actionPerformed( ActionEvent event ) 
      { 
         if (event.getSource() == englishItem){
            bn = ResourceBundle.getBundle("ex1", Locale.US);
         }
         else if (event.getSource() == portugueseItem){
            bn = ResourceBundle.getBundle("ex1", new Locale("pt", "BR"));
         } 
         else if(event.getSource() == francesItem){
            bn = ResourceBundle.getBundle("ex1", new Locale("fr", "FR"));
         } 
         else if(event.getSource() == italianoItem){
            bn = ResourceBundle.getBundle("ex1", new Locale("it", "IT"));
         }
                             
         displayJLabel.setText( bn.getString("mensagem"));
         setTitle(bn.getString("titulo"));
         fileMenu.setText(bn.getString("arquivo"));
         fileMenu.setMnemonic(bn.getString("arquivo.mnemonico").charAt(0)); 
         aboutItem.setText(bn.getString("sobre"));
         aboutItem.setMnemonic(bn.getString("sobre.mnemonico").charAt(0));
         exitItem.setText(bn.getString("sair"));
         exitItem.setMnemonic(bn.getString("sair.mnemonico").charAt(0));
               
         formatMenu.setText(bn.getString("formato"));
         formatMenu.setMnemonic(bn.getString("formato.mnemonico").charAt(0));
               
         colorMenu.setText(bn.getString("cor"));
         colorMenu.setMnemonic(bn.getString("cor.mnemonico").charAt(0));
         colorItems[0].setText(bn.getString("cor.preto"));
         colorItems[1].setText(bn.getString("cor.azul"));
         colorItems[2].setText(bn.getString("cor.vermelho"));
         colorItems[3].setText(bn.getString("cor.verde"));
      
         fontMenu.setText(bn.getString("fonte"));
         fontMenu.setMnemonic(bn.getString("fonte.mnemonico").charAt(0));
               
         styleItems[0].setText(bn.getString("estilo.negrito"));
         styleItems[1].setText(bn.getString("estilo.italico"));
               
         idiomMenu.setText(bn.getString("idioma"));
         idiomMenu.setMnemonic(bn.getString("idioma.mnemonico").charAt(0));
         portugueseItem.setText(bn.getString("portuga"));
         portugueseItem.setMnemonic(bn.getString("portuga.mnemonico").charAt(0));
         englishItem.setText(bn.getString("ingles"));
         englishItem.setMnemonic(bn.getString("ingles.mnemonico").charAt(0));
         francesItem.setText(bn.getString("frances"));
         francesItem.setMnemonic(bn.getString("frances.mnemonico").charAt(0) );
         italianoItem.setText(bn.getString("italiano"));
         italianoItem.setMnemonic(bn.getString("italiano.mnemonico").charAt(0));
      
      
      } // fim do metodo actionPerformed 
   } // fim da classe interna anonima 
   
} // fim da classe MenuFrame 

//--------------------------------------------------------------------------------------