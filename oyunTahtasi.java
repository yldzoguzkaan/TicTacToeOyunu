/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xox;

import java.util.Scanner;

/**
 *
 * @author yldzo
 */
public class oyunTahtasi {
    
    public Scanner veriAl;
    public static int boyut;
    char [][] Board=new char[boyut][boyut];
    public oyunTahtasi(){

	for(int i=0;i<=boyut;i++){
            //System.out.println();
            for(int j=0;j<=boyut;j++){
                if(i==0 && j==0){
                    //tahta[i][j]=' ';
                    //System.out.print(tahta[i][j]+" |");
                }
                else if(j>=1 && i==0){
                    //int d=64+j;
                    //char k=(char)d;
                    //tahta[i][j]=k;
                    //System.out.print(tahta[0][j]+" |");
                }
                else if(j==0 && i>=1){
                    //int d=48+j;
                    //char k=(char)d;
                    //tahta[i][j]=k;
                    //System.out.print(i+" |");
                }
                else if(i>=1 && j>=1){
                    //System.out.print(" - |");
                }
            }
        } 
        //oyunTahtasi board = new oyunTahtasi(tahta);
    }
    public oyunTahtasi(char [][] oynTahtasi){
	for(int i=0;i<boyut;i++){
            for(int j=0;j<boyut;j++){
            Board[i][j]=oynTahtasi[i][j];
            }
        } 
        
        oyunTahtasiniYazdir();
        
    }
    public char [][] oyunTahtasiniAl(){
	//kullanıcıdan oyun tahtasının boyutunu aldık.
	veriAl = new Scanner(System.in);
	System.out.println("Tahtanın boyutunu giriniz:");
	boyut = veriAl.nextInt();
        //System.out.println(boyut);
        if(boyut!=3 && boyut!=5 && boyut!=7){
            oyunTahtasiniAl();
        }
	char[][] tahta = new char [boyut][boyut];
        for(int i=0;i<boyut;i++){
            for(int j=0;j<boyut;j++){
                tahta[i][j]='-';
                Board=tahta;
            }
        }
        
        return tahta;
    }
    public void oyunTahtasiniYazdir(){
        for(int k = 0 ; k<boyut; k ++ ){
            int d=65+k;
            char a=(char)d;
            System.out.print(" "+a);
        }
	for(int i=0;i<boyut;i++){
            System.out.println();
            System.out.print(i+1);
            for(int j=0;j<boyut;j++){
                
                System.out.print(Board[i][j]+" ");
            }
        }
        System.out.println();
    }
    public boolean hamleYaz(String koordinat,char oyuncu){
        int x=Integer.valueOf(koordinat.substring(1, 2));
        int y=koordinat.substring(0, 1).charAt(0)-64;
        //System.out.println(x+""+y);
        if(y==0){
            y++;
        }
        if(x==0){
            x++;
        }
        
        if(Board[x-1][y-1]=='-' ){ 
            Board[x-1][y-1]=oyuncu;
            oyunTahtasiniYazdir();
            return true;
        }
        else{
            //tekrar kordinat üretmeli
            System.out.println("Burası dolu!");
            return false;
        }
        
    }
   public boolean kazanan(char oyuncu){
        if(boyut==3){
             int counter=0,counter3=0,counter1=0,counter2=0;
        for (int i = 0 ; i< boyut; i++) {
            if(Board[i][boyut-(i+1)]==oyuncu){
                    counter++;
                }
            if(i==boyut-1 && counter==boyut){
                    return true;
                }else if(i==boyut-1 && counter!=boyut){
                    counter=0;
                }
        }
        
        for (int i = 0; i < boyut; i++) {
            if(Board[i][i]==oyuncu){
                    counter3++;
                }
            if(i==boyut-1 && counter3==boyut){
                    return true;
                }else if(i==boyut-1 && counter3!=boyut){
                    counter3=0;
                }
        }
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                if(Board[i][j]==oyuncu){
                        counter1++;
                    }
                    if(j==boyut-1 && counter1==boyut)
                    {
                        return true;
                    }
                    else if(j==boyut-1 && counter1!=boyut)
                        counter1=0;
                }
            }
            for (int i = 0; i < boyut; i++) {
                for (int j = 0; j < boyut; j++) {
                    if(Board[j][i]==oyuncu){
                        counter2++;
                    }
                    if(j==boyut-1 && counter2==boyut)
                    {
                        return true;
                    }   
                    else if(j==boyut-1 && counter2!=boyut)
                        counter2=0;
                }
            }
            return false;
        
        }
        if(boyut==5 || boyut==7){
            for(int i=0;i<boyut;i++){
                for(int j=0;j<boyut;j++){
                    if(boyut==5){  if(i>=4 || j>=4) continue; }
                    if(boyut==7){  if(i>=6 || j>=6) continue; }
                    if(Board[i][j]==oyuncu){
                        if(Board[i][j]==oyuncu && Board[i][j+1]==oyuncu   && Board[i][j+2]==oyuncu){
                            return true;
                        }
                        if(Board[i][j]==oyuncu && Board[i+1][j]==oyuncu   && Board[i+2][j]==oyuncu){
                            return true;
                        }
                        if(Board[i][j]==oyuncu && Board[i+1][j+1]==oyuncu && Board[i+2][j+2]==oyuncu){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }
    public boolean beraberlikKontrol(){
        for(int i=0;i<boyut;i++){
            for(int j=0;j<boyut;j++){
                if(Board[i][j]=='-'){
                    return false;
                }
            }
        }    
        return true;
    }
}
