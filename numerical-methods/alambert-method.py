def calculate_term(n):
    return 1/(n*(3**n))

def aprox_metodo_empirico(l,min_error):
    sum = 0
    n = 1
    term = calculate_term(n)
    n+=1
    next_term=calculate_term(n)
    while(abs(next_term*1/(1-l)) >= min_error):
        sum += term
        term = next_term
        n+=1
        next_term=calculate_term(n)
        
    
    print(f"Resultado: {sum}\nNumero de termos adicionados: {n-1}")

aprox_metodo_empirico(1/3,5e-4)


# Use this method to calculate positive series. This is an efficient method because it not calculates every new term again, but calculates the new term as a previous term multiplied by a multiplier of the series
