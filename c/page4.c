#include <stdio.h>
#include <stdlib.h>

int fibonacci(int n){
    if(n == 0) return 0;
    if(n == 1) return 1;
    return fibonacci(n-1) + fibonacci(n-2);
}

int soma_digitos(int n){
    int sum = 0;
    int number;
    while(n != 0){
        number = n % 10;
        sum+=number;
        n = n / 10;
    }    
    return sum;
}

double serie_log(double x, int n){
    int divisor = 2;
    double multiplier = x;
    int signal = -1;
    double sum = 0.0;
    double term = x;
    while(n != 0)
    {
        sum += term;
        term = ((x*multiplier)/divisor) * signal;
        multiplier*=x;
        divisor++;
        signal*=-1;
        n--;
    }
    return sum;
}

double newton_method(double value, double error){
    double x0 = value / 2;
    double x1 = 0.5 * (x0 + value/x0);
    while (abs(x1-x0) > error){
        x1 = 0.5 * (x0 + value/x0);
        x0 = x1;
    }
    return x0;
}

int int_generator(int a, int b){
    return rand() % (b-a);
}

double double_generator(double a, double b){
    return 0.0;
}

int main(){

    //4.1
    // int value;
    // scanf("%d", &value);
    // for (int i = 0; i < value; i++)
    // {
    //     printf("%d ", fibonacci(i));
    // }
    // printf("\n");

    //4.2
    // int value;
    // scanf("%d", &value);
    // printf("%d\n", soma_digitos(value));

    //4.3
    // double x; 
    // int exponent;
    // scanf("%lf %d", &x, &exponent);
    // printf("%lf", serie_log(x, exponent));

    //4.4
    double value;
    double error = 0.001;    
    scanf("%lf", &value);
    printf("%lf", newton_method(value, error));

    //4.5   
    // int a, b;
    // scanf("%d %d", &a, &b);

    // printf("%d\n", int_generator(a,b));

}