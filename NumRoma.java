import java.util.Scanner;
public class NumRoma
{
    public static void main(String[] args)
    {
        int decimal;
        Scanner sc = new Scanner(System.in);
        decimal= sc.nextInt();
        int millar=decimal/1000;
        int centena=(decimal%1000)/100;
        int decena=(decimal%100)/10;
        int unidad=decimal%10;
        String[] rMillar={" ","M","MM","MMM"};
        String[] rCentena={" ","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] rDecena={" ","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] rUnidad={" ","I","II","III","IV","V","VI","VII","VIII","IX"};
        System.out.println(rMillar[millar]+rCentena[centena]+rDecena[decena]+rUnidad[unidad]);
    }
}