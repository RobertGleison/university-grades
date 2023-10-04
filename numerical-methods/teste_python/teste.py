
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

    sum = (sum//min_error)*min_error
    
    print(f"Number of terms: {n_term -1}\nSum of the series is: {sum}")

calculate_serie(0.5, 10**(-9))

def aprox(x,min_err):
    sum = 0
    n_termo = 0
    termo = 1

    # visto que é uma série de termos alternados, podemos os n termos
    # até |T(n+1)| < erro
    while (abs(termo) >= min_err):
        sum += termo
        termo = termo * (-1*(x*x)/(n_termo+1))
        n_termo +=1
    
    #truncar o resultado com base no erro
    sum = (sum//min_err)*min_err
    print(f"Resultado para o erro {min_err}: {sum}") 

aprox(0.5, 10**(-9))

 
