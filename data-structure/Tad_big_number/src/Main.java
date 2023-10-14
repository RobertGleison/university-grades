import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        BigNumber n1 = new BigNumber("1234567890");
        System.out.println(n1); // Escreve "1234567890"

        BigNumber n2 = new BigNumber("42");
        BigNumber n3 = new BigNumber("1234567890");
        System.out.println(n1.equals(n2)); // Escreve "false"
        System.out.println(n1.equals(n3)); // Escreve "true"

        BigNumber n4 = new BigNumber("46711237126582920746212");
        BigNumber n5 = new BigNumber("8765432110");
        BigNumber n6 = n1.add(n3);
        System.out.println(n6); // Escreve "2469135780"
        BigNumber n7 = n1.add(n4);
        System.out.println(n7); // Escreve "46711237126584155314102"
        BigNumber n8 = n1.add(n5);
        System.out.println(n8); // Escreve "10000000000"

        BigNumber n9 = n1.multiply(n3);
        System.out.println(n9); // Escreve "1524157875019052100"
        BigNumber n10 = n1.multiply(n4);
        System.out.println(n10); // Escreve "57668193458655139375688174332680"
    }

}

class BigNumber {
        private int[] value;

        public BigNumber(String value){
            this.value = convertArray(value);
        }

        //Convert given string to char[] and then, to int[]
        public int[] convertArray(String value){
            char[] charArray = value.toCharArray();
            int[] intArray = new int[charArray.length];
            for(int i = 0; i < charArray.length; i++) {
                intArray[i] = charArray[i];
            }
            return intArray;
        }

    public boolean equals(BigNumber n){

    }
    public BigNumber add(BigNumber n) {}
    public BigNumber multiply(BigNumber n){}

    //Printing value as a String
    public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int i : this.value){
                sb.append(i);
            }
            String result =  sb.toString();
            return result;
    }
}