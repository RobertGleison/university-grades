import math

def calculate_term(k):
    return 6/(k**2)

def calculate_serie(min_error):
    sum = 0
    n = 1
    term = calculate_term(n)
    n+=1
    next_term = calculate_term(n)
    while(abs(next_term-term) >= min_error):
        sum+=term
        term = next_term
        n+=1
        next_term = calculate_term(n)

    print(f"The aproximate value of pi² is {sum}")
    print(f"Absolute error is {(math.pi**2) - sum}")
    print(f"Number of terms is {n-1}")

calculate_serie(1e-5)


def calc_termo(k):
    return 6/(k**2)

def aprox(erro):
    soma = 0
    k = 1
    while(abs(math.pi**2 - soma) >= erro):
        soma += calc_termo(k)
        k += 1
    
    print(f"Termos somados = {k-1}")
    print(f"Valor aproximado de pi^2 = {soma:.5f}")  # imprimir com 5 casas decimais (por arredondamento)
    print(f"Erro = {abs(math.pi**2 - soma)}")

# NOTA: Para 10^-7, o programa demora demasiado tempo a correr.
#       Nesse sentido, vamos executar o programa para um erro maior, 10^-5.

aprox(1e-5)