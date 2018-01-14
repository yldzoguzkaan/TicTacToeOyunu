/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import jdk.nashorn.internal.ir.BreakNode;
/**
 *
 * @author yldzo
 */
public class Xox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner veri=new Scanner(System.in);
        //String eh;
        System.out.println("Kayıtlı oyunu Açmak ister misiniz ? E/H");
        char eh= veri.next().charAt(0);
        if (eh=='E'|| eh=='e'){
            
            
		File file=new File("..\\xox\\src\\xox\\yaz.txt");
		try {
                       
			FileInputStream input=new FileInputStream(file);
			int size=(int) file.length();
                        int ay=0;
                        if (size % 3 ==0) ay = size/3;
                        if (size % 5 ==0) ay = size/5;
                        if (size % 7 ==0) ay = size/7;
                        char[][] dizi=new char[ay][ay];
			for(int i=0;i<ay;i++){
                            for (int j=0; j<ay; j++){
                            
                                dizi[i][j]=(char)input.read();

                            }
			}
                         oyunTahtasi board ;
                         oyunTahtasi.boyut=ay;
                         board= new oyunTahtasi(dizi);
                         
                         while(true){
                             
                         oyuncu o = new oyuncu();
                         boolean d = board.hamleYaz(o.insanOyuncuHamlesiniKotrol(),o.harf2);
                         
                if(d==false){
                    while(true){
                        if(d==true){
                            break;
                        }
                        else{
                            d = board.hamleYaz(o.insanOyuncuHamlesiniKotrol(),o.harf2);
                        }
                    }
                
                }
                o.hamletersle();
                boolean f= board.kazanan(o.harf);
                if(f==true){
                    System.out.println(o.harf+" Oyunu kazanmıştır!");
                    
                }
                //kazanan kontrolü yapılır.
                boolean g= board.beraberlikKontrol();
                if(g==true){
                    System.out.println("Oyun berabere bitmiştir!");
                    
                }
                boolean c = board.hamleYaz(o.bilgisayarHamlesiUret(),o.harf2);
                if(c==false){
                    while(true){
                        if(c==true){
                            break;
                        }
                        else{
                            c = board.hamleYaz(o.bilgisayarHamlesiUret(),o.harf2);
                        }
                    }
                }
                f= board.kazanan(o.harf);
                o.hamletersle();
                if(f==true){
                    System.out.println(o.harf+" Oyunu kazanmıştır!");
                   
                }
                //kazanan kontrolü yapılır.
                g= board.beraberlikKontrol();
                if(g==true){
                    System.out.println("Oyun berabere bitmiştir!");
                    
                }  
                         
                         } 
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
            
        }
        
        
        String isim;
        Scanner veriAl = new Scanner(System.in);
        System.out.println("Adınız?");
        isim= veriAl.nextLine();
        //System.out.println(isim);
        oyuncu o = new oyuncu();
        System.out.println("İlk hamleyi yapmak için E veya e ye basınız");
        char a= veriAl.next().charAt(0);
        if(a=='e' || a=='E'){
            System.out.println("Harf secimi yapmak için E veya e ye basınız");
            char b = veriAl.next().charAt(0);
            if(b=='e' || b=='E'){
                o = new oyuncu(true,o.karakteriAl());
            }
            else{
                o = new oyuncu(true);
            }
        }
        oyuncu pc = o;
        oyunTahtasi board = new oyunTahtasi();
        board = new oyunTahtasi(board.oyunTahtasiniAl());
        //pc oyuncusunun ve normal oyuncunun harflerine nasıl ulasırım.
        System.out.println();
        
        while(true){
            System.out.println("oyunu kaydetmek icin k ye basınız:");
            char k=veriAl.next().charAt(0);
            if(k=='k' || k=='K'){
  
               File file=new File("..\\xox\\src\\xox\\yaz.txt");
		try {
			FileOutputStream output=new FileOutputStream(file);
			int n=board.Board.length;
                        char [][] daata = new char[n][n];
                        for(int i=0; i<board.Board.length; i++){
                            for (int j=0; j<board.Board.length; j++){
                                    
                                    //System.out.println(board.Board[i][j]);
                                      daata [i][j] = board.Board[i][j];
                                      char data = daata[i][j];
                                      output.write(data);   
                                    
                            }
                        }
                       
			output.flush();
			output.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
               
               
                break;
            }
            board.oyunTahtasiniYazdir();
            if(a=='e'|| a=='E'){
                boolean d = board.hamleYaz(o.insanOyuncuHamlesiniKotrol(),o.harf2);//kullanıcı
                if(d==false){
                    while(true){
                        if(d==true){
                            break;
                        }
                        else{
                            d = board.hamleYaz(o.insanOyuncuHamlesiniKotrol(),o.harf2);
                        }
                    }
                
                }
                o.hamletersle();
                boolean f= board.kazanan(o.harf);
                if(f==true){
                    System.out.println(o.harf+" Oyunu kazanmıştır!");
                    break;
                }
                //kazanan kontrolü yapılır.
                boolean g= board.beraberlikKontrol();
                if(g==true){
                    System.out.println("Oyun berabere bitmiştir!");
                    break;
                }
                boolean c = board.hamleYaz(pc.bilgisayarHamlesiUret(),pc.harf2);
                if(c==false){
                    while(true){
                        if(c==true){
                            break;
                        }
                        else{
                            c = board.hamleYaz(pc.bilgisayarHamlesiUret(),pc.harf2);
                        }
                    }
                }
                 o.hamletersle();
                f= board.kazanan(pc.harf);
                if(f==true){
                    System.out.println(pc.harf+" Oyunu kazanmıştır!");
                    break;
                }
                //kazanan kontrolü yapılır.
                g= board.beraberlikKontrol();
                if(g==true){
                    System.out.println("Oyun berabere bitmiştir!");
                    break;
                }
            }
            else{
                
                
                boolean c = board.hamleYaz(pc.bilgisayarHamlesiUret(),pc.harf2);
                    if(c==false){
                        while(true){
                            if(c==true){
                                break;
                            }
                            else{
                                c = board.hamleYaz(pc.bilgisayarHamlesiUret(),pc.harf2);
                            }
                        }
                    }
                //beraberlik kontrolü yapılır.
                 o.hamletersle();
                boolean f= board.kazanan(pc.harf);
                if(f==true){
                    System.out.println(pc.harf+" Oyunu kazanmıştır!");
                    break;
                }
                //kazanan kontrolü yapılır.
                boolean g= board.beraberlikKontrol();
                if(g==true){
                    System.out.println("Oyun berabere bitmiştir!");
                    break;
                }
                boolean d = board.hamleYaz(o.insanOyuncuHamlesiniKotrol(),o.harf2);
                if(d==false){
                    while(true){
                        if(d==true){
                            break;
                        }
                        else{
                            d = board.hamleYaz(o.insanOyuncuHamlesiniKotrol(),o.harf2);
                        }
                    }
                
                }
                f= board.kazanan(o.harf);
                if(f==true){
                    System.out.println(o.harf+" Oyunu kazanmıştır!");
                    break;
                }
                //kazanan kontrolü yapılır.
                g= board.beraberlikKontrol();
                if(g==true){
                    System.out.println("Oyun berabere bitmiştir!");
                    break;
                }
            
            } 
        }
    }
    
}
