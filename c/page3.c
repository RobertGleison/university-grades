#include <stdio.h>
#include <math.h>

float expression1(float number)
{
    return 3 * pow(number, 5) + 2 * pow(number, 4) - 5 * pow(number, 3) - pow(number, 2) + 7 * number - 6;
}

float expression2(float n)
{
    return ((((3 * n + 2) * n - 5) * n - 1) * n + 7) * n - 6;
}

int main()
{
    float exp_value;
    printf("Insert a value to the function: ");
    scanf("%f", &exp_value);
    printf("%.2f\n", expression1(exp_value));
    printf("%.2f\n", expression2(exp_value));
    return 0;
}
