#Result using the actual equation of serie
def calculate_serie(x, min_error):
    sum = 0
    term = 1
    n_term = 0
    factorial = 1
    while(abs(term) >= min_error):
        term = (((-1)**n_term) * (x**(2 * n_term))) / factorial
        sum += term
        n_term += 1
        factorial*=n_term
    #Truncate the result for 9 decimal points 
    sum = (sum//min_error)*min_error
    print(f"Sum of the series is: {sum}")


#Resullt using a multiplier.
#This multiplier is calculated by the division between T(n+1)/T(n)
def aprox(x,min_err):
    sum = 0
    n_termo = 0
    termo = 1
    while (abs(termo) >= min_err):
        sum += termo
        termo = termo * (-1*(x*x)/(n_termo+1))
        n_termo +=1
    #Truncate the result for 9 decimal points
    sum = (sum//min_err)*min_err
    print(f"Resultado para o erro {min_err}: {sum}") 

calculate_serie(0.5, 10**(-9))
aprox(0.5, 10**(-9))

 
