/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xox;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yldzo
 * @author emrea
 */
public class oyuncu {
    public char harf;
    public  boolean insan;
    public char harf2;
    public  boolean insan2;
    public Scanner veriAl = new Scanner(System.in);
    public oyuncu(){
        this.insan=insan2=true;
        this.harf=harf2='X';
    }
    public oyuncu(boolean insanmiKontrolu){
        if(insanmiKontrolu==true){
            //System.out.println(oyuncu.harf);
            this.harf=harf2='X';
            this.insan=insan2=true;
        }
        else{
            //System.out.println(oyuncu.harf);
            this.harf=harf2='O';
            this.insan=insan2=false;
        }
    }
    public oyuncu(boolean insanmiKontrolu, char kr){

        insan=insan2=insanmiKontrolu;
        harf=harf2=kr;
    }
    public char karakteriAl(){
        System.out.println("Hangi harf ile oynayacaksınız?:");
        char a;
        a = veriAl.next().charAt(0);
        return a;
    }
    public boolean  oyuncuTurunuAl(){
        System.out.println("İlk hamleyi yapacak mısınız? Ex: E or H");
        char b;
        b=veriAl.next().charAt(0);
        if('E'==b || b=='e'){
            this.insan=true;
            return true;
        }
        else{
            this.insan=false;
            return false;
        }
        
    }
    public String oyuncununHamlesiniAl(){
        String asd=insanOyuncuHamlesiniKotrol();
        return asd;
    }
    public String  insanOyuncuHamlesiniKotrol(){
        System.out.println("Hamleyi nereye yapacaksınız? Ex:A1");
        String cell = null;
        cell = veriAl.nextLine();
        //System.out.println(cell);
        return cell;
    }
    public String  bilgisayarHamlesiUret(){
        Random r = new Random();
        String h1= String.valueOf((char)(r.nextInt(oyunTahtasi.boyut)+64));
        String h2= String.valueOf(r.nextInt(oyunTahtasi.boyut));
        String CCell=h1+h2;
        //System.out.println(CCell);
        return CCell;
    }
    
    public void hamletersle(){
    
        if (insan2==true && harf2=='X') {insan2=false; harf2='O';}
        else if (insan2==false && harf2=='O') {insan2=true; harf2='X';}
        else if (insan2==true && harf2=='O') {insan2=false; harf2='X';}
        else if (insan2==false && harf2=='X') {insan2=true; harf2='O';}
    
    }
    
}
