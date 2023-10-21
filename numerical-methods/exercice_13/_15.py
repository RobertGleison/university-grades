
def calculate_term(n):
    return (n**2)/(n**4+1)
def calculate_serie(min_error):
    sum = 0
    n = 1
    term = calculate_term(n)
    n+=1
    next_term = calculate_term(n)
    while(abs(next_term - term) >= min_error):
        sum+=term
        term = next_term
        n+=1
        next_term = calculate_term(n)
    print(sum)


calculate_serie(1e-5)