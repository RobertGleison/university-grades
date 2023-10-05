#Question A
def calculate_serie_a(min_error):
    sum = 0
    n_term = 1
    term = ((-1)**n_term)*(n_term/((5**n_term) + 10))

    while(abs(term) >= min_error):
        sum += term
        n_term+=1
        term = ((-1)**n_term)*(n_term/((5**n_term) + 10))

    #Truncate the number
    sum = (sum//min_error) * min_error
    print(f"The value of sum is :{sum}")
calculate_serie_a(5e-4)
print()

#Question B
#Empiric method
def calculate_serie_b(min_error):
    sum = 0
    n_term = 1
    term = 1/(n_term*(3**n_term))
    n_term+=1
    next_term = 1/(n_term*(3**n_term))
    sum += term
    while(abs(next_term-term)>= min_error):
        term = next_term
        n_term+=1
        next_term = 1/(n_term*(3**n_term))
        sum += term
    print(sum)

calculate_serie_b(5e-4)
print()

#Question C
#Empiric method
