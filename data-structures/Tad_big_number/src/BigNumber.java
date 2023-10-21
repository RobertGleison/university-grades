import java.util.Comparator;

public class BigNumber {
   public int[] number;

    public BigNumber(String number) {
        int[] temp = number.chars().map(Character::getNumericValue).toArray();
        this.number = temp;
    }

    public int size(){
        return number.length;
    }

    public boolean equals(BigNumber n){
        if(n.size()!=size()) return false;
        for(int i = 0; i<size();i++){
            if(this.number[i]!=n.number[i]) return false;
        }
        return true;
    }

    public BigNumber add(BigNumber n){
        StringBuilder string = new StringBuilder();
        int result = 0;
        int carry =0;
        int mod = 0;
        for(int i = Math.max(n.size()-1,size()-1); i>=0; i--){
            if(i>=size())
                result = n.number[i] + carry;
            else if(i>=n.size())
                result = number[i] + carry;
            else
                result =n.number[i] + number[i] +carry;
            carry = result/10;
            mod = result%10;
            if(i==0) {
                string.insert(0,String.valueOf(result));
                break;
            }
            string.insert(0, String.valueOf(mod));
        }
        BigNumber b = new BigNumber(string.toString());
        return b;
    }

    public BigNumber multiply(BigNumber n){
        int[] result = new int[size() + n.size()]; // Initialize the result array with enough space

        for (int i = size() - 1; i >= 0; i--) {
            int carry = 0;
            int digit1 = number[i];

            for (int j = n.size() - 1; j >= 0; j--) {
                int digit2 = n.number[j];
                int product = digit1 * digit2 + result[i + j + 1] + carry;
                carry = product / 10;
                result[i + j + 1] = product % 10;
            }

            result[i] += carry;
        }

        // Create a new BigNumber from the result array
        StringBuilder resultString = new StringBuilder();
        boolean leadingZeros = true;

        for (int digit : result) {
            if (leadingZeros && digit == 0) {
                continue;
            }
            leadingZeros = false;
            resultString.append(digit);
        }

        return new BigNumber(resultString.toString());
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i:number) {
            result.append(String.valueOf(i));
        }
        return result.toString();
    }
}