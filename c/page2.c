#include <stdio.h>

void whichIsGreater()
{
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    int maior = a;
    if (b > a)
        maior = b;
    if (c > a)
        maior = c;
    printf("%d", maior);
}

void median(int a, int b, int c)
{
    int numbers[3] = {a, b, c};
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (numbers[j] > numbers[i])
            {
                int temp = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = temp;
            }
        }
    }
    printf("%d", numbers[1]);
}

void moneyValues(int value)
{
    int twentyEuros = (int)(value / 20);
    int back = value % 20;

    int tenEuros = (int)(back / 10);
    back = back % 10;

    int fiveEuros = (int)(back / 5);
    back = back % 5;

    int oneEuro = (int)(back / 1);
    back = value % 1;

    printf("Quantia em EUR? %d\n", value);
    printf("Notas EUR 20: %d\n", twentyEuros);
    printf("Notas EUR 10: %d\n", tenEuros);
    printf("Notas EUR 5: %d\n", fiveEuros);
    printf("Notas EUR 1: %d\n", oneEuro);
}

int pontencia(int x, int n)
{
    int result = 1;
    for (int i = 0; i < n; i++)
    {
        result *= result;
    }
    return result;
}

int average()
{
    int value;
    scanf("%d", &value);
    int sum = 0;
    int count = 0;
    while (value != 0)
    {
        count++;
        int tempValue = scanf("%d", &tempValue);
        sum += tempValue;
    }

    return (int)(sum / count);
}

void print_prime_divisors(int number)
{
    printf("%d: ", number);
    int divisor = 2;
    if (number < 1)
        return;
    while (divisor <= number)
    {
        while (number % divisor == 0)
        {
            printf("%d ", divisor);
            number = number / divisor;
        }
        divisor++;
    }
    printf("\n");
}

int is_leap_year(int year)
{
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
        return 1;
    return 0;
}

int next_leap_year(int year)
{
    if (is_leap_year(year))
        return year;
    while (!is_leap_year(year))
    {
        year++;
    }
    return year;
}

int main()
{
    int year;
    printf("Enter a year: ");
    scanf("%d", &year);
    printf("%d\n", is_leap_year(year));

    printf("Next leap year is: ");
    printf("%d\n", next_leap_year(year));

    return 0;
}
